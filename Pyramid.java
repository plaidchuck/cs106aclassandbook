/*
 * File: Pyramid.java
 * Name: 
 * Section Leader: 
 * ------------------
 * This file is the starter file for the Pyramid problem.
 * It includes definitions of the constants that match the
 * sample run in the assignment, but you should make sure
 * that changing these values causes the generated display
 * to change accordingly.
 */

//imports graphics library
import java.awt.Color;

import acm.graphics.*;
import acm.program.*;
import acm.util.*;


//extends graphical output
public class Pyramid extends GraphicsProgram {

//constants for the size of the bricks and how many in the base
/** Width of each brick in pixels */
	private static final int BRICK_WIDTH = 30;

/** Width of each brick in pixels */
	private static final int BRICK_HEIGHT = 12;

/** Number of bricks in the base of the pyramid */
	private static final int BRICKS_IN_BASE = 14;
	
public void run() {
	System.out.println(getHeight());
//used to decrement the amount of bricks per row
	int bricksLeft = BRICKS_IN_BASE;
//used to set starting x coordinate for left most brick in row so base is centered on screen
	double startingX = getWidth() / 2 - (BRICK_WIDTH * BRICKS_IN_BASE) / 2;
//used to set starting y coordinate for centering brick based on its height
	double startingY = (getHeight() + (BRICK_HEIGHT * BRICKS_IN_BASE)) / 2;
//draw new row up to the decrementing amount of bricks
	for (int row = 0; row < BRICKS_IN_BASE; row++) {
//draw bricks up to the number of bricks in the base which is 14
		for (int col = 0; col < bricksLeft; col++) {
//sets brick coordinates and dimensions
			GRect brick = new GRect(startingX + (BRICK_WIDTH * col), startingY - (row * BRICK_HEIGHT), BRICK_WIDTH, BRICK_HEIGHT);
//System.out.println(startingX - (BRICK_WIDTH * col));
			//draws brick to screen
			brick.setFilled(true);
			brick.setFillColor(rgen.nextColor());
			brick.setColor(Color.BLACK);
			add(brick);
			}
//after each row, decrement amount of bricks for next row
		bricksLeft--;
//center the new row based on the new width of the total row from removing a brick
		startingX = getWidth() / 2 - (BRICK_WIDTH * bricksLeft) / 2;
		}
	}		

private RandomGenerator rgen = RandomGenerator.getInstance();
}
