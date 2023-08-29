//imports standard library
import acm.program.*;

//sets class with console output
public class DigitSum2 extends ConsoleProgram {
//run main method
	public void run() {
//Asks for input of a positive integer		
		int n = readInt("Enter a positive integer: ");
//Prints the result of the nDigits method inputed with int n		
		println("The total numbers of digits in " + n + " is: " + nDigits(n));
		
	}

//Sets method that receives n from run method	
	private int nDigits(int n) {
//sets total variable
		int total = 0;
//sets while loop to keep running while n is greatr than zero		
		while (n > 0) {
//Adds 1 to total variable for each loop run
			total += 1;
//Divides n by 10 per loop in order to count the number of digits in integer
			n /= 10;
			}
//After loop completes, sends total variable back to main run method
		return total;
	}
}