
newImage("Test Image", "8-bit ramp", 256, 256, 1);

run("Gaussian Blur...", "sigma=4");

saveAs("PNG", getDirectory("home") + "imagej/output/result.png");

print("Headless processing completed successfully!");

