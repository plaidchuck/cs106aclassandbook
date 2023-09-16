/*
 * A program to performe and display the Hailstone Sequence.
 */

import acm.program.*;

public class Hailstone extends ConsoleProgram {
	public void run() {
		setFont("Helvetica-15");
 //Read in a number: give me a number
		int n = readInt("Enter a number:");
//sets counter variable
		int counter = 0;
		//Perform this sequence until the number 1 is reached
		while (n > 1 ) {
//If the number is even, state current number and the result of performing
//the even number calculation
			if (n % 2 == 0) {
				println(n + " is even, so I take half: " + evenCalc(n));
				n = evenCalc(n);
//If the number is odd, state current number and the result of performing
//the odd number calculation
			} else {
				println(n + " is odd, so I make 3n + 1: " + oddCalc(n));
				n = oddCalc(n);
			}
//Increment counter for number of calculations
			counter++;
		}
//When 1 is reached, end program and report counter
		println("It took " + counter + " to reach 1");
	}
	
//Halve the even number and return value
	private int evenCalc(int n) {
		return n / 2;
	}
	
//Peform the 3n + 1 calculation on odd number and return value
	private int oddCalc(int n) {
		return (3 * n + 1);
	}
	
	
}

