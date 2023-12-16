import acm.program.*;
import acm.graphics.*;

public class LineGraph extends GraphicsProgram {

private static final double SIDE_MARGIN = 10;
private static final double C_RADIUS = 2;

	public void run() {
		double[] values = { 0, 10, 20, 10, 25, 30, 35, 40, 50, 55, 60, 75, 80, 90 }; 
		drawLineGraph(values);
	}

	private void drawLineGraph(double[] values) {
		double xScale = (getWidth() - 2 * SIDE_MARGIN) / (values.length - 1);
		double yScale = calculateYScaling(values);
		double xPos2;
		double yPos2;
		for (int i = 0; i < values.length; i++) {
			double xPos = SIDE_MARGIN + xScale * i;
			double yPos = getHeight() - SIDE_MARGIN - yScale * values[i];
			if ( i == values.length - 1) {
			xPos2 = xPos;
			yPos2 = yPos;
			} else {
			xPos2 = SIDE_MARGIN + xScale * (i + 1);
			yPos2 = getHeight() - SIDE_MARGIN  - yScale * values[i + 1];
			}

			add(dataPoints(xPos, yPos));
			add(drawLines(xPos, xPos2, yPos, yPos2));
		}
	}
	
	private double calculateYScaling(double[] values) {
		double maxValue = findMax(values);
		double minValue = findMin(values);
		double yScale = (getHeight() - 2 * SIDE_MARGIN) / (maxValue - minValue);
		return yScale;
	}
	
	private double findMax(double[] values) {
		double max = -1; // to ensure at least one value  is the maximum
		for (double value : values) {
			if (value > max) {
				max = value;
			}
		}
		return max;
	}
	
	private double findMin(double[] values) {
		double min = 100000000; // makes sure one value is the minimum
		for (double value : values) {
			if (value < min) {
				min = value;
			}
		}
		return min;
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
