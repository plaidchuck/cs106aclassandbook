/*
 * Subclass of the Traincar class that adds the engine to the
 * Train GCompound.
 */

import acm.graphics.*;
import java.awt.*;

/**
 * Class that represents a train engine. Graphical object to be
 * added to GCanvas as a GCompound in the Train class.
 */

public class Engine extends Traincar {
	
	/**
	 * Creates a new black train engine.
	 */
	
	public Engine() {
		super(Color.BLACK);
		drawCowCatcher();
		drawSmokestack();
		drawCab();
	}
	
/*
 * Helper method that draws the cow catcher on the front of the
 * engine.
 */

	private void drawCowCatcher() {
		add(new GLine(0, -CAR_BASELINE, CONNECTOR, -CAR_BASELINE - CAR_HEIGHT / 2 ));
		add(new GLine(CONNECTOR / 2, -CAR_BASELINE, CONNECTOR, -CAR_BASELINE - CAR_HEIGHT / 2 ));
	}

/*
 * Helper method that draws the smokestack.
 */
	private void drawSmokestack() {
		GRect smokestack = new GRect(SMOKESTACK_WIDTH, SMOKESTACK_HEIGHT);
		smokestack.setFilled(true);
		add(smokestack, CONNECTOR + SMOKESTACK_INSET, (-CAR_BASELINE - CAR_HEIGHT) - SMOKESTACK_HEIGHT);
	}
	
/*
 * Helper method that draws the engine cab.
 */
	private void drawCab() {
		GRect cab = new GRect(CAB_WIDTH, CAB_HEIGHT);
		cab.setFilled(true);
		add(cab, CONNECTOR + (CAR_WIDTH - CAB_WIDTH), (-CAR_BASELINE - CAR_HEIGHT) - CAB_HEIGHT);
	}
	
//dimensions of the cab on the engine
private static final double CAB_WIDTH = 35;
private static final double CAB_HEIGHT = 8;
	
//dimensions of the smokestack and its distance from the front
private static final double SMOKESTACK_WIDTH = 8;
private static final double SMOKESTACK_HEIGHT = 8;
private static final double SMOKESTACK_INSET = 8;


}
