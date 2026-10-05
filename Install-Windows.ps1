#Requires -Version 5.1
[CmdletBinding()]
param(
    [string]$PythonExe,
    [switch]$CheckOnly
)

$ErrorActionPreference = 'Stop'
$projectRoot = $PSScriptRoot
$venvPython = Join-Path $projectRoot '.venv-sync\Scripts\python.exe'

function Test-CompatiblePython([string]$Candidate) {
    if (!$Candidate -or !(Test-Path -LiteralPath $Candidate -PathType Leaf)) { return $false }
    try {
        & $Candidate -I -c 'import sys,venv; sys.exit(0 if sys.version_info >= (3,10) and sys.version_info < (4,0) else 1)' 2>$null
        return ($LASTEXITCODE -eq 0)
    } catch { return $false }
}

function Find-Python {
    if ($PythonExe) {
        if (!(Test-CompatiblePython $PythonExe)) { throw 'The specified -PythonExe is not a working Python 3.10+ interpreter.' }
        return (Resolve-Path -LiteralPath $PythonExe).Path
    }
    $candidates = @($venvPython)
    $command = Get-Command python.exe -ErrorAction SilentlyContinue
    if ($command -and $command.Source -notlike '*\WindowsApps\*') { $candidates += $command.Source }
    foreach ($pattern in @("$env:LOCALAPPDATA\Programs\Python\Python*\python.exe", "$env:ProgramFiles\Python*\python.exe", "${env:ProgramFiles(x86)}\Python*\python.exe")) {
        $candidates += @(Get-ChildItem -Path $pattern -File -ErrorAction SilentlyContinue | Select-Object -ExpandProperty FullName)
    }
    foreach ($candidate in $candidates) {
        if (Test-CompatiblePython $candidate) { return $candidate }
    }
    return $null
}

function Install-Python {
    if ($env:OS -ne 'Windows_NT' -or [Environment]::OSVersion.Version.Major -lt 10) {
        throw 'Automatic installation requires Windows 10/11 or Windows Server 2016+.'
    }
    $architecture = if ($env:PROCESSOR_ARCHITEW6432) { $env:PROCESSOR_ARCHITEW6432 } else { $env:PROCESSOR_ARCHITECTURE }
    if ($architecture -eq 'ARM64') { $suffix = '-arm64' }
    elseif ([Environment]::Is64BitOperatingSystem) { $suffix = '-amd64' }
    else { $suffix = '' }
    [Net.ServicePointManager]::SecurityProtocol = [Net.ServicePointManager]::SecurityProtocol -bor [Net.SecurityProtocolType]::Tls12
    Write-Host 'Python not found. Reading official Python 3.13 Windows releases...'
    $page = Invoke-WebRequest -Uri 'https://www.python.org/downloads/windows/' -UseBasicParsing -TimeoutSec 60
    $pattern = 'https://www\.python\.org/ftp/python/(3\.13\.\d+)/python-\1' + [regex]::Escape($suffix) + '\.exe'
    $release = [regex]::Matches($page.Content, $pattern) | Sort-Object { [version]$_.Groups[1].Value } -Descending | Select-Object -First 1
    if (!$release) { throw 'No supported Python installer link found. Install Python 3.10+ from python.org, then rerun setup.' }
    $downloadUrl = $release.Value
    $installer = Join-Path ([IO.Path]::GetTempPath()) ('algorithm-python-' + [guid]::NewGuid().ToString('N') + '.exe')
    try {
        Write-Host ('Downloading Python ' + $release.Groups[1].Value + ' from python.org...')
        Invoke-WebRequest -Uri $downloadUrl -OutFile $installer -UseBasicParsing -TimeoutSec 300
        $signature = Get-AuthenticodeSignature -LiteralPath $installer
        if ($signature.Status -ne 'Valid' -or !$signature.SignerCertificate -or $signature.SignerCertificate.Subject -notmatch '(?i)CN=Python Software Foundation(?:,|$)') {
            throw 'Python installer signature/publisher verification failed. Installer was not executed.'
        }
        Write-Host 'Installing Python for the current Windows user. This may take a few minutes...'
        $process = Start-Process -FilePath $installer -ArgumentList @('/quiet','InstallAllUsers=0','PrependPath=0','Include_pip=1','Include_test=0','Include_launcher=0','Include_doc=0','Include_tcltk=0','Shortcuts=0') -Wait -PassThru -WindowStyle Hidden
        if ($process.ExitCode -notin @(0,3010)) { throw ('Python installer failed with exit code ' + $process.ExitCode) }
        $found = Find-Python
        if (!$found) { throw 'Python installation finished but could not be located. Rerun setup with -PythonExe pointing to python.exe.' }
        return $found
    } finally {
        if (Test-Path -LiteralPath $installer) { Remove-Item -LiteralPath $installer -Force }
    }
}

