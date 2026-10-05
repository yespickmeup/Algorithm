"""Explicit main duplicate repair: newest activity date, then updated/created dates and ID."""
import argparse
from datetime import datetime
import json
import os
from pathlib import Path

import catalog_sync as s
import sync_menu as menu


def timestamp(value):
    if isinstance(value, datetime):
        return value.replace(tzinfo=None)
    try:
        return datetime.fromisoformat(str(value)).replace(tzinfo=None)
    except (TypeError, ValueError):
        return datetime.min


def rank(row):
    updated, created = timestamp(row.get('updated_at')), timestamp(row.get('date_added'))
    return max(updated, created), updated, created, int(row['id'])


def choose(rows):
    if len(rows) < 2:
        raise s.SyncError('Duplicate group changed; refresh the plan')
    if any(r['product_qty'] != 0 for r in rows):
        raise s.SyncError('Master stock is nonzero; a stock-preserving merge is required')
    if all(rank(r)[0] == datetime.min for r in rows):
        raise s.SyncError('No valid updated/created dates; cannot select a latest record')
    return max(rows, key=rank)


def record(journal, event):
    journal.write(json.dumps(event, default=str, ensure_ascii=False) + '\n')
    journal.flush()
    os.fsync(journal.fileno())


def repair_local(local, code, journal):
    local.begin()
    try:
        rows = s.query(local, 'SELECT * FROM inventory WHERE barcode=%s ORDER BY id FOR UPDATE', (code,))
        winner = choose(rows)
        children = s.query(local, 'SELECT * FROM inventory_barcodes WHERE main_barcode=%s FOR UPDATE', (code,))
        record(journal, {'event': 'main_before', 'rows': rows, 'barcode_rows': children, 'selected_id': winner['id']})
        values = s.payload(winner, s.BARCODE_UPDATE)
        values.update(barcode=winner['barcodes'], main_barcode=winner['barcode'])
        s.update(local, 'inventory_barcodes', values, 'main_barcode=%s', (code,))
        deleted = []
        for row in rows:
            if row['id'] != winner['id']:
                if s.execute(local, 'DELETE FROM inventory WHERE id=%s', (row['id'],)) != 1:
                    raise s.SyncError('Main duplicate changed during repair')
                deleted.append(row['id'])
        local.commit()
        record(journal, {'event': 'main_committed', 'selected_id': winner['id'], 'barcode': winner['barcode'], 'deleted_ids': deleted})
        return winner
    except BaseException:
        local.rollback()
        raise


def repair_cloud(local, cloud, code, journal):
    # Hold the selected source row while cloud receives its authoritative values.
    local.begin()
    cloud.begin()
    try:
        source = s.query(local, 'SELECT * FROM inventory WHERE barcode=%s LIMIT 2 FOR UPDATE', (code,))
        if len(source) != 1:
            raise s.SyncError('Main identity changed before cloud update')
        winner = source[0]
        rows = s.query(cloud, 'SELECT * FROM inventory WHERE barcode=%s ORDER BY id FOR UPDATE', (code,))
        if any(r['product_qty'] != 0 for r in rows):
            raise s.SyncError('Cloud master stock is nonzero; review before merging')
        children = s.query(cloud, 'SELECT * FROM inventory_barcodes WHERE main_barcode=%s FOR UPDATE', (code,))
        record(journal, {'event': 'cloud_before', 'rows': rows, 'barcode_rows': children, 'main_id': winner['id']})
        values = s.payload(winner, ['barcode'] + s.CATALOG)
        if rows:
            s.update(cloud, 'inventory', values, 'id=%s', (rows[0]['id'],))
        else:
            values.update(product_qty=0, is_uploaded=1, date_added=winner.get('date_added'), user_name=winner.get('user_name') or '', branch='', branch_code='', location='', location_id='')
            s.insert(cloud, 'inventory', values)
        s.barcode_rows(cloud, winner, s.CATALOG, True, True)
        s.update(cloud, 'inventory_barcodes', {'main_barcode': winner['barcode']}, 'main_barcode=%s', (code,))
        for row in rows[1:]:
            if s.execute(cloud, 'DELETE FROM inventory WHERE id=%s', (row['id'],)) != 1:
                raise s.SyncError('Cloud duplicate changed during repair')
        cloud.commit()
        record(journal, {'event': 'cloud_committed', 'barcode': winner['barcode'], 'deleted_ids': [r['id'] for r in rows[1:]]})
        return len(rows[1:])
    except BaseException:
        cloud.rollback()
        raise
    finally:
        local.rollback()


