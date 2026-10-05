"""One bounded scheduled sync run; Windows Task Scheduler supplies the hourly cadence."""
import argparse
from datetime import datetime
import json
import logging
from logging.handlers import RotatingFileHandler
import os
from pathlib import Path
import signal
import sys
import time

import catalog_sync as s


def config_path(root=s.ROOT, home=None):
    beside = root / 'my_config.conf'
    return beside if beside.is_file() else (home or Path.home()) / 'my_config.conf'


def run(config, state, apply):
    started = time.monotonic()
    committed = 0
    batches = s.number(config, 'sync_hourly_max_batches', 30, 1, 100)
    seconds = s.number(config, 'sync_hourly_max_seconds', 2700, 60, 3000)
    if not apply:
        result = s.cycle(config, False, state)
        return dict(status='checked', committed_items=0, batches=1, comparison=result['before'])
    for batch in range(1, batches + 1):
        if s.STOP.is_set() or time.monotonic() - started >= seconds:
            return dict(status='incomplete', reason='Stopped or time budget reached; next scheduled run resumes', committed_items=committed, batches=batch - 1)
        result = s.cycle(config, True, state)
        committed += result['committed']
        summary = result['before']
        main = summary['source'] == 'Main branch'
        if main and result.get('publication') == 'ready':
            return dict(status='completed', direction='main-to-cloud', publication='ready', committed_items=committed, batches=batch)
        if not result['committed']:
            enabled = s.bridge_guard.policies(s, config)
            blocked = (main or summary['ambiguous'] or any(t in enabled for t in summary['excluded_tables']) or
                       result.get('planned_items', 0) or any(summary[k] for k in ('source_only', 'different', 'destination_only')))
            return dict(status='blocked' if blocked else 'completed', direction='main-to-cloud' if main else 'cloud-to-branch',
                        reason='Review publication status, duplicate identities and excluded tables' if blocked else '',
                        committed_items=committed, batches=batch, comparison=summary)
    return dict(status='incomplete', reason='Batch limit reached; next scheduled run resumes', committed_items=committed, batches=batches)


def main(argv=None):
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument('--config', type=Path, default=config_path())
    parser.add_argument('--options', type=Path, default=s.ROOT / 'sync.local.conf')
    parser.add_argument('--state-dir', type=Path, default=s.ROOT / '.sync-state')
    mode = parser.add_mutually_exclusive_group(required=True)
    mode.add_argument('--apply', action='store_true', help='Apply role-directed changes; intended for the hourly scheduled task')
    mode.add_argument('--check-only', action='store_true', help='Read-only comparison, no database changes')
    mode.add_argument('--validate', action='store_true', help='Check local configuration syntax without database connections')
    args = parser.parse_args(argv)
    args.state_dir.mkdir(parents=True, exist_ok=True)
    s.LOG.setLevel(logging.INFO)
    formatter = logging.Formatter('%(asctime)s %(levelname)s %(message)s')
    handlers = [RotatingFileHandler(args.state_dir / 'hourly-sync.log', maxBytes=1_000_000, backupCount=3)]
    if sys.stderr is not None:
        handlers.append(logging.StreamHandler())
    for handler in handlers:
        handler.setFormatter(formatter)
        s.LOG.addHandler(handler)
    for sig in (signal.SIGINT, signal.SIGTERM):
        signal.signal(sig, lambda *_: s.STOP.set())
    try:
        config = s.load_config(args.config, args.options)
        if args.validate:
            if 'main_branch' in config:
                s.boolean(config, 'main_branch')
            s.number(config, 'sync_hourly_max_batches', 30, 1, 100)
            s.number(config, 'sync_hourly_max_seconds', 2700, 60, 3000)
            s.LOG.info('Configuration loads; database connectivity/role has not been checked')
            return 0
        s.LOG.info('scheduled run started mode=%s config=%s', 'apply' if args.apply else 'check', args.config)
        result = run(config, args.state_dir, args.apply)
    except Exception as exc:
        code = exc.args[0] if exc.args and isinstance(exc.args[0], int) else 'n/a'
        reason = str(exc) if isinstance(exc, s.SyncError) else f'{type(exc).__name__} code={code}; check connection/configuration'
        result = dict(status='failed', reason=reason)
        s.LOG.error('%s', reason)
    result['finished_at'] = datetime.now().astimezone().isoformat(timespec='seconds')
    result['mode'] = 'apply' if args.apply else 'check'
    # Read-only testing must not overwrite the last scheduled apply status.
    name = 'hourly-status.json' if args.apply else 'hourly-check-status.json'
    temporary = args.state_dir / (name + f'.{os.getpid()}.tmp')
    temporary.write_text(json.dumps(result, indent=2), encoding='utf-8')
    os.replace(temporary, args.state_dir / name)
    s.LOG.info('scheduled run finished status=%s committed_items=%s', result['status'], result.get('committed_items', 'see journal'))
    return 0 if result['status'] in ('completed', 'checked') else 2


if __name__ == '__main__':
    raise SystemExit(main())
