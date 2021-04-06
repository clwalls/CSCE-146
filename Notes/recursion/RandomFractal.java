/**
 * Auto Generated Java Class.
 */
import java.applet.*;
import java.awt.*;
import java.util.*;

public class RandomFractal extends Applet {
  private Image display;//window and gives frame res
  private Graphics drawingArea;
  
  public void init() {//called by the applet
    int height = getSize().height;
    int width = getSize().width;
    
    display = createImage(width, height);
    drawingArea = display.getGraphics();
    //TODO call random fractal
    randomFractal(0, height/2, width, height/2, drawingArea);
  }
  public void paint(Graphics g) {
    g.drawImage(display, 0, 0, null);
  }
  public static final int STOP = 4;
  public static final int MAX_Y = 12;
  public static void randomFractal(int leftX, int leftY, int rightX, int rightY, Graphics g) {
    if((rightX - leftX)<=STOP) {
      g.drawLine(leftX, leftY, rightX, rightY);
    }
    else {
      int midX = (leftX+rightX)/2;
      int midY = (leftY+rightY)/2;
      Random r = new Random();
      int delta = r.nextInt(MAX_Y);
      midY += delta;
      //left side
      randomFractal(leftX, leftY, midX, midY, g);
      //right side
      randomFractal(midX, midY, rightX, rightY, g);
    }
  }
  
  /* ADD YOUR CODE HERE */
  
}
