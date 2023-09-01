/*Write a program that simulates flipping a coin repeatedly and continues until three
consecutive heads are tossed. At that point, your program should display
 the total number of coin flips that were made. */

//imports for main program and RandomGenerator
import acm.program.*;
import acm.util.*;

public class CoinFlip extends ConsoleProgram {
	public void run() {
//sets integer variables to count flips
		int flips = 0;
//sets indefinite loop until three heads appear
		while (true) {
//sets nested if/else statements to count each flip and if rgen returns true
//will print as heads and if it is false as tails. If three heads in a row
//appear then the loop ends
			if (rgen.nextBoolean()) {
				flips += 1;
				println("Heads.");
				if (rgen.nextBoolean()) {
					flips += 1;
					println("Heads.");
					if (rgen.nextBoolean()) {
						flips += 1;
						println("Heads.");
						break;
					} else {
						flips += 1;
						println("Tails.");
					}
				} else {
					flips += 1;
					println("Tails.");
				}
			} else {
				flips +=1;
				println("Tails.");
			}
		}
//prints how many times it took to flip three heads
		println("It took " + flips + " flips to get three consecutive Heads.");
//asks for string input to run the program again or quit program
		String answer = readLine("Do you want to try again? Enter Yes or No: ");
		if (answer.equals("Yes")) { 
			run();
		} 
		exit();
	}
	
//instance variable for RandomGenerator objects
	private RandomGenerator rgen = RandomGenerator.getInstance();
}
