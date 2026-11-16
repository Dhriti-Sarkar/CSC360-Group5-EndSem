# Installing ImageJ on Windows with a Modern JDK

**Owner:** Member 1 · **Machine:** Windows 10/11 · **Tested on:** a clean Windows user account

This guide takes you from nothing to a running ImageJ, using a modern OpenJDK (21 LTS or 25) instead of the old Java bundled with the Windows download.

## Why not just use the bundled Java?

The Windows ImageJ download ships with its own Java runtime. That runtime is older, gets no security updates, and does not include `javac`, which you need if you want to compile plugins. Installing our own JDK lets us control the version and makes the setup match what we teach in the plugins section.

## Step 1: Check for existing Java

Open **PowerShell** (Start menu, type `powershell`) and run:

```
java -version
```

- If you see `openjdk version "21..."` or `"25..."`, you already have a suitable JDK. Skip to Step 3.
- If you see `'java' is not recognized`, you have no Java on PATH. Continue to Step 2.
- If you see an older version (8, 11, 17), install the new JDK in Step 2. The newest version on PATH wins only if it appears first, so Step 4 covers that.

## Step 2: Install a JDK

1. Download **Eclipse Temurin 21 (LTS)** from https://adoptium.net (choose Windows, x64, `.msi`). Temurin 25 also works; we standardise on whichever the group agreed in the PLAN.
2. Run the `.msi`. On the **Custom Setup** screen, set these features to "Will be installed on local hard drive":
   - **Set JAVA_HOME variable**
   - **Add to PATH**
   - (Optional) **Associate .jar files with Java**
3. Finish the installer.

> Screenshot: `img/02-temurin-custom-setup.png`

## Step 3: Verify the install

Close every terminal window and open a **new** PowerShell window (environment variables only load in new windows). Run:

```
java -version
javac -version
echo $env:JAVA_HOME
```

Expected: both `java` and `javac` report the same version, and `JAVA_HOME` points to something like `C:\Program Files\Eclipse Adoptium\jdk-21.x.x-hotspot`.

Or run the included script, which prints all of this and flags problems:

```
powershell -ExecutionPolicy Bypass -File .\check-java.ps1
```

> Screenshot: `img/03-java-version.png`

## Step 4: Fix the PATH order (only if needed)

If `java -version` still shows an old version:

1. Press Start, type `environment variables`, open **Edit the system environment variables**.
2. Click **Environment Variables**, select **Path** under *System variables*, click **Edit**.
3. Move the entry for the new JDK (`...\jdk-21...\bin`) to the top. Click OK on all windows and reopen PowerShell.

## Step 5: Get ImageJ

Go to https://imagej.net/ij/download.html. There are two options:

| Option | What it is | When to use |
| --- | --- | --- |
| Windows zip / installer (bundles Java) | ImageJ plus its own Java runtime | Simplest, but the Java is old. Use only as a fallback. |
| **Platform-independent `ij.jar`** | Just the program; runs on *our* JDK | **Recommended.** This is what we demonstrate. |

For the recommended option:

1. Create a folder, e.g. `C:\ImageJ\`.
2. Download `ij.jar` into that folder.
3. Create a `plugins\` subfolder inside it (ImageJ loads plugins from here).
4. Copy `Group5_Plugins.jar` (from Member 4) into `plugins\`.
5. Copy `run-imagej.bat` from this folder into `C:\ImageJ\` as well.

## Step 6: First launch

Double-click `run-imagej.bat`, or run this in PowerShell from the folder containing `ij.jar`:

```
java -Xmx2g -jar ij.jar
```

- `-Xmx2g` gives ImageJ up to 2 GB of memory. Without it, large images can fail with "Out of memory".
- The main ImageJ window should appear with its toolbar.

> Screenshot: `img/04-first-launch.png`

Confirm the Java in use: **Help > About ImageJ** shows the Java version. It should match Step 3.

> Screenshot: `img/05-help-about.png`

## Step 7: Set memory and check plugins

1. **Edit > Options > Memory & Threads**: check the maximum memory value and click OK. Restart ImageJ if prompted.
2. **Plugins** menu: confirm a **Group5** submenu appears. If it does, `Group5_Plugins.jar` loaded correctly. This is the proof that our plugins run on Windows.

> Screenshot: `img/06-plugins-group5.png`

## Troubleshooting

| Symptom | Cause | Fix |
| --- | --- | --- |
| `'java' is not recognized as an internal or external command` | JDK not installed, or PATH not updated | Reinstall with **Add to PATH** ticked; open a new terminal |
| `java -version` shows an old version | Older Java earlier on PATH | Step 4: move the new JDK's `bin` to the top of Path |
| `javac` not recognized but `java` works | You installed a JRE, not a JDK | Install the JDK (the `.msi` from Temurin is a JDK) |
| ImageJ opens, then closes immediately | Usually a Java launch error printed to a window that vanished | Launch from `run-imagej.bat` or PowerShell so the error stays visible |
| `Error: Could not find or load main class ij.ImageJ` | Wrong jar, or `ij.jar` not in the folder you ran from | Run from the folder containing `ij.jar`; re-download it |
| Blurry UI on a high-DPI screen | Windows scaling applied to Java | Right-click `run-imagej.bat` > Properties > Compatibility > Change high DPI settings > tick *Override high DPI scaling* |
| SmartScreen or antivirus blocks the download | Unknown publisher warning | Click *More info* > *Run anyway*, or download from the official site only |
| `Out of memory` on large images | Default heap too small | Use `-Xmx2g` (or more) in the launcher |

## Files in this folder

| File | Purpose |
| --- | --- |
| `README.md` | This guide |
| `check-java.ps1` | Prints Java, `javac`, `JAVA_HOME` and PATH status for self-diagnosis |
| `run-imagej.bat` | Launcher for the `ij.jar` setup, with 2 GB memory |
| `slides.md` | Slide content and speaker notes for the deck |
| `viva-prep.md` | Questions we expect in the viva, with answers |
| `img/` | Numbered screenshots |
