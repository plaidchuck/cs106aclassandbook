/*
 * A class that adds a QuiltBlock class object to the GCompound
 * canvas.
 */

import acm.graphics.*;

public class Quilt extends GCompound {
	
/**
 * Constructor to create the Quilt object
 */
	public Quilt() {
// Simply creates object within class
	}

/**
 * Appends one of the three block patterns to the quilt GCompound object.
 * horizontally one after the other.
 * @param block One of the three block patterns
 */
	public void append(QuiltBlock block) {
		double width = getWidth();
		double x = width;
		add(block, x, 0);
	}
	
}
