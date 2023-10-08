/*
 * A file to animate PacMan as a GArc munching across the screen.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class PacMan extends GraphicsProgram {

/*
 * Constants for PacMan's size as a GArc, movement speed, and animation delay
 */
private static final double PAC_DIAM = 80;
private static final double SPEED = 10;
private static final int DELAY = 50;

	public void run() {
		createPacMan();
	}
/*
 * Create PacMan object as a filled yellow GArc with 90 degree open mouth,
 * calculate by the start angle being 45 degrees and the sweep angle being 270
 * degrees.
 */
	private void createPacMan() {	
	//Set Variables for centering PacMan on canvas
		double startX = 0;
		double startY = (getHeight() - PAC_DIAM) / 2;
			
	//Offsets to start and sweep angles to close PacMans mouth
		double startAngle = 45;
		double sweepAngle = 270;
		
		setBackground(Color.BLACK);
		
		GArc pacMan = new GArc(PAC_DIAM, PAC_DIAM, startAngle , sweepAngle);
		pacMan.setFilled(true);
		pacMan.setColor(Color.BLACK);
		pacMan.setFillColor(Color.YELLOW);
		add (pacMan, startX, startY);
			while (pacMan.getX() < getWidth()) {
				for (int i = 0; i < 4; i++) {
					startAngle = 45;
					sweepAngle = 270;
					pacMan.setStartAngle(startAngle - (i * 15));
					pacMan.setSweepAngle(sweepAngle + (i * 30));
					pacMan.move(SPEED, 0);
					pause(DELAY);
				}
				
				for (int i = 0; i < 4; i++) {
					startAngle = 0;
					sweepAngle = 360;
					pacMan.setStartAngle(startAngle + (i * 15));
					pacMan.setSweepAngle(sweepAngle - (i * 30));
					pacMan.move(SPEED, 0);
					pause(DELAY);
				} 
			}
	
	}
}
