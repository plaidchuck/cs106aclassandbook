import acm.program.*;
import acm.graphics.*;
import java.awt.event.*;

public class ArrayListLabels extends GraphicsProgram {
	
private static final int INITIAL_CAPACITY = 10;

	public void run() {
		addMouseListeners();
		for (int i = 0; i < labels.length; i++) {
			GLabel text = new GLabel("# " + (i), 50, 50);
			labels[i] = text;
		}
	}
	
public void mouseClicked(MouseEvent e) {
	double dy = labels[0].getHeight();
	if (arrayCounter < labels.length) {
		for (int i = 0; i < arrayCounter; i ++) {
			labels[i].move(0, dy);
		}
		add(labels[arrayCounter++]);
	}
	else if (arrayCounter >= labels.length) {
		labels = doubleArrayCapacity(labels);
	}
}

/* 
 * GLabel[] -> GLabel[]
 * Consumes an array of GLabel objects and produces an array of GLabels
 * whose size is doubled and contains all previous and new GLabel objects up to the new 
 * array size.
 */
private GLabel[] doubleArrayCapacity(GLabel[] oldArray) {
	int newCapacity = (arrayCounter * 2);
	GLabel[] newArray = new GLabel[newCapacity];
	for (int i = 0; i < oldArray.length; i++) {
		newArray[i] = oldArray[i];
	}
	for (int j = arrayCounter; j < newCapacity; j++) {
		newArray[j] = new GLabel("# " + j, 50, 50);
	}
	return newArray;
}
	
	private GLabel[] labels = new GLabel[INITIAL_CAPACITY];
	private int arrayCounter = 0;
}
