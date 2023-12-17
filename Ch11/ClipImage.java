import java.awt.Color;
import java.awt.event.MouseEvent;
import acm.program.*;
import acm.graphics.*;

public class ClipImage extends GraphicsProgram {
	
private static final GImage IMAGE = new GImage("derp.jpg");
public static final int APPLICATION_WIDTH = (int) IMAGE.getWidth();
public static final int APPLICATION_HEIGHT = (int) IMAGE.getHeight();

	public void run() {
		add(IMAGE);
		addMouseListeners();	
	}
	
	
	/*
	 * Records initial click coordinate and initializes cropping GRect
	 */
	public void mousePressed(MouseEvent e) {
		square = new GRect(e.getX(), e.getY(), 0, 0);
		last = new GPoint(e.getX(), e.getY());
		square.setColor(Color.WHITE);
	}
	
	/*
	 * Conditions to keep the cropping GRect within the canvas and allow
	 * the GRect to "pivot" on its starting coordinate to increase or decrease its
	 * width and height.
	 */
	public void mouseDragged(MouseEvent e) {
		if (e.getX() < getWidth() && e.getX() > 0 && e.getY() > 0 &&
				e.getY() < getHeight()) {
		square.setBounds(last.getX(), last.getY(), Math.abs(e.getX() - last.getX()), 
				Math.abs(e.getY() - last.getY()));
		
		if (e.getX() < last.getX()) {
			square.setBounds(e.getX(), last.getY(), Math.abs(e.getX() - last.getX()),
					Math.abs(e.getY() - last.getY()));
		}
		if (e.getY() < last.getY()) {
			square.setBounds(last.getX(), e.getY(), Math.abs(e.getX() - last.getX()),
					Math.abs(e.getY() - last.getY()));
		}
		if (e.getX() < last.getX() && e.getY() < last.getY()) {
			square.setBounds(e.getX(), e.getY(), Math.abs(e.getX() - last.getX()),
					Math.abs(e.getY() - last.getY()));
		}
		
	}
		add(square);
	}
	
	/*
	 * Once mouse button is released, create the new cropped image by creating a new
	 * array based on the bounds of the cropping GRect and the place the cropped image
	 * on the top left.
	 */
	public void mouseReleased(MouseEvent e) {
		crop = square.getBounds();
		int[][] cropImageArray = cropImage(crop);
		System.out.println(crop);
		removeAll();
		GImage croppedImage = new GImage(cropImageArray);
		add(croppedImage);
	}
	
	/*
	 * Use bounding values of the cropping GRect to take pixels of the original
	 * image and create a new cropped image array via for loop
	 */
	private int[][] cropImage(GRectangle crop) {
		int[][] origArray = IMAGE.getPixelArray();
		int startX = (int) crop.getX();
		int startY = (int) crop.getY();
		int width = (int) crop.getWidth();
		int height = (int) crop.getHeight();
		int[][] cropArray = new int[height][width];
		for (int i = startY; i < startY + height; i++) {
			for (int j = startX; j < startX + width; j++) {
				cropArray[i - startY][j - startX] = origArray[i][j];
			}
		}
		return cropArray;
	}
	
/* Private instance variables */
private GPoint last; // The last mouse position when button is pressed
private GRect square; // cropping square 
private GRectangle crop; // Contains image crop bounding values
}
