/*
 * File: AddIntegerList.java
 * -------------------------
 * The program will average student grades that are inputed by the user.
 * As a zero grade is possible these grades must factor into the average.
 * The program then asks if the user wants to run the program again.
 */
	import acm.program.*;
	
	public class AverageList extends ConsoleProgram {
		/* Specifies the value of the sentinel used to end
		 * the list of integers and break loops.  */
		private static final int SENTINEL = -1;
		/* Runs the method run */
		
		public void run() {
			//Local terms variable initialized to calculate the number
			// of integers needed to find the average
			int terms = 0;
			//Local sum variable initialized for running sum of
			// the listed integers
			int sum = 0;
			//Lists purpose and instructions for program and then asks for integer
			//inputs for the grade variable
			println("This program averages a list of integers.");
			println("Enter values, one per line, using " + SENTINEL);
			println("to signal the end of the list.");
			// Initiates while loop that runs until a sentinel break
			while (true) {
				//Asks for input for grade variable
				int grade = readInt(" ? ");
				//If sentinel constant is given, ends loop
				if (grade == SENTINEL) break;
				//The grade value for the loop is added to the sum variable
				sum += grade;
				//The terms variable increments by 1 for each loop to count
				//the number of integers 
				terms ++;
		}
		//Prints the output of the sum divided by number of terms (average)
		println("The total is " + sum / terms + ".");
		//Asks the user if they want to run the program again and asks for 
		// an input for integer variable runagain.
		int runagain = readInt("Do you want to calculate another average? Enter 1 or 0: ");
		//If conditional returning to the run method if runagain is 1 
		if (runagain == 1) {
			run();
			} 
	}
}