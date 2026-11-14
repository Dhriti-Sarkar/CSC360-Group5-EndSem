
#!/bin/bash
set -e

# Locate this script's directory
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"

# ImageJ installation
IJ_JAR="$HOME/imagej/ImageJ/ij.jar"

# Output directory
OUTPUT_DIR="$HOME/imagej/output"
mkdir -p "$OUTPUT_DIR"

# Check ImageJ installation
if [ ! -f "$IJ_JAR" ]; then
    echo "Error: ImageJ ij.jar not found at $IJ_JAR"
    exit 1
fi

# Run ImageJ macro in batch mode
java -jar "$IJ_JAR" -batch "$SCRIPT_DIR/headless-demo.ijm"

echo "Headless batch processing finished."
echo "Check output directory: $OUTPUT_DIR"
