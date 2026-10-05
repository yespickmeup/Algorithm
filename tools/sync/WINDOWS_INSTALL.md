# Fresh Windows installation

## Quick setup

1. Copy/extract the Database-Tools-Windows package to a writable folder such as `C:\Users\YourName\Documents\AlgorithmTools`. Do not run inside the ZIP or under Program Files.
2. Double-click **Install-Windows.cmd**. Internet access is needed for Python (if absent) and PyMySQL.
3. Configure this machine's local MySQL connection in `my_config.conf`. The launcher prefers the file beside Run-Database-Menu.cmd; only if absent does it use `%USERPROFILE%\my_config.conf`. Setup preserves existing configuration or creates a project-local template if neither file exists. Fill every pool field, including username and password. The standalone package does not contain the Java source's credential defaults. The menu displays the active configuration path.
4. Check local `settings.is_main_branch` (1 on main, 0 on a branch). If `main_branch` is set in `sync.local.conf` or `my_config.conf`, it must match this database setting; mismatches stop the worker. Do not copy main's connection configuration to a branch.
5. Double-click **Run-Database-Menu.cmd**. Option 3 checks mismatches only; it does not apply updates/deletions.

Cloud credentials/database name are read from the local database's existing settings row. The installer does not create a MySQL database/server or restore any data: the configured local server and its settings table must already exist and be accessible.

## Hourly unattended sync

After the read-only check, run `Install-Hourly-Sync.cmd` to register **Algorithm Inventory Hourly Sync**. This explicitly enables writes: main pushes to cloud; other branches pull only verified publications. The first run is about two minutes after installation, then every hour indefinitely, every day. Python exits between runs. The task uses `pythonw.exe` to avoid console windows and ignores overlapping starts.

The default installer asks for the current Windows account password so the task can run while signed out. Use the real password, not Windows Hello PIN or MySQL credentials. Windows Task Scheduler manages that credential; the package does not store it. Account/server policies may require an administrator or batch-logon rights. A registration failure is reported; it is not treated as success. Do not run under an unrelated account whose Python/configuration paths differ.

If you intentionally only need runs while the current user is signed in, use:

```powershell
powershell.exe -NoProfile -ExecutionPolicy Bypass -File .\Install-Hourly-Sync.ps1 -LoggedOnOnly
```

To validate configuration and the task definition without scheduling or database connections:

```powershell
powershell.exe -NoProfile -ExecutionPolicy Bypass -File .\Install-Hourly-Sync.ps1 -CheckOnly
```

`Test-Sync-ReadOnly.cmd` runs the new runner in check mode. Scheduled apply results go to `.sync-state/hourly-status.json` and `hourly-sync.log`; check results use a separate JSON file. Blocked/incomplete/failed runs return code 2 and Windows retries up to three times at five-minute intervals. Each run catches up in up to 30 batches, stops starting batches after 45 minutes, and has a 55-minute Task Scheduler execution limit. Per-item transactions and the pending publication flag support recovery after interruption. The next run compares actual data again. `sync_hourly_max_batches` and `sync_hourly_max_seconds` may be overridden in existing options; the hourly schedule is controlled by Task Scheduler, independently of `sync_interval` used by legacy `--watch`.

Re-run the hourly installer after moving the package, changing the account password or changing the selected config path. Disable/delete the named task in Task Scheduler to stop automatic runs. Update all branches and stop legacy catalog writers; missing/blocked cloud publication still prevents branch writes. Keep `sync_assemblies=false` on every machine for the verified inventory-only publication. All assembly rows remain untouched until their parent codes can be repaired. Protocol-v1 packages must be updated to accept protocol-v2 publication scope. The server must be powered on and online; missed starts run when Windows can, not while the server is off.

## Python environment installation

- Reuses a working Python 3.10+ installation when found, or downloads the latest stable Python 3.13 Windows installer listed on python.org for x64, x86 or ARM64.
- Requires a valid Authenticode signature issued to Python Software Foundation before executing the downloaded installer.
- Installs Python for the current user without adding a global PATH entry or requesting administrator rights. Windows 10/11 or Windows Server 2016+ is required for automatic installation.
- Creates `.venv-sync`, installs the pinned PyMySQL requirement from PyPI, checks dependencies and validates imports/menu help without connecting to any database.
- Preserves existing configuration. Copies default options and a credential-free connection template only when needed.
- Checks for mysqldump. A missing backup client does not prevent Python sync checks.

Official references: [Windows downloads](https://www.python.org/downloads/windows/) and [Python Windows installation options](https://docs.python.org/3.13/using/windows.html). Installer execution policy bypass applies to this setup process only; it does not change the system policy. Managed computers may still require their administrator's software-installation approval.

## Backups on a fresh PC

Install/provide a mysqldump client compatible with the MySQL server version. Configure its full path in `sync.local.conf`, using forward slashes:

```properties
backup_mysqldump=C:/Path/To/MySQL/bin/mysqldump.exe
```

The installer intentionally does not install or reconfigure a MySQL server. If providing a portable client, include its required runtime/DLL files, not just an isolated executable. Backup options need this client; report checking uses PyMySQL directly.

## Advanced setup and checking

Use an already-installed interpreter if automatic discovery misses it:

```powershell
powershell.exe -NoProfile -ExecutionPolicy Bypass -File .\Install-Windows.ps1 -PythonExe 'C:\Path\To\python.exe'
```

Read-only environment validation:

```powershell
powershell.exe -NoProfile -ExecutionPolicy Bypass -File .\Install-Windows.ps1 -CheckOnly
```

If this PC has no Python and downloads are blocked, install an approved Python 3.10+ distribution first and rerun setup. If an existing .venv-sync was copied from another PC and is broken, rename it before rerunning; virtual environments should be created on each PC. The installer does not delete old environments or user data.

Run the installer again after updating the tools to reuse the environment and check/install the pinned dependency. Do not copy `.sync-state` (reports/backups), `.venv-sync`, `sync.local.conf`, or real `my_config.conf` into a distribution ZIP. Transfer credentials separately through your normal private process.

## Validation performed

Hourly package: 51 tests passed from the packaged directory; the new read-only runner checked the configured databases with zero writes. The hourly task definition passed `Install-Hourly-Sync.ps1 -CheckOnly` using Windows ScheduledTasks. No task was registered here, and Windows credential registration/signed-out execution still needs the server test. `tools/build_sync_package.py` refreshes both `dist/Database-Tools-Windows` and its ZIP and checks that every packaged file matches; SHA256SUMS.txt is included.

Tested with Windows PowerShell 5.1: syntax and check-only mode; a clean project-folder setup using an existing interpreter created a new venv, installed PyMySQL and passed dependency/import checks. 24 Python tests passed. A truly Python-free Windows VM and the downloaded Python install/signature path have not been executed in this session. Setup/testing did not connect to or change database records.
