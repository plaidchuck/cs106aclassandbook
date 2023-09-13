/*
 *   Draws an image of a train on the bottom of the screen which includes
 *   an engine, caboose, and a number of boxcars specified by a constant. 
 */

import acm.program.*;
import acm.graphics.*;
import java.awt.*;
import acm.util.*;

public class DrawTrain extends GraphicsProgram{

//number of boxcars in train
	private static final double NUM_BOXCARS = 1;
	
//Dimensions of frame of train car
	private static final double CAR_WIDTH = 75;
	private static final double CAR_HEIGHT = 36;
	
//Distance from the bottom of a train car to the track below it
	private static final double CAR_BASELINE = 10;
	
//Width of the connector, which overlaps between successive cars
	private static final double CONNECTOR = 6;

//Radius of the wheels on each car
	private static final double WHEEL_RADIUS = 8;

//Distance from the edge of the frame to the center of the wheel
	private static final double WHEEL_INSET = 16;

//dimensions of the cab on the engine
	private static final double CAB_WIDTH = 35;
	private static final double CAB_HEIGHT = 8;

//dimensions of the smokestack and its distance from the front
	private static final double SMOKESTACK_WIDTH = 8;
	private static final double SMOKESTACK_HEIGHT = 8;
	private static final double SMOKESTACK_INSET = 8;

//dimensions of the door panels on the boxcar 
	private static final double DOOR_WIDTH = 18;
	private static final double DOOR_HEIGHT = 32;

//dimensions of the cupola on the caboose
	private static final double CUPOLA_WIDTH = 35;
	private static final double CUPOLA_HEIGHT = 8;

	public void run() {
//calculates width of entire train in order to center on screen
		double trainWidth = (2 + NUM_BOXCARS) * CAR_WIDTH + (NUM_BOXCARS + 3) * CONNECTOR;

//sets center position for entire train with the engine as the first car
		double x = (getWidth() - trainWidth) / 2;
//sets "track" as the bottom of screen
		double y = getHeight();
//sets coordinate to account for connector and the entire car width size
		double dx = CAR_WIDTH + CONNECTOR;
		drawEngine(x, y);
//draw number of boxcars specified by constant, randomizing their color
		for (int i = 1; i <= NUM_BOXCARS; i++) {
			drawBoxCar(x + (i * dx), y, rgen.nextColor());
			}
		drawCaboose(x + (dx * (NUM_BOXCARS + 1)), y);
	}

	private void drawCarFrame(double x, double y, Color color) {
		double x0 = x + CONNECTOR;
		double y0 = y - CAR_BASELINE;
		double top = y0 - CAR_HEIGHT;
		add(new GLine(x, y0, x + CAR_WIDTH + 2 * CONNECTOR, y0));
		drawWheel(x0 + WHEEL_INSET, y - WHEEL_RADIUS);
		drawWheel(x0 + CAR_WIDTH - WHEEL_INSET, y - WHEEL_RADIUS);
		GRect r = new GRect(x0, top, CAR_WIDTH, CAR_HEIGHT);
		r.setFilled(true);
		r.setFillColor(color);
		add(r);
	}
	
	private void drawWheel(double x, double y) {
		double r = WHEEL_RADIUS;
		GOval wheel = new GOval(x - r, y - r, 2 * r, 2 * r);
		wheel.setFilled(true);
		wheel.setFillColor(Color.GRAY);
		add(wheel);
	}
	
	private void drawDoors(double x, double y) {
		double xRight = x + CONNECTOR + CAR_WIDTH / 2;
		double xLeft = xRight - DOOR_WIDTH;
		double yDoor = y - CAR_BASELINE - DOOR_HEIGHT;
		add(new GRect(xRight, yDoor, DOOR_WIDTH, DOOR_HEIGHT));
		add(new GRect(xLeft, yDoor, DOOR_WIDTH, DOOR_HEIGHT));
	}
	
	private void drawBoxCar(double x, double y, Color color) {
		drawCarFrame(x, y, color);
		drawDoors(x, y);
	}
	
	private void drawSmokestack(double x, double y) {
		double y0 = y - CAR_BASELINE;
		double top = y0 - CAR_HEIGHT;
		GRect smoke = new GRect(x + SMOKESTACK_INSET + CONNECTOR, top - SMOKESTACK_HEIGHT, SMOKESTACK_WIDTH, SMOKESTACK_HEIGHT);
		smoke.setFilled(true);
		smoke.setFillColor(Color.BLACK);
		add(smoke);
	}
	
	private void drawCab(double x, double y) {
		double y0 = y - CAR_BASELINE;
		double top = y0 - CAR_HEIGHT;
		GRect cab = new GRect(x + CONNECTOR + (CAR_WIDTH - CAB_WIDTH), top - CAB_HEIGHT, CAB_WIDTH, CAB_HEIGHT);
		cab.setFilled(true);
		cab.setFillColor(Color.BLACK);
		add(cab);
	}
	
	private void drawCowcatcher(double x, double y) {
		double y0 = y - CAR_BASELINE;
		add(new GLine(x, y0, x + CONNECTOR, y0 - (CAR_HEIGHT / 2 )));
		add(new GLine(x + CONNECTOR / 2, y0, x + CONNECTOR, y0 - (CAR_HEIGHT / 2)));
	}
	
	private void drawEngine(double x, double y) {
		drawCarFrame(x, y, Color.BLACK);
		drawSmokestack(x, y);
		drawCab(x, y);
		drawCowcatcher(x, y);
	}
	
	private void drawCupola(double x, double y, Color color) {
		double y0 = y - CAR_BASELINE;
		double top = y0 - CAR_HEIGHT;
		GRect cupola = new GRect(x + CONNECTOR + ((CAR_WIDTH - CUPOLA_WIDTH)) / 2, top - CUPOLA_HEIGHT, CUPOLA_WIDTH, CUPOLA_HEIGHT);
		cupola.setFilled(true);
		cupola.setFillColor(color);
		cupola.setColor(Color.BLACK);
		add(cupola);
	}
	
	private void drawCaboose(double x, double y) {
		drawCarFrame(x, y, Color.RED);
		drawCupola(x, y, Color.RED);
	}
	
//RandomGenerator object to randomize color of boxcar
	private RandomGenerator rgen = new RandomGenerator();
	
}
