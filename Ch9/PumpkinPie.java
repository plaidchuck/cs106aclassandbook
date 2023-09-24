/*
 * A graphic to draw a relatively equally sliced pie
 */

import acm.program.*;
import acm.graphics.*;
import java.awt.*;

public class PumpkinPie extends GraphicsProgram {
	public void run() {
/*
 * set variables to center image, set radius, and divide a circle by
 * the number of slices
 */

		double cx = getWidth() / 2;
		double cy = getHeight() / 2;
		double r = 100;
		int angle = CIRCLE / N_PIECES;
		makeSlice(cx, cy, r, angle);
	}
	
/*
 * Draw each piece as a GArc by the number of pieces, with the start of each 
 * GArc being multiplied by the index variable
 */
	private void makeSlice(double cx, double cy, double r, int angle) {
		for (int i = 0; i < N_PIECES; i++) {
		GArc slice = new GArc(cx - r, cy - r, 2 * r, 2 * r, i * angle, angle);
		slice.setFilled(true);
		slice.setColor(Color.BLACK);
		slice.setFillColor(PIE_COLOR);
		add(slice);
		}
	}

//Constants for number of slices, color of slice, degrees in a circle
private static final int N_PIECES = 6;
private static final Color PIE_COLOR = Color.ORANGE;
private static final int CIRCLE = 360;
}
