# Lightweight SMIS catalog synchronization

## Interactive menu (added 2026-10-05)

Double-click `Run-Database-Menu.cmd` in the project root, or run:

```powershell
.\.venv-sync\Scripts\python.exe tools/sync/catalog_sync.py --menu --config "$env:USERPROFILE\my_config.conf"
```

The menu shows the current local database and isMain flag, cloud database name, and the last completed sync summary:

```text
1.) Backup Local Database (database_name : isMain=true/false)
2.) Backup Cloud Database (database_name)
3.) Sync Data [CHECK ONLY - no updates/deletions]
4.) Exit
--------- Sync checking details (read-only) ---------
```

Option 3 always passes apply=False, then returns to the menu with the refreshed mismatch summary and HTML report path. No restore/apply operation exists in this menu. Reports shown before a check are historical and include their timestamp. `sync.local.conf` is now loaded automatically when it exists. Interactive menu is the default when --once, --watch and --apply are absent; use --once for unattended single read-only checks. Explicit command-line --apply and --watch behavior is unchanged and is outside the read-only menu.

Backups use installed mysqldump, streaming directly to `.sync-state/backups/local_DATABASE_TIMESTAMP.sql` or `cloud_DATABASE_TIMESTAMP.sql`. The entire named database is requested, including data, schema, views, triggers, routines and events. This does not back up MySQL users/grants, server configuration, or other databases. The installed client discovered here is MySQL 5.5 under `C:/Program Files (x86)/MySQL/MySQL Server 5.5/bin/`.

Options: backup_mysqldump overrides the executable; backup_directory overrides the output folder; backup_timeout defaults to 3600 seconds. Use forward slashes in configuration paths. mysqldump's password is passed only in its child-process environment, never in command-line arguments or a temporary credential file. SQL backups themselves include sensitive business/settings records: keep the backup directory private and outside version control. Custom backup folders outside .sync-state need their own exclusion/access controls.

