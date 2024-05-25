import acm.program.*;
import acm.graphics.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class NewStarMap extends GraphicsProgram {

	public void init() {
		setBackground(Color.GRAY);
		add(new JButton("Clear"), SOUTH);
		sizeSlider = new JSlider(MIN_SIZE, MAX_SIZE, INITIAL_SIZE);
		add(new JLabel("  Small"), SOUTH);
		add(sizeSlider, SOUTH);
		add(new JLabel("Large  "), SOUTH);
		initColorChooser();
		add(colorChooser, SOUTH);
		add(new JLabel("Star Name: "), SOUTH);
		starName = new JTextField(26);
		starName.addActionListener(this);
		add(starName, SOUTH);
		addMouseListeners();
		addKeyListeners();
		addActionListeners();
	}
	
	public void initColorChooser() {
		colorChooser = new JComboBox();
		colorChooser.addItem(new LabeledColor(Color.WHITE, "White"));
		colorChooser.addItem(new LabeledColor(Color.RED, "Red"));
		colorChooser.addItem(new LabeledColor(Color.BLUE, "Blue"));
		colorChooser.addItem(new LabeledColor(Color.GREEN, "Green"));
		colorChooser.addItem(new LabeledColor(Color.YELLOW, "Yellow"));
		colorChooser.addItem(new LabeledColor(Color.ORANGE, "Orange"));
		colorChooser.addItem(new LabeledColor(Color.MAGENTA, "Magenta"));
		colorChooser.addItem(new LabeledColor(Color.BLACK, "Black"));
		colorChooser.setEditable(false);
		colorChooser.setSelectedItem(Color.WHITE);
	}
	


	private double getCurrentSize() {
		return sizeSlider.getValue();
	}
	
	private void addStarLabel(double starX, double starY) {
		starLabel = new GLabel(starName.getText());
		starLabel.setFont("Arial-bold-" + sizeSlider.getValue());
		starLabel.setColor((Color) colorChooser.getSelectedItem());
		starLabel.setLocation(starX + 20, starY + 5);
		add(starLabel);
	}
	
	public void mouseClicked(MouseEvent e) {
		gobj = getElementAt(e.getX(), e.getY());
		if (gobj == null) {
			GStar star = new GStar(getCurrentSize());
			star.setFilled(true);
			star.setColor((Color) colorChooser.getSelectedItem());
			add(star, e.getX(), e.getY());
			gobj = star;
		} 
	}
	
	public void keyPressed(KeyEvent e) {
		if (gobj != null) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
				if (gobj instanceof GStar) {
					gobj.move(0, -1); break;
				} else {
					starLabel.move(0, -1); break;
				}
				
			case KeyEvent.VK_DOWN:
				if (gobj instanceof GStar) {
					gobj.move(0, 1); break;
				} else {
					starLabel.move(0, 1); break;
				}
			
			case KeyEvent.VK_LEFT:
				if (gobj instanceof GStar) {
					gobj.move(-1, 0); break;
				} else {
					starLabel.move(-1, 0); break;
				}
			
			case KeyEvent.VK_RIGHT:
				if (gobj instanceof GStar) {
					gobj.move(1, 0); break;
				} else {
					starLabel.move(1, 0); break;
				}
			
			case KeyEvent.VK_DELETE: {
				remove(gobj); break;
			}
			
			}
		}
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Clear")) {
			removeAll();
		}
		else if (e.getSource() == starName && gobj != null) {
			addStarLabel(gobj.getX(), gobj.getY());
			starName.setText("");
		} else {
			starName.setText("");
		}
	}
	
	
	private static final int MIN_SIZE = 1;
	private static final int MAX_SIZE = 50;
	private static final int INITIAL_SIZE = 16;
	
	private JSlider sizeSlider;
	private JComboBox colorChooser;
	private JTextField starName;
	private GLabel starLabel;
	private GObject gobj; //Selected star from canvas
}

class LabeledColor extends Color {
	
	public LabeledColor(Color color, String colorName) {
		super(color.getRed(), color.getGreen(), color.getBlue());
		this.colorName = colorName;
	}
	
	@Override
	public String toString() {
		return colorName;
	}
	
	private String colorName;
}