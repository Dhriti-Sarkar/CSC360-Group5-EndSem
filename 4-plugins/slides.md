# Section 4: Plugins (slide content for Member 1)

**Slide 1: Why plugins?**
- ImageJ core is one jar. Everything else can be added: plugins (Java) and macros (scripts).
- Image: Plugins menu screenshot.
- Notes: Point out that most of ImageJ's own menu commands are plugins too.

**Slide 2: Installing an existing plugin**
- Download .jar -> copy to plugins/ -> restart -> find in Plugins menu.
- Image: jar_demo.jar in the plugins folder + Plugins > JAR Demo submenu.
- Notes: Underscore in the file name is required. Also Plugins > Install... and Compile and Run...

**Slide 3: PlugIn vs PlugInFilter**
- Table: entry point, what you get, what ImageJ does for you.
- Notes: PlugIn = you do everything. PlugInFilter = ImageJ gives you the pixels, undo, ROI.

**Slide 4: Flags in setup()**
- DOES_8G, DOES_RGB, SUPPORTS_MASKING, DOES_STACKS, NO_CHANGES (one line each).

**Slide 5: Our plugins**
- Invert Image, Grayscale (luminance weights), 3x3 Blur.
- Image: before/after screenshots for each (img/).

**Slide 6: Blur_3x3 = convolution**
- Kernel 1/9 * [[1,1,1],[1,1,1],[1,1,1]] drawn as a 3x3 grid.
- Two rules: read from a copy; clamp at the borders.
- Notes: Without the copy, blurred pixels get averaged again.

**Slide 7: Proof it is correct**
- Image: difference image (all black) vs Process > Filters > Mean radius 1.

**Slide 8: Takeaways**
- Plugins are small Java classes + one config line. We wrote three. Built-in tools can verify them.
