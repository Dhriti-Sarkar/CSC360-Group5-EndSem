# Viva prep: Member 1 (Windows and JDK)

The viva carries 60% of the project grade, so be able to explain each answer in your own words, not from memory of this file. Try explaining each answer aloud without looking.

## Concepts

**What is ImageJ?**
A free, open-source image processing program written in Java, developed at the US NIH. Used mainly in science to open, view, measure and filter images. Extensible through macros and plugins.

**ImageJ vs ImageJ2 vs Fiji?**
ImageJ 1.x is the classic program (we use 1.54p). ImageJ2 is a rewrite of the architecture that stays backwards compatible. Fiji is ImageJ bundled with many plugins and an updater.

**What is a JDK and how is it different from a JRE?**
A JRE runs Java programs. A JDK contains the JRE plus development tools, mainly `javac` the compiler. We need the JDK because we compile plugins.

**What is `javac`?**
The Java compiler. It turns `.java` source into `.class` bytecode. Only needed when writing code, not to run ImageJ.

**What is JAVA_HOME?**
An environment variable that points to the JDK folder. Tools and build systems use it to find Java without searching PATH.

**What is PATH and why does order matter?**
A list of folders Windows searches for programs when you type a command. The first match wins, so an old `java.exe` earlier on PATH runs instead of the new one.

**Why install our own JDK instead of the bundled Java?**
The bundled runtime is older, gets no security updates, and has no `javac`. Our own JDK gives us a known version and lets us compile plugins.

**Why 21 or 25?**
21 is an LTS (long-term support) release, so it is stable and supported for years. 25 is newer. The group agreed on one version for the demo (see PLAN.md).

**What does `-Xmx2g` do?**
Sets the maximum Java heap to 2 gigabytes. Without enough memory, large images give an out-of-memory error.

**Why `java -jar ij.jar` and not double-clicking?**
Double-clicking depends on file associations, which may point to an old Java. Running the command, or the bat file, makes the Java version explicit.

**Where do plugins go?**
In the `plugins/` folder next to `ij.jar`. ImageJ scans it at startup and adds the plugins to the menus, so restart after copying.

**Why does the Group5 jar need to be tested on Windows?**
Member 4 works on macOS. Testing on Windows proves the plugin runs on another OS, which is part of the "clean setup" requirement.

## Practical questions

**How do I check which Java ImageJ is using?**
Help > About ImageJ, or `java -version` in the same environment.

**What do I do if ImageJ closes immediately?**
Launch it from `run-imagej.bat` or PowerShell so the error stays visible. Common causes are the wrong Java or a bad jar.

**How do I fix a blurry UI?**
Set high-DPI override on the launcher: Properties > Compatibility > Change high DPI settings.

## Questions to ask yourself before the viva

- Can I open a new PowerShell and show `java -version`, `javac -version` and `JAVA_HOME` from memory?
- Can I explain what happens when I type `java -jar ij.jar`?
- Can I say why we did not use the bundled Java?
- Can I name one problem I hit and how I fixed it?
