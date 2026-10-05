import io
import json
import tempfile
import unittest
from contextlib import redirect_stdout
from pathlib import Path
from unittest.mock import patch

import repair_main_cloud as repair


class RepairTests(unittest.TestCase):
    def test_non_main_refused_before_backup_or_write(self):
        with patch.object(repair.s, 'load_config', return_value={}), patch.object(repair.menu, 'resolve_runtime', return_value=({}, False)), patch.object(repair.menu, 'backup_database') as backup, patch.object(repair.s, 'cycle') as cycle:
            with self.assertRaises(repair.s.SyncError):
                repair.run(Path('config'), None, Path('state'))
            backup.assert_not_called()
            cycle.assert_not_called()

    def test_failed_second_backup_prevents_all_writes(self):
        with tempfile.TemporaryDirectory() as tmp, patch.object(repair.s, 'load_config', return_value={}), patch.object(repair.menu, 'resolve_runtime', return_value=({}, True)), patch.object(repair.menu, 'backup_database', side_effect=['local.sql', RuntimeError('backup failed')]), patch.object(repair.s, 'cycle') as cycle:
            with self.assertRaises(RuntimeError):
                repair.run(Path('config'), None, Path(tmp))
            cycle.assert_not_called()

    def test_no_progress_stops_without_success_result(self):
        summary = dict(source_only=1, different=0, destination_only=0)
        with tempfile.TemporaryDirectory() as tmp, redirect_stdout(io.StringIO()), patch.object(repair.s, 'load_config', return_value={}), patch.object(repair.menu, 'resolve_runtime', return_value=({}, True)), patch.object(repair.menu, 'backup_database', side_effect=['local.sql', 'cloud.sql']), patch.object(repair.s, 'cycle', return_value={'committed': 0, 'before': summary}) as cycle:
            with self.assertRaises(repair.s.SyncError):
                repair.run(Path('config'), None, Path(tmp))
            self.assertEqual(cycle.call_count, 2)
            self.assertFalse((Path(tmp) / 'repair-result.json').exists())

    def test_canary_and_postcheck_then_bounded_batch(self):
        calls = []
        def cycle(config, apply, state):
            calls.append((apply, config['sync_max_changes']))
            remaining = 2 if len(calls) <= 2 else 0
            return {'committed': (1 if len(calls) == 1 else 2) if apply else 0,
                    'before': dict(source_only=remaining, different=0, destination_only=0, ambiguous=5, excluded_tables=['inventory_assembly'])}
        with tempfile.TemporaryDirectory() as tmp, redirect_stdout(io.StringIO()), patch.object(repair.s, 'load_config', return_value={}), patch.object(repair.menu, 'resolve_runtime', return_value=({}, True)), patch.object(repair.menu, 'backup_database', side_effect=['local.sql', 'cloud.sql']), patch.object(repair.s, 'cycle', side_effect=cycle):
            repair.run(Path('config'), None, Path(tmp))
            result = json.loads((Path(tmp) / 'repair-result.json').read_text())
            self.assertEqual(result['committed_items'], 3)
            self.assertEqual(result['ambiguous_codes'], 5)
            self.assertEqual(calls, [(True, '1'), (False, '1'), (True, '100'), (False, '100')])


if __name__ == '__main__':
    unittest.main()
