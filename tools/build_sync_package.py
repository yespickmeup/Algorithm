"""Refresh both the portable directory and ZIP from an explicit credential-free file set."""
import hashlib
from pathlib import Path
import shutil
import zipfile


def build(root):
    folder = root / 'dist' / 'Database-Tools-Windows'
    archive = root / 'dist' / 'Database-Tools-Windows.zip'
    entries = {}
    for path in (root / 'tools' / 'sync').iterdir():
        if path.name == 'START-HERE.md':
            entries['START-HERE.md'] = path
        elif path.is_file() and (path.suffix in ('.py', '.md') or path.name in ('requirements.txt', 'sync.example.conf', 'my_config.example.conf')):
            entries[path.relative_to(root).as_posix()] = path
    for name in ('Install-Windows.cmd', 'Install-Windows.ps1', 'Run-Database-Menu.cmd',
                 'Install-Hourly-Sync.cmd', 'Install-Hourly-Sync.ps1', 'Test-Sync-ReadOnly.cmd'):
        entries[name] = root / name
    folder.mkdir(parents=True, exist_ok=True)
    checksums = []
    for name, source in sorted(entries.items()):
        target = folder / name
        target.parent.mkdir(parents=True, exist_ok=True)
        shutil.copyfile(source, target)
        checksums.append(hashlib.sha256(target.read_bytes()).hexdigest() + '  ' + name)
    manifest = folder / 'SHA256SUMS.txt'
    manifest.write_text('\n'.join(checksums) + '\n', encoding='utf-8')
    temporary = archive.with_suffix('.zip.partial')
    with zipfile.ZipFile(temporary, 'w', zipfile.ZIP_DEFLATED) as zipped:
        for name in sorted(entries):
            zipped.write(folder / name, name)
        zipped.write(manifest, manifest.name)
    temporary.replace(archive)
    with zipfile.ZipFile(archive) as zipped:
        assert zipped.testzip() is None
        for name in entries:
            assert zipped.read(name) == (folder / name).read_bytes()
    print(f'Updated folder: {folder}\nUpdated ZIP: {archive}\nVerified {len(entries)} program/template files plus checksums. No private configs, backups, logs or virtualenv included.')


if __name__ == '__main__':
    build(Path(__file__).resolve().parents[1])
