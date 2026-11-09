@echo off
REM run-imagej.bat
REM Launches ImageJ from ij.jar in the same folder, using the JDK on PATH.
REM -Xmx2g gives ImageJ up to 2 GB of memory. Change it if needed.

cd /d "%~dp0"

if not exist "%~dp0ij.jar" (
    echo ij.jar not found in %~dp0
    echo Download it from https://imagej.net/ij/download.html and place it here.
    pause
    exit /b 1
)

java -Xmx2g -jar "%~dp0ij.jar"

if errorlevel 1 (
    echo.
    echo ImageJ exited with an error. See the troubleshooting table in README.md.
    pause
)