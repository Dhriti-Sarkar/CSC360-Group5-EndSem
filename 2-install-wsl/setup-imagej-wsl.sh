
#!/bin/bash
set -e

echo "=================================="
echo " ImageJ WSL Setup"
echo "=================================="

# Install required packages
sudo apt update
sudo apt install -y openjdk-21-jdk unzip wget

# Create installation directory
INSTALL_DIR="$HOME/imagej"
mkdir -p "$INSTALL_DIR"

# Download ImageJ
ZIP_FILE="/tmp/ij154.zip"

echo "Downloading ImageJ..."
wget -O "$ZIP_FILE" \
  https://wsr.imagej.net/distros/cross-platform/ij154.zip

# Extract ImageJ
echo "Extracting ImageJ..."
unzip -oq "$ZIP_FILE" -d "$INSTALL_DIR"

# Verify installation
IJ_JAR="$INSTALL_DIR/ImageJ/ij.jar"

if [ ! -f "$IJ_JAR" ]; then
    echo "Error: ij.jar was not found!"
    exit 1
fi

echo ""
echo "Installation completed!"
echo "Java version:"
java -version

echo ""
echo "ImageJ location:"
echo "$IJ_JAR"

echo ""
echo "ImageJ WSL setup successful!"
