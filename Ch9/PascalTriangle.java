/* File: PascalTriangle.java
 * -----------------------
 * This program computes rows of Pascal's triangle graphically by using
 * the factorial method to compute the combinations expressed by
 * C(n, k), which is the number of ways of selecting k objects
 * from a set of n distinct objects. Based on the circle radius and
 * spacing between circles, the triangle will fill the screen with
 * as many rows as possible.
 */
import acm.program.*;
import acm.graphics.*;

public class PascalTriangle extends GraphicsProgram {

/* Sets size of circles in triangle */
private static final double CIRCLE_RADIUS = 25;



	public void run() {
		
/* Sets spacing between the circles horizontally and vertically */
		
		double horizontalSpacing = 1.0 * CIRCLE_RADIUS; // Adjust as needed
	    double verticalSpacing = .5 * CIRCLE_RADIUS;  // Adjust as needed
	    
/* Determines the max number of rows in triangle by dividing difference of
 * screen height and circle radius by the sum of the circle
 * diameter and vertical spacing constant
 */
	    int maxRows =  (int) ((getHeight() - CIRCLE_RADIUS) / (2 * CIRCLE_RADIUS + verticalSpacing));

/*
 * Draw each row up to the previously determined max number of rows
 */
	    for (int n = 0; n < maxRows; n++) {
/*
 * Set the width of each row by adding the total number of circles
 * and the amount of horizontal spacing between circles
 */
	        double rowWidth = (n + 1) * (CIRCLE_RADIUS * 2) + n * horizontalSpacing;
/*
 * Set initial x coordinate for row at center of screen
 */
	        double startX = (getWidth() - rowWidth) / 2;
	        
/*
 * Set y coordinate for each row of circles by adding half the radius
 * to the circle diameter plus amount of vertical spacing between circles
 */
	        double circleY = CIRCLE_RADIUS / 2 + n * (2 * CIRCLE_RADIUS + verticalSpacing);

/*
 * Draw circles in each row based on the row number
 */
	        for (int k = 0; k <= n; k++) {
/*
 * Set X coordinate for each circle based on number of circles in row and
 * the amount of horizontal spacing
 */
	            double circleX = startX + k * (CIRCLE_RADIUS * 2 + horizontalSpacing);
	            
// Draw circles based on previous variables
	            add(new GOval(circleX, circleY, CIRCLE_RADIUS * 2, CIRCLE_RADIUS * 2));
// Set GLabel as the value of the combinations method of n, k and set the font
	            GLabel number = new GLabel(String.valueOf(combinations(n, k)));
	            number.setFont("Times New Roman-bold-16");

// Calculate the center of the circle
	            double centerX = circleX + CIRCLE_RADIUS;
	            double centerY = circleY + CIRCLE_RADIUS;

// Calculate the position to center the number within the circle
	            double numberX = centerX - number.getWidth() / 2;
	            double numberY = centerY + number.getAscent() / 2;
// Draw number in circle
	            add(number, numberX, numberY);
	        }
	    }

	}

/*
 * Returns the mathematical combinations function C(n, k),
 * which is the number of ways of selecting k objects
 * from a set of n distinct objects.
 */
	private int combinations(int n, int k) {
		return factorial(n) / (factorial(k) * factorial(n - k));
	}
/*
 * Returns the factorial of n, which is defined as the
 * product of all integers from 1 up to n.
 */
	private int factorial(int n) {
		int result = 1;
		for (int i = 1; i <= n; i++) {
			result *= i;
		}
		return result;
	}

	
}