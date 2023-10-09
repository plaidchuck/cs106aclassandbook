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
		setupCanvas();
		drawPacman();
		animatePacman();
}

/*
 * Sets color of background canvas.
 */
	private void setupCanvas() {
		setBackground(Color.BLACK);
	}

/*
 * Sets variable to center Pacman and adds him to the screen. Pause is used with
 * the delay constant to make sure Pacman starts in the initial open mouth
 * position.
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
 * Moves Pacman across the screen with the open and close mouth animations
 * until his entire object moves past the right edge of the canvas.
 */
	private void animatePacman() {
		while (pacman.getX() < getWidth()) {
			moveMouth();
		}
	}

/*
 * Runs open or close mouth loop to adjust the values of the start and sweep
 * variables for the Pacman GArc object and then calls method to move Pacman
 * while performing mouth animation.
 */
	private void moveMouth() {
		while (start < 0) {
			start += 15;
			sweep -= 30;
			movePacman();
		}
		
		while (start > -45) {
			start -= 15;
			sweep += 30;
			movePacman();
    }

}

/*
 * Moves Pacman object using movement speed constant and changes the
 * start and sweep values before a pause using the animation delay constant.
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
private int sweep = -270;		//GArc sweep angle for Pacman's mouth
}
