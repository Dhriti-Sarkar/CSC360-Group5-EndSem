#!/usr/bin/env bash
set -euo pipefail
cd "$(dirname "$0")"
IJ_VERSION=1.54p
JAR=lib/ij.jar

case "${1:-build}" in
  fetch)
    curl -fL -o "$JAR" "https://repo1.maven.org/maven2/net/imagej/ij/$IJ_VERSION/ij-$IJ_VERSION.jar"
    ;;
  build)
    [ -f "$JAR" ] || { echo "Missing $JAR, run: ./build.sh fetch" >&2; exit 1; }
    rm -rf out && mkdir -p out/classes out/plugins
    javac -cp "$JAR" -d out/classes src/*.java
    cp src/plugins.config out/classes/
    jar cf out/plugins/Group5_Plugins.jar -C out/classes .
    echo "Built out/plugins/Group5_Plugins.jar"
    ;;
  run)
    "$0" build
    java -cp "$JAR:out/classes" ij.ImageJ
    ;;
  *) echo "usage: $0 [fetch|build|run]" >&2; exit 2 ;;
esac
