# CSC360 Group 5: ImageJ End-Sem Project

**Topic:** Present ImageJ capabilities: installation (modern JDK, Windows, WSL), user guide (UI), and plugins.
The project ends in a group presentation with a live demo.

## Who does what

| # | Member   | Topic | Folder | Shared task |
|---|----------|-------|--------|-------------|
| 1 | Jiya   | Intro + Windows & JDK install | `1-install-windows/` | Owns the slide deck (`presentation/`) |
| 2 | Heer   | WSL install: WSLg, apt JDK, headless mode, troubleshooting | `2-install-wsl/` | Records the backup demo video |
| 3 | _Dhriti_ | User guide / UI tour: menus, toolbar, filters, histogram, edges, Macro Recorder | `3-user-guide/` | Sample images + one-page cheat sheet |
| 4 | _Aangi_  | Plugins: installing existing ones, writing our own (Invert_Image, grayscale, 3x3 blur), PlugIn vs PlugInFilter | `4-plugins/` | Q&A prep and rehearsal |

## Repo layout

```
1-install-windows/   Windows + JDK install notes, screenshots
2-install-wsl/       WSL install notes, screenshots
3-user-guide/        UI tour notes, sample images, cheat sheet
4-plugins/           Plugin source project (see its README)
presentation/        Slide deck and demo video
```

## Workflow

- One branch per member (e.g. `m1-windows`, `m2-wsl`, `m3-userguide`, `m4-plugins`).
- Open a PR into `main`; don't push to `main` directly.
- `ij.jar` is git-ignored. Each person fetches it locally (see `4-plugins/README.md`).
