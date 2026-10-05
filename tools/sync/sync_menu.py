"""Interactive menu and streaming mysqldump backups; no database restore actions."""
from datetime import datetime
import json
import os
from pathlib import Path
import re
import shutil
import subprocess
import time


def resolve_runtime(api, config):
    with api.connection(config, 'pool_') as conn:
        rows=api.query(conn,'SELECT is_main_branch,cloud_host,cloud_port,cloud_user,cloud_password,cloud_db FROM settings LIMIT 2')
    if len(rows)!=1:
        raise api.SyncError('Expected exactly one settings row to determine cloud connection and branch role')
    runtime=dict(config)
    runtime.update({k:v for k,v in rows[0].items() if k.startswith('cloud_')})
    return runtime,api.bridge_guard.role(api,config,rows[0])


def dump_executable(config):
    if config.get('backup_mysqldump'):
        path=Path(config['backup_mysqldump'])
        if not path.is_file():
            raise RuntimeError('Configured mysqldump executable was not found')
        return str(path)
    found=shutil.which('mysqldump')
    if found:
        return found
    for pattern in ('C:/Program Files (x86)/MySQL','C:/Program Files/MySQL'):
        root=Path(pattern)
        for path in sorted(root.glob('*/bin/mysqldump.exe')):
            return str(path)
    path=Path('C:/xampp/mysql/bin/mysqldump.exe')
    if path.is_file():
        return str(path)
    raise RuntimeError('mysqldump not found. Set backup_mysqldump in sync.local.conf')


def dump_command(executable,config,prefix):
    # Password exists only in the child environment, never argv or a temp credential file.
    args=[executable,'--no-defaults','--protocol=TCP','--host='+config[prefix+'host'],
          '--port='+str(config.get(prefix+'port') or 3306),'--user='+config[prefix+'user'],
          '--single-transaction','--quick','--skip-lock-tables','--routines','--events','--triggers','--hex-blob',
          '--default-character-set=utf8']
    if prefix=='cloud_' and config.get('sync_ssl_ca'):
        args+=['--ssl-ca='+config['sync_ssl_ca'],'--ssl-verify-server-cert']
    args+=['--databases',config[prefix+'db']]
    env=dict(os.environ,MYSQL_PWD=config[prefix+'password'])
    return args,env


def backup_database(api,config,prefix,state_dir):
    executable=dump_executable(config)
    args,env=dump_command(executable,config,prefix)
    folder=Path(config.get('backup_directory') or state_dir/'backups').resolve()
    folder.mkdir(parents=True,exist_ok=True)
    label='local' if prefix=='pool_' else 'cloud'
    db=config[prefix+'db']
    safe=re.sub(r'[^A-Za-z0-9_.-]','_',db)
    name=f'{label}_{safe}_{datetime.now():%Y%m%d_%H%M%S_%f}.sql'
    final=folder/name
    partial=folder/(name+'.partial')
    started=time.monotonic()
    timeout=api.number(config,'backup_timeout',3600,10,86400)
    proc=None
    print(f'Backing up {label} database {db} to {final}',flush=True)
    try:
        # stderr is deliberately not printed: server errors may include sensitive values.
        with partial.open('xb') as output:
            proc=subprocess.Popen(args,env=env,stdout=output,stderr=subprocess.DEVNULL,
                                  creationflags=getattr(subprocess,'CREATE_NO_WINDOW',0))
            last_progress=started
            while proc.poll() is None:
                if time.monotonic()-started > timeout:
                    raise RuntimeError('Backup timeout; incomplete output will be removed')
                if time.monotonic()-last_progress>=10:
                    print(f'Backing up... {partial.stat().st_size/1024/1024:.2f} MiB written',flush=True)
                    last_progress=time.monotonic()
                time.sleep(1)
            if proc.returncode!=0:
                raise RuntimeError(f'mysqldump failed (exit {proc.returncode}); check connectivity, client compatibility and backup privileges')
        if not partial.stat().st_size:
            raise RuntimeError('Backup produced an empty file')
        partial.rename(final)
        print(f'Backup saved: {final}\nSize: {final.stat().st_size/1024/1024:.2f} MiB. Restore has not been tested.',flush=True)
        return final
    finally:
        if proc is not None and proc.poll() is None:
            proc.terminate()
            try:
                proc.wait(timeout=5)
            except subprocess.TimeoutExpired:
                proc.kill();proc.wait()
        if partial.exists():
            partial.unlink()


