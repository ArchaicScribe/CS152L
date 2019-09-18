import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

/**
 * @version 2019-08-26
 * @author Alex Rauenzahn
 */



public class AsciiArt {

  /* *
   * Prints my name in ASCII Art to the console .
   * @param args Command - line arguments are ignored .
   */
  public static void main(String[] args) {

    int width = 125;//Declaring and initializing the width
    int height = 40;//Declaring and initializing the height
    BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    /*Using BufferedImage class to manipulate the image data.
    Taking the before mentioned width and height, along with
    the the 4 bytes for color with @TYPE_INT_RGB, the code produces the image.
    */
    Graphics graphics = image.getGraphics();
    Graphics2D graphics2D = (Graphics2D) graphics;
    graphics2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
        RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
    graphics2D.drawString("Alex", 12, 24);
/*
Utilizing the graphics class, we grab the image {@link image.getGraphics()} and setRenderingHints. This class will control the rendering quality of the image. We then use the code to have the string 'Alex' be produced and set the x and y coordinates of where on the screen the image will be produced.
 */
    for (int y = 0; y < height; y++) {
      StringBuilder sb = new StringBuilder();
      for (int x = 0; x < width; x++) {

        sb.append(image.getRGB(x, y) == -16777216 ? " " : "/");

      }
/*
We then use the for loop to construct the image and append it. Using the value of '-16777216' it would produce color for the image or blank or '/' instead. When the program is run, it produces this for the name 'Alex'.
 */
      if (sb.toString().trim().isEmpty()) {
        continue;
      }

      System.out.println(sb);
    }
  }
}