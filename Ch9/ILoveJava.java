/*
 * A class to define the ILoveJava pattern as a subclass
 * 
 */
import java.awt.*;
import acm.graphics.*;

/**
 * This class represents a "I Love Java" heart pattern.
 * As a QuiltBlock subclass, it is an object that can be added to
 * the canvas via the Quilt class.
 * 
 * 
 * @author Johnny
 *
 */
public class ILoveJava extends QuiltBlock {

//Offset constants to center heart within square
private static final double X_OFFSET = 0.7;
private static final double Y_OFFSET = 0.6;


/**
 * Creates a new "I Love Java" pattern that can be added to the canvas.
 */
    public ILoveJava() {
    	//creates pattern frame from superclass
    	super();
    	
/*
 * Creates each component of the pattern, a background square,
 * the heart, and the three line, three word centered message.
 */
        square = createSquare(BLOCK_WIDTH, BLOCK_HEIGHT);
        add(square);

        heart = createHeart(BLOCK_WIDTH, BLOCK_HEIGHT);
        add(heart, BLOCK_WIDTH * X_OFFSET, BLOCK_HEIGHT * Y_OFFSET);
        
        writeMessage("I", BLOCK_WIDTH, BLOCK_HEIGHT * .4);
        writeMessage("Love", BLOCK_WIDTH, BLOCK_HEIGHT * .55);
        writeMessage("Java", BLOCK_WIDTH, BLOCK_HEIGHT * .7);
    	}

/*
 * Helper method to create the pink background GRect within the
 * QuiltBlock constant dimensions.
 */
    private GRect createSquare(double width, double height) {
    	GRect square = new GRect(BLOCK_WIDTH + SHORT_SIDE, BLOCK_WIDTH + SHORT_SIDE);
    	square.setColor(Color.BLACK);
        square.setFilled(true);
        square.setFillColor(Color.PINK);
        return square;
    }

/*
 * Helper method to create the GPolygon heart shape and fills
 * it with the color red.
 */
    private GPolygon createHeart(double width, double height) {
        GPolygon heart = new GPolygon();
        heart.addVertex(-width / 2, 0);
        heart.addPolarEdge(width / 2, -45);
        heart.addPolarEdge(width / 2, 45);
        heart.addArc(width / 2 , width / 2, -45, 180);
        heart.addArc(width / 2, width / 2, 45, 180);
        heart.setFilled(true);
        heart.setColor(Color.RED);
        return heart;
    }

/*
 * Helper method that sets the font and color of each GLabel and
 * centers it within the heart and background GRect.
 */
    private void writeMessage(String string, double width, double height) {
    	message = new GLabel(string);
        message.setFont("Helvetica-bold-16");
    	message.setColor(Color.WHITE);
        add(message, (width / 2) + (SHORT_SIDE / 2) - message.getWidth() / 2, height);
    }

// Instance variables of each GObject
    private GPolygon heart;
    private GRect square;
    private GLabel message;
}
