/*
 * Program to draw  a traditional stop light
 */
import acm.program.*;
import acm.graphics.*;
import java.awt.*;

public class DrawStopLight extends GraphicsProgram{

//class variables for width and height of light box, and radius of each light
private static final double FRAME_WIDTH = 100;
private static final double FRAME_HEIGHT = 200;
private static final double LAMP_RADIUS = 20;
	
	public void run() {
//variables for center of screen
		double cx = getWidth() / 2;
		double cy = getHeight() / 2;
//variables to center the light frame on screen
		double fx = cx - FRAME_WIDTH / 2;
		double fy = cy - FRAME_HEIGHT / 2;
//variable to place top and bottom lamp at an even distance from center lamp
//by dividing light into quarters and placing the lamps on each division
		double dy = FRAME_HEIGHT / 4 + LAMP_RADIUS / 2;
//draws frame to screen and then adds lamps
		add(createFilledRect(fx, fy, FRAME_WIDTH, FRAME_HEIGHT, Color.DARK_GRAY));
		add(createFilledCircle(cx, cy - dy, LAMP_RADIUS, Color.RED));
		add(createFilledCircle(cx, cy, LAMP_RADIUS, Color.YELLOW));
		add(createFilledCircle(cx, cy + dy, LAMP_RADIUS, Color.GREEN));
		

 	}
	
	/*
	 * Creates GRect object centered by x, y, and frame constants and
	 * filled with the specified color
	 * 
	 */
	private GRect createFilledRect(double x, double y, double fw, double fh, Color color) {
		GRect frame = new GRect(x, y, fw, fh);
		frame.setColor(color);
		frame.setFilled(true);
		return frame;
	}
	
	/*
	 * Creates GOval object centered at x, y, and radius constant
	 * Also fills based on specified color
	 */
	private GOval createFilledCircle(double x, double y, double r, Color color) {
		GOval circle = new GOval (x - r, y - r,  r * 2, r * 2);
		circle.setColor(color);
		circle.setFilled(true);
		return circle;
	}

}
