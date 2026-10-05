import tempfile
import unittest
from unittest.mock import Mock, patch

import catalog_sync as s
import reconcile_cloud_duplicates as repair


class CloudDuplicateTests(unittest.TestCase):
    def test_absent_group_deletes_parent_dependents_and_all_master_duplicates(self):
        rows = [{'id': 1, 'product_qty': 0}, {'id': 2, 'product_qty': 0}]
        with tempfile.TemporaryFile(mode='w+', encoding='utf-8') as journal, patch.object(s, 'query', side_effect=[[], rows, [{'n': 10}]]), patch.object(s, 'execute', return_value=1) as execute:
            cloud = Mock()
            self.assertEqual(repair.reconcile(Mock(), cloud, 'A', journal, True, 2), (2, ''))
            statements = [c.args[1] for c in execute.call_args_list]
            self.assertEqual(len(statements), 4)
            self.assertIn('WHERE main_item_code=%s', statements[1])
            cloud.commit.assert_called_once()

    def test_growth_since_absent_deletion_plan_is_not_applied(self):
        rows = [{'id': i, 'product_qty': 0} for i in range(3)]
        with tempfile.TemporaryFile(mode='w+', encoding='utf-8') as journal, patch.object(s, 'query', side_effect=[[], rows]), patch.object(s, 'execute') as execute:
            count, reason = repair.reconcile(Mock(), Mock(), 'A', journal, True, 2)
            self.assertEqual(count, 0)
            self.assertTrue(reason)
            execute.assert_not_called()

    def test_empty_main_blocks_absent_deletion(self):
        rows = [{'id': i, 'product_qty': 0} for i in range(2)]
        with tempfile.TemporaryFile(mode='w+', encoding='utf-8') as journal, patch.object(s, 'query', side_effect=[[], rows, [{'n': 0}]]), patch.object(s, 'execute') as execute:
            with self.assertRaises(s.SyncError):
                repair.reconcile(Mock(), Mock(), 'A', journal, True, 2)
            execute.assert_not_called()

    def test_ambiguous_main_and_nonzero_stock_cannot_be_merged(self):
        source = [{'barcode': 'A'}]
        rows = [{'id': 1, 'product_qty': 0}, {'id': 2, 'product_qty': 0}]
        self.assertEqual(repair.eligible(source, rows), '')
        self.assertTrue(repair.eligible(source * 2, rows))
        self.assertTrue(repair.eligible([], rows))
        self.assertTrue(repair.eligible(source, [dict(rows[0], product_qty=1), rows[1]]))

    def test_only_extra_master_ids_deleted_and_main_values_win(self):
        source = dict.fromkeys(s.CATALOG, 1)
        source['barcode'] = 'A'
        rows = [{'id': 10, 'product_qty': 0}, {'id': 20, 'product_qty': 0}]
        with tempfile.TemporaryFile(mode='w+', encoding='utf-8') as journal, patch.object(s, 'query', side_effect=[[source], rows]), patch.object(s, 'update') as update, patch.object(s, 'barcode_rows') as children, patch.object(s, 'execute', return_value=1) as execute:
            cloud = Mock()
            self.assertEqual(repair.reconcile(Mock(), cloud, 'A', journal), (1, ''))
            self.assertEqual(update.call_args.args[2], s.payload(source, ['barcode'] + s.CATALOG))
            self.assertEqual(update.call_args.args[4], (10,))
            execute.assert_called_once_with(cloud, 'DELETE FROM inventory WHERE id=%s', (20,))
            children.assert_called_once()
            cloud.commit.assert_called_once()
            journal.seek(0)
            self.assertIn('"event": "before"', journal.read())

    def test_failed_delete_rolls_back_whole_group(self):
        source = dict.fromkeys(s.CATALOG, 1)
        source['barcode'] = 'A'
        rows = [{'id': 10, 'product_qty': 0}, {'id': 20, 'product_qty': 0}]
        with tempfile.TemporaryFile(mode='w+', encoding='utf-8') as journal, patch.object(s, 'query', side_effect=[[source], rows]), patch.object(s, 'update'), patch.object(s, 'barcode_rows'), patch.object(s, 'execute', return_value=0):
            cloud = Mock()
            with self.assertRaises(s.SyncError):
                repair.reconcile(Mock(), cloud, 'A', journal)
            cloud.rollback.assert_called_once()
            cloud.commit.assert_not_called()

    def test_conflicting_main_does_not_write_cloud(self):
        with tempfile.TemporaryFile(mode='w+', encoding='utf-8') as journal, patch.object(s, 'query', side_effect=[[{'barcode': 'A'}] * 2, [{'id': 1}, {'id': 2}]]), patch.object(s, 'update') as update:
            count, reason = repair.reconcile(Mock(), Mock(), 'A', journal)
            self.assertEqual(count, 0)
            self.assertTrue(reason)
            update.assert_not_called()


if __name__ == '__main__':
    unittest.main()
