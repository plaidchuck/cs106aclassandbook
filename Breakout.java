/*
 * File: Breakout.java
 * -------------------
 * Name:
 * Section Leader:
 * 
 * This file will eventually implement the game of Breakout.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Breakout extends GraphicsProgram {

/** Width and height of application window in pixels */
	public static final int APPLICATION_WIDTH = 400;
	public static final int APPLICATION_HEIGHT = 600;

/** Dimensions of game board (usually the same) */
	private static final int WIDTH = APPLICATION_WIDTH;
	private static final int HEIGHT = APPLICATION_HEIGHT;

/** Dimensions of the paddle */
	private static final int PADDLE_WIDTH = 60;
	private static final int PADDLE_HEIGHT = 10;

/** Offset of the paddle up from the bottom */
	private static final int PADDLE_Y_OFFSET = 30;

/** Number of bricks per row */
	private static final int NBRICKS_PER_ROW = 10;

/** Number of rows of bricks */
	private static final int NBRICK_ROWS = 10;

/** Separation between bricks */
	private static final int BRICK_SEP = 4;

/** Width of a brick */
	private static final int BRICK_WIDTH =
	  (WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

/** Height of a brick */
	private static final int BRICK_HEIGHT = 8;

/** Radius of the ball in pixels */
	private static final int BALL_RADIUS = 10;

/** Offset of the top brick row from the top */
	private static final int BRICK_Y_OFFSET = 70;

/** Number of turns */
	private static final int NTURNS = 3;

/** Animaton delay */

	private static final int DELAY = 7;
/* Method: run() */


/** Runs the Breakout program. */
	public void run() {
		addMouseListeners();
		setup();
		startGame();
	}

/*
 * Begin game loop after setup
 */
	private void startGame() {
		makeBall();
		waitForClick();
		while (true) {
			animateBall();
			checkCollision();
			if (ball.getY() > getHeight() - BALL_RADIUS * 2) {
				remove(ball);
				startGame();
			}
		}
	}
	
/*
 * At beginning of game loop, create the ball in the center of the
 * screen and initiate the velocity variables.
 */
	private void makeBall() {
		double startBallX = (getWidth() - BALL_RADIUS * 2) / 2;
		double startBallY = (getHeight() - BALL_RADIUS * 2) / 2;
		vx = rgen.nextDouble(1.0, 4.0);
		vy = 3.0;
		if (rgen.nextBoolean(0.5)) vx = -vx;
		ball = new GOval(startBallX, startBallY, BALL_RADIUS * 2, BALL_RADIUS * 2);
		ball.setFilled(true);
		add(ball);
	}

	/*
	 * Returns the an object the ball collides with or returns null
	 * if none are at the collision points of the ball.
	 */
	
	private GObject getCollidingObject() {
		if (getElementAt(ball.getX(), ball.getY()) != null) {
			return getElementAt(ball.getX(), ball.getY());
		}
		if (getElementAt(ball.getX() + (2 * BALL_RADIUS), ball.getY()) != null) {
			return getElementAt(ball.getX() + (2 * BALL_RADIUS), ball.getY());
		}
		if (getElementAt(ball.getX(), ball.getY() + (2 * BALL_RADIUS)) != null) {
			return getElementAt(ball.getX(), ball.getY() + (2 * BALL_RADIUS));
		}
		
		if (getElementAt(ball.getX() + (2 * BALL_RADIUS), ball.getY() + (2 * BALL_RADIUS)) != null) {
			return getElementAt(ball.getX() + (2 * BALL_RADIUS), ball.getY() + (2 * BALL_RADIUS));
		}
		
		return null;
	}
	
	/*
	 * While ball is animated and loop runs, check points on balls
	 * bounding box and change movement if the points have collided
	 * with another object on screen either than the screen walls.
	 */
	private void checkCollision() {
		GObject collider = getCollidingObject();
		if (collider == paddle) {
	//		bounceClip.play();
			if (ball.getY() >= getHeight() - PADDLE_Y_OFFSET - PADDLE_HEIGHT - BALL_RADIUS*2 && ball.getY() < getHeight() - PADDLE_Y_OFFSET - PADDLE_HEIGHT - BALL_RADIUS*2 + 3) {
				vy = -vy;
				//-Math.abs(vy);
				ball.move(vx, vy);
				pause(DELAY);
			}
		}
			else if (collider != null) {
			remove(collider);
//			bounceClip.play();
			vy = -vy;
			ball.move(vx, vy);
			pause(DELAY);
		}
	}

	
/*
 * Detects if the ball object touches the
 */
	private void animateBall() {
		
		if (ball.getY() < 0 ) {
			vy = -vy;
			ball.move(vx, vy);	
			pause(DELAY);
		
		}
		
		if (ball.getX() < WIDTH - WIDTH ) {
			vx = -vx;
			ball.move(vx, vy);	
			pause(DELAY);
		}
		
		if (ball.getX() > getWidth() - BALL_RADIUS * 2) {
			vx = -vx;
			ball.move(vx, vy);	
			pause(DELAY);
		}
		
		ball.move(vx, vy);
		pause(DELAY);
	}
/*
 * Sets up the program by adding the bricks and paddle
 */
	private void setup() {	
	//	bounceClip = MediaTools.loadAudioClip("bounce.au"); 
		turnsLeft = NTURNS;
		makeBrickRow();
		makePaddle();
	}
	
/*
 * Use two nested for loops to make each row 
 * and column of bricks with the appropriate
 * color.
 */
	
	private void makeBrickRow() {
		double rowWidth = (BRICK_WIDTH + BRICK_SEP) * NBRICKS_PER_ROW;
		double bricksStartX = ((getWidth() - rowWidth) / 2) + 1;
		for (int i = 0; i < NBRICK_ROWS; i++) {
			for (int j = 0; j < NBRICKS_PER_ROW; j++) {
				brick = new GRect(bricksStartX + (j * (BRICK_SEP + BRICK_WIDTH)), BRICK_Y_OFFSET + i * (BRICK_HEIGHT + BRICK_SEP), BRICK_WIDTH, BRICK_HEIGHT);
				brick.setFilled(true);
				brick.setColor(rowColor(i));
				brick.setFillColor(rowColor(i));
				add(brick);
			}
		}
	}
	
	/* 
	 * Helper to get appropriate color of each row based on the
	 * current index number of the row loop.
	 */
	
	private Color rowColor(int rowNumber) {
		if (rowNumber < 2) {
			return Color.RED;
			}
		else if	(rowNumber == 2 || rowNumber == 3) {
			return Color.ORANGE;
			}
		else if (rowNumber == 4 || rowNumber == 5) {
			return Color.YELLOW;
			}
		else if (rowNumber == 6 || rowNumber == 7) {
			return Color.GREEN;
			}
		else if (rowNumber == 8 || rowNumber == 9) {
			return Color.CYAN;
			}
		return null;
		
	}
	
	/*
	 * Creates paddle on screen and waits for mouse listeners to
	 * begin tracking the mouse
	 */
	
	private void makePaddle() {
		double paddleStartX = (getWidth() - PADDLE_WIDTH) / 2;
		double paddleStartY = getHeight() - PADDLE_Y_OFFSET - PADDLE_HEIGHT;
		paddle = new GRect(paddleStartX, paddleStartY, PADDLE_WIDTH, PADDLE_HEIGHT);
		paddle.setFilled(true);
		add(paddle);
		
	}
	
	/*
	 * Have paddle track mouse movement on the x axis while y axis
	 * is fixed. Make sure paddle does not go outside canvas on the right side.
	 * @see acm.program.Program#mouseMoved(java.awt.event.MouseEvent)
	 */
	
	public void mouseMoved(MouseEvent e) {
		double paddleY = getHeight() - PADDLE_Y_OFFSET - PADDLE_HEIGHT;
		double paddleBoundary = getWidth() - PADDLE_WIDTH;
		paddle.setLocation(e.getX(), paddleY);
		if (paddle.getX() > paddleBoundary) {
			paddle.setLocation(paddleBoundary, paddleY);
		}
	}
	
	private GRect brick; // brick GRects to be eliminated by ball
	private GRect paddle; // Paddle to interact with ball
	private AudioClip bounceClip; // for bounce sound on collisions
	
	private GOval ball; // ball to hit bricks and bounce of paddle
	private double vx; //x direction speed of ball
	private double vy; //y direction speed of ball
	
	private int turnsLeft;
	
	/*
	 * Use to randomize ball velocity
	 */
	private RandomGenerator rgen = RandomGenerator.getInstance();
}
