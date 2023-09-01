/*Write a program that simulates throwing 10,000 darts and then uses the simulation
technique described in this exercise to generate and display an approximate value of
pi. */

//imports standard library and util for randomgenerator
import acm.program.*;
import acm.util.*;

//extends ConsoleProgram for text output
public class PiApproximation extends ConsoleProgram {
	
//Sets the number of thrown darts constant
private static final int NUMDARTS = 10000;

	public void run() {
//sets inside int for number of darts in circle
		int inside = 0;
//sets for loop to "throw" darts up to the constant number
		for (int i =0; i < NUMDARTS; i++) {
//generates x and y coordinates randomly as a double between -1 and 1
			double x = rgen.nextDouble(-1.0, +1.0);
			double y = rgen.nextDouble(-1.0, +1.0);
//checks if coordinates are inside circle by using (x * x) + (y + y) < 1 formula
//if so, adds to inside count
			if (((x * x) + (y * y)) < 1.0) {
				inside++;
			}
	}
//calculates the value of pi using formula (4 * inside darts) / Number of outside
//darts, which are the same as the attempts in the constant
		double pi = (4.0 * inside) / NUMDARTS;
		println("Pi is approximately " + pi + ".");
		
	}
	
//initialize RandomGenerator for instance variables
private RandomGenerator rgen = RandomGenerator.getInstance();
	
}