def run(config, state, apply, reuse_backups):
    runtime, main = menu.resolve_runtime(s, config)
    if not main:
        raise s.SyncError('Latest-record reconciliation requires local main')
    state.mkdir(parents=True, exist_ok=True)
    manifest = state / 'latest-selection-backups.json'
    if apply:
        if reuse_backups:
            backups = json.loads(manifest.read_text(encoding='utf-8'))
            if len(backups) != 2 or any(not Path(p).is_file() or not Path(p).stat().st_size for p in backups):
                raise s.SyncError('Two completed backups are required')
        else:
            backups = [str(menu.backup_database(s, runtime, prefix, state)) for prefix in ('pool_', 'cloud_')]
            manifest.write_text(json.dumps(backups, indent=2), encoding='utf-8')
    decisions = []
    with s.connection(runtime, 'pool_') as local, s.connection(runtime, 'cloud_') as cloud, s.bridge_guard.publication_session(s, cloud, True, apply, config):
        for conn in (local, cloud):
            for table in ('inventory', 'inventory_barcodes'):
                engine = s.query(conn, 'SELECT ENGINE FROM information_schema.TABLES WHERE TABLE_SCHEMA=DATABASE() AND TABLE_NAME=%s', (table,))
                if not engine or engine[0]['ENGINE'] != 'InnoDB':
                    raise s.SyncError('Transactional tables required')
            if s.query(conn, "SELECT TABLE_NAME FROM information_schema.KEY_COLUMN_USAGE WHERE REFERENCED_TABLE_SCHEMA=DATABASE() AND REFERENCED_TABLE_NAME='inventory'"):
                raise s.SyncError('Inventory IDs have foreign-key references; migrate references before merging')
            s.execute(conn, "SET SESSION sql_mode='STRICT_ALL_TABLES,NO_ENGINE_SUBSTITUTION'")
            s.execute(conn, 'SET SESSION innodb_lock_wait_timeout=10')
        groups = s.query(local, 'SELECT barcode FROM inventory GROUP BY barcode HAVING COUNT(*)>1 ORDER BY barcode')
        for group in groups:
            rows = s.query(local, 'SELECT * FROM inventory WHERE barcode=%s ORDER BY id', (group['barcode'],))
            winner = choose(rows)
            decisions.append({'item_code': group['barcode'], 'keep_id': winner['id'], 'keep_code': winner['barcode'],
                              'updated_at': winner.get('updated_at'), 'date_added': winner.get('date_added'),
                              'deleted_ids': [r['id'] for r in rows if r['id'] != winner['id']]})
        (state / 'latest-selection-plan.json').write_text(json.dumps(decisions, indent=2, default=str), encoding='utf-8')
        if apply:
            with (state / ('latest-selection-recovery-' + datetime.now().strftime('%Y%m%d_%H%M%S') + '.jsonl')).open('w', encoding='utf-8') as journal:
                for decision in decisions:
                    winner = repair_local(local, decision['item_code'], journal)
                    cloud_deleted = repair_cloud(local, cloud, winner['barcode'], journal)
                    print(f'Reconciled main ID {winner["id"]}; cloud extras removed={cloud_deleted}', flush=True)
            s.bridge_guard.set_status(s, cloud, 'pending', 'Latest-record repair complete; waiting for full inventory verification', scope=s.bridge_guard.scope_for(s, config))
    print(json.dumps({'apply': apply, 'groups': len(decisions), 'decisions': decisions}, indent=2, default=str), flush=True)


if __name__ == '__main__':
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument('--config', type=Path, required=True)
    parser.add_argument('--options', type=Path, default=s.ROOT / 'sync.local.conf')
    parser.add_argument('--state-dir', type=Path, default=s.ROOT / '.sync-state')
    parser.add_argument('--apply', action='store_true')
    parser.add_argument('--reuse-backups', action='store_true')
    args = parser.parse_args()
    try:
        run(s.load_config(args.config, args.options), args.state_dir, args.apply, args.reuse_backups)
    except Exception as exc:
        code = exc.args[0] if exc.args and isinstance(exc.args[0], int) else 'n/a'
        print('Repair stopped:', str(exc) if isinstance(exc, s.SyncError) else f'{type(exc).__name__} code={code}; review recovery journal')
        raise SystemExit(1)
