# Session handoff — 2026-09-29

## Quick recall

Repository: `C:\Users\USER\Documents\Projects\Algorithm`. Product name: SMIS. Java Swing desktop POS/inventory system; NetBeans Ant project, not Maven or Gradle. Branch `master`, last commit `d349d5a` (2022-02-05, `inv`). There are 786 Java source files. No files exist under the configured `test/` root; sample/test packages also exist under `src/`, but no automated test suite was run.

This session inspected configuration, compiled all application sources, and queried metadata from both configured databases. No application code, existing configuration, database schema, or business records were changed. The desktop application and synchronization jobs were not launched. Database inspection used SELECT statements and JDBC read-only connections.

## Verified state

| Check | Result |
| --- | --- |
| Source compilation | Passed with JDK 8, source/target 1.6, bundled `dist/lib/*` |
| Local database | `localhost:3306/db_algorithm_kabankalan`, MySQL 5.5.15 |
| Configured cloud database | `128.199.80.53:3306/db_algorithm`, MySQL 5.5.59-0ubuntu0.14.04.1 |
| Local structure | 150 InnoDB tables, 2,670 columns, 153 index-column records |
| Cloud structure | 140 InnoDB tables, 2,497 columns, 147 index-column records |
| Declared foreign keys | None in either inspected schema |
| Shared tables | 134; significant schema differences, detailed in DATABASE.md |

The cloud database requested as DigitalOcean was reached using the active application's settings. DigitalOcean account ownership, Droplet configuration, backups, and firewall configuration were not independently inspected; no cloud control-plane access was used.

## Configuration precedence

1. Entry point `src/POS/main/MyMain.java` calls `ret_config()`.
2. It loads `${user.home}/my_config.conf` if present, otherwise `my_config.conf` in the working directory. This is a choice of one file, not a merge.
3. On this user's machine the file is `C:\Users\USER\my_config.conf`. It sets `pool_host=localhost`, `pool_db=db_algorithm_kabankalan`, and `environment=development`. It does not supply pool username/password/port; startup uses the defaults in MyMain for these. Do not copy secret default values into documentation or commands.
4. MyMain sets JVM `pool_*` properties, then reads the local `settings` table through `Settings.ret_data`. It assumes a row exists (`datas.get(0)`) and supplies no ordering for that selection.
5. Cloud host, port, username, password, and database come from that settings row and become JVM `cloud_*` properties. MyMain does not load cloud credentials from the config file. Business information, printing settings, module switches, and software version also come partly from this row.
6. `src/POS/util/MyConnection.java` uses those JVM properties for JDBC. Its own credential defaults differ from MyMain's defaults: an initial isolated probe using connection-class defaults failed with MySQL 1045; matching actual startup precedence succeeded. The inspection helper now implements that precedence.

`src/POS/versions/my_config.conf` is a historical sample, not an automatically loaded configuration. Its database name differs from the active file. It includes sensitive values: do not paste it into logs. The legacy `MyConnection1.java` contains a separate connection path; it is not the main startup connection.

The sandbox Java process did not resolve `user.home` to the user's profile. Pass the explicit config path to the inspection helper. For any future app launch, confirm Java's effective user.home/config first.

Other connected files: `nbproject/project.properties` sets main class, source/target, UTF-8, and the external NetBeans library `libs.maytopacka.classpath`; `build.xml` imports generated NetBeans build logic; `manifest.mf` supplies packaging metadata; `applet.policy` is referenced by run.jvmargs. `.gitignore` excludes build, dist, and nbproject/private. No private NetBeans settings were found here.

## Code map

| Area | Starting points |
| --- | --- |
| Startup/dashboard | `src/POS/main/MyMain.java`, `src/POS/pnl/Pnl_Dashboard.java` |
| Local/cloud JDBC | `src/POS/util/MyConnection.java` |
| Database settings | `src/POS/settings/Settings.java` |
| Checkout | `src/POS/touchscreen/`, `src/POS/sales/` |
| Stock/catalog | `src/POS/inventory/`, `src/POS/adjuster/`, `src/POS/inventory_reports/` |
| Receiving/transfers | `src/POS/receipts/`, `src/POS/stock_transfer/` |
| Cloud synchronization | `src/POS/cloud/Cloud.java`, `src/POS/synch/Synch_stock_transfers.java` |
| Accounting | `src/POS/accounts_payable/`, `src/POS/accounts_receivable/`, `src/POS/cash_drawer/` |
| Reports | `*.jrxml` report sources, `*.jasper` compiled reports across feature folders |
| Historical SQL | `src/POS/versions/`, `src/POS/sql_updates/`, `src/POS/adjustments/` |

UI `.java` and `.form` files are paired NetBeans forms. SQL files are historical scripts, including adjustment/clearing operations; they are not a verified ordered migration system. Do not execute the directories wholesale. The placeholder `src/pos_retail/POS_Retail.java` is not the configured entry point.

## Build and recheck

Installed JDK: `C:\Program Files\Java\jdk1.8.0_101`. `java` is on PATH; `javac`, `ant`, `mysql`, and `doctl` were not found on PATH. Dependencies are present in `dist/lib/`, including custom Synapse utilities, JasperReports 4.7.0, and MySQL Connector/J 3.1.14. The pre-existing `dist/SMIS.jar` is dated 2024-02-02; it was not rebuilt or verified to match current sources.

