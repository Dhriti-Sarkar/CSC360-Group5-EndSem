# ImageJ plugins

Plain `javac` project, no build tool needed. Tested with OpenJDK 25 and ImageJ 1.54p.

## Setup

```sh
./build.sh fetch   # downloads ij.jar into lib/ (git-ignored)
./build.sh         # compiles src/ into out/ and builds out/plugins/Group5_Plugins.jar
./build.sh run     # launches ImageJ with the plugins on the classpath
```

To install into a real ImageJ, copy `out/plugins/Group5_Plugins.jar` into its `plugins/` folder
and restart. Plugins appear under **Plugins > Group5**.

## Naming rules

A plugin class name must contain an underscore (`Invert_Image`) or ImageJ will not list it in the menu.
Menu entries come from `src/plugins.config`.

## Plugins

| Class | Type | Status |
|-------|------|--------|
| `Invert_Image` | `PlugInFilter` | starter, working |
| grayscale | `PlugInFilter` | TODO |
| 3x3 blur | `PlugInFilter` | TODO |
