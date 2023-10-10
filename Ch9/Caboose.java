/*
 * Subclass of the Traincar class that adds a caboose to the
 * Train GCompound.
 */


import acm.graphics.*;
import java.awt.*;

/**
 * Class that represents a caboose. Graphical object to be
 * added to GCanvas as a GCompound in the Train class.
 */

public class Caboose extends Traincar {

	/**
	 * Creates a new red caboose with cupola.
	 */
		
	public Caboose() {
		super(Color.RED);
		drawCupola();
	}
	
/*
 * Helper method that centers and draws cupola on top
 * of the caboose.
 */
	private void drawCupola() {
		double xCupola = CONNECTOR + ((CAR_WIDTH - CUPOLA_WIDTH) / 2);
		double yCupola = (-CAR_BASELINE - CAR_HEIGHT) - CUPOLA_HEIGHT;
		GRect cupola = new GRect(xCupola, yCupola, CUPOLA_WIDTH, CUPOLA_HEIGHT);
		cupola.setFilled(true);
		cupola.setFillColor(Color.RED);
		cupola.setColor(Color.BLACK);
		add(cupola);
	}
	
//Dimensions of the cupola
private static final double CUPOLA_WIDTH = 35;
private static final double CUPOLA_HEIGHT = 8;
}
