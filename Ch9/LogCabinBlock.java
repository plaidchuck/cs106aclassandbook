import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class LogCabinBlock extends GraphicsProgram {

/*
 * Constants to define size of frame sides along with
 * the number of frames and the offset for nesting frames
 */
    private static final double LONG_SIDE = 200;
    private static final double SHORT_SIDE = 25;
    private static final double FRAME_OFFSET = 2;
    private static final int NUM_FRAMES = 4;

    public void run() {
/*
 * Set origin point for frame
 */
        double startingX = 0;
        double startingY = 0;
        
/*
 * Loop to draw frames the number of times specified in constant
 */
        for (int i = 0; i < NUM_FRAMES; i++) {
            drawLogCabinFrame(startingX + (i * SHORT_SIDE), startingY + (i * SHORT_SIDE), i);
        }
    }

/*
 * Helper method that receives origin points based on the index number of loop
 * 
 */
    private void drawLogCabinFrame(double startingX, double startingY, int index) {
/*
 * Variables to reduce long side size of frame based on the offset constant
 * and index number of loop
 */
        double horizontalFrameTop = LONG_SIDE - (index * SHORT_SIDE * FRAME_OFFSET);
        double verticalFrameLeft = LONG_SIDE - (index * SHORT_SIDE * FRAME_OFFSET);

        GRect topFrame = createFilledRectangle(startingX, startingY, SHORT_SIDE, horizontalFrameTop);
        GRect bottomFrame = createFilledRectangle(startingX, startingY + horizontalFrameTop, verticalFrameLeft, SHORT_SIDE);
        GRect rightFrame = createFilledRectangle(startingX + verticalFrameLeft, startingY + SHORT_SIDE, SHORT_SIDE, horizontalFrameTop);
        GRect leftFrame = createFilledRectangle(startingX + SHORT_SIDE, startingY, verticalFrameLeft, SHORT_SIDE);
        
        add(topFrame);
        add(bottomFrame);
        add(rightFrame);
        add(leftFrame);
    }

/*
 * Helper method to fill each GRect with the specified color
 */
    private GRect createFilledRectangle(double x, double y, double width, double height) {
        GRect rect = new GRect(x, y, width, height);
        rect.setColor(Color.BLACK);
        rect.setFilled(true);
        rect.setFillColor(Color.GREEN);
        return rect;
    }
}
