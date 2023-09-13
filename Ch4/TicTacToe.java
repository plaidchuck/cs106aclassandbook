import acm.graphics.*;
import acm.program.*;

public class TicTacToe extends GraphicsProgram {
    private static final int BOARD_SIZE = 250;

    public void run() {
//center board by subtracting board size from total width and height of canvas
        double x = (getWidth() - BOARD_SIZE) / 2;
        double y = (getHeight() - BOARD_SIZE) / 2;
        
        // Draw vertical lines
            add(new GLine(x + (BOARD_SIZE / 3), y, x + (BOARD_SIZE / 3), y + BOARD_SIZE));
            add(new GLine(x + 2 * (BOARD_SIZE / 3), y, x + 2 * (BOARD_SIZE / 3), y + BOARD_SIZE));

        // Draw the horizontal lines
            add(new GLine(x, y + (BOARD_SIZE / 3), x + BOARD_SIZE, y + (BOARD_SIZE / 3)));
            add(new GLine(x, y + 2 * (BOARD_SIZE / 3), x + BOARD_SIZE, y + 2 * (BOARD_SIZE / 3)));
        }
    }

