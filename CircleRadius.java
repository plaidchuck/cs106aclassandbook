import acm.program.* ;

/* Ask for the radius and then calculate A = pi r 2(squared) */

public class CircleRadius extends ConsoleProgram {
	public void run() {
		println("This program calculates the area of a circle 'A' ");
		double r = readDouble("Radius: ");
		double a = PI * (r * r);
		println("Area of circle: " + a);
		
	}
	
	private static final double PI = 3.14;
 	
}
