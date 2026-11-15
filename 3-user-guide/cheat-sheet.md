# ImageJ cheat sheet

One page for the audience. Menu names were checked against ImageJ 1.54 (`ij.jar`). On a Mac, use Cmd instead of Ctrl.

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
| Open a picture | **File > Open...** (Ctrl+O) | **File > Open Samples** has free pictures, but needs internet |
| Make it grey (8-bit) | **Image > Type > 8-bit** | Each pixel is 0 (black) to 255 (white) |
| Histogram | **Analyze > Histogram** (Ctrl+H) | Shows how many pixels have each brightness |
| Blur / smooth noise | **Process > Filters > Gaussian Blur...** | Tick **Preview**; bigger Sigma = smoother |
| Find outlines | **Process > Find Edges** | Bright where brightness changes fast |
| Undo | **Edit > Undo** (Ctrl+Z) | Brings the original back |
| Threshold | **Image > Adjust > Threshold...** (Ctrl+Shift+T) | **Auto** gives a quick start, **Apply** makes it black and white |
| Count and measure shapes | **Analyze > Analyze Particles...** | Tick **Display results** and **Summarize** |
| Record steps | **Plugins > Macros > Record...** (Ctrl+U) | Click **Create** to get a macro |
| Run a macro | **Plugins > Macros > Run...** | Repeats the steps on any picture |

## Macro in one line

Record once, replay on any picture. Example macro that does a blur then edges:

```
run("Gaussian Blur...", "sigma=2");
run("Find Edges");
```

## Starting ImageJ

| System | Command |
|---|---|
| Windows | Double-click `run-imagej.bat`, or `java -Xmx2g -jar ij.jar` |
| WSL (Ubuntu) | `./run-gui.sh`, or `java -Xmx2g -jar ~/imagej/ImageJ/ij.jar` |
| No window (batch) | `java -jar ij.jar -batch macro.ijm` |

`-Xmx2g` allows up to 2 GB of memory.

## Our plugins

Build with `4-plugins/build.sh`, copy `Group5_Plugins.jar` into `plugins/` and restart ImageJ. Commands appear under **Plugins > Group5**.

## Common problems

| Problem | Fix |
|---|---|
| Threshold looks backwards | Click **Auto**, or tick **Dark background** |
| "Out of memory" | Launch with `java -Xmx2g -jar ij.jar` |
| Plugin missing from the menu | Class name needs an underscore; check the jar is in `plugins/` and restart |
| `java` not recognized | Install a JDK and tick **Add to PATH** (see `1-install-windows/`) |
