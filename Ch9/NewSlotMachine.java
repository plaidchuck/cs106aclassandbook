/*
 * This program simulates a slot machine graphically that pays out based 
 * on certain combinations and allows the player to play until they are
 * out of money.
 */

import acm.program.*;
import acm.util.RandomGenerator;
import acm.graphics.*;
import java.awt.*;


public class NewSlotMachine extends GraphicsProgram {

//Constants to set the size of the canvas
public static final int APPLICATION_WIDTH = 500;
public static final int APPLICATION_HEIGHT = 400;

//Constants to set the size of each slot symbol window and space between them
private static final double WINDOW_WIDTH = 115;
private static final double WINDOW_HEIGHT = 105;
private static final double WINDOW_OFFSET = 40;

//sets constant for how much money the player starts with
 private static final int MONEY = 2;
  
//sets constant for the various payouts for winning combinations
 private static final int PAYOUT_BAR = 250;
 private static final int PAYOUT_BELL = 20;
 private static final int PAYOUT_PLUM = 14;
 private static final int PAYOUT_ORANGE = 10;
 private static final int PAYOUT_CHERRY = 7;
 private static final int PAYOUT_TWO_CHERRY = 5;
 private static final int PAYOUT_ONE_CHERRY = 2;
 
 //Pause between symbol reveal in window
 private static final int DELAY = 300; 
 
 //set string constants
 private static final String FONT = "Times New Roman-bold-25";
 private static final String ALL_BAR = "bar.jpg bar.jpg bar.jpg";
 private static final String ALL_BELL = "bell.jpg bell.jpg bell.jpg";
 private static final String BELL_BAR = "bell.jpg bell.jpg bar.jpg";
 private static final String ALL_PLUM = "plum.jpg plum.jpg plum.jpg";
 private static final String PLUM_BAR = "plum.jpg plum.jpg bar.jpg";
 private static final String ALL_ORANGE = "orange.jpg orange.jpg orange.jpg";
 private static final String ORANGE_BAR = "orange.jpg orange.jpg bar.jpg";
 private static final String THREE_CHERRY = "cherry.jpg cherry.jpg cherry.jpg";
 private static final String TWO_CHERRY = "cherry.jpg cherry.jpg";
 private static final String ONE_CHERRY = "cherry.jpg";

	public void run() {
		resetBackground();
		drawWelcomeMessage();
		while (wallet > 0) {
			checkBank();
			waitForClick();
			resetWindows(windowY);
			if (win != null) {
				win.setVisible(false);
			}
			if(lose != null) {
				lose.setVisible(false);
			}
 			bank.setVisible(false);
			welcome.setVisible(false);
			spinWheels();
		}
		gameOver();
	}
	
	/*
	 * Creates bank GLabel and adds current wallet amount to canvas.
	 * Then decrements wallet variable by one as "payment" for current
	 * game 
	 */
	
	private void checkBank() {
		bank = new GLabel("You now have $" + wallet + ".");
		bank.setFont(FONT);
		bank.setLocation(windowX, secondLineY);
		add(bank);
		wallet--;
	}
	
//generates three slots variables as integers and converts them into slot symbols
    private void spinWheels() {
        String firstSlot = (makeSymbols(rgen.nextInt(1, 6)));
        String secondSlot = (makeSymbols(rgen.nextInt(1, 6)));
        String thirdSlot = (makeSymbols(rgen.nextInt(1, 6)));
        showWheel(firstSlot, secondSlot, thirdSlot);
        getResult(firstSlot, secondSlot, thirdSlot);
    }
    
    /*
     * If a winning combination hits, determines the combination and
     * makes the appropriate payout
     */
    
