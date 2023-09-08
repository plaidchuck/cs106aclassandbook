/*Write a ConsoleProgram that reads in a list of integers, one per line, until a sentinel
value of 0 (which you should be able to change easily to some other value). When the
sentinel is read, your program should display the smallest and largest values in the
list
 */

import acm.program.*;

public class FindRange extends ConsoleProgram {

//sets constant value to stop asking for input and end the program
private static final int SENTINEL = 0;


	public void run() {
//state purpose of program
		println("This program finds the largest and smallest numbers.");
//ask for for first input number
		int inputNumber = readInt("? ");
//sets smallest and largest number as the first input number
		int smallNumber = inputNumber;
		int largeNumber = inputNumber;
//sets indefinite loop until a break is specified
		while (true) {
//if the first number entered is the sentinel, the small and large number values
//are checked for this and the program ends with no valid values entered
			if ((smallNumber == SENTINEL) && (largeNumber == SENTINEL)) {
			println("No values entered");
			break;
			} else {
//if the number is not the sentinel, ask for the next number
				inputNumber = readInt("? ");
//if the next entered number is the sentinel, output the largest and smallest number
//values which will be the first number entered, end program
				if (inputNumber == SENTINEL) {
					println("Largest: " + largeNumber);
					println("Smallest: " + smallNumber);
					break;
/*
*	the next entered number is then checked each loop to see if it is larger or smaller
*	than the current value of the large and small number variables. If so, the variables
*	are replaced until the sentinel is entered and the loop ends with the output
*	of the largest and smallest numbers.
*/
					} else {
						if (inputNumber > largeNumber) {
							largeNumber = inputNumber;
						} else {
							if (inputNumber < smallNumber) {
								smallNumber = inputNumber;
							}
					}
				}
			} 		
		}	
	}
}
