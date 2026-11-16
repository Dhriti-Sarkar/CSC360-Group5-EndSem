import ij.ImagePlus;
import ij.plugin.filter.PlugInFilter;
import ij.process.ImageProcessor;
import java.awt.Rectangle;

/**
 * Blur_3x3 - Group 5
 * A 3x3 mean (box) blur written by hand, i.e. a convolution with the kernel
 *     1/9 * [[1,1,1],[1,1,1],[1,1,1]]
 *
 * Key decisions:
 *  - We read from a COPY of the image (ip.duplicate()) and write to the original.
 *    Otherwise already-blurred pixels would be averaged into later pixels.
 *  - Borders: coordinates are clamped to the image edge (edge pixels are repeated).
 *  - Rounding: (sum + 4) / 9 rounds to nearest, like ImageJ's built-in BLUR_MORE.
 *  - Works on 8-bit gray and RGB (each colour channel blurred separately).
 */
public class Blur_3x3 implements PlugInFilter {

    public int setup(String arg, ImagePlus imp) {
        return DOES_8G | DOES_RGB | SUPPORTS_MASKING;
    }

    public void run(ImageProcessor ip) {
        int w = ip.getWidth(), h = ip.getHeight();
        boolean rgb = (ip.getBitDepth() == 24);
        ImageProcessor src = ip.duplicate();      // unmodified copy to read from
        Rectangle r = ip.getRoi();                // only process inside the selection

        for (int y = r.y; y < r.y + r.height; y++) {
            for (int x = r.x; x < r.x + r.width; x++) {
                int sumR = 0, sumG = 0, sumB = 0;
                for (int dy = -1; dy <= 1; dy++) {
                    for (int dx = -1; dx <= 1; dx++) {
                        int xx = Math.min(w - 1, Math.max(0, x + dx));   // clamp to edge
                        int yy = Math.min(h - 1, Math.max(0, y + dy));
                        int v = src.get(xx, yy);
                        if (rgb) {
                            sumR += (v >> 16) & 0xff;
                            sumG += (v >> 8) & 0xff;
                            sumB += v & 0xff;
                        } else {
                            sumR += v;
                        }
                    }
                }
                if (rgb) {
                    int rr = (sumR + 4) / 9, gg = (sumG + 4) / 9, bb = (sumB + 4) / 9;
                    ip.set(x, y, (rr << 16) | (gg << 8) | bb);
                } else {
                    ip.set(x, y, (sumR + 4) / 9);
                }
            }
        }
    }
}
