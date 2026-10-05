import argparse
from contextlib import redirect_stdout
import io
from pathlib import Path
import tempfile
import unittest
from unittest.mock import Mock, patch

import catalog_sync as api
import sync_menu as menu


class MenuTests(unittest.TestCase):
    def config(self):
        return dict(pool_host='localhost',pool_port='3306',pool_user='user',pool_password='test-secret',pool_db='test_db')

    def test_password_not_in_command_and_environment_not_mutated(self):
        import os
        before=os.environ.get('MYSQL_PWD')
        args,env=menu.dump_command('mysqldump',self.config(),'pool_')
        self.assertNotIn('test-secret',' '.join(args))
        self.assertEqual(env['MYSQL_PWD'],'test-secret')
        self.assertEqual(os.environ.get('MYSQL_PWD'),before)
        for opt in ['--single-transaction','--quick','--routines','--events','--triggers','--skip-lock-tables']:
            self.assertIn(opt,args)

    def test_backup_streams_to_file_and_publishes_only_on_success(self):
        with tempfile.TemporaryDirectory() as tmp,patch.object(menu,'dump_executable',return_value='mysqldump'),redirect_stdout(io.StringIO()):
            def spawn(*args,**kwargs):
                kwargs['stdout'].write(b'-- fixture backup\nCREATE TABLE test (id INT);\n')
                return Mock(poll=Mock(return_value=0),returncode=0)
            with patch.object(menu.subprocess,'Popen',side_effect=spawn):
                path=menu.backup_database(api,self.config(),'pool_',Path(tmp))
            self.assertTrue(path.exists())
            self.assertEqual(path.suffix,'.sql')
            self.assertFalse(list(Path(tmp).rglob('*.partial')))

    def test_failed_backup_not_presented_as_success(self):
        with tempfile.TemporaryDirectory() as tmp,patch.object(menu,'dump_executable',return_value='mysqldump'),redirect_stdout(io.StringIO()):
            with patch.object(menu.subprocess,'Popen',return_value=Mock(poll=Mock(return_value=2),returncode=2)):
                with self.assertRaises(RuntimeError): menu.backup_database(api,self.config(),'pool_',Path(tmp))
            self.assertFalse(list(Path(tmp).rglob('*.sql')))
            self.assertFalse(list(Path(tmp).rglob('*.partial')))

    def test_menu_sync_is_read_only_and_exit_does_not_backup(self):
        with tempfile.TemporaryDirectory() as tmp,redirect_stdout(io.StringIO()):
            args=argparse.Namespace(config=Path('unused'),options=None,state_dir=Path(tmp))
            with patch.object(api,'load_config',return_value=self.config()),patch.object(menu,'resolve_runtime',return_value=(dict(self.config(),cloud_db='cloud_db'),True)),patch('builtins.input',side_effect=['3','4']),patch.object(api,'cycle') as cycle,patch.object(menu,'backup_database') as backup:
                self.assertEqual(menu.run_menu(api,args),0)
                cycle.assert_called_once_with(self.config(),False,Path(tmp))
                backup.assert_not_called()

    def test_menu_dispatches_local_and_cloud_backup(self):
        with tempfile.TemporaryDirectory() as tmp,redirect_stdout(io.StringIO()):
            args=argparse.Namespace(config=Path('unused'),options=None,state_dir=Path(tmp))
            runtime=dict(self.config(),cloud_db='cloud_db')
            with patch.object(api,'load_config',return_value=self.config()),patch.object(menu,'resolve_runtime',return_value=(runtime,False)),patch('builtins.input',side_effect=['1','2','4']),patch.object(menu,'backup_database') as backup:
                menu.run_menu(api,args)
                self.assertEqual([c.args[2] for c in backup.call_args_list],['pool_','cloud_'])


if __name__=='__main__': unittest.main()
