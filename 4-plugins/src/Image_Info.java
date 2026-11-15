import ij.IJ;
import ij.ImagePlus;
import ij.gui.GenericDialog;
import ij.plugin.PlugIn;

/**
 * Image_Info - Group 5
 * A tiny PlugIn (NOT a PlugInFilter) used to show the difference.
 * ImageJ calls run(String) and hands us nothing: we fetch the image ourselves
 * with IJ.getImage(), and we build our own dialog. It does not change any pixels.
 */
public class Image_Info implements PlugIn {

    public void run(String arg) {
        ImagePlus imp = IJ.getImage();            // stops with an error if no image is open
        GenericDialog gd = new GenericDialog("Image Info (Group 5)");
        gd.addMessage("Title: " + imp.getTitle());
        gd.addMessage("Size: " + imp.getWidth() + " x " + imp.getHeight() + " pixels");
        gd.addMessage("Bit depth: " + imp.getBitDepth());
        gd.addCheckbox("Also print to Log window", true);
        gd.showDialog();
        if (gd.wasCanceled()) return;
        if (gd.getNextBoolean()) {
            IJ.log(imp.getTitle() + ": " + imp.getWidth() + "x" + imp.getHeight()
                   + ", " + imp.getBitDepth() + "-bit");
        }
    }
}
