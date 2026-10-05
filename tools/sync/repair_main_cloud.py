"""Explicit one-time main-to-cloud reconciliation with backups and verification."""
import argparse
import json
import logging
from pathlib import Path

import catalog_sync as s
import sync_menu as menu


def run(config_path, options, state, reuse_backups=False):
    config=s.load_config(config_path,options)
    runtime,main=menu.resolve_runtime(s,config)
    if not main:
        raise s.SyncError('Repair requires the local main branch; no writes executed')
    # Fix direction for this invocation even if settings later change.
    config['main_branch']='true'
    manifest=state/'pre-repair-backups.json'
    if reuse_backups:
        files=json.loads(manifest.read_text(encoding='utf-8'))
        if len(files)!=2 or any(not Path(p).is_file() or not Path(p).stat().st_size for p in files):
            raise s.SyncError('Two completed backup files required')
    else:
        files=[str(menu.backup_database(s,runtime,prefix,state)) for prefix in ('pool_','cloud_')]
        manifest.write_text(json.dumps(files,indent=2),encoding='utf-8')
    total=0
    for batch in range(1,32):
        # Start with one item; every later batch commits at most 100 items.
        config['sync_max_changes']='1' if batch==1 else '100'
        result=s.cycle(config,True,state)
        total+=result['committed']
        check=s.cycle(config,False,state)
        remaining=sum(check['before'][k] for k in ('source_only','different','destination_only'))
        print(f'VERIFIED batch={batch} committed_total={total} remaining_unambiguous={remaining}',flush=True)
        if not remaining:
            break
        if result['committed']==0:
            raise s.SyncError('No forward progress; inspect stale/collation-conflicting records before retrying')
    else:
        raise s.SyncError('Batch limit reached; some differences remain')
    output={'committed_items':total,'remaining_unambiguous':remaining,'ambiguous_codes':check['before']['ambiguous'],'excluded_tables':check['before']['excluded_tables'],'publication':result.get('publication'),'backups':files}
    (state/'repair-result.json').write_text(json.dumps(output,indent=2),encoding='utf-8')
    print(json.dumps(output,indent=2),flush=True)


if __name__=='__main__':
    parser=argparse.ArgumentParser(description=__doc__)
    parser.add_argument('--config',type=Path,required=True)
    parser.add_argument('--options',type=Path,default=s.ROOT/'sync.local.conf')
    parser.add_argument('--state-dir',type=Path,default=s.ROOT/'.sync-state')
    parser.add_argument('--reuse-backups',action='store_true',help='Use completed pre-repair backups from this repair session')
    parser.add_argument('--apply',action='store_true',required=True,help='Explicitly authorize the one-time cloud repair')
    args=parser.parse_args()
    args.state_dir.mkdir(parents=True,exist_ok=True)
    logging.basicConfig(level=logging.INFO,format='%(asctime)s %(levelname)s %(message)s')
    try:
        run(args.config,args.options,args.state_dir,args.reuse_backups)
    except Exception as exc:
        if isinstance(exc,s.SyncError):
            print('Repair stopped: '+str(exc))
        else:
            code=exc.args[0] if exc.args and isinstance(exc.args[0],int) else 'n/a'
            print(f'Repair stopped: {type(exc).__name__} code={code}; see applied-changes.jsonl for completed items')
        raise SystemExit(1)
