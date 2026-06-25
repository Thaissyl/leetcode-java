param(
    [Parameter(Mandatory = $true)]
    [string]$Target
)

$ErrorActionPreference = 'Stop'

chcp 65001 | Out-Null
$utf8 = [System.Text.UTF8Encoding]::new($false)
[Console]::InputEncoding = $utf8
[Console]::OutputEncoding = $utf8
$OutputEncoding = $utf8

$root = Split-Path -Parent $MyInvocation.MyCommand.Path
$outDir = Join-Path $root '.build\classes'

if ($Target.EndsWith('.java', [System.StringComparison]::OrdinalIgnoreCase)) {
    $fullPath = [System.IO.Path]::GetFullPath($Target)
    $relativePath = $fullPath.Substring($root.Length).TrimStart('\', '/')
    $Class = ($relativePath -replace '\.java$', '' -replace '[\\/]', '.')
} else {
    $Class = $Target
}

New-Item -ItemType Directory -Force -Path $outDir | Out-Null

$sourceDirs = @('Easy', 'Medium', 'Hard') | ForEach-Object { Join-Path $root $_ }
$files = Get-ChildItem -Path $sourceDirs -Filter '*.java' -File -ErrorAction SilentlyContinue

if (-not $files) {
    throw 'No Java source files found.'
}

& javac -encoding UTF-8 -d $outDir @($files.FullName)
if ($LASTEXITCODE -ne 0) {
    exit $LASTEXITCODE
}

& java '-Dfile.encoding=UTF-8' '-Dsun.stdout.encoding=UTF-8' -cp $outDir $Class
exit $LASTEXITCODE
