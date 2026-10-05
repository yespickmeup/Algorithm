"""Reconcile cloud master duplicates only where main has one authoritative row."""
import argparse
from datetime import datetime
import json
import os
from pathlib import Path

import catalog_sync as s
import sync_menu as menu


def eligible(source, rows):
    if len(source) != 1:
        return 'Main identity missing or ambiguous'
    if len(rows) < 2:
        return 'No longer duplicated'
    # Master quantities should be zero here; never merge or discard stock.
    if any(r['product_qty'] != 0 for r in rows):
        return 'Cloud master contains stock; requires separate reconciliation'
    if source[0]['barcode'] is None or not source[0]['barcode'].strip():
        return 'Main identity is blank'
    return ''


def reconcile(local, cloud, code, journal, delete_absent=False, expected_count=None, sync_assemblies=False):
    source = s.query(local, 'SELECT * FROM inventory WHERE barcode <=> %s ORDER BY id LIMIT 2', (code,))
    cloud.begin()
    try:
        rows = s.query(cloud, 'SELECT * FROM inventory WHERE barcode <=> %s ORDER BY id FOR UPDATE', (code,))
        if delete_absent:
            if source or len(rows) < 2 or len(rows) != expected_count or any(r['product_qty'] != 0 for r in rows):
                cloud.rollback()
                return 0, 'No longer an absent zero-stock duplicate group'
            if not s.query(local, 'SELECT COUNT(*) AS n FROM inventory')[0]['n']:
                raise s.SyncError('Main inventory became empty; deletion stopped')
            # Invalid assemblies have blank parents; this path handles only nonblank codes.
            if code is None or not code.strip():
                cloud.rollback()
                return 0, 'Blank cloud identity requires review'
            journal.write(json.dumps({'event': 'before_delete_absent', 'code': code, 'rows': rows}, default=str) + '\n')
            journal.flush()
            os.fsync(journal.fileno())
            s.execute(cloud, 'DELETE FROM inventory_barcodes WHERE main_barcode=%s', (code,))
            if sync_assemblies:
                s.execute(cloud, 'DELETE FROM inventory_assembly WHERE main_item_code=%s', (code,))
            for row in rows:
                if s.execute(cloud, 'DELETE FROM inventory WHERE id=%s', (row['id'],)) != 1:
                    raise s.SyncError('Cloud-only duplicate changed during deletion')
            cloud.commit()
            journal.write(json.dumps({'event': 'committed_delete_absent', 'code': code, 'deleted_ids': [r['id'] for r in rows]}) + '\n')
            journal.flush()
            return len(rows), ''
        reason = eligible(source, rows)
        if reason:
            cloud.rollback()
            return 0, reason
        keeper = rows[0]['id']
        # Durable before-images precede deletion, in addition to a full cloud backup.
        journal.write(json.dumps({'event': 'before', 'code': code, 'keeper': keeper, 'rows': rows}, default=str) + '\n')
        journal.flush()
        os.fsync(journal.fileno())
        values = s.payload(source[0], ['barcode'] + s.CATALOG)
        s.update(cloud, 'inventory', values, 'id=%s', (keeper,))
        s.barcode_rows(cloud, source[0], s.CATALOG, True, True)
        for row in rows[1:]:
            if s.execute(cloud, 'DELETE FROM inventory WHERE id=%s', (row['id'],)) != 1:
                raise s.SyncError('Cloud duplicate changed during reconciliation')
        cloud.commit()
        journal.write(json.dumps({'event': 'committed', 'code': code, 'keeper': keeper, 'deleted_ids': [r['id'] for r in rows[1:]]}) + '\n')
        journal.flush()
        return len(rows) - 1, ''
    except BaseException:
        cloud.rollback()
        raise


