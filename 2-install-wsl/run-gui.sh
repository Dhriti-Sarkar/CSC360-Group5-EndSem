
#!/bin/bash
set -e

IJ_JAR="$HOME/imagej/ImageJ/ij.jar"

if [ ! -f "$IJ_JAR" ]; then
    echo "Error: ImageJ ij.jar not found!"
    exit 1
fi

echo "Launching ImageJ through WSLg..."

java -Xmx2g -jar "$IJ_JAR"
