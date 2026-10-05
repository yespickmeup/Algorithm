# Database Tools for Windows

This package runs independently of Java. Use a separate copy/configuration on main and each branch.

1. Extract the ZIP to a permanent writable folder on the server. When updating an existing installation, overwrite program files but keep its private `my_config.conf`, `sync.local.conf`, `.venv-sync` and `.sync-state`. Wait for a running sync to finish before replacing files.
2. Run **Install-Windows.cmd** to install/check Python and dependencies.
3. Configure **this server's local database** in `my_config.conf`. The local database setting `is_main_branch` must be 1 on main and 0 on each other branch. Any `main_branch` option must agree. Cloud connection details come from the local database's settings row.
4. Run **Test-Sync-ReadOnly.cmd** first. It checks differences without applying changes. Review `.sync-state/inventory-report.html`.
5. To enable automatic writes, run **Install-Hourly-Sync.cmd**. Enter the current Windows account's password, not its PIN or MySQL password, so Windows can run the task while signed out. Some server policies require an administrator to register scheduled tasks. Cancelling does not enable hourly sync.

The task starts about two minutes after registration and repeats **every hour, every day**. On main it pushes local catalog changes to cloud. On another branch it pulls a verified cloud catalog into that branch. Python exits after each run; it does not stay in memory between hourly runs. Keep the server powered on and connected. Windows runs a missed start when possible; it cannot sync while the computer is off. No Java build is needed.

The Windows task is named **Algorithm Inventory Hourly Sync**. Re-running its installer updates that task, rather than creating another one. After moving the package folder or changing the Windows account password, rerun the hourly installer. Task Scheduler lets you Run, Disable or Delete this task. Deleting it does not remove your database or files.

Main catalog prices always update cloud. Existing branch prices are preserved by default (`sync_prices=false`); use `true` on branches if they must follow main prices. Existing stock quantities stay local; new rows start at zero. Deletions follow source authority with limits. Assembly syncing is explicitly disabled (`sync_assemblies=false`): all assembly rows remain untouched, including when an inventory item is deleted. Stop legacy Java/older Python catalog writers before using the new publication protocol.

## Status and current limitations

- `.sync-state/hourly-status.json`: latest automatic apply result and completion time.
- `.sync-state/hourly-sync.log`: rotating worker log.
- `.sync-state/hourly-check-status.json`: separate read-only test result.
- Task Scheduler result 0 means completed; 2 means blocked, incomplete or failed. Windows retries a failed run up to three times at five-minute intervals, then the next hourly trigger can try again.
- A run processes up to 30 batches and starts no new batch after 45 minutes. Windows imposes a 55-minute backstop. Unfinished work is compared again on the next run.
- Branch writes require a verified cloud publication. Protocol v2 records and checks the publication scope. The local-main duplicate repair selected the latest updated/created records and published a verified inventory-only catalog; the 20 invalid assembly rows on each side remain unchanged. Keep `sync_assemblies=false` on main and branches. Do not enable assemblies until their parent codes are repaired and a full publication is verified. Older protocol-v1 workers will refuse the new publication: update every machine to this package. Future inventory duplicates or incomplete publication still block verification; hourly runs do not automatically delete duplicate records.

For accounts without a usable Windows password, an explicit logged-in-only alternative is documented in `tools/sync/WINDOWS_INSTALL.md`. No task is installed just by extracting this package or running the read-only test.
