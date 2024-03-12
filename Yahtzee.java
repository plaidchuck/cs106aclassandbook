/*
 * File: Yahtzee.java
 * ------------------
 * This program will eventually play the Yahtzee game.
 */


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
		selectCategories = new boolean[nPlayers][N_CATEGORIES];
		scores = new int[nPlayers][3];
		int round = N_SCORING_CATEGORIES;
		while (round > 0) {
		for (int currentPlayer = 0; currentPlayer < nPlayers; currentPlayer++){
			newTurn(currentPlayer);
		}
			round--;
		}
		display.printMessage("You win with " + scores[nPlayers - 1][0] + " points.");
	}
	
	private void newTurn(int currentPlayer) {
		int[] dice = new int[N_DICE];
		dice = getFinalDiceRoll(dice, currentPlayer);
		int categorySelection = getCategory(selectCategories, currentPlayer);
		int score = updateScore(dice, categorySelection, currentPlayer);
		scores[currentPlayer][0] += score;
		display.updateScorecard(categorySelection, currentPlayer + 1, score);
		display.updateScorecard(TOTAL, currentPlayer + 1, scores[currentPlayer][0]);
	}
	
	private int updateScore(int[] dice, int categorySelection, int currentPlayer) {
		int score = 0;
		if (categorySelection < 7) {
			for (int i = 0; i < dice.length; i++) {
				if (dice[i] == categorySelection) {
					score += dice[i];
				}
			}
			scores[currentPlayer][1] += score;
			return score;
		}
		else if (categorySelection == 15) {
			for (int i = 0; i < dice.length; i++) {
				score += dice[i];
				}
			scores[currentPlayer][1] += score;
			return score;
			} 
		else {
			switch (categorySelection) {
				case 9: return checkThreeOfAKind(dice, currentPlayer);
				case 10: return checkFourOfAKind(dice, currentPlayer);
				case 11: return checkFullHouse(dice, currentPlayer);
				case 12: return checkSmallStraight(dice, currentPlayer);
				case 13: return checkLargeStraight(dice, currentPlayer);
				case 14: return checkYahtzee(dice, currentPlayer);
				default: return 0;
				}
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
	
	private int[] getFinalDiceRoll (int[] dice, int currentPlayer) {
		int roll = 3;
		display.printMessage(playerNames[currentPlayer] + "'s turn! Click the \"Roll Dice\" button to begin.");
		display.waitForPlayerToClickRoll(currentPlayer + 1);
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
	//	dice = cheatMode();
		sortDice(dice);
	//	display.displayDice(dice);
		return dice;
	}
	
	private int getCategory(boolean[][] selectCategories, int currentPlayer) {
		int categorySelection;
		display.printMessage("Select a category for this roll");
		while (true) {
			categorySelection = display.waitForPlayerToSelectCategory();
			if (selectCategories[currentPlayer][categorySelection]) {
				display.printMessage("You already picked that category. Please choose another category");
			}
			else break;
		}
		selectCategories[currentPlayer][categorySelection] = true;
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
	
	private int checkThreeOfAKind(int[] dice, int currentPlayer) {
		int score = 0;
		if (dice[0] == dice[2] || dice[1] == dice[3] || dice[2] == dice[4])  {
			for (int i = 0; i < dice.length; i++) {
				score += dice[i];
			}
		}
		scores[currentPlayer][2] += score;
		return score;
	}
	
	private int checkFourOfAKind(int[] dice, int currentPlayer) {
		int score = 0;
		if (dice[0] == dice[3] || dice[1] == dice[4]) {
			for (int i = 0; i < dice.length; i++) {
				score += dice[i];
			}
		}
		scores[currentPlayer][2] += score;
		return score;
	}
	
	private int checkLargeStraight(int[] dice, int currentPlayer) {
		for (int i = 0 ; i < N_DICE - 1; i++) {
			if (dice[i + 1] !=  dice[i] + 1) {
				return 0;
			}
		}
		scores[currentPlayer][2] += 40;
		return 40;
	}
	
	private int checkSmallStraight(int[] dice, int currentPlayer) {
		int consecutiveCount = 0;
		if (dice[0] < 4) {
			for (int i = 0 ; i < N_DICE - 1; i++) {
				if (dice[i] == dice[i + 1]) {
					
				}
				else if (dice[i + 1] ==  dice[i] + 1) {
					consecutiveCount++;
					if (consecutiveCount == 3) {
						scores[currentPlayer][2] += 30;
						return 30;
					}
				} else {
					consecutiveCount = 0;
				}
			}
		}
		if (consecutiveCount >= 3) {
			scores[currentPlayer][2] += 30;
			return 30;
		}
		else return 0;
	}
	
	private int checkFullHouse(int[] dice, int currentPlayer) {
		if (dice[0] == dice[4]) return 0;
		if ((dice[0] == dice[1] && dice[1] == dice[2]) && dice[3] == dice[4] 
			|| (dice[0] == dice[1]) && dice[2] == dice[3] && dice[3] == dice[4]) {
			scores[currentPlayer][2] += 25;
				return 25;
			}
		else return 0;
	}
	
	private int checkYahtzee(int[] dice, int currentPlayer) {
		if (dice[0] == dice[4]) { 
			scores[currentPlayer][2] += 50;
			return 50;
		}
		return 0;
	}
		
/* Private instance variables */
	private int nPlayers;
	private String[] playerNames;
	private boolean[][] selectCategories; // An array for each player to determine if category already played
	private int[][] scores; // An array for each player consisting of the total, upper, lower score
	private YahtzeeDisplay display;
	private RandomGenerator rgen = new RandomGenerator();

}
