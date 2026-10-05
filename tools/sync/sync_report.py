"""Local, read-only catalog reports generated from the comparison snapshots."""
import html
import json
from datetime import datetime


def inventory_rows(disk):
    sql = """SELECT s.k,s.data,d.data FROM snapshot s LEFT JOIN snapshot d
        ON d.side='destination' AND d.tbl=s.tbl AND d.k=s.k
        WHERE s.side='source' AND s.tbl='inventory'
        UNION ALL SELECT d.k,NULL,d.data FROM snapshot d LEFT JOIN snapshot s
        ON s.side='source' AND s.tbl=d.tbl AND s.k=d.k
        WHERE d.side='destination' AND d.tbl='inventory' AND s.k IS NULL"""
    for key, source, destination in disk.execute(sql):
        a, b = json.loads(source) if source else None, json.loads(destination) if destination else None
        blocked = disk.execute("SELECT 1 FROM blocked WHERE tbl='inventory' AND k=?",(key,)).fetchone()
        status = 'ambiguous' if blocked else 'destination_only' if a is None else 'source_only' if b is None else 'synced' if a == b else 'different'
        changes = {} if status != 'different' else {k:{'source':a.get(k),'destination':b.get(k)} for k in sorted(set(a)|set(b)) if a.get(k) != b.get(k)}
        yield {'item_code':(a or b)['barcode'],'status':status,'source_present':a is not None,'destination_present':b is not None,
               'source_description':a.get('description') if a else None,'destination_description':b.get('description') if b else None,'differences':changes}


