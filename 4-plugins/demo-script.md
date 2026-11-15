# Plugins demo script (about 5 minutes)

Prep (before the audience arrives): ImageJ open, Group5_Plugins.jar installed, jar_demo.jar downloaded but NOT installed, two test images ready (one 8-bit noisy, one RGB), Log window closed. Works offline.

| Time | Action | Say |
| --- | --- | --- |
| 0:00 | Slide: PlugIn vs PlugInFilter | PlugIn finds the image itself. PlugInFilter is handed the image and ImageJ does undo, ROI and type checks. |
| 0:45 | Copy jar_demo.jar into plugins/, restart ImageJ, open Plugins > JAR Demo | Installing a plugin is: drop the file in plugins/, restart, find it in the menu. |
| 1:30 | Open RGB image, Plugins > Group5 > Invert Image, then Edit > Undo | Our first plugin. Undo comes free from PlugInFilter. |
| 2:15 | Draw an oval selection, run Grayscale (Group5) | Only the selection changes (SUPPORTS_MASKING). Y = 0.299R + 0.587G + 0.114B. |
| 3:00 | Open noisy 8-bit image, Duplicate. On copy A: Process > Filters > Mean radius 1. On the original: Plugins > Group5 > 3x3 Blur | Same maths: convolution with 1/9 of ones. |
| 4:00 | Process > Image Calculator > Difference (A vs ours) | Black image: our hand-written blur equals the built-in one. |
| 4:30 | Plugins > Group5 > Image Info | A plain PlugIn with a dialog. Not a filter. |
| 5:00 | Hand over to Q&A | |

Fallback if live demo fails: show the before/after screenshots in img/ and the backup video.
