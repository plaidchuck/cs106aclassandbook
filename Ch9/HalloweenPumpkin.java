/**
 * A GCompound class that draws a Halloween Pumpkin
 * @author Johnny
 */

import acm.graphics.*;
import java.awt.*;

public class HalloweenPumpkin extends GCompound {

/**
 * Creates the Halloween pumpkin with a defined width and height
 * @param width Width of the pumpkin
 * @param height Height of the pumpkin
 */
	public HalloweenPumpkin(double width, double height) {
		head = new GOval(width, height);
		head.setFilled(true);
		head.setColor(Color.BLACK);
		head.setFillColor(COLOR_PUMPKIN);
		stem = new GRect(STEM_WIDTH * width, STEM_HEIGHT * height);
		stem.setFilled(true);
		stem.setColor(COLOR_STEM);
		leftEye = createEye(EYE_WIDTH * width, EYE_HEIGHT * height);
		rightEye = createEye(EYE_WIDTH * width, EYE_HEIGHT * height);
		nose = createNose(NOSE_WIDTH * width, NOSE_HEIGHT * height);
		mouth = createMouth(MOUTH_WIDTH * width, MOUTH_HEIGHT * height);
		add(head, 0, STEM_HEIGHT * height);
		add(stem, (width - STEM_WIDTH * width) / 2, 0);
		add(leftEye, 0.4 * width - EYE_WIDTH * width / 2,
				 0.4 * height - EYE_HEIGHT * height / 2);
		add(rightEye, .75 * width - EYE_WIDTH * width / 2,
				0.4 * height - EYE_HEIGHT * height / 2);
		add(nose, 0.50 * width, 0.50 * height);
		add(mouth, 0.31 * width - MOUTH_WIDTH * width / 2,
				   0.8 * height - MOUTH_HEIGHT * height / 2);
	}

//Create inverted triangle for the eye
	private GPolygon createEye(double width, double height) {
		GPolygon poly = new GPolygon();
		poly.addVertex(0, height / 2);
		poly.addVertex(-width / 2, -height / 2);
		poly.addVertex(width / 2, -height / 2);
		poly.setFilled(true);
		poly.setColor(COLOR_EYES);
		return poly;
	}

//Create triangle for the nose
	private GPolygon createNose(double width, double height) {
		GPolygon poly = new GPolygon();
		poly.addVertex(0, -height / 2);
		poly.addVertex(width / 2, height / 2);
		poly.addVertex(-width / 2, height / 2);
		poly.setFilled(true);
		poly.setColor(COLOR_NOSE);
		return poly;
	}

//Create mouth polygon
	private GPolygon createMouth(double width, double height) {
		GPolygon poly = new GPolygon();
		poly.addVertex(-width / 2, 0);
		poly.addEdge(width, height);
		poly.addEdge(width / 2, -height / 2);
		poly.addEdge(width / 2, height / 2);
		poly.addEdge(width / 2, -height / 2);
		poly.addEdge(width / 2, height / 2);
		poly.addEdge(width / 2, -height / 2);
		poly.addEdge(width / 2, height / 2);
		poly.addEdge(width, -height);
		poly.addEdge(-width / 2 , -height / 2);
		poly.addEdge(-width / 2, height / 2);
		poly.addEdge(-width / 2, -height / 2);
		poly.addEdge(-width / 2, height / 2);
		poly.addEdge(-width / 2, -height / 2);
		poly.addEdge(-width / 2, height / 2);
		poly.addEdge(-width / 2, -height / 2);
		poly.addEdge(-width / 2, height / 2);
		poly.addEdge(-width / 2, -height / 2);
		poly.setFilled(true);
		poly.setColor(COLOR_MOUTH); 

		return poly;
	}
	
//constants variables for colors and features based on relatve head size
private static final Color COLOR_PUMPKIN = Color.ORANGE;
private static final Color COLOR_EYES = Color.BLACK;
private static final Color COLOR_STEM = Color.BLACK;
private static final Color COLOR_NOSE = Color.BLACK;
private static final Color COLOR_MOUTH = Color.BLACK;
private static final double STEM_WIDTH = .06;
private static final double STEM_HEIGHT = .08;
private static final double EYE_WIDTH = 0.15;
private static final double EYE_HEIGHT = 0.13;
private static final double NOSE_WIDTH = 0.15;
private static final double NOSE_HEIGHT = 0.15;
private static final double MOUTH_WIDTH = 0.13;
private static final double MOUTH_HEIGHT = 0.13;


//instance variables of the features
private GOval head; //head/body of pumpkin
private GRect stem; //stem on top of pumpkin
private GPolygon leftEye, rightEye, nose; // eyes and nose, both triangle shapes
private GPolygon mouth; //mouth in form of slanted rectangles
}
