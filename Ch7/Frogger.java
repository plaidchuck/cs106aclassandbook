import acm.graphics.*;
import acm.program.*;
import java.awt.event.*;

/*
 * Simple program to simulate a basic "Frogger" game that only moves within
 * defined grid squares on the canvas based on the x/y distance of the mouse click
 * to the frogger's image center
 */

public class Frogger extends GraphicsProgram {

/*
 * Constants to define size of the grid squares and the number of columns and rows
 * that the canvas is divided into. Application height is a magic number to make my
 * local "frog.jpg" fit nicely within all grid squares on the canvas.
 */
private static final int SQSIZE = 75;
private static final int NCOLS = 7;
private static final int NROWS = 3;
public static final int APPLICATION_WIDTH = NCOLS * SQSIZE;
public static final int APPLICATION_HEIGHT = 245;

	
	public void run() {
		addMouseListeners();		
		placeFrog();	
		
	}
	
/*
 * Creates frog image and places it in on canvas in bottom center grid square
 * on the canvas. Set variables to define center of frog image.
 */
	private void placeFrog() {
		frog = new GImage("frog.jpg");
		fx = (NCOLS / 2 + 0.5) * SQSIZE;
		fy = (NROWS - 0.5) * SQSIZE;
		add(frog, fx - frog.getWidth() / 2, fy - frog.getHeight() / 2);
	}
	
/*
 * When mouse is clicked, first determine whether absolute x or y distance from
 * frog center is larger. Then move frog one grid square in the x or y direction as long
 * as the new frog position won't move it outside of the canvas borders. 
 * 
 */
	public void mouseClicked(MouseEvent e) {
		double mx = e.getX(); // X location mouse click
		double my = e.getY(); // Y location mouse click
		if (Math.abs(mx - fx) > Math.abs(my - fy)) {
			if (mx < fx && fx + -SQSIZE > 0) {
				frog.move(-SQSIZE, 0);
				fx += -SQSIZE;	
			}
			
			else if (mx > fx && fx + SQSIZE < APPLICATION_WIDTH) {
				frog.move(SQSIZE, 0);
				fx += SQSIZE;	
				}
			
		} else {
			
			if (my < fy && fy + -SQSIZE > 0) {
				frog.move(0, -SQSIZE);
				fy += -SQSIZE;
			}
			else if (my > fy && fy + SQSIZE < APPLICATION_HEIGHT) {
				frog.move(0, SQSIZE);
				fy += SQSIZE;
			}
		}
		
		
	}
	
	
private GImage frog; // Frog image object
private double fx; // X center of Frog
private double fy; // Y center of Frog
}
