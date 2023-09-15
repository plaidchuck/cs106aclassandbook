import acm.program.*;
import acm.util.*;


public class SlotMachine extends ConsoleProgram {

//set starting wallet amount and instance variable to be changed
private static final int MONEY = 50;
private int wallet = MONEY;

	public void run() {
//		rgen.setSeed(1);
//Asks user if they want instructions and lists winning slot combos and payout
		String instructions = readLine("Would you like instructions? " );
		if (instructions.equalsIgnoreCase("yes")) {
			println("BAR	BAR 	BAR 	 pays $250");
			println("BELL	BELL	BELL/BAR 	pays $20");
			println("PLUM	PLUM	PLUM/BAR 	pays $14");
			println("ORANGE	ORANGE	ORANGE/BAR  pays $10");
			println("CHERRY	CHERRY	CHERRY	pays $7");
			println("CHERRY	CHERRY	----	pays $5");
			println("CHERRY	----	----	pays $2");
		}
//set variable to add/subtract to wallet
//set while loop to allow continued playing until no money is left
		while (wallet > 0) {
//asks whether to spin again or stop playing
			String playOrStop = readLine("You have $" + wallet + ", would you like to play? ");
			if (playOrStop.equalsIgnoreCase("yes")) {
//takes $1 to play
				wallet--;
//generate three slot symbols
				spinWheels();
			} else {
//ends loop and program if user does not continue playing
				break;
			}
		}
//if the player is out of money, ends program
		if (wallet == 0) println("Out of money!");
	}

//method to convert integers to symbols for the slot wheels
	private void spinWheels() {
		String firstSlot = makeSymbols(rgen.nextInt(1, 6));
		String secondSlot = makeSymbols(rgen.nextInt(1, 6));
		String thirdSlot = makeSymbols(rgen.nextInt(1, 6));
		print(firstSlot + "    " + secondSlot + "    " + thirdSlot + " -- ");
		getResult(firstSlot, secondSlot, thirdSlot);
		

	}
//takes the results of the three slot wheels and determines if
//the symbol combination is a winner, if so it adds the appropriate payout to the
//players wallet
	private void getResult (String firstSlot, String secondSlot, String thirdSlot) {
		if (firstSlot.equals("BAR") && secondSlot.equals("BAR") && thirdSlot.equals("BAR")) {
			println("You win $250");
			wallet += 250;
		} else if (firstSlot.equals("BELL") && secondSlot.equals("BELL") & thirdSlot.equals("BELL")) {
					println("You win $20");
					wallet += 20;
		} else if (firstSlot.equals("BELL") && secondSlot.equals("BELL") & thirdSlot.equals("BAR")) {
					println("You win $20");
					wallet += 20;
		} else if (firstSlot.equals("PLUM") && secondSlot.equals("PLUM") & thirdSlot.equals("PLUM")) {
					println("You win $14");
					wallet += 14;
		} else if (firstSlot.equals("PLUM") && secondSlot.equals("PLUM") & thirdSlot.equals("BAR")) {
					println("You win $14");
					wallet += 14;
		} else if (firstSlot.equals("ORANGE") && secondSlot.equals("ORANGE") & thirdSlot.equals("ORANGE")) {
					println("You win $10");
					wallet += 10;
		} else if (firstSlot.equals("ORANGE") && secondSlot.equals("ORANGE") & thirdSlot.equals("BAR")) {
					println("You win $10");
					wallet += 10;
		} else if (firstSlot.equals("CHERRY") && secondSlot.equals("CHERRY") & thirdSlot.equals("CHERRY")) {
					println("You win $7");
					wallet += 7;
		} else if (firstSlot.equals("CHERRY") & secondSlot.equals("CHERRY")) {
					println("You win $5");
					wallet += 5;
		} else if (firstSlot.equals("CHERRY")) {
					println("You win $2");
					wallet += 2;
//outputs if no winning combination was generated
														} else {
															println("You lose");
														}
												}
	
		 
		
	
//converts the random generated int to a string representing slot symbol
	private String makeSymbols (int slot) {
		switch(slot) {
		case 1: return "BAR";
		case 2: return "BELL";
		case 3: return "PLUM";
		case 4: return "ORANGE";
		case 5: return "CHERRY";
		case 6: return "LEMON";
		default: return "";
		}
	}
	
//random number generator instance variable
private RandomGenerator rgen = RandomGenerator.getInstance();
}
