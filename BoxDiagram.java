import acm.program.*;
import acm.graphics.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class BoxDiagram extends GraphicsProgram {
	public void init() {
		addButtons();
	}
	
	private void addButtons() {
		add(new JLabel("Name"), SOUTH);
		textField = new JTextField(30);
		add(textField, SOUTH);
		add(new JButton("Add"), SOUTH);
		add(new JButton("Remove"), SOUTH);
		add(new JButton("Clear"), SOUTH);
		addMouseListeners();
		addActionListeners();
	}
	
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("Add")) {
			Box box = new Box(textField.getText());
			double cx = getWidth() / 2;
			double cy = getHeight() / 2;
			double bx = box.getWidth() / 2;
			double by = box.getHeight() / 2;
			add(box, cx - bx, cy - by);
		}
		if (e.getActionCommand().equals("Remove")) {
			Iterator<GObject> boxes = iterator();
			if (boxes.hasNext()) {
			while (boxes.hasNext()) {
				Box box = (Box) boxes.next();
				if (box.getLabel().equals(textField.getText())) {
					remove(box);
					}
				}
			}
		}
		if (e.getActionCommand().equals("Clear")) {
			removeAll();
		}
	}
	
	private JTextField textField;
}



class Box extends GCompound {
	
	private static final double BOX_WIDTH = 120;
	private static final double BOX_HEIGHT = 50;
	
	public Box(String boxLabel) {
		this.label = new GLabel(boxLabel);
		add(new GRect(0, 0, BOX_WIDTH, BOX_HEIGHT));
		add(label, BOX_WIDTH / 2 - label.getWidth() / 2, BOX_HEIGHT / 2 + label.getAscent() / 2);
	}
	
	public String getLabel() {
		return label.getLabel();
	}
	
	private GLabel label;
}