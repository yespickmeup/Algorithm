import json
from pathlib import Path
import sqlite3
import tempfile
import unittest
from sync_report import write_report


class ReportTests(unittest.TestCase):
    def test_classification_counts_and_html_escaping(self):
        with sqlite3.connect(':memory:') as disk, tempfile.TemporaryDirectory() as tmp:
            disk.executescript('CREATE TABLE snapshot(side,tbl,k,id,data,PRIMARY KEY(side,tbl,k)); CREATE TABLE blocked(tbl,k); CREATE TABLE disabled(tbl); CREATE TABLE totals(side,tbl,n);')
            rows=[('source','same','same'),('destination','same','same'),('source','new','<script>alert(1)</script>'),('source','updated','new value'),('destination','updated','old value'),('destination','gone','old'),('source','duplicate','one'),('destination','duplicate','two')]
            for side,code,description in rows:
                disk.execute('INSERT INTO snapshot VALUES (?,?,?,?,?)',(side,'inventory',json.dumps([code]),1,json.dumps({'barcode':code,'description':description})))
            disk.execute('INSERT INTO blocked VALUES (?,?)',('inventory',json.dumps(['duplicate'])))
            disk.executemany('INSERT INTO totals VALUES (?,?,?)',[('source','inventory',5),('destination','inventory',4)])
            result=write_report(disk,Path(tmp),True,['description'])
            for status in ['synced','source_only','different','destination_only','ambiguous']:
                self.assertEqual(result[status],1)
            self.assertEqual(result['source_rows'],5)
            self.assertEqual(result['source_unique_codes'],4)
            html=(Path(tmp)/'inventory-report.html').read_text(encoding='utf-8')
            self.assertNotIn('<script>alert(1)</script>',html)
            self.assertIn('&lt;script&gt;',html)
            details=[json.loads(line) for line in (Path(tmp)/'inventory-details.jsonl').read_text(encoding='utf-8').splitlines()]
            changed=next(r for r in details if r['status']=='different')
            self.assertEqual(changed['differences']['description'],{'source':'new value','destination':'old value'})


if __name__=='__main__': unittest.main()
