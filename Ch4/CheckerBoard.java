/*
 * File: Checkerboard.java
 * -----------------------
 * This program draws a checkerboard.
 */
import java.awt.Color;

import acm.graphics.*;
import acm.program.*;
/*
 * This class draws a checkerboard on the graphics window.
 * The size of the checkerboard is specified by the
 * constants NROWS and NCOLUMNS, and the checkboard fills
 * the vertical space available.
 */
public class CheckerBoard extends GraphicsProgram {
 /* Number of rows */
	private static final int NROWS = 8;
 /* Number of columns */
	private static final int NCOLUMNS = 8;
/* size of checkers */
	private static final int CHECKERS_SIZE = 40;

 /* Runs the program */
	public void run() {
//divide the screen vertically into rows specificed by constant
		int sqSize = getHeight() / NROWS;
//set loop to fill next row when all columns are complete
		for (int i = 0; i < NROWS; i++) {
//set loop to make each column
			for (int j = 0; j < NCOLUMNS; j++) {
//sets x and y to start each column and row, also centers entire board by calculating
//board size subtracted from the screen width and halving the difference
				int x = (j * sqSize) + ((getWidth() - (sqSize * NROWS)) / 2);
				int y = i * sqSize;
//creates square object based on loop count
				GRect sq = new GRect(x, y, sqSize, sqSize);
//fills square if it is an even number on the column loop
				sq.setFillColor(Color.GRAY);
				sq.setFilled(((i + j) % 2) != 0);
//outputs square to screen
				add(sq);
//if on the first through third row, fill in even square with red checkers
				if ((i < 3) && ((i + j) % 2) != 0){
					GOval redChecker = new GOval (x + (sqSize - CHECKERS_SIZE) / 2, y + (sqSize - CHECKERS_SIZE) / 2, CHECKERS_SIZE, CHECKERS_SIZE);
					redChecker.setFilled(true);
					redChecker.setFillColor(Color.RED);
					add(redChecker);
				}
//if on the sixth through eigth row, fill in even square with black checkers
				if ((i > 4) & ((i + j) % 2) != 0) {
					GOval blackChecker = new GOval (x + (sqSize - CHECKERS_SIZE) / 2, y + (sqSize - CHECKERS_SIZE) / 2, CHECKERS_SIZE, CHECKERS_SIZE);
					blackChecker.setFilled(true);
					blackChecker.setFillColor(Color.BLACK);
					add(blackChecker);
				}
			}
		}
	}
}
