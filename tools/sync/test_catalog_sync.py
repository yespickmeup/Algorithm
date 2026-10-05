import json
from pathlib import Path
import sqlite3
import tempfile
import unittest
from unittest.mock import Mock, patch

import catalog_sync as s


class SyncTests(unittest.TestCase):
    def test_java_properties_password_characters_and_escapes(self):
        with tempfile.TemporaryDirectory() as directory:
            p=Path(directory)/"my_config.conf"
            p.write_text('pool_password=abc#:=\\u0021\nmain_branch : true\nname=one\\\n  two\n',encoding='iso-8859-1')
            result=s.properties(p)
            self.assertEqual(result['pool_password'],'abc#:=!')
            self.assertEqual(result['name'],'onetwo')
            self.assertTrue(s.boolean(result,'main_branch'))

    def test_invalid_boolean_is_not_silently_false(self):
        with self.assertRaises(s.SyncError): s.boolean({'main_branch':'ture'},'main_branch')

    def test_diff_handles_new_changed_deleted_and_unchanged(self):
        with sqlite3.connect(':memory:') as disk:
            disk.execute('CREATE TABLE snapshot(side,tbl,k,id,data,PRIMARY KEY(side,tbl,k))')
            disk.execute('CREATE TABLE blocked(tbl,k,PRIMARY KEY(tbl,k))')
            disk.execute('CREATE TABLE disabled(tbl PRIMARY KEY)')
            for side, key, value in [('source','same',1),('destination','same',1),('source','new',2),('source','changed',3),('destination','changed',2),('destination','gone',4)]:
                disk.execute('INSERT INTO snapshot VALUES (?,?,?,?,?)',(side,'inventory',key,1,s.encode({'barcode':key,'cost':value})))
            rows=list(s.plan(disk,'inventory'))
            self.assertEqual(sorted(x[0] for x in rows),['delete','upsert','upsert'])
            self.assertFalse(any('same' in (a or '') for _,a,b in rows))

    def test_deletion_budget_stops_empty_source_and_large_loss(self):
        for source,total,count in [(0,100,1),(99,100,11),(1,10,1)]:
            with self.assertRaises(s.SyncError): s.deletion_guard(source,total,count,{},'inventory')
        s.deletion_guard(99,100,1,{},'inventory')

    def test_duplicate_keys_and_their_assemblies_are_excluded(self):
        with sqlite3.connect(':memory:') as disk:
            disk.execute('CREATE TABLE snapshot(side,tbl,k,id,data,PRIMARY KEY(side,tbl,k))')
            disk.execute('CREATE TABLE blocked(tbl,k,PRIMARY KEY(tbl,k))')
            disk.execute('CREATE TABLE disabled(tbl PRIMARY KEY)')
            for table,row in [('inventory',{'barcode':'A','description':'new'}),('inventory_assembly',{'main_item_code':'A','item_code':'B','product_qty':2})]:
                key=s.encode([row[k] for k in s.KEYS[table]])
                disk.execute('INSERT INTO snapshot VALUES (?,?,?,?,?)',('source',table,key,1,s.encode(row)))
            disk.execute('INSERT INTO blocked VALUES (?,?)',('inventory',s.encode(['A'])))
            self.assertEqual(list(s.plan(disk,'inventory')),[])
            self.assertEqual(list(s.plan(disk,'inventory_assembly')),[])

    def test_disabled_table_cannot_produce_deletions(self):
        with sqlite3.connect(':memory:') as disk:
            disk.execute('CREATE TABLE disabled(tbl PRIMARY KEY)')
            disk.execute("INSERT INTO disabled VALUES ('inventory_assembly')")
            self.assertEqual(list(s.plan(disk,'inventory_assembly')),[])

    def test_delete_removes_dependents_in_same_transaction(self):
        row={'barcode':'A','description':'old'}
        with patch.object(s,'query',side_effect=[[],[row]]),patch.object(s,'execute') as execute:
            dst=Mock()
            self.assertTrue(s.apply_change(Mock(),dst,'inventory','delete',None,row,['description'],True,True))
            statements=[call.args[1] for call in execute.call_args_list]
            self.assertEqual(len(statements),3)
            self.assertIn('inventory_barcodes',statements[0])
            self.assertIn('item_code=%s',statements[1])
            self.assertNotIn(' OR ',statements[1])
            dst.commit.assert_called_once()

    def test_update_preserves_stock_and_location_fields(self):
        before={'barcode':'A','description':'old'}
        desired={'barcode':'A','description':'new'}
        current=dict(before,product_qty=42,location_id='branch2')
        src=Mock(); dst=Mock()
        with patch.object(s,'query',side_effect=[[desired],[current]]), patch.object(s,'update') as update, patch.object(s,'barcode_rows'):
            self.assertTrue(s.apply_change(src,dst,'inventory','upsert',desired,before,['description'],True,True))
            self.assertEqual(update.call_args.args[2],{'description':'new'})
            dst.commit.assert_called_once()

    def test_source_changed_since_snapshot_skips_write(self):
        with patch.object(s,'query',return_value=[{'barcode':'A','description':'newer'}]):
            dst=Mock()
            result=s.apply_change(Mock(),dst,'inventory','upsert',{'barcode':'A','description':'new'},None,['description'],True,True)
            self.assertFalse(result)
            dst.begin.assert_not_called()

    def test_ambiguous_commit_retry_does_not_insert_twice(self):
        row={'barcode':'A','description':'new'}
        with patch.object(s,'query',side_effect=[[row],[row]]),patch.object(s,'insert') as insert:
            dst=Mock()
            self.assertFalse(s.apply_change(Mock(),dst,'inventory','upsert',row,None,['description'],True,True))
            insert.assert_not_called()
            dst.rollback.assert_called_once()

    def test_failure_rolls_back_item_and_does_not_commit(self):
        row={'barcode':'A','description':'new'}
        old={'barcode':'A','description':'old'}
        with patch.object(s,'query',side_effect=[[row],[old]]),patch.object(s,'update',side_effect=RuntimeError('failure')):
            dst=Mock()
            with self.assertRaises(RuntimeError): s.apply_change(Mock(),dst,'inventory','upsert',row,old,['description'],True,True)
            dst.rollback.assert_called_once()
            dst.commit.assert_not_called()

    def test_recreated_source_item_is_not_deleted(self):
        with patch.object(s,'query',return_value=[{'barcode':'A'}]),patch.object(s,'execute') as execute:
            self.assertFalse(s.apply_change(Mock(),Mock(),'inventory','delete',None,{'barcode':'A'},[],True,True))
            execute.assert_not_called()

    def test_new_inventory_starts_at_zero_stock(self):
        row={'barcode':'A','description':'new'}
        source=dict(row,product_qty=100,selling_price=19)
        with patch.object(s,'query',side_effect=[[source],[]]),patch.object(s,'insert') as insert,patch.object(s,'barcode_rows'):
            self.assertTrue(s.apply_change(Mock(),Mock(),'inventory','upsert',row,None,['description'],False,False))
            self.assertEqual(insert.call_args.args[2]['product_qty'],0)
            self.assertEqual(insert.call_args.args[2]['selling_price'],19)

    def test_assembly_quantity_changes_are_written(self):
        old={'main_item_code':'A','item_code':'B','product_qty':1}
        new=dict(old,product_qty=2)
        with patch.object(s,'query',side_effect=[[new],[old]]),patch.object(s,'update') as update:
            self.assertTrue(s.apply_change(Mock(),Mock(),'inventory_assembly','upsert',new,old,['product_qty'],True,True))
            self.assertEqual(update.call_args.args[2],{'product_qty':2})

    def test_connection_is_closed_on_error(self):
        db=Mock()
        cfg={'pool_host':'host','pool_user':'user','pool_password':'secret','pool_db':'db'}
        with patch.object(s.pymysql,'connect',return_value=db) as connect:
            with self.assertRaises(RuntimeError):
                with s.connection(cfg,'pool_'): raise RuntimeError('test')
            db.close.assert_called_once()
            db.rollback.assert_called_once()
            self.assertEqual(connect.call_args.kwargs['read_timeout'],30)

    def test_existing_branch_prices_are_not_written(self):
        source={name:1 for name in s.CATALOG}
        source.update(barcode='A',barcodes='alt')
        with patch.object(s,'update') as update,patch.object(s,'query',side_effect=[[{'id':1,'branch':'B','branch_id':'B','location':'L'}],[{'id':2}]]):
            s.barcode_rows(Mock(),source,s.CATALOG,False,False)
            self.assertNotIn('selling_price',update.call_args.args[2])
            self.assertNotIn('product_qty',update.call_args.args[2])
            self.assertNotIn('unit',update.call_args.args[2])
            self.assertNotIn('conversion',update.call_args.args[2])
            self.assertNotIn('status',update.call_args.args[2])

    def test_branch_policy_preserves_embedded_unit_prices(self):
        cols=s.sync_columns(s.CATALOG,False)
        self.assertFalse(s.PRICE_FIELDS.intersection(cols))
        self.assertIn('status',cols)
        self.assertTrue(s.PRICE_FIELDS.issubset(s.sync_columns(s.CATALOG,True)))

    def test_master_inactive_status_survives_insert(self):
        row={'barcode':'A','description':'new','status':0}
        source=dict(row,selling_price=19,unit='[pc:19/1^1]',conversion=1)
        with patch.object(s,'query',side_effect=[[source],[]]),patch.object(s,'insert') as insert,patch.object(s,'barcode_rows'):
            s.apply_change(Mock(),Mock(),'inventory','upsert',row,None,['description','status'],False,False)
            values=insert.call_args.args[2]
            self.assertEqual(values['status'],0)
            self.assertEqual(values['unit'],source['unit'])


if __name__=='__main__': unittest.main()
