/*
 * File: CircleGrid.java
 * An exercise to practice making rows and columns of graphical objects.
 * In this case a grid of circles is made to fill the available space
 * of the canvas based on the radius of the circle. The
 * image is centered.
 * */
 
import acm.graphics.*;
import acm.program.*;
import acm.util.RandomGenerator;

 
public class CircleGrid extends GraphicsProgram { 

private static final double RADIUS = 20;
     
    public void run(){
/* Determine the max number of rows and columns of circles that can fit
 * on the available canvas space
 */
    	int maxRows =  (int) ((getHeight() - RADIUS) / (2 * RADIUS));
    	int maxCols = (int) ((getWidth() - RADIUS) / (2 * RADIUS));

 
    	int circleNum = 0; //set counter to number each circle
 
/*
 * Loop to draw each row based on how many rows fit on the canvas.
 * Set variables to determine the total width and height of each row
 * for centering and the starting x and y coordinates of each circle.
 */
    	for (int i = 0; i < maxRows; i++) {
    		double rowWidth = (maxCols) * (RADIUS * 2);
    		double startX = (getWidth() - rowWidth) / 2;
    		double rowHeight = (maxRows) * (RADIUS * 2);
    		double startY = (getHeight() - rowHeight) / 2;
    		double circleY = startY + i * (2 * RADIUS); 
 /*
  * Loop to draw each circle in the row.
  */
    		for (int j = 0; j < maxCols; j++) {
    			double circleX = startX + j * (RADIUS * 2);
    			GOval circle = new GOval(circleX, circleY, RADIUS * 2, RADIUS * 2);
    			add(circle);
/*
 * Create GLabel to number each circle, make it
 * a random colour, and set variables to center the
 * number in each circle.
 */
    			GLabel number = new GLabel(String.valueOf(circleNum + 1));
    			number.setFont("Arial-bold-16");
    			number.setColor(rgen.nextColor());
    			double centerX = circleX + RADIUS;
	            double centerY = circleY + RADIUS;
	            double numberX = centerX - number.getWidth() / 2;
	            double numberY = centerY + number.getAscent() / 2;
	            add(number, numberX, numberY);
	            circleNum++; //Increment circle number for each drawn circle
    		}
    	}
    }

//Instance variable to generate random colours
private RandomGenerator rgen = RandomGenerator.getInstance();
     
}