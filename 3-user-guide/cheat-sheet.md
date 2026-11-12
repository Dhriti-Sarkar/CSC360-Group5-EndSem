# ImageJ cheat sheet (DRAFT)

One page for the audience. Menu paths come from our demo script; items marked **CHECK** are not yet confirmed in real ImageJ 1.54p.

## The window

| Part | What it is |
|---|---|
| Menu bar | File, Edit, Image, Process, Analyze, Plugins, Window, Help |
| Toolbar | Row of tool icons (select, zoom, draw, ...) |
| Status bar | Position and pixel value under the mouse |
| Picture window | The image you work on |

## Core tasks

| Task | Where | Notes |
|---|---|---|
| Open a picture | **File > Open** | |
| Make it grey (8-bit) | **Image > Type > 8-bit** | 8-bit: each pixel is 0 (black) to 255 (white) |
| Histogram | **Analyze > Histogram** (Ctrl+H) | **CHECK** shortcut. Shows how many pixels have each brightness |
| Blur / smooth noise | **Process > Filters > Gaussian Blur...** | Tick **Preview**; bigger Sigma = smoother |
| Find outlines | **Process > Find Edges** | Bright where brightness changes fast |
| Undo | **Edit > Undo** | |
| Threshold | **Image > Adjust > Threshold...** (Ctrl+Shift+T) | **Auto** gives a quick start, **Apply** makes it black and white |
| Count and measure shapes | **Analyze > Analyze Particles...** | Tick **Display results** and **Summarize** |
| Record steps | **Plugins > Macros > Record...** | Click **Create** to get a macro |
| Run a macro | **Macros > Run Macro** in the editor | Repeats the steps on any picture |

## Our plugins

After building (`4-plugins/build.sh`), copy `Group5_Plugins.jar` into `plugins/` and restart. Commands appear under **Plugins > Group5**.

## Common problems

| Problem | Fix |
|---|---|
| Threshold looks backwards | Click **Auto**, or tick **Dark background** |
| ImageJ shows "Out of memory" | Launch with `java -Xmx2g -jar ij.jar` |
| Plugin missing from the menu | Class name needs an underscore; check the jar is in `plugins/` and restart |
