import acm.program.*;
import acm.graphics.*;

public class LineGraph extends GraphicsProgram {

private static final double SIDE_MARGIN = 10;
private static final double C_RADIUS = 2;

	public void run() {
		double[] values = { 0, 10, 50, 80, 85, 100, 150, 120, 170, 120, 200 }; 
		drawLineGraph(values);
	}

	private void drawLineGraph(double[] values) {
		double canvasMinusMargins = (getWidth() - 2 * SIDE_MARGIN) / (values.length - 1);
		double bottomMargin = getHeight() - SIDE_MARGIN;
		//double yScale = calculate
		double xPos2;
		double yPos2;
		for (int i = 0; i < values.length; i++) {
			double xPos = SIDE_MARGIN + canvasMinusMargins * i;
			double yPos = bottomMargin - values[i];
			if ( i == values.length - 1) {
				xPos2 = xPos;
				yPos2 = yPos;
			} else {
				xPos2 = SIDE_MARGIN + canvasMinusMargins * (i + 1);
				yPos2 = bottomMargin - values[i + 1];
			}

			add(dataPoints(xPos, yPos));
			add(drawLines(xPos, xPos2, yPos, yPos2));
		}
	}
	
	private GOval dataPoints(double xPos, double yPos) {
		GOval dataPoint = new GOval(xPos - C_RADIUS, yPos, C_RADIUS * 2, C_RADIUS * 2);
		dataPoint.setFilled(true);
		return dataPoint;
	}
	
	private GLine drawLines(double xPos, double xPos2, double yPos, double yPos2) {
		GLine dataLine = new GLine(xPos, yPos + C_RADIUS, xPos2, yPos2 + C_RADIUS);
		return dataLine;
	}
}
