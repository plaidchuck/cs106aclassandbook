/* this program will actually calculate the quadratic equation given
* three values for a, b, and c, via the user console. As per the exercise instructions,
* if the square root value in the formula is zero then the program will end
* with no real solution. Otherwise the two root solutions for the formula
* will be given. */

//imports program library
import acm.program.*;
//Class is extended to ConsoleProgram for text output and the run method begins
public class GoldenRatio extends ConsoleProgram {
	public void run() {
	//prints instructions to user
		println("Enter coefficients for the quadratic equation:");
	//Prompts users for three inputs for the values a,b, and c of the equation
		int a = readInt("a (Non-zero number: ");
		int b = readInt("b: ");
		int c = readInt("c: ");
	//Checks if the squareroot is zero and if so, kills program.
	//If not zero, continues program and calculation of the formula
		if  ((b * b) - (4 * a * c) < 0) {
			println("Based on those coefficients, there are no real solutions. Bye!");
		} else {
		//Sets d as an integer of the result of squaring b^2 - 4ac
			int d = (int) Math.sqrt ((b * b) - (4 * a * c));
		//sets integers of each +/- solution to the formula
			int x1 = (-b + d) / 2 * a;
			int x2 = (-b - d) / 2 * a;
		//Prints the solution for x1 and x2 integer
			println("The first solution is " + x1);
			println("The second solution is " + x2);
		
		}
		
		
	}
	
	
}

