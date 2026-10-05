import tempfile
import unittest
from unittest.mock import Mock, patch

import catalog_sync as s
import reconcile_latest_main as repair


class LatestMainTests(unittest.TestCase):
    def test_latest_update_beats_id_and_creation(self):
        rows = [dict(id=1, updated_at='2026-10-01', date_added='2020-01-01', product_qty=0),
                dict(id=2, updated_at='2025-10-01', date_added='2025-10-01', product_qty=0)]
        self.assertEqual(repair.choose(rows)['id'], 1)

    def test_creation_date_handles_legacy_older_update(self):
        rows = [dict(id=1, updated_at='2015-01-01', date_added='2026-01-01', product_qty=0),
                dict(id=2, updated_at='2020-01-01', date_added='2020-01-01', product_qty=0)]
        self.assertEqual(repair.choose(rows)['id'], 1)

    def test_invalid_update_falls_back_to_creation_and_exact_tie_uses_id(self):
        row = dict(updated_at='0000-00-00 00:00:00', date_added='2024-01-01', product_qty=0)
        self.assertEqual(repair.choose([dict(row, id=1), dict(row, id=2)])['id'], 2)

    def test_stock_or_no_dates_prevents_destructive_merge(self):
        rows = [dict(id=1, date_added='2024-01-01', product_qty=0), dict(id=2, date_added='2025-01-01', product_qty=1)]
        with self.assertRaises(s.SyncError):
            repair.choose(rows)
        with self.assertRaises(s.SyncError):
            repair.choose([dict(id=1, product_qty=0), dict(id=2, product_qty=0)])

    def test_main_merge_keeps_latest_and_preserves_quantity_and_assemblies(self):
        row = dict.fromkeys(s.CATALOG, 1)
        row.update(id=1, barcode='A', barcodes='scan', product_qty=0, date_added='2020-01-01')
        newer = dict(row, id=2, date_added='2026-01-01')
        with tempfile.TemporaryFile(mode='w+', encoding='utf-8') as journal, patch.object(s, 'query', side_effect=[[row, newer], [{'id': 22, 'product_qty': 5}]]), patch.object(s, 'update') as update, patch.object(s, 'execute', return_value=1) as execute:
            conn = Mock()
            self.assertEqual(repair.repair_local(conn, 'A', journal)['id'], 2)
            self.assertNotIn('product_qty', update.call_args.args[2])
            execute.assert_called_once_with(conn, 'DELETE FROM inventory WHERE id=%s', (1,))
            conn.commit.assert_called_once()

    def test_failure_rolls_back_without_cloud_commit(self):
        row = dict.fromkeys(s.CATALOG, 1)
        row.update(id=1, barcode='A', barcodes='scan', product_qty=0, date_added='2020-01-01')
        newer = dict(row, id=2, date_added='2026-01-01')
        with tempfile.TemporaryFile(mode='w+', encoding='utf-8') as journal, patch.object(s, 'query', side_effect=[[row, newer], []]), patch.object(s, 'update'), patch.object(s, 'execute', return_value=0):
            conn = Mock()
            with self.assertRaises(s.SyncError):
                repair.repair_local(conn, 'A', journal)
            conn.rollback.assert_called_once()
            conn.commit.assert_not_called()


if __name__ == '__main__':
    unittest.main()
