
newImage("Test Image", "8-bit ramp", 256, 256, 1);

run("Gaussian Blur...", "sigma=4");

// Create the output directory if it does not exist.
home = getDirectory("home");
outputDir = home + "imagej/output/";
File.makeDirectory(outputDir);

// Save the processed image.
saveAs("PNG", outputDir + "result.png");

print("Batch processing completed successfully!");
