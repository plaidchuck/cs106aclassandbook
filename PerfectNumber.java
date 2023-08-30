/*This program identifies a perfect number based on the inputed integer using
 * a boolean/predicate method.
 * It then states if the number is perfect or not. A perfect number is a number
 * where the sum of its unique divisors equals itself.
 */

//import standard library
import acm.program.*;
//extends class for console output
public class PerfectNumber extends ConsoleProgram{
//start main method run
	public void run() {
//Inputs starting value of 1 for n
		int n = 1;
//sets for loop to check all numbers from 1 to 9999
		for (int i = 1; i <= 9999; i++) {
//sets if conditional to print that n is a perfect number if the isPerfect method
//returns true.
			if (isPerfect(n)) {
			println(n + " is a perfect number.");
			} 
//adds 1 to n to check the next number
			n++;
		}
	}
	
//sets private boolean method receiving int n from run method		
	private boolean isPerfect(int n) {
//sets int integer to 0
		int total = 0;
//sets for loop to run and add 1 to i until i reaches the n value 
		for (int i = 1; i < n; i++) {
//within for loop, sets conditional if to add i to total if n divided by i
//has no remainder and therefore is a divisor
			if (n % i == 0) {
				total += i;
			}
		}
//if the total of the divisors equal n, isPerfect returns a true flag
//otherwise it returns false
		if (total == n) {
			return true;
		} else {
			return false;
		}
	
	}
}
