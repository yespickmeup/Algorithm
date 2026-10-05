[CmdletBinding()]
param(
    [switch]$CheckOnly,
    [switch]$LoggedOnOnly,
    [string]$TaskName = 'Algorithm Inventory Hourly Sync'
)
$ErrorActionPreference = 'Stop'
$packageRoot = $PSScriptRoot
$python = Join-Path $packageRoot '.venv-sync\Scripts\python.exe'
$pythonWindowless = Join-Path $packageRoot '.venv-sync\Scripts\pythonw.exe'
$worker = Join-Path $packageRoot 'tools\sync\hourly_sync.py'
$options = Join-Path $packageRoot 'sync.local.conf'
$config = Join-Path $packageRoot 'my_config.conf'
if (!(Test-Path -LiteralPath $config)) { $config = Join-Path $env:USERPROFILE 'my_config.conf' }
foreach ($required in @($python,$pythonWindowless,$worker,$options,$config)) {
    if (!(Test-Path -LiteralPath $required)) { throw ('Missing file: ' + $required + '. Run Install-Windows.cmd and configure this machine first.') }
}
& $python $worker --validate --config $config --options $options
if ($LASTEXITCODE -ne 0) { throw 'Configuration validation failed; task was not installed.' }
$arguments = '"{0}" --apply --config "{1}" --options "{2}" --state-dir "{3}"' -f $worker,$config,$options,(Join-Path $packageRoot '.sync-state')
$action = New-ScheduledTaskAction -Execute $pythonWindowless -Argument $arguments -WorkingDirectory $packageRoot
# No repetition duration means the hourly trigger repeats indefinitely, every day.
$trigger = New-ScheduledTaskTrigger -Once -At ((Get-Date).AddMinutes(2)) -RepetitionInterval (New-TimeSpan -Hours 1)
$settings = New-ScheduledTaskSettingsSet -StartWhenAvailable -MultipleInstances IgnoreNew -ExecutionTimeLimit (New-TimeSpan -Minutes 55) -RestartCount 3 -RestartInterval (New-TimeSpan -Minutes 5) -AllowStartIfOnBatteries -DontStopIfGoingOnBatteries
$task = New-ScheduledTask -Action $action -Trigger $trigger -Settings $settings -Description 'Hourly main-to-cloud or cloud-to-branch inventory sync. Uses local database role and verified-publication safeguards. Writes changes.'
if ($CheckOnly) {
    Write-Host ('Check passed. Would register: ' + $TaskName)
    Write-Host ('Python: ' + $pythonWindowless)
    Write-Host ('Configuration: ' + $config)
    Write-Host 'Every hour, every day; start in two minutes; no overlapping runs; retry failures up to three times.'
    Write-Host 'No scheduled task or database changes were made.'
    return
}
$existing = Get-ScheduledTask -TaskName $TaskName -ErrorAction SilentlyContinue
if ($existing -and $existing.State -eq 'Running') { throw 'The existing sync task is running. Wait for it to finish before updating its registration.' }
$account = [System.Security.Principal.WindowsIdentity]::GetCurrent().Name
if ($LoggedOnOnly) {
    $task.Principal = New-ScheduledTaskPrincipal -UserId $account -LogonType Interactive -RunLevel Limited
    Register-ScheduledTask -TaskName $TaskName -InputObject $task -Force | Out-Null
    Write-Host 'Installed for the current signed-in Windows session only.'
} else {
    Write-Host 'This task applies database changes hourly, including while signed out.'
    Write-Host 'Enter this Windows account password (not a PIN or MySQL password). Windows Task Scheduler stores the credential; it is not saved in this package.'
    $credential = Get-Credential -UserName $account -Message 'Windows account for hourly inventory sync while signed out'
    if (!$credential) { throw 'Cancelled; no scheduled task was installed.' }
    if ($credential.UserName -ne $account) { throw 'Use the current Windows account that owns this Python installation and configuration.' }
    $task.Principal = New-ScheduledTaskPrincipal -UserId $account -LogonType Password -RunLevel Limited
    $taskPassword = $credential.GetNetworkCredential().Password
    try {
        Register-ScheduledTask -TaskName $TaskName -InputObject $task -User $account -Password $taskPassword -Force | Out-Null
    } finally {
        $taskPassword = $null
        $credential = $null
    }
}
Write-Host ('Installed: ' + $TaskName)
Write-Host 'First run in about two minutes, then hourly every day. The PC must be powered on and connected.'
Write-Host ('Status and logs: ' + (Join-Path $packageRoot '.sync-state'))
