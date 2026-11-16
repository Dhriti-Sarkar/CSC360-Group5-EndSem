# Member 1 slides: Intro + Windows and JDK install

Speaker time: about 8 minutes (2-3 intro, 5 install).

---

## Slide 1: Title
- Present ImageJ: Install, User Guide, Plugins
- Group 5, CSC360
- Notes: Introduce yourself and the three sections. Say the demo is at the end.

## Slide 2: Agenda
- What ImageJ is
- ImageJ vs ImageJ2 vs Fiji
- Installing on Windows with a modern JDK
- Hand-over to WSL (Member 2), UI (Member 3), Plugins (Member 4)
- Notes: Keep to one line per item.

## Slide 3: What is ImageJ?
- Free, open-source image processing program written in Java
- Developed at the US National Institutes of Health (NIH)
- Used for microscopy and medical imaging: open, view, measure, filter, analyse
- Runs anywhere Java runs
- Notes: One sentence on why science uses it: it is free and extensible.
- Image: ImageJ main window (screenshot)

## Slide 4: ImageJ vs ImageJ2 vs Fiji
- ImageJ (1.x): the classic program we present, current 1.54p
- ImageJ2: rewritten architecture, backwards compatible
- Fiji: "Fiji Is Just ImageJ", ImageJ bundled with many plugins and an updater
- Notes: We use plain ImageJ 1.x throughout. If asked about Fiji, see viva-prep.md.

## Slide 5: Why this matters for the course
- Pixels and bit depth
- Histograms and thresholding
- Convolution filters: blur, sharpen
- Edge detection and grayscale conversion
- Plugins let us implement some of these ourselves
- Notes: Link each bullet to a later section if possible.

## Slide 6: Two ways to install ImageJ
- Bundled Java (Windows zip/installer): simple, old Java
- ij.jar with our own JDK: recommended, what we demonstrate
- Image: side-by-side comparison table
- Notes: The key point is that the bundled Java is outdated and has no javac.

## Slide 7: Step 1, check for Java
- Command: `java -version` in PowerShell
- Three outcomes: suitable JDK, not recognised, old version
- Screenshot: img/01-java-check.png
- Notes: Demo this live if time allows.

## Slide 8: Step 2, install a JDK
- Download Eclipse Temurin 21 (LTS) from adoptium.net
- Run the .msi, tick: Set JAVA_HOME, Add to PATH
- Notes: Explain what JAVA_HOME and PATH are in one sentence each. This is a likely viva question.

## Slide 9: Step 3, verify
- Open a NEW terminal, then run: `java -version`, `javac -version`, `echo $env:JAVA_HOME`
- Screenshot: img/03-java-version.png
- Notes: Emphasise "new terminal". Env variables do not refresh in old windows.

## Slide 10: Step 4, launch ImageJ
- `java -Xmx2g -jar ij.jar`, or double-click run-imagej.bat
- Screenshot: img/04-first-launch.png
- Notes: Explain -Xmx2g means a 2 GB memory limit.

## Slide 11: Help > About shows the Java in use
- Screenshot: img/05-help-about.png
- Notes: Proof that ImageJ runs on our JDK, not the bundled one.

## Slide 12: Memory and plugins
- Edit > Options > Memory & Threads
- Plugins > Group5 appears after copying Group5_Plugins.jar into plugins/
- Notes: Hand over to Member 4 for what Group5 contains.

## Slide 13: Common problems
- 'java' is not recognised: PATH not updated
- Old Java picked up first: move new JDK to top of PATH
- ImageJ closes immediately: launch from the bat file so errors stay visible
- Blurry UI on high-DPI: Compatibility > High DPI settings
- Notes: Refer to the full table in README.md.

## Slide 14: Summary and hand-over
- A modern JDK gives us control of the Java version
- ImageJ runs from one jar and one launcher
- Next: Member 2 shows the same on WSL (Linux)
- Notes: Thank the audience, then hand over.
