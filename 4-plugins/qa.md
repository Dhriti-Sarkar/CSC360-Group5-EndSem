# Q&A bank (all sections). Answerer in brackets. Add real questions from rehearsals.

## Plugins (M4)
1. **PlugIn vs PlugInFilter: when do you use which?** [M4] PlugIn when you manage everything (dialogs, new images, file opening). PlugInFilter when you just process the pixels of the current image: ImageJ passes the processor and handles undo, ROI and stacks.
2. **What do DOES_8G, SUPPORTS_MASKING, NO_CHANGES mean?** [M4] DOES_8G: accepts 8-bit gray only. SUPPORTS_MASKING: non-rectangular selections are respected, ImageJ restores pixels outside the mask. NO_CHANGES: plugin does not modify the image, so no undo snapshot is made.
3. **Why does the plugin name need an underscore?** [M4] ImageJ only adds classes/jars with an underscore in the name to the Plugins menu. It is a simple rule to avoid listing every helper class.
4. **Why copy the image before blurring?** [M4] The filter reads neighbours. If it reads pixels already blurred, results depend on scan order and smear. Reading from the copy gives each pixel the average of the original values.
5. **How do you handle border pixels?** [M4] Clamp coordinates to the edge so edge pixels are repeated. Other options: skip the border, mirror, or wrap around.
6. **How is Blur_3x3 different from Process > Filters > Mean?** [M4] Same result for radius 1 (we verified the difference image is black). Ours is hand-written and fixed at 3x3; the built-in is optimised and supports any radius.
7. **How would you extend it to Gaussian or any kernel?** [M4] Replace the sum of ones with a kernel array of weights and divide by the kernel sum. A Gaussian just uses Gaussian weights.
8. **How do you debug a plugin?** [M4] IJ.log and IJ.showMessage, or run from an IDE with ij.ImageJ as main class.
9. **Why does our grayscale differ from Image > Type > 8-bit?** [M4] We use luminance weights (0.299, 0.587, 0.114). ImageJ's default is the plain average of R, G, B unless weighted conversions is enabled.
10. **Why is the grayscale result still RGB?** [M4] A PlugInFilter cannot change an image's type. A PlugIn that builds a new 8-bit image could, at the cost of losing ImageJ's undo/ROI handling.
11. **Why does the blur round with (sum + 4) / 9?** [M4] Integer division truncates. Adding half the divisor rounds to nearest, matching ImageJ.
12. **How do you install a plugin?** [M4] Copy the jar into plugins/, restart, find it in the Plugins menu. Or Plugins > Install....

## Intro / Windows (M1)
13. **What is ImageJ and who made it?** [M1] Free, open-source Java image-processing program from the US National Institutes of Health, widely used in science.
14. **ImageJ vs ImageJ2 vs Fiji?** [M1] ImageJ 1.x is the classic program. ImageJ2 is a rewritten architecture, backwards compatible. Fiji is ImageJ plus many plugins and an updater.
15. **Why not use the bundled Java?** [M1] It is old, without security updates, and cannot run plugins built for newer Java.
16. **JRE vs JDK, why do we need javac?** [M1] A JRE runs programs; a JDK adds the compiler. We need javac to build our plugins.
17. **How much memory should ImageJ get?** [M1] Enough for the images in use, e.g. -Xmx2g; set in Edit > Options > Memory & Threads.

## WSL (M2)
18. **WSL1 vs WSL2, and what is WSLg?** [M2] WSL2 runs a real Linux kernel in a lightweight VM. WSLg lets Linux GUI apps show as normal Windows windows.
19. **Why run ImageJ in Linux?** [M2] Headless batch processing, servers, and the same tooling as production.
20. **What does headless mean, what breaks?** [M2] Running without a display. GUI-only commands throw a headless exception.
21. **Why is /mnt/c slow?** [M2] Files cross the Windows/Linux boundary. Work in the Linux filesystem instead.

## User guide (M3)
22. **What is a histogram telling us, and what does thresholding do?** [M3] It counts pixels per intensity. Thresholding splits intensities into object and background.
23. **Gaussian vs median filter?** [M3] Gaussian averages with weights and blurs edges. Median takes the middle value, removes salt-and-pepper noise and keeps edges.
24. **What does Find Edges compute?** [M3] Sobel gradient magnitude.
25. **8-bit vs 16-bit vs RGB?** [M3] Number of intensity levels per channel and number of channels: 256 levels, 65,536 levels, or three 8-bit channels.
26. **What can the Macro Recorder not record?** [M3] It records menu commands and their settings. It does not record loops, conditions or your own logic; those are written by hand.
27. **What happens to the original when we apply a filter?** [M3] It changes in place; use Undo or work on a duplicate.
