import ij.ImagePlus;
import ij.process.*;
import java.awt.Rectangle;
import java.util.Random;

/** Headless self-test: compares our plugins against ImageJ built-ins. Run: ./build.sh test */
public class PluginTest {
    static int fails = 0;
    static void check(String name, boolean ok) {
        System.out.println((ok ? "PASS  " : "FAIL  ") + name);
        if (!ok) fails++;
    }
    static int maxDiff8(ImageProcessor a, ImageProcessor b) {
        int m = 0;
        for (int y = 0; y < a.getHeight(); y++)
            for (int x = 0; x < a.getWidth(); x++)
                m = Math.max(m, Math.abs(a.get(x, y) - b.get(x, y)));
        return m;
    }
    public static void main(String[] args) {
        Random rnd = new Random(42);
        int w = 37, h = 29;   // odd sizes on purpose

        // 8-bit random image
        ByteProcessor bp = new ByteProcessor(w, h);
        for (int i = 0; i < w * h; i++) bp.set(i, rnd.nextInt(256));
        ImageProcessor ours = bp.duplicate(), ref = bp.duplicate();
        new Blur_3x3().run(ours);
        ref.filter(ImageProcessor.BLUR_MORE);
        check("Blur_3x3 8-bit equals built-in BLUR_MORE (max diff " + maxDiff8(ours, ref) + ")", maxDiff8(ours, ref) == 0);

        // RGB: compare each channel against built-in
        ColorProcessor cp = new ColorProcessor(w, h);
        for (int i = 0; i < w * h; i++) cp.set(i, rnd.nextInt(0x1000000));
        ImageProcessor oursC = cp.duplicate(), refC = cp.duplicate();
        new Blur_3x3().run(oursC);
        refC.filter(ImageProcessor.BLUR_MORE);
        int md = 0;
        for (int y = 0; y < h; y++) for (int x = 0; x < w; x++) {
            int a = oursC.get(x, y), b = refC.get(x, y);
            for (int s = 0; s <= 16; s += 8) md = Math.max(md, Math.abs(((a >> s) & 255) - ((b >> s) & 255)));
        }
        check("Blur_3x3 RGB equals built-in BLUR_MORE (max channel diff " + md + ")", md == 0);

        // Blur respects a rectangular ROI: pixels outside must be unchanged
        ImageProcessor roi = bp.duplicate();
        roi.setRoi(new Rectangle(5, 5, 10, 10));
        new Blur_3x3().run(roi);
        boolean outsideSame = true;
        for (int y = 0; y < h; y++) for (int x = 0; x < w; x++)
            if (!(x >= 5 && x < 15 && y >= 5 && y < 15) && roi.get(x, y) != bp.get(x, y)) outsideSame = false;
        check("Blur_3x3 leaves pixels outside the ROI untouched", outsideSame);

        // Grayscale: R=G=B everywhere, and value equals weighted formula
        ImageProcessor g = cp.duplicate();
        new Grayscale_Convert().run(g);
        boolean gray = true, formula = true;
        for (int y = 0; y < h; y++) for (int x = 0; x < w; x++) {
            int c = cp.get(x, y), o = g.get(x, y);
            int r = (o >> 16) & 255, gg = (o >> 8) & 255, b = o & 255;
            if (r != gg || gg != b) gray = false;
            int exp = (int) Math.round(0.299 * ((c >> 16) & 255) + 0.587 * ((c >> 8) & 255) + 0.114 * (c & 255));
            if (r != exp) formula = false;
        }
        check("Grayscale_Convert gives R=G=B for every pixel", gray);
        check("Grayscale_Convert matches Y = 0.299R+0.587G+0.114B", formula);

        // Grayscale known values
        ColorProcessor k = new ColorProcessor(3, 1);
        k.set(0, 0, 0xFF0000); k.set(1, 0, 0x00FF00); k.set(2, 0, 0x0000FF);
        new Grayscale_Convert().run(k);
        check("Pure red->76, green->150, blue->29", (k.get(0,0)&255)==76 && (k.get(1,0)&255)==150 && (k.get(2,0)&255)==29);

        System.out.println(fails == 0 ? "\nALL TESTS PASSED" : "\n" + fails + " TEST(S) FAILED");
        System.exit(fails == 0 ? 0 : 1);
    }
}
