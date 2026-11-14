
# ImageJ Installation on WSL2 (Ubuntu)

## 1. Overview

This section demonstrates how to install and run ImageJ on Ubuntu using Windows Subsystem for Linux 2 (WSL2).

It covers:
- Installing WSL2 and Ubuntu.
- Installing OpenJDK 21.
- Downloading and launching ImageJ.
- Running ImageJ through WSLg.
- Running ImageJ in batch mode without opening its GUI.
- Accessing Windows files from Ubuntu.

## 2. Requirements

- Windows 10 (supported recent build) or Windows 11.
- WSL2 enabled.
- Ubuntu Linux.
- Internet connection for initial installation.
- OpenJDK 21.

## 3. Install WSL2 and Ubuntu

Open PowerShell as Administrator.

Run:

```powershell
wsl --install -d Ubuntu
```

Restart Windows if requested.

Open Ubuntu and create a Linux username and password.

Verify the installation:

```powershell
wsl --status
wsl -l -v
```

Ubuntu should appear with VERSION 2.

## 4. Install Java JDK 21

Open the Ubuntu terminal.

Update packages:

```bash
sudo apt update
```

Install Java:

```bash
sudo apt install openjdk-21-jdk -y
```

Verify Java:

```bash
java -version
javac -version
```

## 5. Install ImageJ

Run the provided setup script:

```bash
./setup-imagej-wsl.sh
```

The script installs the required packages, downloads ImageJ and extracts it into:

```text
~/imagej/ImageJ/
```

The main application JAR is:

```text
~/imagej/ImageJ/ij.jar
```

## 6. Run ImageJ with GUI (WSLg)

Execute:

```bash
./run-gui.sh
```

Alternatively:

```bash
java -jar ~/imagej/ImageJ/ij.jar
```

WSLg allows Linux graphical applications to appear as normal windows on Windows.

## 7. Run ImageJ in Batch Mode

ImageJ supports automated image processing through macros.

The supplied macro:

`headless-demo.ijm`

performs these operations:

1. Creates a 256 x 256 8-bit ramp image.
2. Applies Gaussian Blur with sigma 4.
3. Saves the processed image as result.png.

Run:

```bash
./run-headless.sh
```

The generated image is saved at:

```text
~/imagej/output/result.png
```

Verify the output:

```bash
file ~/imagej/output/result.png
```

Expected output: a 256 x 256, 8-bit grayscale PNG image.

Note: The tested batch command uses ImageJ's -batch option.
Strict Java headless mode using
-Djava.awt.headless=true was not verified successfully.

## 8. Windows and Linux File Access

Windows drives are accessible through:

```text
/mnt/c/
```

For example:

```bash
cd /mnt/c/Users/
```

Windows can access Ubuntu files through File Explorer using:

```text
\\wsl$\Ubuntu\
```

For better file performance, working inside the Ubuntu filesystem is recommended.

## 9. Troubleshooting

| Problem | Solution |
|---|---|
| WSL installation fails | Check virtualization and Windows features |
| Ubuntu not listed | Run wsl --list --online and install Ubuntu |
| WSL1 instead of WSL2 | Run wsl --set-version Ubuntu 2 |
| GUI does not open | Run wsl --update and wsl --shutdown |
| Java not found | Install openjdk-21-jdk |
| ImageJ JAR not found | Verify the path to ij.jar |
| Headless output missing | Check macro path and Java output for errors |
| Slow file access | Work inside ~/ rather than /mnt/c |

## 10. Project Files

| File | Purpose |
|---|---|
| setup-imagej-wsl.sh | Installs Java and downloads ImageJ |
| run-gui.sh | Launches ImageJ GUI |
| headless-demo.ijm | Image processing macro |
| run-headless.sh | Executes the macro in batch mode |
| img/ | Installation screenshots |

## 11. Conclusion

ImageJ was successfully installed and executed on Ubuntu through WSL2.

Both graphical execution using WSLg and automated batch processing using ImageJ macros were tested successfully.
