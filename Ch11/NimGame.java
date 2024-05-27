import acm.program.*;
import acm.graphics.*;
import acm.util.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class NimGame extends GraphicsProgram {

	public static final int NUM_COINS = 11;
	public static final int COIN_SIZE = 40;
	public static final int SPACING = 20;
	
	public void init() {
		coins = new ArrayList<Coin>();
		playerTurn = true;
		selectedCoins = 0;
		setupCoins();
		addMouseListeners();
	}
	
	public void mousePressed(MouseEvent e) {
		GObject gobj = getElementAt(e.getX(), e.getY());
		if (gobj instanceof Coin) {
			int coinIndex  = coins.indexOf(gobj);
			if (coinIndex >= coins.size() - 3 && !coins.get(coinIndex).isSelected()) {
				selectCoins(coinIndex);
			}
		}
	}
	
	public void mouseReleased(MouseEvent e) {
		if (selectedCoins > 0) {
			removeSelectedCoins();
		}
		if (coins.size() > 0 && !playerTurn) {
			computerMove();
		}
	}
	
	private void computerMove() {
		Runnable r = new Runnable() {
		    public void run() {
		    	int move;
		    	if (coins.size() > 6) {
		    		
		    	}
		    	move =  selectedCoins;
		    	selectedCoins = 0;
		    	System.out.println(move);
		    	pause(1000);
				for (int i = 0; i < move; i++) {
					(coins.get(coins.size() - i - 1)).setFillColor(Color.YELLOW);
				}
				pause(1000);
				for (int i = 0; i < move; i++) {
		            remove(coins.remove(coins.size() - 1));
		        }
				playerTurn = true;
		    }
		};
		new Thread(r).start();

	}
	/*	int move = 1;
		for (int i = 0; i < move; i++) {
			(coins.get(coins.size() - i - 1)).setFillColor(Color.YELLOW);
		}
		pause(1000);
		for (int i = 0; i < move; i++) {
            remove(coins.remove(coins.size() - 1));
        }
		playerTurn = true; 
	} */
	
	private void selectCoins(int startIndex) {
		for (int i = startIndex; i < coins.size(); i++) {
			coins.get(i).select();
		}
		selectedCoins = coins.size() - startIndex;
	}
	
	private void removeSelectedCoins() {
		for (int i = 0; i < selectedCoins; i++) {
			remove(coins.remove(coins.size() - 1));
		}
		playerTurn = false;
	}
	
	
	/*
	 * Sets up the canvas with the initial number of coins and adds them to canvas
	 * and ArrayList
	 */
	private void setupCoins() {
		double startX = (getWidth() - (NUM_COINS * (COIN_SIZE + SPACING) - SPACING)) / 2;
		double y = getHeight() / 2 - COIN_SIZE / 2;
		for (int i = 0; i < NUM_COINS; i++) {
			double x = startX + i * (COIN_SIZE + SPACING);
			Coin coin = new Coin(x, y, COIN_SIZE);
			coins.add(coin);
			add(coin);
		}
	}
	
	private int selectedCoins; // Number of coins currently selected to eliminate by player
	private ArrayList<Coin> coins; // Array containing coin objects
	private boolean playerTurn; // To determine if computer can remove coins or not
	
}

class Coin extends GOval {
	
	public Coin(double x, double y, double diameter) {
		super(x, y, diameter, diameter);
		selected = false;
		setFilled(true);
		setFillColor(Color.BLACK);
	}
	
	public void select() {
		selected = true;
		setFillColor(Color.RED);
	}
	
	/*
	 * Implemented to be used in a later extension where dragging the mouse
	 * left or right will select 1 to 3 coins to take
	 */
	public void deselect() {
		selected = false;
		setFillColor(Color.BLACK);
	}
	
	public boolean isSelected() {
		return selected;
	}
	
	private boolean selected; // If coin is selected to be removed or not
}