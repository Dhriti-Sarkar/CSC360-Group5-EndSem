# Sample pictures for the live demo

These pictures are used in `../demo-script.md`. They must work **offline**, so every file is saved here.

| File | What it is | Used in step | Source (URL or "own photo") | Licence | Size |
|---|---|---|---|---|---|
| `photo.gif` | Normal photo | 1, 2, 3 | ImageJ built-in sample: Clown | _TODO: confirm_ | 37 KB |
| `noisy.gif` | Grainy picture (Leaf with Process > Noise > Add Noise applied) | 4 | ImageJ built-in sample: Leaf, noise added by us | _TODO: confirm_ | 179 KB |
| `edges.gif` | Picture with clear outlines | 5 | ImageJ built-in sample: Boats | _TODO: confirm_ | 370 KB |
| `blobs.gif` | Round shapes on a plain background | 6, 7, 8 | ImageJ built-in sample: Blobs | _TODO: confirm_ | 26 KB |
| `particles.png` (backup) | Particles for step 7 if the Blobs count looks wrong | 7 | ImageJ built-in sample: Particles | _TODO: confirm_ | _TODO_ |
| `demo-macro.ijm` | Recorded macro (Gaussian Blur sigma 2, then Find Edges) | 8 (fallback) | recorded by us | n/a | n/a |

## Rules

- Use only your own photos, ImageJ's built-in samples, or pictures that are free to use (e.g. Wikimedia Commons, Unsplash).
- Keep each file under about 1 MB.
- If you save an ImageJ built-in sample (File > Open Samples), write "ImageJ built-in sample: <name>" as the source.

## Notes

- Blobs uses an inverting LUT. If the threshold looks backwards in step 6, click **Auto** or tick **Dark background**.
- Choose a format that matches the file name when saving (all four are saved as GIF).

## Checklist

- [ ] All four pictures saved here
- [ ] Source and licence filled in for each row
- [ ] Each picture tested with its demo step in real ImageJ
- [ ] `blobs.gif` gives a sensible particle count
- [ ] `demo-macro.ijm` recorded and saved here
