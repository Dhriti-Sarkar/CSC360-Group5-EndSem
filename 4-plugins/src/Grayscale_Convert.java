import ij.ImagePlus;
import ij.plugin.filter.PlugInFilter;
import ij.process.ImageProcessor;
import java.awt.Rectangle;

/**
 * Grayscale_Convert - Group 5
 * Converts an RGB image to gray using luminance weights:
 *     Y = 0.299 R + 0.587 G + 0.114 B
 *
 * Approach (Option A): the image stays RGB, but R = G = B = Y, so it looks gray.
 * A PlugInFilter cannot change an image's TYPE, which is why we do not
 * produce a real 8-bit image here. Use Image > Type > 8-bit afterwards if needed.
 *
 * Flags: DOES_RGB (colour images only), SUPPORTS_MASKING (respects non-rectangular selections).
 * Undo and ROI handling are done by ImageJ.
 */
public class Grayscale_Convert implements PlugInFilter {

    public int setup(String arg, ImagePlus imp) {
        return DOES_RGB | SUPPORTS_MASKING;
    }

    public void run(ImageProcessor ip) {
        Rectangle r = ip.getRoi();               // selection bounds (whole image if none)
        int w = ip.getWidth();
        int[] pixels = (int[]) ip.getPixels();   // packed 0xRRGGBB per pixel
        for (int y = r.y; y < r.y + r.height; y++) {
            for (int x = r.x; x < r.x + r.width; x++) {
                int c = pixels[y * w + x];
                int red = (c >> 16) & 0xff;
                int green = (c >> 8) & 0xff;
                int blue = c & 0xff;
                int gray = (int) Math.round(0.299 * red + 0.587 * green + 0.114 * blue);
                pixels[y * w + x] = (gray << 16) | (gray << 8) | gray;
            }
        }
    }
}
