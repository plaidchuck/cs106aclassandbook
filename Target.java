/*
 * File: Target.java
 * -----------------
 * Suppose that you’ve been hired to produce a program that draws an image of an
 * archery target.
 */

//imports library for graphics and color

import acm.graphics.*;
import acm.program.*;
import java.awt.*;


public class Target extends GraphicsProgram {	
	//constants for radius of each circle
	private static final int OUTER_RADIUS = 72;
	private static final int WHITE_RADIUS = 46;
	private static final int INNER_RADIUS = 22;
	
//sends centered screen position to each circle
	public void run() {
		drawOuterCircle(getWidth() / 2.0, getHeight() / 2.0);
		drawWhiteCircle(getWidth() / 2.0, getHeight() / 2.0);
		drawInnerCircle(getWidth() / 2.0, getHeight() / 2.0);
	}
	
	
//Methods that draw each circle, subtracting the radius to further center
//the circle and doubling the radius to make the circles bigger
	private void drawOuterCircle(double cx, double cy) {
		GOval outer = new GOval(cx - OUTER_RADIUS, cy - OUTER_RADIUS, OUTER_RADIUS * 2, OUTER_RADIUS * 2);
		outer.setColor(Color.RED);
		outer.setFilled(true);
		outer.setFillColor(Color.RED);
		add(outer);
	}
	
	private void drawWhiteCircle(double cx, double cy) {
		GOval white = new GOval (cx - WHITE_RADIUS, cy - WHITE_RADIUS, WHITE_RADIUS * 2, WHITE_RADIUS * 2);
		white.setColor(Color.WHITE);
		white.setFilled(true);
		white.setFillColor(Color.WHITE);
		add(white);
	}
	
	private void drawInnerCircle(double cx, double cy) {
		GOval inner = new GOval (cx - INNER_RADIUS, cy - INNER_RADIUS, INNER_RADIUS * 2, INNER_RADIUS * 2);
		inner.setColor(Color.RED);
		inner.setFilled(true);
		inner.setFillColor(Color.RED);
		add(inner);
	}
}
