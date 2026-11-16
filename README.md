# CSC360 Group 5: ImageJ End-Sem Project

**Topic:** Present ImageJ capabilities: installation (modern JDK, Windows, WSL), user guide (UI), and plugins.
The project ends in a group presentation (slides and viva notes are kept outside this repo).

## Who does what

| # | Member   | Topic | Folder | Shared task |
|---|----------|-------|--------|-------------|
| 1 | Jiya   | Intro + Windows & JDK install | `1-install-windows/` | Intro and Windows guide |
| 2 | Heer   | WSL install: WSLg, apt JDK, headless mode, troubleshooting | `2-install-wsl/` | Tests the plugin jar on WSL |
| 3 | Dhriti  | User guide / UI tour: menus, toolbar, filters, histogram, edges, Macro Recorder | `3-user-guide/` | One-page cheat sheet |
| 4 | Aangi   | Plugins: Invert_Image, Grayscale_Convert, Blur_3x3, Image_Info; installing existing plugins; PlugIn vs PlugInFilter | `4-plugins/` | Test checklist (`TESTING.md`) |

## Repo layout

```
1-install-windows/   Windows + JDK install notes, screenshots
2-install-wsl/       WSL install notes, screenshots
3-user-guide/        UI tour notes, cheat sheet
4-plugins/           Plugin source, tests, screenshots (see its README)
```

## Workflow

- One branch per member (e.g. `m1-windows`, `m2-wsl`, `m3-userguide`, `m4-plugins`).
- Open a PR into `main`; don't push to `main` directly.
- `ij.jar` is git-ignored. Each person fetches it locally (see `4-plugins/README.md`).
