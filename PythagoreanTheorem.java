/*
 * File: PythagoreanTheorem.java
 * A program to compute c of the Pythagorean Theorem: a^2 + b^2 = c^2
 */

import acm.program.*;

//extends program to the console output
public class PythagoreanTheorem extends ConsoleProgram {
	public void run() {
//state program purpose and instructions
	println("Enter values to compute Pythagorean Theorem");
//asks for user input of a and b
	int a = readInt("a: ");
	int b = readInt("b: ");
//compute inputed values via Calculate method and print them
	println ("c = " + Calculate(a, b));
	}
	
//calculates theorem using math object to square (a^2 + b^2)
	private double Calculate(int a, int b) {
		double c = Math.sqrt((a * a) + (b * b));
		return c;
	}
}