def run(config, state, apply, delete_absent_only=False):
    runtime, main = menu.resolve_runtime(s, config)
    if not main:
        raise s.SyncError('Cloud duplicate reconciliation must run from local main')
    state.mkdir(parents=True, exist_ok=True)
    backup = str(menu.backup_database(s, runtime, 'cloud_', state)) if apply else None
    result = {'apply': apply, 'delete_absent_only': delete_absent_only, 'cloud_backup': backup, 'deleted_master_rows': 0, 'reconciled_groups': 0, 'skipped': []}
    stamp = datetime.now().strftime('%Y%m%d_%H%M%S')
    with s.connection(runtime, 'pool_') as local, s.connection(runtime, 'cloud_') as cloud, s.bridge_guard.publication_session(s, cloud, True, apply, config):
        for table in ('inventory', 'inventory_barcodes'):
            engine = s.query(cloud, 'SELECT ENGINE FROM information_schema.TABLES WHERE TABLE_SCHEMA=DATABASE() AND TABLE_NAME=%s', (table,))
            if not engine or engine[0]['ENGINE'] != 'InnoDB':
                raise s.SyncError('Transactional tables required')
        refs = s.query(cloud, "SELECT TABLE_NAME FROM information_schema.KEY_COLUMN_USAGE WHERE REFERENCED_TABLE_SCHEMA=DATABASE() AND REFERENCED_TABLE_NAME='inventory'")
        if refs:
            raise s.SyncError('Inventory has foreign-key dependents; duplicate IDs require a reference migration')
        s.execute(cloud, 'SET SESSION innodb_lock_wait_timeout=10')
        s.execute(cloud, "SET SESSION sql_mode='STRICT_ALL_TABLES,NO_ENGINE_SUBSTITUTION'")
        groups = s.query(cloud, 'SELECT barcode FROM inventory GROUP BY barcode HAVING COUNT(*)>1 ORDER BY barcode')
        if delete_absent_only:
            absent, planned = [], 0
            for group in groups:
                code = group['barcode']
                if code is None or not code.strip():
                    continue
                if s.query(local, 'SELECT id FROM inventory WHERE barcode=%s LIMIT 1', (code,)):
                    continue
                rows = s.query(cloud, 'SELECT product_qty FROM inventory WHERE barcode=%s', (code,))
                if any(r['product_qty'] != 0 for r in rows):
                    raise s.SyncError('Cloud-only duplicate has stock; review before deletion')
                planned += len(rows)
                group['expected_count'] = len(rows)
                absent.append(group)
            source_total = s.query(local, 'SELECT COUNT(*) AS n FROM inventory')[0]['n']
            cloud_total = s.query(cloud, 'SELECT COUNT(*) AS n FROM inventory')[0]['n']
            s.deletion_guard(source_total, cloud_total, planned, config, 'inventory')
            groups = absent
        with (state / ('cloud-duplicate-recovery-' + stamp + '.jsonl')).open('w', encoding='utf-8') as journal:
            for i, group in enumerate(groups, 1):
                code = group['barcode']
                if apply:
                    count, reason = reconcile(local, cloud, code, journal, delete_absent_only, group.get('expected_count'), s.boolean(config, 'sync_assemblies', False))
                else:
                    source = s.query(local, 'SELECT * FROM inventory WHERE barcode <=> %s LIMIT 2', (code,))
                    rows = s.query(cloud, 'SELECT * FROM inventory WHERE barcode <=> %s', (code,))
                    reason = ('Source item appeared' if source else '') if delete_absent_only else eligible(source, rows)
                    count = 0 if reason else len(rows) if delete_absent_only else len(rows) - 1
                if reason:
                    result['skipped'].append({'code': code, 'reason': reason})
                else:
                    result['deleted_master_rows'] += count
                    result['reconciled_groups'] += 1
                if i % 25 == 0:
                    print(f'Processed {i}/{len(groups)} groups; eligible/reconciled={result["reconciled_groups"]}; extra rows={result["deleted_master_rows"]}', flush=True)
        if apply:
            s.bridge_guard.set_status(s, cloud, 'blocked', 'Duplicate cleanup finished; main must verify complete catalog before publication')
    prefix = 'cloud-absent-duplicate' if delete_absent_only else 'cloud-duplicate'
    path = state / (prefix + ('-result.json' if apply else '-plan.json'))
    path.write_text(json.dumps(result, indent=2), encoding='utf-8')
    print(json.dumps(result, indent=2), flush=True)


if __name__ == '__main__':
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument('--config', type=Path, required=True)
    parser.add_argument('--options', type=Path, default=s.ROOT / 'sync.local.conf')
    parser.add_argument('--state-dir', type=Path, default=s.ROOT / '.sync-state')
    parser.add_argument('--apply', action='store_true')
    parser.add_argument('--delete-absent-only', action='store_true', help='Only remove duplicate cloud groups absent in main, subject to deletion limits')
    args = parser.parse_args()
    try:
        run(s.load_config(args.config, args.options), args.state_dir, args.apply, args.delete_absent_only)
    except Exception as exc:
        code = exc.args[0] if exc.args and isinstance(exc.args[0], int) else 'n/a'
        print('Cleanup stopped:', str(exc) if isinstance(exc, s.SyncError) else f'{type(exc).__name__} code={code}')
        raise SystemExit(1)
