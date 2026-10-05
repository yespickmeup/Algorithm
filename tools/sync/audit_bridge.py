"""Read-only report of identities preventing a verified cloud publication."""
import argparse
from datetime import datetime
import html
import json
from pathlib import Path

import catalog_sync as s
import sync_menu


def inspect(conn):
    groups = s.query(conn, 'SELECT barcode,COUNT(*) AS n FROM inventory GROUP BY barcode HAVING COUNT(*)>1 ORDER BY barcode')
    result = []
    for group in groups:
        rows = s.query(conn, 'SELECT * FROM inventory WHERE barcode <=> %s ORDER BY id', (group['barcode'],))
        differing = [k for k in rows[0] if k != 'id' and any(r[k] != rows[0][k] for r in rows[1:])]
        result.append({'item_code': group['barcode'], 'rows': rows, 'different_fields': differing,
                       'catalog_conflicts': [k for k in differing if k in s.CATALOG or k == 'barcode']})
    invalid = s.query(conn, "SELECT * FROM inventory_assembly WHERE main_item_code IS NULL OR TRIM(main_item_code)='' OR item_code IS NULL OR TRIM(item_code)='' ORDER BY id")
    return {'duplicate_groups': result, 'invalid_assemblies': invalid}


def run(config, state):
    runtime, main = sync_menu.resolve_runtime(s, config)
    if not main:
        raise s.SyncError('Run this audit against local main')
    report = {'checked_at': datetime.now().astimezone().isoformat(), 'read_only': True}
    for side, prefix in (('main', 'pool_'), ('cloud', 'cloud_')):
        with s.connection(runtime, prefix) as conn:
            s.execute(conn, 'SET SESSION TRANSACTION ISOLATION LEVEL REPEATABLE READ')
            s.execute(conn, 'START TRANSACTION WITH CONSISTENT SNAPSHOT')
            report[side] = inspect(conn)
            conn.rollback()
        print(side, 'duplicate_groups=', len(report[side]['duplicate_groups']), 'invalid_assemblies=', len(report[side]['invalid_assemblies']), flush=True)
    state.mkdir(parents=True, exist_ok=True)
    (state / 'bridge-identity-audit.json').write_text(json.dumps(report, indent=2, ensure_ascii=False, default=str), encoding='utf-8')
    esc = lambda x: html.escape(str(x))
    with (state / 'bridge-identity-audit.html').open('w', encoding='utf-8') as out:
        out.write('<!doctype html><meta charset="utf-8"><title>Bridge identity review</title><style>body{font:15px system-ui;margin:30px}table{border-collapse:collapse}td,th{border:1px solid #ccc;padding:8px;white-space:pre-wrap}details{margin:15px 0}</style><h1>Bridge identity review</h1><p>Read-only. Select the correct main item identity before cleanup; no rows were deleted.</p>')
        for side in ('main', 'cloud'):
            out.write('<h2>' + side.title() + '</h2>')
            for group in report[side]['duplicate_groups']:
                out.write('<details><summary>' + esc(repr(group['item_code'])) + ' — IDs ' + esc([r['id'] for r in group['rows']]) + '</summary><p>Conflicting catalog fields: ' + esc(group['catalog_conflicts']) + '</p><table><tr><th>Field</th>')
                for row in group['rows']:
                    out.write('<th>ID ' + esc(row['id']) + '</th>')
                out.write('</tr>')
                for key in dict.fromkeys(['barcode', 'description', 'selling_price', 'product_qty'] + group['different_fields']):
                    out.write('<tr><th>' + esc(key) + '</th>' + ''.join('<td>' + esc(repr(r.get(key))) + '</td>' for r in group['rows']) + '</tr>')
                out.write('</table></details>')
            out.write('<h3>Invalid assembly records</h3><pre>' + esc(json.dumps(report[side]['invalid_assemblies'], indent=2, default=str)) + '</pre>')
    print('Read-only reports saved:', state / 'bridge-identity-audit.html', flush=True)


if __name__ == '__main__':
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument('--config', type=Path, required=True)
    parser.add_argument('--options', type=Path, default=s.ROOT / 'sync.local.conf')
    parser.add_argument('--state-dir', type=Path, default=s.ROOT / '.sync-state')
    args = parser.parse_args()
    try:
        run(s.load_config(args.config, args.options), args.state_dir)
    except Exception as exc:
        code = exc.args[0] if exc.args and isinstance(exc.args[0], int) else 'n/a'
        print('Audit stopped:', str(exc) if isinstance(exc, s.SyncError) else f'{type(exc).__name__} code={code}')
        raise SystemExit(1)
