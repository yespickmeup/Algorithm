$ErrorActionPreference = 'Stop'
$projectRoot = Split-Path $PSScriptRoot -Parent
Push-Location $projectRoot
try {
    $compiler = 'C:\Program Files\Java\jdk1.8.0_101\bin\javac.exe'
    if (!(Test-Path -LiteralPath $compiler)) { throw "JDK compiler missing: $compiler" }
    New-Item -ItemType Directory -Force build/inspection-classes | Out-Null
    Get-ChildItem src -Recurse -Filter '*.java' | ForEach-Object {
        '"' + $_.FullName.Replace('\', '/') + '"'
    } | Set-Content build/inspection-sources.txt -Encoding ascii
    & $compiler -encoding UTF-8 -source 1.6 -target 1.6 -cp 'dist/lib/*' -d build/inspection-classes '@build/inspection-sources.txt' *> build/inspection-compile.log
    $compileExit = $LASTEXITCODE
    Get-Content build/inspection-compile.log
    if ($compileExit -ne 0) { throw "Compilation failed with exit code $compileExit" }
    Write-Output 'Compilation passed. No application or sync job was launched.'
} finally {
    Pop-Location
}
