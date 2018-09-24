import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;


/**
 * Source: http://www.java2s.com/Tutorials/Java/Graphics_How_to/Image/Create_BMP_format_image.htm
 */
public class Main {
    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        BufferedImage map = map(1920, 1080);
        savePNG(map, "~/image");
    }

    private static BufferedImage map(int sizeX, int sizeY ){
        final BufferedImage res = new BufferedImage( sizeX, sizeY, BufferedImage.TYPE_INT_RGB );
        for (int x = 0; x < sizeX; x++){
            for (int y = 0; y < sizeY; y++){
                res.setRGB(x, y, getColor(x, y).getRGB());
            }
        }
        return res;
    }

    private static Color getColor(int x, int y) {
        if (y % 2 == 0) {
            return ((x % 2 == 0) ? Color.BLACK : Color.RED);
        } else {
            return ((x % 2 == 0) ? Color.BLUE : Color.GREEN);
        }
    }

    private static void savePNG( final BufferedImage bi, final String path ){
        try {
            RenderedImage rendImage = bi;
            ImageIO.write(rendImage, "bmp", new File(path));
            //ImageIO.write(rendImage, "PNG", new File(path));
            //ImageIO.write(rendImage, "jpeg", new File(path));
        } catch ( IOException e) {
            e.printStackTrace();
        }
    }
}
