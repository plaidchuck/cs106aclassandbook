/*
* File: Fibonacci.java
* --------------------
* This program lists the terms in the Fibonacci sequence up to
* 10000, which is the largest Fibonacci term
* the program will display.
*/

//imports program library
import acm.program.*;

//extends class to text output and starts run method
	public class NewFibonacci extends ConsoleProgram {
		public void run() {
//sets integer n to 0 for first sequence to send to fibonacci method		
			int n = 0;
//sets while loop to run while the result of the fiboncacci sequence calculation
//remains under 10000
			while ((fibonacci(n)) < 10000) {
//prints sequence calculation for n
				println (fibonacci(n));
//adds 1 to n to move to next number in sequence
				n++;
			}
		}

//sets method to calculate fibonacci number based on sequence number from n
		private int fibonacci(int n) {
//sets a b c integers to begin calculating the number for n sequence
			int a = 0, b = 1, c;
//as the first number in the sequence is zero, returns a with 0  value
			if (n == 0)
	            return a;
//calculates non zero sequence value of n using a b c variables
	        for (int i = 2; i <= n; i++) {
	            c = a + b;
	            a = b;
	            b = c;
	        }
//returns result of calculation
	        return b;
		}
}