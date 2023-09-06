import acm.program.*;
import acm.graphics.*;
import java.awt.*;


public class TriColorFlag extends GraphicsProgram {
// sets flag width and height constants along with specific color codes for the flag
	private static final double FLAG_WIDTH = 500;
    private static final double FLAG_HEIGHT = 300;
    private static final Color RED = new Color(206, 17, 38);
    private static final Color YELLOW = new Color(255, 223, 0);
    private static final Color PURPLE = new Color(69, 0, 132);

    public void run() {
//set variables for coordinates to center the flag
    	double flagX = (getWidth() / 2) - (FLAG_WIDTH / 2);
        double flagY = (getHeight() / 2) - (FLAG_HEIGHT / 2);
//sets dimension for the stripes which are a third of the flag
        double stripeHeight = FLAG_HEIGHT / 3;

//draws first stripe 
        GRect flagRed = new GRect(flagX, flagY, FLAG_WIDTH, stripeHeight);
        flagRed.setFilled(true);
        flagRed.setFillColor(RED);
        add(flagRed);

//draws second stripe moving one stripe length down
        GRect flagYellow = new GRect(flagX, flagY + stripeHeight, FLAG_WIDTH, stripeHeight);
        flagYellow.setFilled(true);
        flagYellow.setFillColor(YELLOW);
        add(flagYellow);

 //draws third stripe moving two stripe lengths down
        GRect flagPurple = new GRect(flagX, flagY + 2 * stripeHeight, FLAG_WIDTH, stripeHeight);
        flagPurple.setFilled(true);
        flagPurple.setFillColor(PURPLE);
        add(flagPurple);
        
 //draws flag name flush to the bottom right of window using getDescent
        GLabel label = new GLabel("Flag of the Spanish Second Republic");
        label.setFont("Times New Roman-32");
        label.setLocation(getWidth() - label.getWidth(), getHeight() - label.getDescent());
        add(label);
    }
}