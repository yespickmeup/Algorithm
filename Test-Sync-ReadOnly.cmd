@echo off
setlocal
cd /d "%~dp0"
if not exist ".venv-sync\Scripts\python.exe" (
  echo Run Install-Windows.cmd first.
  pause
  exit /b 1
)
".venv-sync\Scripts\python.exe" "tools\sync\hourly_sync.py" --check-only
set "SYNC_TEST_RESULT=%ERRORLEVEL%"
pause
exit /b %SYNC_TEST_RESULT%
