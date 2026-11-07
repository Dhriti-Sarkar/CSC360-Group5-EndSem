import ij.ImagePlus;
import ij.plugin.filter.PlugInFilter;
import ij.process.ImageProcessor;

/** Starter plugin: inverts an 8-bit grayscale or RGB image in place. */
public class Invert_Image implements PlugInFilter {

    @Override
    public int setup(String arg, ImagePlus imp) {
        // Accept 8-bit and RGB; ask ImageJ to keep an undo snapshot.
        return DOES_8G | DOES_RGB | SUPPORTS_MASKING;
    }

    @Override
    public void run(ImageProcessor ip) {
        ip.invert();
    }
}
