import acm.program.*;
import acm.graphics.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SpeedControlBar extends GraphicsProgram {
	
	private static final int BALL_SIZE = 50; // Size of ball in number if pixels.
	private static final int INITIAL_SPEED = 3; // Milliseconds ball will pause between each movement.
	private static final int MIN_SPEED = 1;
	private static final int MAX_SPEED = 30;
	
	public void init() {
		setupGUI();
		setupBall();
		addActionListeners();
	}
	
	public void run() {
		moveBall = false;
		startBall();		
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Start")) {
			moveBall = true;
		}
		else if (e.getActionCommand().equals("Stop")) {
			moveBall = false;
		}
	}
	
	private void startBall() {
		//Sets values for 'dx' and 'dy' to be used for movement.
		int dx = 1;
		int dy = 1;
		while (true) {
			if (moveBall) {
				ball.move(dx, dy);
				int pauseTime = MAX_SPEED - speedSlider.getValue() + MIN_SPEED;
		        pause(pauseTime);
		//Gets values for current x-axis and y-axis coordinates.
				double x = ball.getX();
				double y = ball.getY();
		//Modifies direction of movement depending on which boundary is met.
				if ((x >= (getWidth() - BALL_SIZE)) || (x == 0)) {
					dx = -dx;
					}
				if ((y >= (getHeight() - BALL_SIZE)) || (y == 0)) {
					dy = -dy;
					}
				}
			}
		}
	
	private void setupBall() {
		//Sets the 'startx' and 'starty' as the center winder minus the offset.
		double startx = ((getWidth() / 2) - (BALL_SIZE / 2));
		double starty = ((getHeight() / 2) - (BALL_SIZE / 2));
		//Generates 'ball' that is filled BLACK.
		ball = new GOval (startx, starty, BALL_SIZE, BALL_SIZE);
		ball.setFilled(true);
		ball.setFillColor(Color.BLACK);
		add(ball);
	}
	
	private void setupGUI() {
		add(new JButton("Start"), SOUTH);
		add(new JButton("Stop"), SOUTH);
		speedSlider = new JSlider(MIN_SPEED, MAX_SPEED, INITIAL_SPEED);
		add(new JLabel("Slow  "), SOUTH);
		add(speedSlider, SOUTH);
		add(new JLabel("  Fast"), SOUTH);
	}
	
	private JSlider speedSlider;
	private GOval ball;
	private boolean moveBall;
}
