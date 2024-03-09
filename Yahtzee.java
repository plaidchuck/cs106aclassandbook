/*
 * File: Yahtzee.java
 * ------------------
 * This program will eventually play the Yahtzee game.
 */

import java.util.Arrays;

import acm.io.*;
import acm.program.*;
import acm.util.*;

public class Yahtzee extends GraphicsProgram implements YahtzeeConstants {
	
	public static void main(String[] args) {
		new Yahtzee().start(args);
	}
	
	public void run() {
		IODialog dialog = getDialog();
		do {
		nPlayers = dialog.readInt("Enter number of players (1 to 4)");
		} 
		while (nPlayers < 1 || nPlayers > 4); 
		playerNames = new String[nPlayers];			
		for (int i = 1; i <= nPlayers; i++) {
			playerNames[i - 1] = dialog.readLine("Enter name for player " + i);
		}
		
		display = new YahtzeeDisplay(getGCanvas(), playerNames);
		playGame();
	}

	private void playGame() {
		newTurn();
	}
	
	private void newTurn() {
		int roll = 3;
		int[] dice = new int[N_DICE];
		display.waitForPlayerToClickRoll(1);
		while (roll > 0) {
			if (roll == 3) {
				dice = rollDice();
				display.displayDice(dice);
			} else {
				display.waitForPlayerToSelectDice();
				for (int i = 0; i < N_DICE; i++) {
					if (display.isDieSelected(i)) {
						dice[i] = rgen.nextInt(1, 6);
					}
				}
				display.displayDice(dice);
			}
			roll--;
		}
	//	dice = cheatMode();
	//	sortDice(dice);
	//	display.displayDice(dice);
		while (true) {
			dice = rollDice();
			sortDice(dice);
			display.displayDice(dice);
			System.out.println("");
			System.out.println("Full House: " + checkFullHouse(dice));
			System.out.println("Large Straight: " + checkLargeStraight(dice));
			System.out.println("Small Straight: " + checkSmallStraight(dice));
			System.out.println("Yahtzee: " + checkYahtzee(dice));
			waitForClick();
		}
	}
	
	private int[] rollDice() {
		int[] dice = new int[N_DICE];
		for (int i = 0; i < N_DICE; i++) {
			dice[i] = rgen.nextInt(1, 6);
		}
		return dice;
	}
	
	private int[] sortDice(int[] dice) {
		int tempDie;
		boolean sorted = false;
		while (!sorted) {
			sorted = true;
			for (int i = 0; i < dice.length - 1; i++) {
				if (dice[i] > dice[i + 1]) {
					tempDie = dice[i + 1];
					dice[i + 1] = dice[i];
					dice[i] = tempDie;
					sorted = false;
				}
			}
		}
		return dice;
	}
	
	private int[] cheatMode() {
		IODialog dialog = getDialog();
		int[] dice = new int[N_DICE];
		for (int i = 0; i < N_DICE; i++) {
			do {
				dice[i] = dialog.readInt("Enter Roll for die: " + i);
				}
			while (dice[i] < 1 || dice[i] > 6);
			}
		return dice;
	}
	
	private boolean checkLargeStraight(int[] dice) {
		for (int i = 0 ; i < N_DICE - 1; i++) {
			if (dice[i + 1] !=  dice[i] + 1) {
				return false;
			}
		}
		return true;
	}
	
	private boolean checkSmallStraight(int[] dice) {
		int consecutiveCount = 0;
		if (dice[0] < 4) {
			if (checkLargeStraight(dice)) return true;
			for (int i = 0 ; i < N_DICE - 1; i++) {
				if (dice[i] == dice[i + 1]) {
					
				}
				else if (dice[i + 1] ==  dice[i] + 1) {
					consecutiveCount++;
					if (consecutiveCount == 3) return true;
				} else {
					consecutiveCount = 0;
				}
			}
		}
		return consecutiveCount >= 3;
	}
	
	private boolean checkFullHouse(int[] dice) {
		if (dice[0] == dice[4]) return false;
		if ((dice[0] == dice[1] && dice[1] == dice[2]) && dice[3] == dice[4] 
			|| (dice[0] == dice[1]) && dice[2] == dice[3] && dice[3] == dice[4]) {
				return true;
			}
		else return false;
	}
	
	private boolean checkYahtzee(int[] dice) {
		if (dice[0] == dice[4]) return true;
		return false;
	}
		
/* Private instance variables */
	private int nPlayers;
	private String[] playerNames;
	private YahtzeeDisplay display;
	private RandomGenerator rgen = new RandomGenerator();

}
