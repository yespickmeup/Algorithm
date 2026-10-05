import sqlite3
import unittest
from unittest.mock import Mock, patch

import catalog_sync as s
import bridge_guard as guard


class GuardTests(unittest.TestCase):
    def test_inventory_only_default_and_explicit_full_scope(self):
        self.assertEqual(list(guard.policies(s, {})), ['inventory'])
        self.assertIn('inventory_assembly', guard.policies(s, {'sync_assemblies': 'true'}))

    def test_scope_mismatch_refuses_branch_before_fingerprint(self):
        with patch.object(s, 'query', side_effect=[[{}], [{'protocol_version': guard.VERSION, 'status': 'ready', 'scope': 'inventory+assembly', 'catalog_hash': 'x'}]]), patch.object(guard, 'fingerprint') as fingerprint:
            with self.assertRaises(s.SyncError):
                guard.require_ready(s, Mock(), {'sync_assemblies': 'false'})
            fingerprint.assert_not_called()

    def test_disabled_assembly_does_not_block_verified_inventory_scope(self):
        with sqlite3.connect(':memory:') as disk:
            disk.execute('CREATE TABLE disabled(tbl)')
            disk.execute('CREATE TABLE blocked(tbl,k)')
            disk.execute('CREATE TABLE snapshot(side,tbl,k,id,data)')
            disk.execute("INSERT INTO disabled VALUES ('inventory_assembly')")
            for side in ('source', 'destination'):
                disk.execute("INSERT INTO snapshot VALUES (?,'inventory','A',1,'{}')", (side,))
            self.assertEqual(guard.publication_problem(s, disk, ['inventory']), '')
            self.assertIn('Invalid', guard.publication_problem(s, disk))

    def test_existing_publication_table_gets_scope_column(self):
        with patch.object(s, 'execute') as execute, patch.object(s, 'fields', return_value={'id', 'status'}):
            guard.ensure_table(s, Mock())
            self.assertIn('ADD COLUMN scope', execute.call_args.args[1])

    def test_role_override_cannot_turn_branch_into_publisher(self):
        with self.assertRaises(s.SyncError):
            guard.role(s, {'main_branch': 'true'}, {'is_main_branch': 0})
        with self.assertRaises(s.SyncError):
            guard.role(s, {'main_branch': 'false'}, {'is_main_branch': 1})
        self.assertTrue(guard.role(s, {}, {'is_main_branch': 1}))
        self.assertFalse(guard.role(s, {}, {'is_main_branch': 0}))

    def test_missing_or_unready_publication_blocks_branch(self):
        for answers in ([[]], [[{'TABLE_NAME': guard.TABLE}], []], [[{'TABLE_NAME': guard.TABLE}], [{'protocol_version': 1, 'status': 'pending', 'catalog_hash': ''}]], [[{'TABLE_NAME': guard.TABLE}], [{'protocol_version': 999, 'status': 'ready', 'catalog_hash': 'x'}]]):
            with patch.object(s, 'query', side_effect=answers), patch.object(guard, 'fingerprint') as fingerprint:
                with self.assertRaises(s.SyncError):
                    guard.require_ready(s, Mock())
                fingerprint.assert_not_called()

    def test_cloud_changes_after_ready_are_rejected(self):
        for actual, accepted in [('original', True), ('modified', False)]:
            with patch.object(s, 'query', side_effect=[[{}], [{'protocol_version': guard.VERSION, 'scope': 'inventory', 'status': 'ready', 'catalog_hash': 'original'}]]), patch.object(guard, 'fingerprint', return_value=actual):
                if accepted:
                    guard.require_ready(s, Mock())
                else:
                    with self.assertRaises(s.SyncError):
                        guard.require_ready(s, Mock())

    def test_busy_cloud_prevents_entry(self):
        with patch.object(s, 'query', return_value=[{'acquired': 0}]), patch.object(guard, 'ensure_table') as schema:
            with self.assertRaises(s.SyncError):
                with guard.publication_session(s, Mock(), True, True):
                    self.fail('Busy session entered')
            schema.assert_not_called()

    def test_main_failure_leaves_pending_and_releases_lock(self):
        with patch.object(s, 'query', return_value=[{'acquired': 1}]) as query, patch.object(guard, 'ensure_table'), patch.object(guard, 'set_status') as status:
            with self.assertRaises(RuntimeError):
                with guard.publication_session(s, Mock(), True, True):
                    raise RuntimeError('write failed')
            self.assertEqual(status.call_args.args[2], 'pending')
            self.assertIn('RELEASE_LOCK', query.call_args.args[1])

    def test_branch_releases_lock_when_verification_fails(self):
        with patch.object(s, 'query', return_value=[{'acquired': 1}]) as query, patch.object(guard, 'require_ready', side_effect=s.SyncError('blocked')):
            with self.assertRaises(s.SyncError):
                with guard.publication_session(s, Mock(), False, True):
                    self.fail('Unready branch entered')
            self.assertIn('RELEASE_LOCK', query.call_args.args[1])

    def test_read_only_does_not_create_marker_or_acquire_lock(self):
        with patch.object(s, 'query') as query, patch.object(guard, 'set_status') as status:
            with guard.publication_session(s, Mock(), False, False):
                pass
            query.assert_not_called()
            status.assert_not_called()

    def test_duplicates_invalid_tables_empty_source_or_differences_prevent_ready(self):
        with sqlite3.connect(':memory:') as disk:
            disk.execute('CREATE TABLE disabled(tbl)')
            disk.execute('CREATE TABLE blocked(tbl,k)')
            disk.execute('CREATE TABLE snapshot(side,tbl,k,id,data)')
            self.assertIn('empty', guard.publication_problem(s, disk))
            disk.execute("INSERT INTO snapshot VALUES ('source','inventory','A',1,'{}')")
            disk.execute("INSERT INTO blocked VALUES ('inventory','A')")
            self.assertIn('Duplicate', guard.publication_problem(s, disk))
            disk.execute("INSERT INTO disabled VALUES ('inventory_assembly')")
            self.assertIn('Invalid', guard.publication_problem(s, disk))
            disk.execute('DELETE FROM blocked')
            disk.execute('DELETE FROM disabled')
            self.assertIn('differences', guard.publication_problem(s, disk))
            disk.execute("INSERT INTO snapshot VALUES ('destination','inventory','A',2,'{}')")
            self.assertEqual(guard.publication_problem(s, disk), '')


if __name__ == '__main__':
    unittest.main()
