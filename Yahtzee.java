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
		selectedCategories = new boolean[N_CATEGORIES];
		int turns = N_SCORING_CATEGORIES;
		while (turns > 0) {
			newTurn();
			turns--;
		}
		display.printMessage("You win with " + totalScore + " points.");
	}
	
	private void newTurn() {
		int[] dice = new int[N_DICE];
		dice = getFinalDiceRoll(dice);
		int categorySelection = getCategory(selectedCategories);
		int score = updateScore(dice, categorySelection);
		totalScore += score;
		display.updateScorecard(categorySelection, 1, score);
		display.updateScorecard(TOTAL, 1, totalScore);
	}
	
	private int updateScore(int[] dice, int categorySelection) {
		int score = 0;
		if (categorySelection < 7) {
			for (int i = 0; i < dice.length; i++) {
				if (dice[i] == categorySelection) {
					score += dice[i];
				}
			}
			return score;
		}
		else if (categorySelection == 15) {
			for (int i = 0; i < dice.length; i++) {
				score += dice[i];
				}
			return score;
			} 
		else {
			switch (categorySelection) {
				case 9: break;
				case 10: break;
				case 11: return checkFullHouse(dice);
				case 12: break;
				case 13: break;
				case 14: break;
				case 15: break;
				default: break;
				}
			return 10;
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
	
	private int[] getFinalDiceRoll (int[] dice) {
		int roll = 3;
		display.printMessage(playerNames[0] + "'s turn! Click the \"Roll Dice\" button to begin.");
		display.waitForPlayerToClickRoll(1);
		while (roll > 0) {
			if (roll == 3) {
				dice = rollDice();
				display.displayDice(dice);
			} else {
				display.printMessage("Select the dice you wish to re-roll and click \"Roll Again\"");
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
		dice = cheatMode();
		sortDice(dice);
		display.displayDice(dice);
		return dice;
	}
	
	private int getCategory(boolean[] selectedCategories) {
		int categorySelection;
		display.printMessage("Select a category for this roll");
		while (true) {
			categorySelection = display.waitForPlayerToSelectCategory();
			if (selectedCategories[categorySelection]) {
				display.printMessage("You already picked that category. Please choose another category");
			}
			else break;
		}
		selectedCategories[categorySelection] = true;
		return categorySelection;
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
	
	private int checkFullHouse(int[] dice) {
		if (dice[0] == dice[4]) return 0;
		if ((dice[0] == dice[1] && dice[1] == dice[2]) && dice[3] == dice[4] 
			|| (dice[0] == dice[1]) && dice[2] == dice[3] && dice[3] == dice[4]) {
				return 25;
			}
		else return 0;
	}
	
	private boolean checkYahtzee(int[] dice) {
		if (dice[0] == dice[4]) return true;
		return false;
	}
		
/* Private instance variables */
	private int nPlayers;
	private String[] playerNames;
	private boolean[] selectedCategories; // Determines if category was used already for scoring in a game
	private int totalScore; // Holds overall score for player in a game
	private YahtzeeDisplay display;
	private RandomGenerator rgen = new RandomGenerator();

}

