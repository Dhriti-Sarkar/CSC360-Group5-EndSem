# Manual test checklist

Tested in ImageJ 1.54p (Java 25.0.4). Menu check: Plugins > Group5 shows all four entries.

Test images (in test-images/): an 8-bit gray image, an RGB colour image.

| Test | Invert | Grayscale | Blur 3x3 | Image Info |
| --- | --- | --- | --- | --- |
| 8-bit image | [x] | refuses (RGB only), as expected | [x] | [x] |
| RGB image | [x] | [x] | [x] | [x] |
| Rectangle selection (only inside changes) | [x] | [x] | [x] | n/a |
| Oval selection (mask respected) | [x] | [x] | [x] | n/a |
| Edit > Undo restores the image | [x] | [x] | [x] | n/a |
| No image open (sensible error) | [x] | [x] | [x] | [x] |
| Stack (optional) | [ ] | [ ] | [ ] | n/a |

Blur proof: Image > Duplicate, Process > Filters > Mean... radius 1 on one copy, our 3x3 Blur on the other, Process > Image Calculator > Difference. The difference image is black. Screenshot: img/07-blur-difference.png.