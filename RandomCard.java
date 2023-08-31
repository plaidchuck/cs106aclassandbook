/*
 * File: RandomCard.java
 * -------------------
 * This program generates a random card out of
 * a standard 52 card deck which includes 4 suits and 13 card ranks.
 */

//For RandomGenerator objects
import acm.util.*;
import acm.program.*;

//extends for console output
public class RandomCard extends ConsoleProgram {
	//constants for number of card ranks and suits
	private static final int RANKS = 13;
	private static final int SUITS = 4;
//runs program
	public void run() {
//state purpose of program
		println("This program displays a randomly chosen card.");
//generates card rank and suit values
		int rank = rgen.nextInt(1, RANKS);
		int suit = rgen.nextInt(1, SUITS);
//prints string if rank integer is 1 or 11-13
		switch (rank) {
		case 1: print("Ace of "); break;
		case 11: print("Jack of "); break;
		case 12: print("Queen of "); break;
		case 13: print("King of "); break;
		default: print(rank + " of "); break;
		}
//prints string of card suit
		switch (suit) {
		case 1: print("Clubs"); break;
		case 2: print("Spades"); break;
		case 3: print("Diamonds"); break;
		case 4: print("Hearts"); break;
		}
	}
	
	//constructor for RandomGenerator and instance variable
	private RandomGenerator rgen = RandomGenerator.getInstance();
}

