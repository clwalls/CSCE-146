package hw05;

import java.applet.*;
import java.awt.*;
import java.util.*;

public class SierpenskiTriangles extends Applet {
	private Image display;//Window
	private Graphics drawingArea;//Drawing tools
	
	public void init() {
		setSize(640,640);
		int height = getSize().height;
		int width = getSize().width;
		display = createImage(width,height);//Creates the window
		drawingArea = display.getGraphics();
		drawGasket(0,0,width,drawingArea);
	}
	public void paint(Graphics g) {
		g.drawImage(display,0,0,null);
	}
	//Origin is topleft of image
	public static final int STOP = 4;
	public static void drawGasket(int x, int y, int side, Graphics g) {
		int sub = side/3;
		//TODO draw HEXAGON
		drawHexagon(x,y,side,g);
		if(sub>=STOP) {
			drawGasket(x+sub,y,sub,g);//top middle
			drawGasket(x,y+sub,sub,g);//middle left
			drawGasket(x+sub*2,y+sub,sub,g);//middle right
			drawGasket(x+sub,y+sub*2,sub,g);//bottom middle
		}
	}
	private static void drawHexagon(int x, int y, int side, Graphics g) {
		int[] xs = {x,
				x+side/4,
				x+side*3/4,
				x+side,
				x+side*3/4,
				x+side/4,
				x};
		int[] ys = {y+side/2,
				y,
				y,
				y+side/2,
				y+side,
				y+side,
				y+side/2};
		g.drawPolygon(xs, ys, xs.length);
	}	
}	
