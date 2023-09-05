/*
 * File: ProgramHierarchy.java
 * Name: 
 * Section Leader: 
 * ---------------------------
 * This file is the starter file for the ProgramHierarchy problem.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class ProgramHierarchy extends GraphicsProgram {	
	
private static final int BOX_WIDTH = 160;

private static final int BOX_HEIGHT = 50;
//main program that sends halved screen width and height parameters
	public void run() {
		drawDiagram(getWidth() / 2 , getHeight() / 2);
	}
//draws each box in the diagram along with lines using halved screen height and width params	
	private void drawDiagram(int cx, int cy) {
		drawCenterBox(cx, cy);
		drawLeftBox(cx, cy);
		drawRightBox(cx, cy);
		drawTopBox(cx, cy);
		drawLines(cx, cy);
	}
	
	private void drawCenterBox(int cx, int cy) {
//construct and add box to center by calculating x from subtracted halved box values from
//halved screen values
		GRect centerBox = new GRect (cx - BOX_WIDTH / 2, cy - BOX_HEIGHT / 2, BOX_WIDTH, BOX_HEIGHT);
		add(centerBox);
//centers label like the box but using getAscent to make centering more precise
		GLabel consoleProgram = new GLabel ("ConsoleProgram");
		consoleProgram.setLocation(cx - consoleProgram.getWidth() / 2, cy + consoleProgram.getAscent() / 2);
		add(consoleProgram);
	}
		
	private void drawLeftBox(int cx, int cy) {
		GRect leftBox = new GRect ((cx / 2) - (BOX_WIDTH / 2), cy - BOX_HEIGHT / 2, BOX_WIDTH, BOX_HEIGHT);
		add(leftBox);
		GLabel graphicsProgram = new GLabel ("GraphicsProgram");
		graphicsProgram.setLocation((cx / 2) - graphicsProgram.getWidth() / 2, cy + graphicsProgram.getAscent() / 2);
		add(graphicsProgram);
	}
	
	private void drawRightBox(int cx, int cy) {
		GRect rightBox = new GRect ((cx * 1.5) - (BOX_WIDTH / 2), cy - BOX_HEIGHT / 2, BOX_WIDTH, BOX_HEIGHT);
		add(rightBox);
		GLabel dialogProgram = new GLabel ("DialogProgram");
		dialogProgram.setLocation((cx * 1.5) - dialogProgram.getWidth() / 2, cy + dialogProgram.getAscent() / 2);
		add(dialogProgram);
	}
	
	private void drawTopBox(int cx, int cy) {
		GRect topBox = new GRect (cx - BOX_WIDTH / 2, cy - BOX_HEIGHT * 2.5, BOX_WIDTH, BOX_HEIGHT);
		add(topBox);
		GLabel program = new GLabel ("Program");
		program.setLocation(cx - program.getWidth() / 2, cy / 2 + (program.getAscent() * 2));
		add(program);
	}
	
	private void drawLines(int cx, int cy) {
		//draw lines
		GLine centerLine = new GLine(cx, cy - BOX_HEIGHT * 1.5, cx, cy - BOX_HEIGHT / 2);
		add(centerLine);
		GLine leftLine = new GLine(cx, cy - BOX_HEIGHT * 1.5, (cx / 2), cy - BOX_HEIGHT / 2);
		add(leftLine);
		GLine rightLine = new GLine(cx, cy - BOX_HEIGHT * 1.5, cx * 1.5, cy -  BOX_HEIGHT / 2);
		add(rightLine);
	}
	
}