    private void getResult(String firstSlot, String secondSlot, String thirdSlot) {
    
//create variable to format the combination in order to determine if it wins
//If it doesn't, creates a GLabel that states the loss
    	
    	String combination = firstSlot + " " + secondSlot + " " + thirdSlot;
    	        
    	if (combination.equals(ALL_BAR)) {
    	   handleWin(PAYOUT_BAR);
    	} else if (combination.equals(ALL_BELL) || combination.equals(BELL_BAR)) {
    	   handleWin(PAYOUT_BELL);
    	} else if (combination.equals(ALL_PLUM) || combination.equals(PLUM_BAR)) {
    	   handleWin(PAYOUT_PLUM);
    	} else if (combination.equals(ALL_ORANGE) || combination.equals(ORANGE_BAR)) {
    	   handleWin(PAYOUT_ORANGE);
    	} else if (combination.equals(THREE_CHERRY)) {
    	   handleWin(PAYOUT_CHERRY);
    	} else if (combination.startsWith(TWO_CHERRY)) {
    	   handleWin(PAYOUT_TWO_CHERRY);
    	} else if (combination.startsWith(ONE_CHERRY)) {
    	   handleWin(PAYOUT_ONE_CHERRY);
    	} else {
    		 	lose = new GLabel("You lose!");
    		 	lose.setFont(FONT);
    		 	add(lose, windowX, firstLineY);
    			}
    	    } 
    	
//adds winning combination payout amount to current wallet and adds to canvas
        private void handleWin(int payout) {
        	win =  new GLabel("You win $" + payout + "." ); 
	        win.setFont(FONT);
	        add(win, windowX, firstLineY);
            wallet += payout;
        }

/*
 *  Adds GImage on canvas that matches the randomly generated String from
 *  spinWheels method
 */

    private void showWheel(String firstSlot, String secondSlot, String thirdSlot) {
    	GImage firstWheel = new GImage(firstSlot);
    	GImage secondWheel = new GImage(secondSlot);
    	GImage thirdWheel = new GImage(thirdSlot);
    	firstWheel.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
    	secondWheel.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
    	thirdWheel.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
    	pause(DELAY);
    	add(firstWheel, windowX, windowY);
    	pause(DELAY);
    	add(secondWheel, windowX + WINDOW_OFFSET + WINDOW_WIDTH, windowY);
    	pause(DELAY);
    	add(thirdWheel, windowX + 2 * (WINDOW_OFFSET + WINDOW_WIDTH), windowY);
    	pause(DELAY);
    }
    
  //converts random generated integer from 1 to 6 to a slots symbol
    private String makeSymbols(int slot) {
        switch (slot) {
            case 1: return "bar.jpg";
            case 2: return "bell.jpg";
            case 3: return "plum.jpg";
            case 4: return "orange.jpg";
            case 5: return "cherry.jpg";
            case 6: return "lemon.jpg";
            default: return "";
        }
    }
	
/*
 * Set the background canvas color, centers and sets the windows to empty.
 */
	private void resetBackground() {
		setBackground(Color.GRAY);
		windowX = (getWidth() - (WINDOW_WIDTH * 3) - WINDOW_OFFSET * 2) / 2;
		windowY = (getHeight() / 2 - WINDOW_HEIGHT);
		resetWindows(windowY);
	}
	
	/*
	 * Helper method to add the empty window image to the canvas.
	 */
	private void resetWindows(double windowY) {
		for (int i = 0; i < 3; i++) {
			GRect frame = new GRect(WINDOW_WIDTH, WINDOW_HEIGHT);
			empty = new GImage("empty.jpg");
			empty.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
			add(empty, (windowX + (i * WINDOW_OFFSET) + (i * (WINDOW_WIDTH))), windowY);
			add(frame, (windowX + (i * WINDOW_OFFSET) + (i * (WINDOW_WIDTH))), windowY);
		}
	}
	
	/*
	 * Sets initial text on canvas before first slot game
	 */
	private void drawWelcomeMessage() {
		welcome.setFont(FONT);
		firstLineY = getHeight() - WINDOW_WIDTH - welcome.getAscent();
		welcome.setLocation(windowX, firstLineY);
		play.setFont(FONT);
		secondLineY = firstLineY + (welcome.getAscent() * 2);
		double thirdLineY = firstLineY + (welcome.getAscent() * 4);
		play.setLocation(windowX, thirdLineY);
		add(welcome);
		add(play);
	}
	
	/*
	 * Informs player that they are out of money and the game is over 
	 */
	
	private void gameOver() {
		play.setVisible(false);
		double thirdLineY = firstLineY + (welcome.getAscent() * 4);
		GLabel end = new GLabel("Out of money!");
		end.setFont(FONT);
		end.setLocation(windowX, thirdLineY);
		add(end);
	}

//Instance variables
	private double windowX; //X coordinate for first slot window and GLabels
	private double windowY; //Y cordinates for slot windows
	private double firstLineY; // First GLabel information line
	private double secondLineY; //Second GLabel line
	private int wallet = MONEY; //Starting and current amount of wallet
	private GImage empty;
	private GLabel welcome = new GLabel("Welcome to the Slot Machine!");
	private GLabel play = new GLabel("One dollar per spin. Click to play.");
	private GLabel lose;
	private GLabel bank;
	private GLabel win;
	
	private RandomGenerator rgen = RandomGenerator.getInstance();
}
