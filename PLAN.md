# Project Plan & Checklist

Goal: group presentation + live demo of ImageJ (install, UI, plugins). The demo is 35% of the grade, so every phase is aimed at a demo that can't fail.

Dates: presentation = `____`, internal freeze (everything merged) = `____`, dress rehearsal = `____`.

Owners: **M1** Windows/JDK + slides, **M2** WSL + demo video, **M3** user guide + samples + cheat sheet, **M4** plugins + Q&A.

## Phase 0: Setup (all, day 1)

- [ ] Lead commits skeleton to `main` and pushes
- [ ] Everyone clones, creates their branch (`m1-windows`, `m2-wsl`, `m3-userguide`, `m4-plugins`)
- [ ] Everyone runs `4-plugins/build.sh fetch` and confirms ImageJ launches on their machine
- [ ] Fill in names in README table
- [ ] Agree on slide template, screenshot style (resolution, annotation color), and demo image set
- [ ] Decide demo machine (which laptop, which OS) and the backup machine

## Phase 1: Content (parallel, each on own branch)

### M1: Intro + Windows & JDK install (`1-install-windows/`)
- [ ] Intro: what ImageJ is, history (NIH), where it's used, ImageJ vs ImageJ2 vs Fiji
- [ ] Compare install options: bundled-JRE zip vs `ij.jar` + own JDK
- [ ] Install a modern JDK on Windows (OpenJDK 21/25): download, install, `JAVA_HOME`, `PATH`, `java -version`
- [ ] Install ImageJ, first launch, set memory (Edit > Options > Memory & Threads)
- [ ] Common problems: wrong Java on PATH, blocked by SmartScreen, HiDPI scaling
- [ ] Screenshots of every step, in `1-install-windows/img/`
- [ ] Write `1-install-windows/README.md` (steps + troubleshooting)

### M2: WSL install (`2-install-wsl/`)
- [ ] Enable WSL2, install Ubuntu (`wsl --install`)
- [ ] Verify WSLg works (GUI apps display)
- [ ] `sudo apt install openjdk-XX-jdk`, check version
- [ ] Run ImageJ GUI under WSLg
- [ ] Headless mode: `-batch` / macro run with no display, `java.awt.headless=true`
- [ ] Troubleshooting: no display, font/HiDPI issues, file access between Windows and WSL (`/mnt/c`)
- [ ] Write `2-install-wsl/README.md` + screenshots

### M3: User guide (`3-user-guide/`)
- [ ] UI tour: menu bar, toolbar, status bar, image window, Log, ROI Manager
- [ ] Open/save formats, image types (8-bit, 16-bit, RGB), Image > Type
- [ ] Filters: Gaussian blur, median, sharpen, unsharp mask
- [ ] Histogram and Brightness/Contrast, thresholding
- [ ] Edge detection (Find Edges, Sobel)
- [ ] Analyze > Measure / Analyze Particles
- [ ] Macro Recorder: record a short pipeline, replay it
- [ ] Sample images (small, license-clean) in `3-user-guide/samples/`
- [ ] One-page cheat sheet (PDF) in `3-user-guide/`
- [ ] Choose the 5-minute demo flow and write it as numbered steps

### M4: Plugins (`4-plugins/`)
- [ ] Installing existing plugins: where `plugins/` is, restart, Plugins > Install, example from imagej.net
- [ ] `PlugIn` vs `PlugInFilter`: when to use which, `setup` flags, `run`
- [ ] Finish `Invert_Image` (test 8-bit and RGB, undo, ROI/mask)
- [ ] Write `Grayscale_Convert` (RGB to 8-bit, with luminance weights)
- [ ] Write `Blur_3x3` (manual convolution, edge handling, compare with built-in)
- [ ] Add each to `plugins.config`, build jar, test it inside a real ImageJ install
- [ ] Optional: one `PlugIn` with a dialog (`GenericDialog`) to show the contrast
- [ ] Document each plugin (what/why/how) in `4-plugins/README.md`

## Phase 2: Shared deliverables

- [ ] **Slides (M1 owns, all contribute):** outline, template, one section per member, 1 slide per major point, screenshots not walls of text
- [ ] M2, M3, M4 each send M1 their section's slides/notes by `____`
- [ ] **Backup demo video (M2 owns):** record after the demo script is frozen; cover install check, UI tour, plugin run; keep it under 5 minutes; export mp4 to `presentation/`
- [ ] **Sample images + cheat sheet (M3 owns):** circulated to the group before slides are finalized
- [ ] **Q&A prep (M4 owns):** list of 20+ likely questions with answers, assign each to a member

## Phase 3: Integration (after merge freeze)

- [ ] All PRs reviewed by at least one other member and merged to `main`
- [ ] Fresh-machine test: someone who did not write a guide follows it start to finish
- [ ] Combined demo script: order, who speaks, who drives the keyboard, timing per section
- [ ] Demo machine prepared: ImageJ and plugins installed, sample images open-ready, macro ready, notifications off, screen resolution set
- [ ] Offline fallback: everything works with no network

## Phase 4: Rehearsal

- [ ] Rehearsal 1: full run-through with timer, note problems
- [ ] Fix list from rehearsal 1
- [ ] Rehearsal 2 (dress rehearsal on the actual demo machine and projector setup if possible)
- [ ] Q&A drill: members ask each other the prepared questions
- [ ] Final check the day before: slides exported to PDF, video and ij.jar on a USB stick and cloud copy

## Risks and mitigations

| Risk | Mitigation |
|------|-----------|
| Live demo fails | Backup video (M2), rehearsed fallback slides with screenshots |
| JDK 25 vs ImageJ incompatibility on some machine | Test early in Phase 0; fall back to JDK 21 and document it |
| WSLg display broken on demo machine | Demo WSL by video or headless terminal only |
| Merge conflicts in slides | M1 is the only one editing the deck; others send content in markdown |
| Someone is absent on the day | Every member can run the whole demo from the script |

## Open decisions

- Slide tool (PowerPoint, Google Slides, Canva)? Affects how members contribute.
- Time slot for the presentation, and per-member speaking time.
- JDK version we standardize on for the demo (25 vs 21 LTS).
