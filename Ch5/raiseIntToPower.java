/*
 * A program to return the value of n to the k power.
 * Displays a table of all values of n ^ 0 to n ^ 10.
 */

import acm.program.*;

public class raiseIntToPower extends ConsoleProgram{

//sets constants to change values of n and k
	private static final int N = 2;

	private static final int K = 10;
	
	public void run() {
//calculate and print each power of n to i
		for (int i = 0; i <= K; i++) {
			println((int)Math.pow (N, i));
			}
		}
}