Run `tools/CheckCompile.ps1` from the repository root to repeat the isolated compilation. The output goes to ignored `build/inspection-classes`, preserving the existing packaged application. This is compilation validation, not a full NetBeans packaging or GUI/runtime test. Warnings: missing Java 6 bootstrap classpath, internal `sun.net.www.content.image.gif` import, deprecated APIs and unchecked operations.

To refresh live metadata (overwrites snapshot files):

```powershell
New-Item -ItemType Directory -Force build/inspection | Out-Null
& 'C:\Program Files\Java\jdk1.8.0_101\bin\javac.exe' -d build/inspection tools/InspectDatabase.java
& 'C:\Program Files\Java\jdk1.8.0_101\bin\java.exe' -cp 'build/inspection;dist/lib/mysql-connector-java-3.1.14-bin.jar' InspectDatabase 'C:\Users\USER\my_config.conf'
```

The helper reads credentials into memory; it does not print them or persist settings records. It checks only the configured local schema and the cloud schema selected by the first settings row. It does not enumerate unrelated databases. The schema comparison is a separate snapshot and must be regenerated after metadata refresh.

## Existing work to preserve

These 14 tracked files were already modified before inspection:

- `src/POS/adjuster/Dlg_adjuster_inventory.form` and `.java`
- `src/POS/inventory_reports/Dlg_report_inventory_ledger.form` and `.java`
- `src/POS/main/MyMain.java`
- `src/POS/stock_transfer/Stock_transfers.java`
- `src/POS/synch/Synch_stock_transfers.java`
- `src/POS/touchscreen/Dlg_touchscreen_transactions.form` and `.java`
- `src/POS/touchscreen_reports/Dlg_report_ledger.java`
- `src/POS/touchscreen_reports/Dlg_report_sales_summary.form` and `.java`
- `src/POS/touchscreen_reports/rpt_end_of_day_summary.jrxml`
- `src/POS/util/DateType.java`

Pre-existing untracked files: `src/POS/adjustments/Inventory2024_date_adjustment.sql` and `src/POS/versions/2022_february_bayawan_inventory.sql`. Some existing diffs are large; do not reset, normalize, or reformat them as part of unrelated work.

## Recommended continuation

2026-10-05 menu update: `Run-Database-Menu.cmd` opens the Python menu with local/cloud full-database backup options, read-only Sync Data, and Exit. Current config now resolves the LOCAL database to `db_algorithm`, main=true (previous db_algorithm_kabankalan is historical), and cloud to db_algorithm. Menu option 3 is hard-coded read-only; use --once for a noninteractive check. Backups stream via installed MySQL 5.5 mysqldump to ignored .sync-state/backups. 24 tests passed; live menu check/exit tested; actual full backups/restores were not run. See tools/sync/README.md for details.

Detailed reporting: each worker check generates `.sync-state/inventory-report.html` with search, status filters and per-field source/destination values, plus Markdown/JSON summaries and JSONL detail. The read-only 2026-09-29 23:13 check found 368 new-to-cloud, 1,986 differing, 7,019 already-matching, 22 cloud-only and 538 ambiguous distinct codes across both sides. Counts refer to compared master catalog fields; not historical deletion events or every location row.

Inventory CRUD follow-up: read `docs/INVENTORY_STRUCTURE.md`. The worker now handles master status, embedded UOM prices, Java's child update fields and parent-only assembly deletion more accurately. Branch-specific edit scope and independent location-price changes remain outside its master-driven replication. 18 tests pass; refresh prior live plan counts before apply.

Python worker follow-up: `tools/sync/catalog_sync.py` and `tools/sync/README.md` implement bounded-memory catalog polling, role-based direction, automatic guarded deletions, price policy and reliable connection cleanup. Virtualenv `.venv-sync` has PyMySQL installed. Only read-only live comparison was run; no apply/watch service was deployed. Current findings: 9 local / 532 cloud duplicate barcode groups; 20 invalid assembly keys on each server; 2,352 unambiguous inventory upserts and 22 deletion candidates. Default deletion budget of 10 blocks apply until the plan is reviewed. See worker README before continuing.

Follow-up review: `docs/STOCK_TRANSFER_CHECK_ITEMS_REVIEW.md` traces both stock-transfer check_items methods and their inventory synchronization dialogs. It records deletion scope, threading/error handling, missed assembly changes, price policy, matching performance, and a transfer/header-item mismatch. Static review only; no sync was run or application code changed.

1. Read this handoff and DATABASE.md; check `git status --short` for newer work.
2. Identify the next requested feature/fix and inspect its existing edits before changing anything.
3. Before modifying sync, compare the exact tables/columns it reads and writes against both schema snapshots. Different branch/cloud roles may explain differences; do not automatically make the schemas identical.
4. Restore a reproducible NetBeans library configuration or build wrapper if packaging is needed. The current compile check already works with bundled dependencies.
5. Validate runtime changes against a development database copy. The config label `development` alone does not establish that current data is disposable.

Potential follow-up areas: plaintext credentials/defaults in legacy source and settings; absence of declared foreign keys; legacy JDBC/JDK dependencies; unchecked startup assumption that settings is nonempty. These were observed, not changed in this session.

Suggested next-session prompt: “Read docs/SESSION_HANDOFF.md and docs/DATABASE.md, preserve existing edits, then continue with [specific task].”
