/*
 * File: DigitSum.java
 * -------------------
 * This program reverses the number order for a positive integer. (e.g. 1729 ->
 * 9271. 
 */

import acm.program.*;

// Class extended from ConsoleProgram that inputs and outputs through text
	public class DigitSum extends ConsoleProgram {

// Main method named run()
		public void run() {
			//Initializes the digits sum variable and assigns that as 0
			int reverseinteger = 0;
			//Outputs text statement of purpose of the program
			println("This program reverse the digits in an integer.");
			//Asks user for integer input and assigns that to n
			int n = readInt("Enter a positive integer: ");
			// While loop initialized and keeps running while n is greater than
			// zero 
			while (n > 0) {
			//reverse integer value is multiplied by 10 each time and this
			// product is added to the remainder of n
			//The remainder will add the digits in the correct order
			// while the multiplication makes sure the reverse number is in the
			//	proper decimal position.
			reverseinteger = (reverseinteger * 10) + (n % 10);
			// n is the quotient of n / 10 for the while loop counter
			n /=  10;
			}
			
		// outputs that the sum of the integer digits is equal to reverseinteger
		//	integer variable
		println("The reversed number is " + reverseinteger);
		
		//Asks for input "1" or "0" for again variable
		// and runs the program again if 1 and stops
		// the program if 0 or any other number
		int again = readInt("Again? ");
		if (again== 1) {
			run();
		}  else {
			exit();
			}
		
	}
}