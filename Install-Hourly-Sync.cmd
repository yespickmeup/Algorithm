@echo off
setlocal
cd /d "%~dp0"
powershell.exe -NoProfile -ExecutionPolicy Bypass -File "%~dp0Install-Hourly-Sync.ps1"
set "SYNC_INSTALL_RESULT=%ERRORLEVEL%"
if not "%SYNC_INSTALL_RESULT%"=="0" echo Installation failed. Read the error above; no successful installation is implied.
pause
exit /b %SYNC_INSTALL_RESULT%
