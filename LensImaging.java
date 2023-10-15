import acm.program.*;
import acm.graphics.*;

public class LensImaging extends GraphicsProgram {
	
public static final double LENS_WIDTH = 250;
public static final double LENS_HEIGHT = 400;

	public void run() {
		createLens();
		createCandle();
		createInvertedCandle();
		createLightRays();
	}
	
	private void createLens() {
		lens = new GLens(LENS_WIDTH, LENS_HEIGHT);
		double cx = getWidth() / 2;
		double cy = getHeight() / 2;
		add(lens, cx, cy);
	}
	
	private void createCandle() {
		GImage candle = new GImage("candle.jpg");
		double cx = getWidth() / 2;
		double cy = getHeight() / 2;
		candle.setSize(LENS_WIDTH / 2, LENS_HEIGHT);
		add(candle, cx + candle.getWidth() * 2, cy - candle.getWidth() * 2);
	}

	private void createInvertedCandle() {
		GImage invertedCandle = new GImage("InvertedCandle.jpg");
		double cx = getWidth() / 2;
		double cy = getHeight() / 2;
		invertedCandle.setSize(LENS_WIDTH / 2, LENS_HEIGHT / 2);
		add(invertedCandle, cx - invertedCandle.getWidth() * 3  , cy - invertedCandle.getWidth());
	}
	
	private void createLightRays() {
		double cx = getWidth() / 2;
		double linesY = 10 + lens.getHeight() / 7;
		double focalPointX = cx / 2; 
		for (int i = 0; i < 7; i++) {
			add(new GLine(cx, linesY * (i + 1), cx + LENS_WIDTH, linesY * (i + 1)));
			add(new GLine(cx, linesY * (i + 1), focalPointX, (linesY * 4)));
			GLine thirdSetRays = new GLine(focalPointX, linesY * 4, focalPointX / 3, linesY * (i + 1));
			thirdSetRays.scale(.6);
			add(thirdSetRays);
		}
	} 
	
	
	private GLens lens;
}
