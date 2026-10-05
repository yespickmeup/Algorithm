"""Cloud publication gate shared by main and branch workers (MySQL 5.5)."""
import hashlib
from contextlib import contextmanager, suppress

TABLE = 'smis_catalog_publication'
VERSION = 2


def scope_for(api, config):
    return 'inventory+assembly' if api.boolean(config, 'sync_assemblies', False) else 'inventory'


def policies(api, config, prices=True):
    result = {'inventory': api.sync_columns(api.CATALOG, prices)}
    if scope_for(api, config) == 'inventory+assembly':
        result['inventory_assembly'] = api.sync_columns(api.ASSEMBLY, prices)
    return result


def role(api, config, settings):
    value = settings['is_main_branch']
    if value not in (0, 1):
        raise api.SyncError('settings.is_main_branch must be 0 or 1')
    main = value == 1
    if 'main_branch' in config and api.boolean(config, 'main_branch') != main:
        raise api.SyncError('main_branch configuration conflicts with local settings.is_main_branch; correct the machine role before syncing')
    return main


def fingerprint(api, cloud, scope='inventory'):
    digest = hashlib.sha256()
    tables = [('inventory', api.CATALOG)]
    if scope == 'inventory+assembly':
        tables.append(('inventory_assembly', api.ASSEMBLY))
    for table, columns in tables:
        digest.update((table + '\n').encode())
        names = ['id'] + api.KEYS[table] + columns
        with cloud.cursor(api.pymysql.cursors.SSDictCursor) as cur:
            cur.execute('SELECT ' + ','.join(map(api.qi, names)) + ' FROM ' + api.qi(table) + ' ORDER BY id')
            while True:
                rows = cur.fetchmany(200)
                if not rows:
                    break
                for row in rows:
                    digest.update((api.encode(row) + '\n').encode('utf-8'))
    return digest.hexdigest()


def ensure_table(api, cloud):
    api.execute(cloud, f'''CREATE TABLE IF NOT EXISTS {TABLE} (
        id TINYINT NOT NULL PRIMARY KEY,
        protocol_version INT NOT NULL,
        status VARCHAR(16) NOT NULL,
        catalog_hash CHAR(64) NOT NULL,
        reason VARCHAR(255) NOT NULL,
        scope VARCHAR(32) NOT NULL DEFAULT 'inventory+assembly',
        checked_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
    ) ENGINE=InnoDB''')
    if 'scope' not in api.fields(cloud, TABLE):
        api.execute(cloud, f"ALTER TABLE {TABLE} ADD COLUMN scope VARCHAR(32) NOT NULL DEFAULT 'inventory+assembly'")


def set_status(api, cloud, status, reason='', catalog_hash='', scope='inventory'):
    api.execute(cloud, f'''INSERT INTO {TABLE}
        (id,protocol_version,status,catalog_hash,reason,scope,checked_at)
        VALUES (1,%s,%s,%s,%s,%s,CURRENT_TIMESTAMP)
        ON DUPLICATE KEY UPDATE protocol_version=VALUES(protocol_version),
        status=VALUES(status),catalog_hash=VALUES(catalog_hash),reason=VALUES(reason),
        scope=VALUES(scope),checked_at=CURRENT_TIMESTAMP''', (VERSION, status, catalog_hash, reason, scope))


def require_ready(api, cloud, config=None):
    exists = api.query(cloud, 'SELECT TABLE_NAME FROM information_schema.TABLES WHERE TABLE_SCHEMA=DATABASE() AND TABLE_NAME=%s', (TABLE,))
    if not exists:
        raise api.SyncError('Cloud has no verified publication; run the updated main worker first')
    rows = api.query(cloud, f'SELECT * FROM {TABLE} WHERE id=1')
    if len(rows) != 1 or rows[0]['protocol_version'] != VERSION or rows[0]['status'] != 'ready':
        raise api.SyncError('Cloud publication is not ready; branch writes blocked until main completes a clean sync')
    expected = scope_for(api, config or {})
    if rows[0].get('scope') != expected:
        raise api.SyncError('Cloud publication scope differs from this worker; align sync_assemblies on main and branches')
    if rows[0]['catalog_hash'] != fingerprint(api, cloud, expected):
        raise api.SyncError('Cloud catalog changed after publication; main must verify it again before branch writes')


@contextmanager
def publication_session(api, cloud, main, apply, config=None):
    if not apply:
        yield
        return
    # GET_LOCK on MySQL 5.5 releases a previous named lock on the SAME connection.
    # Main therefore uses only this cloud lock; branches also lock their separate local connection.
    lock = 'smis_bridge_' + hashlib.sha256(str(cloud.db).encode()).hexdigest()[:32]
    if api.query(cloud, 'SELECT GET_LOCK(%s,0) AS acquired', (lock,))[0]['acquired'] != 1:
        raise api.SyncError('Cloud bridge is busy; retry after the current main/branch cycle')
    try:
        if main:
            ensure_table(api, cloud)
            set_status(api, cloud, 'pending', 'Main verification or reconciliation in progress', scope=scope_for(api, config or {}))
        else:
            require_ready(api, cloud, config)
        yield
    finally:
        with suppress(Exception):
            api.query(cloud, 'SELECT RELEASE_LOCK(%s)', (lock,))


def finish_publication(api, source, cloud, disk, config):
    # Fresh snapshots after all committed writes, never the pre-apply plan.
    for table in ('snapshot', 'blocked', 'disabled', 'totals'):
        disk.execute('DELETE FROM ' + table)
    active = policies(api, config)
    scope = scope_for(api, config)
    for side, conn in (('source', source), ('destination', cloud)):
        api.execute(conn, 'SET SESSION TRANSACTION ISOLATION LEVEL REPEATABLE READ')
        api.execute(conn, 'START TRANSACTION WITH CONSISTENT SNAPSHOT')
        try:
            for table, cols in active.items():
                api.snapshot(conn, disk, side, table, cols, api.number(config, 'sync_page_size', 200, 1, 1000), 'skip')
            if side == 'destination':
                catalog_hash = fingerprint(api, cloud, scope)
        finally:
            conn.rollback()
    reason = publication_problem(api, disk, active)
    set_status(api, cloud, 'blocked' if reason else 'ready', reason, '' if reason else catalog_hash, scope)
    api.LOG.info('cloud publication=%s scope=%s reason=%s', 'blocked' if reason else 'ready', scope, reason or 'all enabled catalog tables verified')
    return 'blocked' if reason else 'ready'


def publication_problem(api, disk, tables=None):
    tables = list(api.KEYS if tables is None else tables)
    placeholders = ','.join('?' for _ in tables)
    if disk.execute('SELECT 1 FROM disabled WHERE tbl IN (' + placeholders + ') LIMIT 1', tables).fetchone():
        return 'Invalid identity keys exclude a catalog table'
    if disk.execute('SELECT 1 FROM blocked WHERE tbl IN (' + placeholders + ') LIMIT 1', tables).fetchone():
        return 'Duplicate catalog identities require reconciliation'
    if not disk.execute("SELECT 1 FROM snapshot WHERE side='source' AND tbl='inventory' LIMIT 1").fetchone():
        return 'Main inventory is empty'
    if any(next(api.plan(disk, table), None) is not None for table in tables):
        return 'Catalog differences remain; main must finish publishing'
    return ''
