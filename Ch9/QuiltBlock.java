/*
 * This class defines the abstract superclass for all quilt
 * pattern blocks.
 * 
 *
 */

import acm.graphics.*;

/**
 * Creates a frame of a GRect pattern block with the size specified by
 * the class constants.
 *
 */

public abstract class QuiltBlock extends GCompound {

	
	/**
	 * Creates a new quilt that contains no patterns. Clients can add
	 * pattern blocks by calling the appropriate method.
	 */
		public QuiltBlock() { 
			add(new GRect(BLOCK_WIDTH, BLOCK_HEIGHT + SHORT_SIDE));
		}

//Constant to set grid size of block pattern
protected static final double BLOCK_WIDTH = 100;
protected static final double BLOCK_HEIGHT = 100;

//Constant for short side of log cabin block pattern
protected static final double SHORT_SIDE = 12;
		
}
