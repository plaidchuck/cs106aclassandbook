/*Write a program that simulates flipping a coin repeatedly and continues until three
consecutive heads are tossed. At that point, your program should display
 the total number of coin flips that were made. */

//imports for main program and RandomGenerator
import acm.program.*;
import acm.util.*;

public class CoinFlip extends ConsoleProgram {
	public void run() {
//sets integer variables to count flips and heads
		int flips = 0;
		int headflips = 0;
//sets loop until headflips count equals 3
		while (headflips < 3) {
//adds to flip count for each coin flip
		flips += 1;
//if flip is heads, outputs result adds to headflips counter and goes back to loop
			if (rgen.nextBoolean()) {
				println("Heads.");
				headflips += 1;
			} else {
//If flip is tails, outputs result and resets headflips counter 
				println("Tails.");
				headflips = 0;
			}
			
		}
//prints how many times it took to flip three heads
		println("It took " + flips + " flips to get three consecutive Heads.");
//asks for string input to run the program again or quit program
		String answer = readLine("Do you want to try again? Enter Yes or No: ");
		if (answer.equalsIgnoreCase("Yes")) { 
			run();
		} 
		exit();
	}
	
//instance variable for RandomGenerator objects
	private RandomGenerator rgen = RandomGenerator.getInstance();
}
