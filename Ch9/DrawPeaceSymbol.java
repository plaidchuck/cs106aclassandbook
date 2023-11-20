import java.awt.*;
import acm.program.*;
import acm.graphics.*;


public class DrawPeaceSymbol extends GraphicsProgram {
	public void run() {
		double x = getWidth() /2;
		double y = getHeight() / 2;
		double r = 150;
		drawPeaceSymbol(x, y, r); 
	}
	
	private void drawPeaceSymbol(double x, double y, double r) {
		GOval circle = new GOval (r * 2, r * 2);
		add(circle, x - (circle.getWidth() / 2), y - (circle.getHeight() /2));
		GArc arc = new GArc(2 * r, 2 * r, -45, -90);
		arc.setFilled(true);
		arc.setFillColor(Color.WHITE);
		add(arc, x - (circle.getWidth() / 2), y - (circle.getHeight() /2));
		GLine middleLine = new GLine(x, y - r, x, y + r);
		add(middleLine);
	}
}
