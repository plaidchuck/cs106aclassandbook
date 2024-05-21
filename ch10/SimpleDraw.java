import acm.program.*;
import acm.graphics.*;
import java.awt.event.*;

public class SimpleDraw extends GraphicsProgram {
	
	public void init() {
		palette = new Palette();
		add(palette);
		selectedShape = "FilledRect";
		addMouseListeners();
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		gobj = getElementAt(e.getX(), e.getY());
		if (gobj instanceof Palette) {
			selectedShape = palette.chooseShape(palette.getLocalPoint(e.getX(), e.getY()));
		} 
	}
	
	
	@Override
	public void mousePressed(MouseEvent e) {
		gobj = getElementAt(e.getX(), e.getY());
		if (gobj == null) {
				startX = e.getX();
				startY = e.getY();
				createShape(startX, startY);
			}
	
	}
	
	public void mouseDragged(MouseEvent e) {
		if (gobj == null) {
		double mouseX = e.getX();
		double mouseY = e.getY();
		double dragX = Math.min(e.getX(), startX);
		double dragY = Math.min(e.getY(), startY);
		double dragWidth = Math.abs(e.getX() - startX);
		double dragHeight = Math.abs(e.getY() - startY);
		dragShape(dragX, dragY, dragWidth, dragHeight, mouseX, mouseY);
		}
	}
	
	private void createShape(double startX, double startY) {
		if (selectedShape.equals("FilledRect") || selectedShape.equals("OpenRect")) {
			currentRect = new GRect(startX, startY, 0, 0);
			if (selectedShape.equals("FilledRect")) {
				currentRect.setFilled(true);
			}
			add(currentRect);
		}
		if (selectedShape.equals("FilledOval") || selectedShape.equals("OpenOval")) {
			currentOval = new GOval(startX, startY, 0, 0);
			if (selectedShape.equals("FilledOval")) {
				currentOval.setFilled(true);
			}
			add(currentOval);
		}
		if (selectedShape.equals("Line")) {
			currentLine = new GLine(startX, startY, startX, startY);
			add(currentLine);
		}
	}
	
	private void dragShape(double dragX, double dragY, double dragWidth, double dragHeight, double mouseX, double mouseY) {
		if (selectedShape.equals("FilledRect") || selectedShape.equals("OpenRect")) {
			currentRect.setBounds(dragX, dragY, dragWidth, dragHeight);
		}
		if (selectedShape.equals("FilledOval") || selectedShape.equals("OpenOval")) {
			currentOval.setBounds(dragX, dragY, dragWidth, dragHeight);
		}
		if (selectedShape.equals("Line")) {
			currentLine.setEndPoint(mouseX, mouseY);
		}
	}
	
	
	private GObject gobj;
	private Palette palette;
	private String selectedShape;
	
	private double startX; //Starting X point of shapes
	private double startY; //Starting Y point of shapes
	private GRect currentRect;
	private GOval currentOval;
	private GLine currentLine;
}

class Palette extends GCompound {
	
	public Palette() {
		add(new FilledRect(), BUTTON_SPACING, BUTTON_SPACING);
		add(new OpenRect(), BUTTON_SPACING, ShapeButton.SHAPE_HEIGHT * 2 + BUTTON_SPACING);
		add(new FilledOval(), BUTTON_SPACING, ShapeButton.SHAPE_HEIGHT * 4 + BUTTON_SPACING);
		add(new OpenOval(), BUTTON_SPACING, ShapeButton.SHAPE_HEIGHT * 6 + BUTTON_SPACING);
		add(new Line(), BUTTON_SPACING, ShapeButton.SHAPE_HEIGHT * 8 + BUTTON_SPACING);
	}
	
	public String chooseShape(GPoint coords) {
		GObject obj = getElementAt(coords);
		String shape;
		if (obj instanceof FilledRect) {
			shape = "FilledRect";
			return shape;
		}
		else if (obj instanceof OpenRect) {
			shape = "OpenRect";
			return shape;
		}
		else if (obj instanceof FilledOval) {
			shape = "FilledOval";
			return shape;
		}
		else if (obj instanceof OpenOval) {
			shape = "OpenOval";
			return shape;
		}
		else if (obj instanceof Line) {
			shape = "Line";
			return shape;
		}
		return null;
	}
	
	private static final int BUTTON_SPACING = 10;
}

abstract class ShapeButton extends GCompound {
	
	public ShapeButton() {
		add(new GRect(BUTTON_WIDTH, BUTTON_HEIGHT));
	}
	
	public static final int BUTTON_WIDTH = 60;
	public static final int BUTTON_HEIGHT = 50;
	public static final int SHAPE_WIDTH = 40;
	public static final int SHAPE_HEIGHT = 30;
}

class OpenRect extends ShapeButton {
	
	public OpenRect() {
		add(new GRect((ShapeButton.BUTTON_WIDTH - ShapeButton.SHAPE_WIDTH) / 2, (ShapeButton.BUTTON_HEIGHT - ShapeButton.SHAPE_HEIGHT) / 2, 
				ShapeButton.SHAPE_WIDTH, ShapeButton.SHAPE_HEIGHT));
	}
}

class FilledRect extends ShapeButton {
	
	public FilledRect() {
		GRect rect = new GRect((ShapeButton.BUTTON_WIDTH - ShapeButton.SHAPE_WIDTH) / 2, (ShapeButton.BUTTON_HEIGHT - ShapeButton.SHAPE_HEIGHT) / 2, 
				ShapeButton.SHAPE_WIDTH, ShapeButton.SHAPE_HEIGHT);
		
		rect.setFilled(true);
		add(rect);
	}
}

class FilledOval extends ShapeButton {
	
	public FilledOval() {
		GOval oval = new GOval((ShapeButton.BUTTON_WIDTH - ShapeButton.SHAPE_WIDTH) / 2, (ShapeButton.BUTTON_HEIGHT - ShapeButton.SHAPE_HEIGHT) / 2, 
				ShapeButton.SHAPE_WIDTH, ShapeButton.SHAPE_HEIGHT);
		oval.setFilled(true);
		add(oval);
	}
}

class OpenOval extends ShapeButton {
	
	public OpenOval() {
		GOval oval = new GOval((ShapeButton.BUTTON_WIDTH - ShapeButton.SHAPE_WIDTH) / 2, (ShapeButton.BUTTON_HEIGHT - ShapeButton.SHAPE_HEIGHT) / 2, 
				ShapeButton.SHAPE_WIDTH, ShapeButton.SHAPE_HEIGHT);
		add(oval);
	}
}

class Line extends ShapeButton {
	
	public Line() {
		GLine line = new GLine((ShapeButton.BUTTON_WIDTH - ShapeButton.SHAPE_WIDTH) / 2, (ShapeButton.BUTTON_HEIGHT - ShapeButton.SHAPE_HEIGHT) / 2, 
				ShapeButton.SHAPE_WIDTH, ShapeButton.SHAPE_HEIGHT);
		add(line);
	}
}