from pathlib import Path
import tempfile
import unittest
from unittest.mock import patch

import hourly_sync as hourly


def result(main=False, changed=0, ready=None, planned=0, ambiguous=0):
    return dict(committed=changed, publication=ready, planned_items=planned,
                before=dict(source='Main branch' if main else 'Cloud', ambiguous=ambiguous,
                            excluded_tables=[], source_only=0, different=0, destination_only=0))


class HourlyTests(unittest.TestCase):
    def test_intentionally_disabled_assembly_is_success_for_inventory_only_branch(self):
        value = result()
        value['before']['excluded_tables'] = ['inventory_assembly']
        with patch.object(hourly.s, 'cycle', return_value=value):
            self.assertEqual(hourly.run({}, Path('state'), True)['status'], 'completed')
            self.assertEqual(hourly.run({'sync_assemblies': 'true'}, Path('state'), True)['status'], 'blocked')

    def test_prefers_package_config_then_home(self):
        with tempfile.TemporaryDirectory() as tmp:
            root = Path(tmp)
            home = root / 'home'
            self.assertEqual(hourly.config_path(root, home), home / 'my_config.conf')
            (root / 'my_config.conf').touch()
            self.assertEqual(hourly.config_path(root, home), root / 'my_config.conf')

    def test_read_only_never_applies(self):
        with patch.object(hourly.s, 'cycle', return_value=result()) as cycle:
            value = hourly.run({}, Path('state'), False)
            self.assertEqual(value['status'], 'checked')
            cycle.assert_called_once_with({}, False, Path('state'))

    def test_main_batches_until_publication_ready(self):
        with patch.object(hourly.s, 'cycle', side_effect=[result(True, 100, 'blocked'), result(True, 5, 'ready')]):
            value = hourly.run({}, Path('state'), True)
            self.assertEqual(value['status'], 'completed')
            self.assertEqual(value['committed_items'], 105)

    def test_blocked_publication_is_not_success_or_infinite_loop(self):
        with patch.object(hourly.s, 'cycle', return_value=result(True, 0, 'blocked')) as cycle:
            self.assertEqual(hourly.run({}, Path('state'), True)['status'], 'blocked')
            self.assertEqual(cycle.call_count, 1)

    def test_branch_checks_again_after_last_writes(self):
        with patch.object(hourly.s, 'cycle', side_effect=[result(changed=2), result()]) as cycle:
            value = hourly.run({}, Path('state'), True)
            self.assertEqual(value['status'], 'completed')
            self.assertEqual(value['committed_items'], 2)
            self.assertEqual(cycle.call_count, 2)

    def test_remaining_assembly_plan_is_not_reported_complete(self):
        with patch.object(hourly.s, 'cycle', return_value=result(planned=1)):
            self.assertEqual(hourly.run({}, Path('state'), True)['status'], 'blocked')

    def test_batch_limit_exits_with_incomplete_status(self):
        with patch.object(hourly.s, 'cycle', return_value=result(changed=1)):
            value = hourly.run({'sync_hourly_max_batches': '2'}, Path('state'), True)
            self.assertEqual(value['status'], 'incomplete')
            self.assertEqual(value['committed_items'], 2)

    def test_time_limit_does_not_start_another_batch(self):
        with patch.object(hourly.time, 'monotonic', side_effect=[0, 61]), patch.object(hourly.s, 'cycle') as cycle:
            self.assertEqual(hourly.run({'sync_hourly_max_seconds': '60'}, Path('state'), True)['status'], 'incomplete')
            cycle.assert_not_called()


if __name__ == '__main__':
    unittest.main()