Successful exit and nonempty output are required before renaming a .partial file to .sql. Failure, timeout or Ctrl+C terminates the child and removes incomplete output. Existing backups are not overwritten. No restore is performed or claimed as verified. Single-transaction plus quick keeps client memory low and provides an InnoDB snapshot; do not change schema during a dump, and nontransactional tables would need a separate consistency strategy. See [MySQL's mysqldump documentation](https://dev.mysql.com/doc/refman/8.0/en/mysqldump.html). A compatible client and privileges for tables, views, routines, triggers and events are required; errors return to the menu instead of marking the backup successful.

Verification: 24 automated tests passed, including fake-process backup success/failure and password argument checks. The real menu's options 3 then 4 were exercised against the configured databases on 2026-10-05; no database writes ran. Full production backups and restore testing were not run during menu development.

One Python process, PyMySQL, standard-library SQLite, and no Java GUI. Run one worker on the main database server and one on each of the two branch database servers. The main worker pushes local catalog changes to the cloud; branch workers pull cloud changes into their local databases.

## Setup on each machine

Python 3.10+ is required. From the project root:

```powershell
python -m venv .venv-sync
.\.venv-sync\Scripts\python.exe -m pip install -r tools/sync/requirements.txt
Copy-Item tools/sync/sync.example.conf sync.local.conf
```

This session already created `.venv-sync` and installed PyMySQL on this machine. `sync.local.conf`, the virtual environment, and `.sync-state` are git-ignored. Do not commit credentials.

Connection properties are read from the existing `my_config.conf`. When running inside this repository, missing pool credentials are resolved from MyMain's startup defaults in memory. For standalone deployment, put explicit `pool_host`, `pool_port`, `pool_db`, `pool_user`, and `pool_password` in the existing private configuration. Cloud connection details come from its local `settings` row, matching Java startup. Exactly one settings row is required.

Set `main_branch=true` on the main server and `main_branch=false` on both real branches in `sync.local.conf`. If omitted, the worker uses `main_branch` from my_config.conf, then `settings.is_main_branch`. It cannot read a running JVM's System properties directly. In this session the current local settings reported main branch = 1, even though the schema name is db_algorithm_kabankalan. Confirm each machine's role when deploying.

## Run

First run a read-only comparison:

Each successful snapshot now also generates `.sync-state/inventory-report.html` (searchable, includes already-synced items and old/new field values), `inventory-summary.md`, `inventory-summary.json`, and `inventory-details.jsonl`. New and missing/deletion categories describe current presence, not proven historical events. Duplicate master codes remain ambiguous. “Already synced” checks actual compared master values, not is_uploaded flags, and does not verify every location record. Open the HTML report in a browser; all files are local and no external resources are loaded.

```powershell
.\.venv-sync\Scripts\python.exe tools/sync/catalog_sync.py --config "$env:USERPROFILE\my_config.conf" --options sync.local.conf --once
```

Then a single write cycle, after reviewing the comparison and limits:

The dry-run saves `.sync-state/last-plan.jsonl` with proposed operations, item keys and changed field names. It excludes credentials and field values. It is a proposed plan, not a record of committed writes, and is replaced after a successful snapshot on each cycle; check its timestamp. To view just the deletion candidates:

```powershell
Get-Content .sync-state/last-plan.jsonl | ForEach-Object { $_ | ConvertFrom-Json } | Where-Object operation -eq 'delete' | Format-Table table,key
```

Apply command:

```powershell
.\.venv-sync\Scripts\python.exe tools/sync/catalog_sync.py --config "$env:USERPROFILE\my_config.conf" --options sync.local.conf --apply
```

For ongoing monitoring, add `--watch` to that command. It runs a cycle, closes both MySQL sessions, and waits 300 seconds by default. Ctrl+C stops gracefully between units of work; an in-flight database operation is bounded by its socket timeout. `--watch` without `--apply` only monitors/reports differences. No Windows scheduled task or startup service was installed in this session. The worker was not started in production write mode.

The script resolves files relative to its location except explicitly supplied paths. For startup via Windows Task Scheduler, use the full Python executable and script/config/options paths, set the project as Start in, run under the account that can read the private config, and select “Do not start a new instance.” A database advisory lock also excludes cooperating script instances writing the same destination. It does not lock out the Java sync code: stop using the legacy catalog sync action while this worker is active.

## Policies

| Option | Default | Behavior |
| --- | --- | --- |
| sync_interval | 300 | Seconds between completed cycles |
| sync_page_size | 200 | Maximum catalog records read per page |
| sync_max_changes | 100 | Maximum committed item/assembly operations per cycle |
| sync_prices | false | Preserve existing branch prices; main-to-cloud always copies main prices |
| sync_deletes | true | Automatically delete destination-only items within deletion limits |
| sync_max_deletes | 10 | Maximum planned deletions per table before blocking the write cycle |
| sync_delete_percent | 5 | Maximum fraction of destination rows removed per table, as a percent |
| sync_duplicates | skip | Skip duplicate identities on either side; `stop` instead aborts the cycle |
| sync_connect_timeout | 10 | Connection timeout in seconds |
| sync_read_timeout / sync_write_timeout | 30 | Socket timeouts in seconds |

Deletion limits are checked against the whole plan before any writes, not reset after each group of 100 changes. An empty source cannot wipe a populated destination. A blocked deletion plan is displayed in dry-run; `--apply` exits without applying it. For the current 22 deletion candidates, review the affected data before increasing the limit above 10; do not blindly disable the guard.

Updates preserve existing inventory and location stock quantities, IDs, location ownership, serial numbers, and transaction history. New inventory/location records begin with zero stock. Main prices update cloud prices. Existing branch selling prices remain unchanged under the current policy; set sync_prices=true if branches should inherit cloud prices too. Newly inserted items receive the source price even when existing branch prices are preserved.

Catalog fields include names, categories and IDs, units/conversion, prices under the selected policy, costs, supplier information, markup, brand/model, flags and barcodes. Assembly component quantity is a recipe value and is synchronized; it is not the branch's on-hand stock quantity. The worker does not transfer sales, receipts, stock transfers, or account transactions.

Inventory deletion also removes its destination inventory_barcodes and parent assembly rows, atomically for that item, matching Inventory.delete_inventory. Assembly membership additions, updates and removals follow the same source authority. Invalid/empty identity keys exclude the whole affected table from writes; invalid inventory also excludes assemblies. Duplicate barcodes are skipped, including assembly operations whose exact parent/component key is blocked. No duplicate cleanup is performed automatically.

## Memory, retries and consistency

The cloud inventory table has no dependable updated_at column, and the existing is_uploaded flags do not capture hard deletions or all write paths. Consequently each cycle reads catalog snapshots in primary-key pages, compares them in a temporary disk-backed SQLite file, and writes only differences. This reduces Python memory use, but it is still a full catalog poll over the network, not change-data capture. No triggers, new MySQL tables, or indexes are installed.

SQLite's page cache is limited to approximately 2 MiB; payload memory is proportional to page size. This is not a hard cap on total process RAM. Temporary snapshots contain catalog data, never connection settings, and are removed on normal exit. An OS crash may leave a snapshot directory under .sync-state; keep that directory private. Logs rotate at 1 MB with three backups and contain counts/error codes rather than passwords, SQL values, or product details.

Every cursor is closed. Connections are explicitly closed in finally blocks on success, exception, and timeout. Each item and its related barcode changes use one destination transaction, with rollback on error. The worker rereads source and destination before writes and skips stale candidates. A lost commit response is reconciled by the next full comparison, rather than blind repeated inserts. Source data is never modified or marked uploaded: Java's is_uploaded counters may still show pending work, and should not be used as this worker's completion status.

No distributed transaction is claimed: edits made during a cycle are eventually picked up on a later poll. Exact key differences that compare equal under MySQL collation are conservatively skipped by the live recheck; normalize those identities during data cleanup. Do not concurrently run another catalog writer against the same destination. Only script instances honor its advisory lock. The destination's existing InnoDB row locks protect individual updates, not a cross-server snapshot.

Existing barcode records are refreshed when their parent inventory record changes, and missing location records are created for that changed item. Independent edits to inventory_barcodes with an unchanged inventory master are not a trigger for repair in this version. The worker assumes each catalog's master inventory is authoritative. SQL scans can still be costly because the live databases lack barcode indexes; deduplicate and assess indexes separately before increasing polling frequency.

## Findings from 2026-09-29

- Read-only main-to-cloud comparison: 9,884 local inventory rows; 10,095 cloud inventory rows.
- Local duplicate identity groups: 9 (18 rows). Cloud: 532 groups (1,066 rows, 534 excess rows).
- With ambiguous identities excluded: 2,352 inventory upserts and 22 deletion candidates. These are a point-in-time plan, not an approval or applied result.
- Each database has 20 assembly rows with empty/null identity keys. Assembly writes are excluded until repaired.
- Cloud wait_timeout and interactive_timeout: 28,800 seconds. Observed Threads_connected=41, max_connections=151, historical Max_used_connections=83. These values do not prove a timeout incident.
- Confirmed Java leak: Inventory.edit_inventory_cloud opens a cloud connection at line 2150 and only invokes MyConnection.close at line 2320, which closes the shared local connection; its finally block is empty. Inventory.ret_data22_cloud also has an empty cleanup block. add_inventory_cloud closes both connections only on success; its error path leaks them.
- No Java code, production records, server timeout settings, or schema were changed. No production write cycle has been run.
- Measured full dry-run: approximately 8 seconds and 32.76 MiB peak working set of the actual Python worker process on Windows. This is one measurement on the current catalog, not a guaranteed memory ceiling or a measurement of apply mode.

PyMySQL connection/timeout behavior was checked against its [official implementation](https://github.com/PyMySQL/PyMySQL/blob/main/pymysql/connections.py).

## Tests

```powershell
.\.venv-sync\Scripts\python.exe -m unittest discover -s tools/sync -p "test_*.py" -v
```

Tests use fake connections/in-memory SQLite to cover comparison, transaction rollback, lost-response retries, deletions, branch price/quantity preservation and resource cleanup. Live verification is read-only; end-to-end writes must be validated on isolated database copies before deployment.

18 tests pass after the POS.inventory review. See ../../docs/INVENTORY_STRUCTURE.md for the CRUD contract and remaining differences. Branch price preservation now retains unit and conversion too, because the serialized unit field embeds prices. Master status is replicated; existing child update fields match Java's catalog edit. Prior live comparison counts predate these changes and need refreshing before apply.
