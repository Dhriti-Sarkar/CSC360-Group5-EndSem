# Member 2 – Running ImageJ on WSL2

## Slide 1: What is WSL2?

**Slide content**
- WSL = Windows Subsystem for Linux.
- Runs a Linux environment directly inside Windows.
- WSL2 uses a real Linux kernel in a lightweight virtual machine.
- No dual-boot or separate Linux installation required.
- WSLg allows Linux graphical applications to open as Windows windows.

**Suggested visual:** `img/01-wsl-version.png`

**Speaker notes:**

"WSL stands for Windows Subsystem for Linux. It allows us to run a Linux environment directly inside Windows without setting up dual boot. We use WSL2, which runs a real Linux kernel inside a lightweight virtual machine. Another important feature is WSLg, which allows Linux graphical applications to open directly on the Windows desktop."

---

## Slide 2: Setting up Ubuntu and Java

**Slide content**
1. Install WSL2 and Ubuntu using PowerShell.
2. Verify the distribution using `wsl -l -v`.
3. Update Ubuntu using `sudo apt update`.
4. Install OpenJDK 21.
5. Verify using `java -version` and `javac -version`.

**Commands:**

```bash
sudo apt update
sudo apt install openjdk-21-jdk -y
java -version
javac -version
```

**Suggested visual:** `img/03-java-version.png`

**Speaker notes:**

"After setting up WSL2, we installed Ubuntu as our Linux distribution. Since ImageJ is a Java-based application, we needed a Java Development Kit. We installed OpenJDK 21 and verified both the Java runtime and compiler. This gives us the environment required to run ImageJ inside Linux."

---

## Slide 3: Installing and launching ImageJ through WSLg

**Slide content**
- Downloaded the ImageJ distribution using wget.
- Extracted the application inside Ubuntu.
- Located the main application file: `ij.jar`.
- Launched ImageJ using Java.
- WSLg displayed the Linux application as a normal desktop window.

**Commands:**

```bash
mkdir -p ~/imagej
cd ~/imagej
java -jar ~/imagej/ImageJ/ij.jar
```

**Suggested visual:** `img/04-imagej-installation.png` and `img/05-imagej-gui.png`

**Speaker notes:**

"Once Java was installed, we downloaded the ImageJ distribution and extracted it inside our Ubuntu environment. ImageJ's main application is stored in a JAR file called ij.jar. We launched it using Java, and WSLg allowed the graphical interface to appear directly on our Windows desktop."

---

## Slide 4: Running ImageJ in Batch Mode

**Slide content**
- Batch processing allows ImageJ to execute macros automatically.
- No manual interaction with the graphical interface is required.
- Created a 256 × 256, 8-bit grayscale test image.
- Applied Gaussian Blur with sigma 4.
- Saved the processed image as `result.png`.

**Macro example:**

```javascript
newImage("Test Image", "8-bit ramp", 256, 256, 1);
run("Gaussian Blur...", "sigma=4");
saveAs("PNG", "/home/heer_patel/imagej/output/result.png");
print("Headless processing completed successfully!");
```

**Execution command:**

```bash
java -jar ~/imagej/ImageJ/ij.jar -batch /path/to/headless-demo.ijm
```

**Output:** `result.png` (256 × 256 pixels, 8-bit grayscale).

**Suggested visual:** `img/06-headless-output.png`

**Speaker notes:**

"One of the major advantages of running ImageJ in Linux is automated batch processing. Instead of manually opening the application and processing images, we can execute macros through the terminal. In our demonstration, we generated a 256 by 256 grayscale image, applied Gaussian Blur and saved the result as a PNG file. We verified that the output was successfully generated."

---

## Slide 5: Windows–Linux File Access and Conclusion

**Slide content**

**Accessing Windows files from Ubuntu:**
- Windows drives are mounted under `/mnt/`.
- Example: `/mnt/c/Users/`

**Accessing Ubuntu files from Windows:**
- Use `\\wsl$\Ubuntu\` in File Explorer.

**Why use WSL2?**
- Linux development environment inside Windows.
- Supports GUI applications through WSLg.
- Enables automated processing through terminal commands.
- Useful for server-based and batch-processing workflows.

**Suggested visual:** `img/07a-windows-files-from-wsl.png` and `img/07b-wsl-files-from-windows.png`

**Speaker notes:**

"WSL2 also provides access to files between Windows and Linux. Windows drives can be accessed through the /mnt directory in Ubuntu, while Ubuntu files can be accessed through the WSL network path in Windows Explorer. We have successfully demonstrated both graphical and batch execution of ImageJ, showing how the same application can work in a Linux environment within Windows."