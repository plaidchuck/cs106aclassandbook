/*A Program to make a grid of black boxes with slight space in between
 * to generate an effect of there being grey boxes on the corner of each box.
 */
import acm.program.*;
import acm.graphics.*;

public class BoxesIllusion extends GraphicsProgram {
//sets constants for total number of columns, rows. Also set constant for
//the size of each box and space between and above each one
	private static final int NUM_ROWS = 5;
    private static final int NUM_COLS = 6;
    private static final double BOX_SIZE = 40;
    private static final double BOX_SPACING = 10;

    public void run() {
/* declare a variable for the entire width and height of the grid by
 * subtracting the box spacing size from the product of the number of columns/rows
 * and the total of the box size and spacing.
 */
    	double totalWidth = NUM_COLS * (BOX_SIZE + BOX_SPACING) - BOX_SPACING;
        double totalHeight = NUM_ROWS * (BOX_SIZE + BOX_SPACING) - BOX_SPACING;

 /* Set variables for the x and y coordinates of each row by halving the difference of
  * the total grid width/height from the total screen width/height
  */
        double xOffset = (getWidth() - totalWidth) / 2;
        double yOffset = (getHeight() - totalHeight) / 2;

//sets loop to make the next higher row based on the constant variable
        for (int j = 0; j < NUM_ROWS; j++) {
//sets loop to make the next box in the column based on the constant variable
            for (int i = 0; i < NUM_COLS; i++) {
//set x coordinate variable for each box based on column constant
            	double x = xOffset + i * (BOX_SIZE + BOX_SPACING);
//set y coordinate for each box in the row based on the row constant
                double y = yOffset + j * (BOX_SIZE + BOX_SPACING);
//defines square object using previous variables for coordinates
                GRect square = new GRect(x, y, BOX_SIZE, BOX_SIZE);
//fill the square
                square.setFilled(true);
//add square to screen
                add(square);
            }
        }
    }
//constants to set the size of initial application window
    public static final int APPLICATION_WIDTH = 350;
    public static final int APPLICATION_HEIGHT = 300;
}