function Invoke-PythonChecked([string]$Executable, [string[]]$Arguments) {
    & $Executable @Arguments
    if ($LASTEXITCODE -ne 0) { throw ('Python step failed (exit ' + $LASTEXITCODE + '). Check the output above.') }
}

Push-Location $projectRoot
try {
    foreach ($relative in @('tools\sync\catalog_sync.py','tools\sync\bridge_guard.py','tools\sync\sync_menu.py','tools\sync\sync_report.py','tools\sync\requirements.txt','tools\sync\sync.example.conf','tools\sync\my_config.example.conf','Run-Database-Menu.cmd')) {
        if (!(Test-Path -LiteralPath (Join-Path $projectRoot $relative))) { throw ('Missing package file: ' + $relative + '. Copy/extract the full tool folder first.') }
    }
    $runtime = Find-Python
    if ($CheckOnly) {
        Write-Host 'Check-only mode: no downloads, installation, configuration changes or database connections.'
        if (!$runtime) { throw 'Python 3.10+ not found; run Install-Windows.cmd to install it.' }
        Write-Host ('Compatible Python: ' + $runtime)
        if (Test-CompatiblePython $venvPython) {
            Invoke-PythonChecked $venvPython @('-I','-c',"import pymysql; print('Project dependency import: OK')")
            Invoke-PythonChecked $venvPython @('tools/sync/catalog_sync.py','--help')
        } else { Write-Host 'Project environment still needs setup.' }
        return
    }
    if (!$runtime) { $runtime = Install-Python }
    Write-Host ('Using Python: ' + $runtime)
    if (Test-Path -LiteralPath (Join-Path $projectRoot '.venv-sync')) {
        if (!(Test-CompatiblePython $venvPython)) { throw 'Existing .venv-sync is unusable (possibly copied from another PC). Rename that folder and rerun setup; no files were removed.' }
        Write-Host 'Reusing existing project virtual environment.'
    } else {
        Write-Host 'Creating project virtual environment...'
        Invoke-PythonChecked $runtime @('-m','venv',(Join-Path $projectRoot '.venv-sync'))
    }
    Write-Host 'Installing pinned Python dependencies from PyPI...'
    Invoke-PythonChecked $venvPython @('-m','pip','--isolated','install','--disable-pip-version-check','--index-url','https://pypi.org/simple','-r','tools/sync/requirements.txt')
    Invoke-PythonChecked $venvPython @('-m','pip','check')
    Invoke-PythonChecked $venvPython @('tools/sync/catalog_sync.py','--help')

    $options = Join-Path $projectRoot 'sync.local.conf'
    if (!(Test-Path -LiteralPath $options)) { Copy-Item -LiteralPath 'tools/sync/sync.example.conf' -Destination $options }
    $userConfig = Join-Path $env:USERPROFILE 'my_config.conf'
    $projectConfig = Join-Path $projectRoot 'my_config.conf'
    if (Test-Path -LiteralPath $projectConfig) {
        Write-Host ('Existing connection configuration preserved: ' + $projectConfig)
    } elseif (Test-Path -LiteralPath $userConfig) {
        Write-Host ('Existing connection configuration preserved: ' + $userConfig)
    } else {
        Copy-Item -LiteralPath 'tools/sync/my_config.example.conf' -Destination $projectConfig
        Write-Host ('ACTION NEEDED: edit ' + $projectConfig + ' with this machine''s database credentials.') -ForegroundColor Yellow
    }
    Invoke-PythonChecked $venvPython @('-c',"import sys; sys.path.insert(0,'tools/sync'); import catalog_sync,sync_menu,sync_report; print('Menu imports: OK')")
    $backupProbe = "import sys; sys.path.insert(0,'tools/sync'); import catalog_sync,sync_menu; c=catalog_sync.properties('sync.local.conf')`ntry: print('Backup tool:',sync_menu.dump_executable(c))`nexcept RuntimeError: sys.exit(1)"
    & $venvPython -c $backupProbe
    if ($LASTEXITCODE -ne 0) {
        Write-Host 'Backup tool missing: configure a compatible mysqldump.exe using backup_mysqldump in sync.local.conf. Python sync checks can run without it.' -ForegroundColor Yellow
    }
    Write-Host ''
    Write-Host 'Python setup complete. No Java build is needed.' -ForegroundColor Green
    Write-Host 'Verify local database credentials and main_branch in sync.local.conf, then double-click Run-Database-Menu.cmd.'
    Write-Host 'Setup did not connect to databases, run backups, apply sync changes or install a MySQL server.'
} catch {
    Write-Host ('SETUP FAILED: ' + $_.Exception.Message) -ForegroundColor Red
    exit 1
} finally {
    Pop-Location
}