def print_summary(state_dir):
    path=state_dir/'inventory-summary.json'
    print('\n--------- Sync checking details (read-only) ---------')
    if not path.exists():
        print('No report yet. Choose 3 to check mismatches.')
        return
    try:
        data=json.loads(path.read_text(encoding='utf-8'))
        print(f"Last completed check: {data['checked_at']}")
        print(f"{'Check':38} | {data['source']:18} | {data['destination']}")
        for label,left,right in [
            ('Total inventory rows',data['source_rows'],data['destination_rows']),
            ('New to destination (present / missing)',data['source_only'],data['source_only']),
            ('Updated / differing items',data['different'],data['different']),
            ('Deletion candidates (absent / present)',data['destination_only'],data['destination_only']),
            ('Already synchronized',data['synced'],data['synced']),
            ('Ambiguous codes excluded',data['source_ambiguous_codes'],data['destination_ambiguous_codes'])]:
            print(f'{label:38} | {left:18,} | {right:,}')
        if data.get('excluded_tables'):
            print('Not verified: '+', '.join(data['excluded_tables']))
        print('Synced = compared master fields match. Absence is not proof of historical deletion.')
        print('Detailed report: '+str((state_dir/'inventory-report.html').resolve()))
    except (OSError,ValueError,KeyError):
        print('Previous report is unreadable. Choose 3 to regenerate it.')


def run_menu(api,args):
    while True:
        config=runtime=None;main=None
        try:
            config=api.load_config(args.config,args.options)
            runtime,main=resolve_runtime(api,config)
        except Exception as exc:
            if isinstance(exc,api.SyncError):
                print('Configuration/connection unavailable: '+str(exc))
            else:
                code=exc.args[0] if exc.args and isinstance(exc.args[0],int) else 'n/a'
                print('Configuration/connection unavailable: '+type(exc).__name__+f' (code {code}). Check configuration and local MySQL.')
        print('\n========== Database Tools ==========')
        print('Connection config: '+str(args.config.resolve()))
        local_name=config.get('pool_db','unavailable') if config else 'unavailable'
        cloud_name=runtime.get('cloud_db','unavailable') if runtime else 'unavailable'
        role='unknown' if main is None else str(main).lower()
        print(f'1.) Backup Local Database ({local_name} : isMain={role})')
        print(f'2.) Backup Cloud Database ({cloud_name})')
        print('3.) Sync Data [CHECK ONLY - no updates/deletions]')
        print('4.) Exit')
        print_summary(args.state_dir)
        try:
            choice=input('\nSelect 1-4: ').strip()
            if choice=='4':
                print('Exited.');return 0
            if choice=='1' and config:
                backup_database(api,config,'pool_',args.state_dir)
            elif choice=='2' and runtime:
                backup_database(api,runtime,'cloud_',args.state_dir)
            elif choice=='3' and runtime:
                print('Checking mismatches only. No database updates or deletions will run.',flush=True)
                api.cycle(config,False,args.state_dir)
            elif choice in ('1','2','3'):
                print('This option needs a working configuration/connection.')
            else:
                print('Please enter 1, 2, 3 or 4.')
        except (EOFError,KeyboardInterrupt):
            print('\nStopped.');return 0
        except Exception as exc:
            # Our backup RuntimeErrors contain only controlled text. Driver errors do not.
            if type(exc) is RuntimeError or isinstance(exc,api.SyncError):
                print('Action failed: '+str(exc))
            else:
                print('Action failed: '+type(exc).__name__+'. No successful completion was recorded.')

