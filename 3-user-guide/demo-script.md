# ImageJ Live Demo Script (DRAFT)

Owner: Dhriti (M3). Length: 5:00. Status: **menu names checked against ij.jar 1.54p; not yet timed in real ImageJ**.

Menu paths and shortcuts below come from general ImageJ knowledge. Before freezing this script, run it once on the demo laptop and fix anything that differs (marked **CHECK**).

## Before the demo starts (not part of the 5 minutes)

- [ ] ImageJ is open and the window is moved to the main screen.
- [ ] Sample pictures are in `3-user-guide/samples/` and open-ready (File > Open works with no internet).
- [ ] Notifications are off, screen resolution is set, ImageJ zoom is readable from the back of the room.
- [ ] The backup macro `demo-macro.ijm` is saved next to the pictures (see step 8).
- [ ] Close every image window so the demo starts clean.

## Pictures needed (to collect in `samples/`)

Tip: **File > Open Samples** has free built-in pictures (Blobs, Boats, Clown, Leaf, Particles), but it downloads them from the internet. Open them once at home and use **File > Save As** into `samples/`, so the demo works offline.

| Name (draft) | What it is | Used in step |
|---|---|---|
| `photo.gif` | A normal colour photo | 1, 2, 3 |
| `noisy.gif` | A grainy or blurry picture | 4 |
| `edges.gif` | A picture with clear outlines (a building, a tool) | 5 |
| `blobs.gif` | Dark or light round shapes on a plain background (cells, coins) | 6, 7, 8 |

Replace these names with the real files once chosen. All must be small and free to use. Write the source and licence of each in `samples/README.md`.

## The steps

| # | Time | Do this | Say this (plain words) |
|---|------|---------|------------------------|
| 1 | 0:20 | **File > Open**, choose `photo.gif`. | "ImageJ is a free program for looking at and measuring pictures. Let's open one." |
| 2 | 0:40 | Point at: menu bar, toolbar (the row of tool icons), status bar (bottom of the picture window), picture window. Move the mouse over the picture and show the pixel values in the status bar / ImageJ window. | "Menus at the top, tools under them. When I move over the picture, ImageJ tells me the position and the brightness of each point." |
| 3 | 0:40 | **Image > Type > 8-bit** to turn it grey. Then **Analyze > Histogram** (shortcut Ctrl+H). | "A picture is a grid of numbers. 8-bit means each point is a brightness from 0 (black) to 255 (white). The histogram shows how many points have each brightness." |
| 4 | 0:30 | Open `noisy.gif`. **Process > Filters > Gaussian Blur...**, tick **Preview**, move the Sigma slider (try 2). Click OK. Then **Edit > Undo** to show we can go back. | "A blur smooths out the grain. The bigger the number, the smoother the picture. Undo brings the original back." |
| 5 | 0:30 | Open `edges.gif`. **Process > Find Edges**. | "This shows where brightness changes fast. Those are the outlines of things." |
| 6 | 0:40 | Open `blobs.gif`. **Image > Adjust > Threshold...** (shortcut Ctrl+Shift+T, confirmed `[T]` in ij.jar). Move the slider until only the shapes are red. Click **Apply**. | "Thresholding picks which points count as 'object' and which count as 'background'. The picture turns black and white." |
| 7 | 0:50 | **Analyze > Analyze Particles...**, tick **Display results** and **Summarize**, click OK. Read out the count from the Results window. | "Now ImageJ counts the shapes and measures the size of each one. This is what scientists use ImageJ for." |
| 8 | 0:50 | Open a fresh copy of `blobs.gif` (or `noisy.gif`). **Plugins > Macros > Record...** Run **Gaussian Blur** (sigma 2), then **Find Edges**. In the Recorder window click **Create**. Open another picture and run the macro from the editor with **Macros > Run Macro**. | "A macro is a recording of steps. I do the work once, and ImageJ repeats it on any other picture. That is how you process hundreds of pictures without clicking each time." |

Total: 0:20 + 0:40 + 0:40 + 0:30 + 0:30 + 0:40 + 0:50 + 0:50 = **5:00**.

Step 8 is the most likely to go wrong, so it has a fallback: if recording fails, open the pre-saved `demo-macro.ijm` (**Plugins > Macros > Run...**) and say "here is one I recorded earlier."

## Fallbacks (if something breaks)

- A step fails: say "let me skip ahead", go to the next step. Each step works on its own picture, so skipping does not break later steps.
- ImageJ crashes or freezes: restart it, then continue from step 4 with the pictures already in `samples/`.
- Nothing works: switch to Heer's backup video (`presentation/`) and talk over it.
- Threshold slider gives a messy result: click **Auto** in the Threshold window, then **Apply**.

## Who does what (to agree in Stage 3)

| Part | Speaker | Keyboard |
|------|---------|----------|
| Steps 1 to 3 | ___ | ___ |
| Steps 4 to 6 | ___ | ___ |
| Steps 7 to 8 | ___ | ___ |

## To do before freezing this script

- [ ] Choose and download the four sample pictures.
- [ ] Run every step in real ImageJ on the demo laptop and time it with a stopwatch.
- [ ] Fix every **CHECK** item (shortcuts and menu names can differ by version).
- [ ] Record `demo-macro.ijm` and save it in `3-user-guide/samples/`.
- [ ] Send the final numbered steps to Heer so the backup video follows the same order.
- [ ] Add a screenshot of each step for Jiya's slides.
