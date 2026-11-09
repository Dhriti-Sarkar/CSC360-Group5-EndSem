# check-java.ps1
# Prints the Java setup on this machine so problems can be diagnosed.
# Run with:  powershell -ExecutionPolicy Bypass -File .\check-java.ps1

Write-Host "== java -version ==" -ForegroundColor Cyan
$java = Get-Command java -ErrorAction SilentlyContinue
if ($java) {
    & java -version 2>&1 | ForEach-Object { Write-Host $_ }
    Write-Host "java found at: $($java.Source)"
} else {
    Write-Host "java NOT found on PATH. Install a JDK and tick 'Add to PATH'." -ForegroundColor Red
}

Write-Host ""
Write-Host "== javac -version ==" -ForegroundColor Cyan
$javac = Get-Command javac -ErrorAction SilentlyContinue
if ($javac) {
    & javac -version 2>&1 | ForEach-Object { Write-Host $_ }
} else {
    Write-Host "javac NOT found. You have a JRE, not a JDK. Plugin development needs a JDK." -ForegroundColor Yellow
}

Write-Host ""
Write-Host "== JAVA_HOME ==" -ForegroundColor Cyan
if ($env:JAVA_HOME) {
    Write-Host $env:JAVA_HOME
    if (-not (Test-Path (Join-Path $env:JAVA_HOME "bin\java.exe"))) {
        Write-Host "Warning: JAVA_HOME does not contain bin\java.exe" -ForegroundColor Yellow
    }
} else {
    Write-Host "JAVA_HOME is not set. Reinstall the JDK with 'Set JAVA_HOME variable' ticked." -ForegroundColor Yellow
}

Write-Host ""
Write-Host "== javaw on PATH ==" -ForegroundColor Cyan
$javaw = Get-Command javaw -ErrorAction SilentlyContinue
if ($javaw) { Write-Host "javaw found at: $($javaw.Source)" } else { Write-Host "javaw NOT found on PATH." -ForegroundColor Yellow }

Write-Host ""
Write-Host "== Other Java installs on PATH (first match wins) ==" -ForegroundColor Cyan
$all = where.exe java 2>$null
if ($all) { $all | ForEach-Object { Write-Host $_ } } else { Write-Host "none" }

Write-Host ""
Write-Host "Done."