@echo off
cd /d "%~dp0"
if not exist ".venv-sync\Scripts\python.exe" (
  echo Python environment is missing. Run Install-Windows.cmd first.
  pause
  exit /b 1
)
set "SYNC_CONFIG=%~dp0my_config.conf"
if not exist "%SYNC_CONFIG%" set "SYNC_CONFIG=%USERPROFILE%\my_config.conf"
if not exist "%SYNC_CONFIG%" (
  echo Database configuration is missing. Run Install-Windows.cmd first.
  pause
  exit /b 1
)
".venv-sync\Scripts\python.exe" "tools\sync\catalog_sync.py" --menu --config "%SYNC_CONFIG%"
if errorlevel 1 pause
