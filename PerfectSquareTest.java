//imports standard library
import acm.program.*;

//extends class for console output and runs main run method
public class PerfectSquareTest extends ConsoleProgram {
	public void run() {
//asks for input for the n integer variable and states program purpose
		int n = readInt("Enter an integer to see if it's a perfect square: ");
//sets if condition to make call with the n value to see if it is a perfect square
		if (isPerfectSquare(n)) {
//if condition is true, prints message stating that n is a perfect square
			println(n + " is indeed a perfect square.");
//otherwise, prints a message stating that n is not a perfect square			
		} else {
			println(n + " is NOT a perfect square.");
		}
	}
		
//sets method to determine if the inputed n integer is a perfect square
//and returns this condition as a boolean variable
	private boolean isPerfectSquare(int n) {
//sets squareroot variable  as an integer from the square root of n
		double squareroot = Math.sqrt(n);
//returns boolean value of dividing n by squareroot and determining if this
//value is 0 (there are no remainders)
		return (n % squareroot == 0);
			
		}
	
}
