
package Utils;

import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author Acer
 */
public class SysUtils {
    
    public static void SetLogo(JFrame frame) throws MalformedURLException {
        ArrayList<Image> icons = new ArrayList<Image>();
        icons.add(new ImageIcon(new URL("https://i.ibb.co/xKHz85fF/logo-mestok.png")).getImage());
        icons.add(new ImageIcon(new URL("https://d1nhio0ox7pgb.cloudfront.net/_img/o_collection_png/green_dark_grey/512x512/plain/box_open.png")).getImage());

        frame.setIconImages(icons);
    }
}
