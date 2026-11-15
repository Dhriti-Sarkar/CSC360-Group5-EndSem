# Manual test checklist (do in a real ImageJ, tick each)

Menu check first: Plugins > Group5 shows all entries. If not, copy out/plugins/Group5_Plugins.jar into ImageJ's plugins/ folder and restart.

Test images (put small ones in test-images/): an 8-bit gray image, an RGB colour image.

| Test | Invert | Grayscale | Blur 3x3 | Image Info |
| --- | --- | --- | --- | --- |
| 8-bit image | [ ] | should refuse (RGB only) | [ ] | [ ] |
| RGB image | [ ] | [ ] | [ ] | [ ] |
| Rectangle selection (only inside changes) | [ ] | [ ] | [ ] | n/a |
| Oval selection (mask respected) | [ ] | [ ] | [ ] | n/a |
| Edit > Undo restores the image | [ ] | [ ] | [ ] | n/a |
| No image open (sensible error) | [ ] | [ ] | [ ] | [ ] |
| Stack (optional) | [ ] | [ ] | [ ] | n/a |

Blur proof: use Image > Duplicate, run Process > Filters > Mean... radius 1 on one copy, our 3x3 Blur on the other, Process > Image Calculator > Difference. Result should be black. Screenshot it into img/.

Grayscale check: open an RGB image, run Grayscale (Group5); then on a copy use Image > Type > 8-bit; compare the two visually and by Analyze > Measure (means differ slightly, explain why in the README).

Fix anything that fails, then update the README status table.
