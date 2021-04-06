package hw05;

import java.applet.*;
import java.awt.*;
import java.util.*;

/*
 * Written by Christopher Walls.
 */
public class homework05 extends Applet {
	private Image display;//Window
	private Graphics drawingArea;//Drawing tools
	public static final int PIXEL_LIMIT = 4;//How many per triangle
	
	public void init() {
		setSize(640,640);
		int height = getSize().height;
		int width = getSize().width;
		display = createImage(width,height);//Creates the window
		drawingArea = display.getGraphics();
		Point pointA = new Point(0, height);
		Point pointB = new Point(height, height);
		Point pointC = new Point(width/2, 0);
		drawTriangle(drawingArea);
		drawGasket(width, pointA, pointB, pointC, drawingArea);
	}
	public void paint(Graphics g) {
		g.drawImage(display,0,0,null);
	}
	//Origin is topleft of image
	public static void drawGasket(int side, Point pointA, Point pointB, Point pointC, Graphics g) {
		int sub = side/3;
		Color white = new Color(255, 255, 255);
		//g.setColor(white);
		if(sub>=PIXEL_LIMIT) {
			Point midpointAB = getMidpoint(pointA, pointB);
			Point midpointBC = getMidpoint(pointB, pointC);
			Point midpointCA = getMidpoint(pointC, pointA);
			
			int[] xPoints = new int[] {midpointAB.x, midpointBC.x, midpointCA.x };
			int[] yPoints = new int[] {midpointAB.y, midpointBC.y, midpointCA.y };
			Polygon tri = new Polygon(xPoints, yPoints, 3);
			g.setColor(white);
			g.fillPolygon(tri);
			drawGasket(sub-1, pointA, midpointAB, midpointCA, g);
			drawGasket(sub-1, pointB, midpointBC, midpointAB, g);
			drawGasket(sub-1, pointC, midpointCA, midpointBC, g);
		}
	}
	public void drawTriangle(Graphics g) {
		int size = getSize().width;
		Color black = new Color(0, 0, 0);
		g.setColor(black);
		int[] xPoints = new int[] {0, size, size/2 };
		int[] yPoints = new int[] {size, size, 0 };
		Polygon tri = new Polygon(xPoints, yPoints, 3);
		g.fillPolygon(tri);
	}
	public static Point getMidpoint(Point a, Point b) {
		return new Point((a.x +b.x)/2, (a.y + b.y)/2);
	}
}	