def write_report(disk, folder, main, columns):
    source_label,destination_label = ('Main branch','Cloud') if main else ('Cloud','Local branch')
    counts={k:0 for k in ('source_only','destination_only','different','synced','ambiguous')}
    blocked_source=blocked_destination=0
    timestamp=datetime.now().astimezone().isoformat(timespec='seconds')
    def esc(value): return html.escape('NULL' if value is None else str(value))
    with (folder/'inventory-report.html').open('w',encoding='utf-8') as out, (folder/'inventory-details.jsonl').open('w',encoding='utf-8') as details:
        out.write('''<!doctype html><html lang="en"><meta charset="utf-8"><title>Inventory sync comparison</title>
<style>body{font:15px system-ui;margin:32px;color:#1e293b}table{border-collapse:collapse;width:100%;margin:16px 0}td,th{padding:8px;border:1px solid #dbe2ea;text-align:left;vertical-align:top}th{background:#eef3f8}input,select{padding:9px;margin:8px}details{max-width:650px}pre{white-space:pre-wrap;overflow-wrap:anywhere}.synced{color:#157347}.different,.destination_only{color:#a44b00}.ambiguous{color:#b42318}header{padding:16px;background:#f5f8fc}td{overflow-wrap:anywhere}</style>
<header><h1>Inventory sync comparison</h1>''')
        out.write(f'<p>{esc(source_label)} → {esc(destination_label)} · {esc(timestamp)}</p><p>Read-only comparison; this report does not execute changes. “Synced” means all compared master fields match, not merely that an upload flag is set.</p></header>')
        out.write('<p><a href="inventory-summary.md">Summary and counts</a> · <a href="inventory-details.jsonl">Machine-readable item details</a></p>')
        out.write('<label>Filter <select id="status"><option value="mismatch">Mismatches / needs review</option value="all">All items</option value="synced">Already synced</option value="source_only">Source only / new to destination</option value="different">Updated fields</option value="destination_only">Destination only / deletion candidate</option value="ambiguous">Ambiguous item codes</option></select></label><input id="search" placeholder="Search item code or description"><span id="visible"></span>')
        out.write(f'<table id="items"><thead><tr><th>Item code</th><th>Status</th><th>{esc(source_label)}</th><th>{esc(destination_label)}</th><th>Field differences</th></tr></thead><tbody>')
        for row in inventory_rows(disk):
            counts[row['status']]+=1
            if row['status']=='ambiguous':
                blocked_source+=row['source_present'];blocked_destination+=row['destination_present']
            details.write(json.dumps(row,ensure_ascii=False)+'\n')
            diff=''
            if row['differences']:
                diff='<details><summary>'+str(len(row['differences']))+' differing fields</summary><table><tr><th>Field</th><th>'+esc(source_label)+'</th><th>'+esc(destination_label)+'</th></tr>'
                for name, values in row['differences'].items():
                    diff+=f'<tr><td>{esc(name)}</td><td>{esc(values["source"])}</td><td>{esc(values["destination"])}</td></tr>'
                diff+='</table></details>'
            elif row['status']=='ambiguous': diff='Multiple master rows use this code. No automatic match selected.'
            out.write(f'<tr data-status="{row["status"]}"><td>{esc(row["item_code"])}</td><td class="{row["status"]}">{esc(row["status"])}</td><td>{esc(row["source_description"]) if row["source_present"] else "Absent"}</td><td>{esc(row["destination_description"]) if row["destination_present"] else "Absent"}</td><td>{diff}</td></tr>')
        out.write('''</tbody></table><script>
const rows=[...document.querySelectorAll('#items > tbody > tr')],filter=document.getElementById('status'),search=document.getElementById('search');
function refresh(){let n=0;const q=search.value.toLowerCase();for(const r of rows){const s=r.dataset.status;const match=(filter.value==='all'||(filter.value==='mismatch'?s!=='synced':s===filter.value))&&r.textContent.toLowerCase().includes(q);r.hidden=!match;if(match)n++;}document.getElementById('visible').textContent=n+' items shown';}filter.onchange=refresh;search.oninput=refresh;refresh();</script></html>''')
    total=lambda side: disk.execute("SELECT n FROM totals WHERE side=? AND tbl='inventory'",(side,)).fetchone()[0]
    unique=lambda side: disk.execute("SELECT COUNT(*) FROM snapshot WHERE side=? AND tbl='inventory'",(side,)).fetchone()[0]
    disabled=[r[0] for r in disk.execute('SELECT tbl FROM disabled')]
    summary={'checked_at':timestamp,'source':source_label,'destination':destination_label,'source_rows':total('source'),'destination_rows':total('destination'),
             'source_unique_codes':unique('source'),'destination_unique_codes':unique('destination'),**counts,'source_ambiguous_codes':blocked_source,'destination_ambiguous_codes':blocked_destination,'excluded_tables':disabled,'compared_fields':columns}
    (folder/'inventory-summary.json').write_text(json.dumps(summary,indent=2,ensure_ascii=False),encoding='utf-8')
    md=f'''# Inventory sync comparison

Checked: {timestamp}. Source: **{source_label}**. Destination: **{destination_label}**.

| Check | {source_label} | {destination_label} |
| --- | ---: | ---: |
| Total inventory rows (including duplicates) | {total('source'):,} | {total('destination'):,} |
| Distinct internal item codes | {unique('source'):,} | {unique('destination'):,} |
| New to destination / source-only codes | {counts['source_only']:,} present | {counts['source_only']:,} missing |
| Updated items / differing field values | {counts['different']:,} source versions | {counts['different']:,} different versions |
| Deletion candidates / destination-only codes | {counts['destination_only']:,} absent | {counts['destination_only']:,} present |
| Already synchronized master items | {counts['synced']:,} | {counts['synced']:,} |
| Ambiguous codes excluded from automatic comparison | {blocked_source:,} | {blocked_destination:,} |

No database updates or deletions were executed by report generation. New/updated/deleted labels describe differences in the current snapshot; without history, absence cannot prove when an item was added or whether someone actually deleted it. Deletion candidates may include independently created destination items.

Synced means all compared master fields match. Stock quantities, IDs, location ownership, source metadata and upload flags are excluded. This does not verify every inventory_barcodes location row or tier-pricing table. Counts below total rows reflect excluded duplicate identities; ambiguous codes are shown for review, not declared synchronized.

Excluded tables: {', '.join(disabled) or 'none'}. Tables can be excluded by configuration or invalid identities. An excluded table has not been verified as synchronized.

Compared fields: {', '.join(columns)}.

Open [the searchable detailed report](inventory-report.html) for every item, including already-synced items and side-by-side changed values. [JSONL details](inventory-details.jsonl) contain the same classification data. Files contain private catalog information and should stay in the ignored state directory.
'''
    (folder/'inventory-summary.md').write_text(md,encoding='utf-8')
    return summary
