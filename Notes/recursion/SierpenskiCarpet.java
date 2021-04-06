/**
 * Auto Generated Java Class.
 */
import java.applet.*;
import java.awt.*;
import java.util.*;

public class SierpenskiCarpet extends Applet{
  private Image display;
  private Graphics drawingArea;
  
  public void init() {
    int height = getSize().height;
    int width = getSize().width;
    display = createImage(width,height);
    drawingArea = display.getGraphics();
    drawGasket(0,0,width,drawingArea);
  }
  public void paint(Graphics g) {
    g.drawImage(display,0,0,null);
  }
  //origin is topleft on computers
  public static final int STOP = 4;
  public static void drawGasket(int x, int y, int side, Graphics g) {
    int sub = side/3;
    g.fillRect(x+sub, y+sub, sub, sub);
    if(sub>=STOP) {
      //top 3 squares
      drawGasket(x,y,sub,g);//top left
      drawGasket(x+sub,y,sub,g);//top middle
      drawGasket(x+sub*2,y,sub,g);//top right
      //middle 2 squares
      drawGasket(x,y+sub,sub,g);//middle left
      drawGasket(x+sub*2,y+sub,sub,g);//middle right
      //bottom 3 squares
      drawGasket(x,y+sub*2,sub,g);//bottom left
      drawGasket(x+sub,y+sub*2,sub,g);//bottom middle
      drawGasket(x+sub*2,y+sub*2,sub,g);//bottom right
    }
  }
  
}
