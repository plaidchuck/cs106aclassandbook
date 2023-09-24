/*
 * A program that simulates the output of the stroop test by
 * displaying GLabel color names in random locations on the canvass
 * with the color names being any random color except the actual color name
 */

import acm.program.*;
import acm.graphics.*;
import java.awt.*;
import acm.util.*;

public class StroopTest extends GraphicsProgram{

private static final String FONT = "Arial-24";
	
//Sends each color name string to be added to the canvas
	public void run() {
		addLabelToCanvas(red);
		addLabelToCanvas(orange);
		addLabelToCanvas(yellow);
		addLabelToCanvas(green);
		addLabelToCanvas(cyan);
		addLabelToCanvas(blue);
		addLabelToCanvas(magenta);
	}

/*
 * Adds the GLabel to a random location on the canvas and randomizes
 * its color
 */
private void addLabelToCanvas(String colorName) {
		GLabel color = new GLabel(colorName);
		color.setFont(FONT);
		double colorX = (rgen.nextDouble(color.getWidth(), getWidth()) - color.getWidth());
		double colorY = (rgen.nextDouble(color.getAscent() * 2, getHeight()) - color.getAscent());
		add(setColor(color, colorName), colorX, colorY);
}

/*
 * Sets a color for the GLabel and then checks to make sure that
 * the GLabel name and color of the GLabel are never the same.
 * Then returns the GLabel.
 */
private GLabel setColor(GLabel colorLabel, String colorName) {
	colorLabel.setColor(chooseColor());
	if (colorName.equals("RED")) {
		while (colorLabel.getColor() == Color.RED) {
			colorLabel.setColor(chooseColor());
		}
	}
	if (colorName.equals("ORANGE")) {
		while (colorLabel.getColor() == Color.ORANGE) {
			colorLabel.setColor(chooseColor());
		}
	}
	if (colorName.equals("YELLOW")) {
		while (colorLabel.getColor() == Color.YELLOW) {
			colorLabel.setColor(chooseColor());
		}
	}
	if (colorName.equals("GREEN")) {
		while (colorLabel.getColor() == Color.GREEN) {
			colorLabel.setColor(chooseColor());
		}
	}
	if (colorName.equals("CYAN")) {
		while (colorLabel.getColor() == Color.CYAN) {
			colorLabel.setColor(chooseColor());
		}
	}
	if (colorName.equals("BLUE")) {
		while (colorLabel.getColor() == Color.BLUE) {
			colorLabel.setColor(chooseColor());
		}
	}
	if (colorName.equals("MAGENTA")) {
		while (colorLabel.getColor() == Color.MAGENTA) {
			colorLabel.setColor(chooseColor());
		}
	}
	return colorLabel;
}

/*
 * Generates an integer from 1 to 7 and returns the corresponding color
 */
private Color chooseColor() {
	int num = rgen.nextInt(1, 7);
	switch(num) {
	case 1: return Color.RED;
	case 2: return Color.ORANGE;
	case 3: return Color.YELLOW;
	case 4: return Color.GREEN;
	case 5: return Color.CYAN;
	case 6: return Color.BLUE;
	case 7: return Color.MAGENTA;
	default: return Color.BLACK;
	}
}
//private instance variables of each color name string
String red = "RED";
String orange = "ORANGE";
String yellow = "YELLOW";
String green = "GREEN";
String cyan = "CYAN";
String blue = "BLUE";
String magenta = "MAGENTA";

//to randomize the colors of the GLabel objects
RandomGenerator rgen = RandomGenerator.getInstance();
}
