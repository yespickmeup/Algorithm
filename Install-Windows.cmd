@echo off
setlocal
cd /d "%~dp0"
echo Installing Python requirements for Algorithm Database Tools...
powershell.exe -NoProfile -ExecutionPolicy Bypass -File "%~dp0Install-Windows.ps1"
set "SETUP_RESULT=%ERRORLEVEL%"
echo.
if not "%SETUP_RESULT%"=="0" echo Installation failed. Read the message above before retrying.
pause
exit /b %SETUP_RESULT%
