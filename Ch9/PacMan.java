/*
 * A file to animate PacMan as a GArc munching across the screen.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class PacMan extends GraphicsProgram {

/*
 * Constants for PacMan's size as a GArc, movement speed, animation delay,
 * and initial starting X position.
 */
private static final int PAC_DIAM = 80;
private static final int SPEED = 10;
private static final int DELAY = 50;
private static final double START_X = 0;



	public void run() {
		
//Canvas color for more contrast with yellow Pacman
		setBackground(Color.BLACK);
		
		drawPacman();

//Moves Pacman far until the object is past the right edge of canvas
			while (pacman.getX() < getWidth()) {
				
/* 
 * Sets two conditional loops based on if the "mouth" is open or closed.
 * In either scenario the start and sweep variables are adjusted to
 * open and close the mouth respectively and Pacman is moved
 * across the screen.
 */
				if (start < 0) {
					start += 15;
					sweep -= 30;
					movePacman();
				}
				
				if (start == 0) {
					while (start > -45) {
					start -= 15;
					sweep += 30;
					movePacman();
					}
				}
			} 
	}

/*
 * Centers Pacman on the screen vertically and places him horizontally
 * and sets the appropriate size based on constants.
 */
	private void drawPacman() {
		double startY = (getHeight() - PAC_DIAM) / 2;
		pacman = new GArc(START_X, startY, PAC_DIAM, PAC_DIAM, start, sweep);
		pacman.setFilled(true);
		pacman.setFillColor(Color.YELLOW);
		add(pacman);
		pause(DELAY);
	}

/*
 * Moves Pacman the number of pixels set by constant. Also sets current start
 * and sweep angle of mouth and then pauses for the time specified by
 * constant.
 */
	private void movePacman() {
		pacman.move(SPEED, 0);
		pacman.setStartAngle(start);
		pacman.setSweepAngle(sweep);
		pause(DELAY);
		
	}
	
// instance variables
	private GArc pacman;
	private int start = -45;		//GArc start angle for Pacman's mouth
	private int sweep = -270;	//GArc sweep angle for Pacman's mouth
}
