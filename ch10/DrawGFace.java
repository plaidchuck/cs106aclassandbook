
import java.awt.event.MouseEvent;

import acm.program.*;
import acm.graphics.*;

public class DrawGFace extends GraphicsProgram {
	
	public void init() {
		face = new GFace(300, 350);
		add(face, (getWidth() - face.getWidth()) / 2, (getHeight() - face.getHeight()) / 2);
		addMouseListeners();
	}
	
	public void mouseMoved(MouseEvent e) {
		// sends x and y coords as GPoint and converts them to match with the GCompound canvas
		face.movePupils(face.getLocalPoint(e.getX(), e.getY()));
	}
	
	private GFace face;
}

	class GFace extends GCompound {

		public GFace(double width, double height) {
	
		head = new GOval(width, height);
		leftEye = new GOval(EYE_WIDTH * width, EYE_HEIGHT * height);
		rightEye = new GOval(EYE_WIDTH * width, EYE_HEIGHT * height);
		leftPupil = new GOval(PUPIL_WIDTH * width, PUPIL_HEIGHT * height);
		rightPupil = new GOval(PUPIL_WIDTH * width, PUPIL_HEIGHT * height);
		nose = createNose(NOSE_WIDTH * width, NOSE_HEIGHT * height);
		mouth = new GRect(MOUTH_WIDTH * width, MOUTH_HEIGHT * height);
		leftPupil.setFilled(true);
		rightPupil.setFilled(true);
		add(head, 0, 0);
		add(leftEye, 0.25 * width - EYE_WIDTH * width / 2,
				 0.25 * height - EYE_HEIGHT * height / 2);
		add(rightEye, 0.75 * width - EYE_WIDTH * width / 2,
				  0.25 * height - EYE_HEIGHT* height / 2);
		add(leftPupil, 0.25 * width - PUPIL_WIDTH * width / 2,
				 0.25 * height - PUPIL_HEIGHT * height / 2);
		add(rightPupil, .75 * width - PUPIL_WIDTH * width / 2,
				  0.25 * height - PUPIL_HEIGHT * height / 2);
		add(nose, 0.50 * width, 0.50 * height);
		add(mouth, 0.50 * width - MOUTH_WIDTH * width / 2,
				   0.75 * height - MOUTH_HEIGHT * height / 2);
	}

//Create triangle for the nose
	private GPolygon createNose(double width, double height) {
		GPolygon poly = new GPolygon();
		poly.addVertex(0, -height / 2);
		poly.addVertex(width / 2, height / 2);
		poly.addVertex(-width / 2, height / 2);
		return poly;
	}
	
	public void movePupils(GPoint mouse) {
		double leftEyeCenterX = leftEye.getX() + leftEye.getWidth() / 2;
		double leftEyeCenterY = leftEye.getY() + leftEye.getHeight() / 2;
		double rightEyeCenterX = rightEye.getX() + rightEye.getWidth() / 2;
		double rightEyeCenterY = rightEye.getY() + rightEye.getHeight() / 2;
		updatePupil(leftPupil, leftEyeCenterX, leftEyeCenterY, mouse.getX(), mouse.getY());
		updatePupil(rightPupil, rightEyeCenterX, rightEyeCenterY, mouse.getX(), mouse.getY());
	}
	
	private void updatePupil(GOval pupil, double eyeCenterX, double eyeCenterY, double mouseX, double mouseY) {
		double distX = mouseX - eyeCenterX;
        double distY = mouseY - eyeCenterY;
        double radiusEye = leftEye.getWidth() / 2;
        double radiusPupil = leftPupil.getWidth() / 2;
        double maxDistance = radiusEye - radiusPupil;
        double angle = GMath.angle(distX, distY);
        double pupilX = (int)(eyeCenterX + (GMath.cosDegrees(angle) * maxDistance) - radiusPupil);
		double pupilY = (int)(eyeCenterY + 
				(-GMath.sinDegrees(angle) * maxDistance) - radiusPupil);
        pupil.setLocation(pupilX, pupilY);
	}
	
//Constants of each feature size based on overall head size
private static final double EYE_WIDTH = 0.15;
private static final double EYE_HEIGHT = 0.15;
private static final double PUPIL_WIDTH = 0.03;
private static final double PUPIL_HEIGHT = 0.03;
private static final double NOSE_WIDTH = 0.15;
private static final double NOSE_HEIGHT = 0.10;
private static final double MOUTH_WIDTH = 0.50;
private static final double MOUTH_HEIGHT = 0.03;

// instance variables
private GOval head;
private GPolygon nose;
private GRect mouth;
private GOval leftEye, rightEye;
private GOval leftPupil, rightPupil;
}
	


	

