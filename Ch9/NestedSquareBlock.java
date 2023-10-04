/*
 * A program to draw a pattern of nested GPolygon objects where every other object
 * rotates 45 degrees and shrinks to fit the dimensions of the previous
 * object.
 */

import java.awt.Color;

import acm.graphics.*;
import acm.program.*;

public class NestedSquareBlock extends GraphicsProgram {

/*
 * Constants to set the pattern size, number of squares,
 * and the factor to resize each square to fit into the
 * previous square. The scale factor is based on the
 * Pythagorean theorem.
 */
    private static final double BASE_SIZE = 200;
    private static final int NUM_SQUARES = 4;
    private static final double SCALE_FACTOR = Math.sqrt(2);

    public void run() {
/*
 * Set variable for the square size based on the defined size constant
 */
        double size = BASE_SIZE;
        for (int i = 0; i < NUM_SQUARES; i++) {
            GPolygon square = createSquare(size);
            if (i % 2 == 0) {
            	square.setFillColor(Color.CYAN);
            } else {
            	square.setFillColor(Color.MAGENTA);
            }
            add(square, getWidth() / 2, getHeight() / 2);
            size /= SCALE_FACTOR; //Resizes each subsequent square
            square.rotate(i * 45); //rotates each subsequent square for pattern
        }
    }

/*
 * A helper method to create a GPolygon based on the size variable
 * around a center reference point as well as set color for border and fill
 */
    private GPolygon createSquare(double size) {
        GPolygon square = new GPolygon();
        square.addVertex(-size / 2, -size / 2);
        square.addVertex(size / 2, -size / 2);
        square.addVertex(size / 2, size / 2);
        square.addVertex(-size / 2, size / 2);
        square.setColor(Color.BLACK);
        square.setFilled(true);
        return square;
    }
}
