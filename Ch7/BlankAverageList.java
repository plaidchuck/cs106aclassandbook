/* File: AddIntegerList.java
 * -------------------------
 * The program will average student grades that are inputed by the user.
 * As a zero grade is possible these grades must factor into the average.
 * The program then asks if the user wants to run the program again.
 */
	import acm.program.*;
	
	public class BlankAverageList extends ConsoleProgram {
		/* Specifies the value of the sentinel used to end
		 * the list of integers and break loops.  */
				
		public void run() {
			//Initialize input as an empty string
			String inputString = "";
			//Local terms variable initialized to calculate the number
			// of integers needed to find the average
			int terms = 0;
			//Local sum variable initialized for running sum of
			// the listed integers
			int sum = 0;
			//Lists purpose and instructions for program and then asks for integer
			//inputs for the grade variable
			println("This program averages a list of integers.");
			println("Enter values, one per line, pressing enter with no value ");
			println("to signal the end of the list.");
			// Initiates while loop that runs until a sentinel break
			while (true) {
				//Asks for input for grade variable as a String
				inputString = readLine(" ? ");
				//If blank line is given, exit loop
				if (inputString.equals("")) break;
				//The grade value for the loop is added to the sum variable
				int grade = Integer.parseInt(inputString);
				sum += grade;
				//The terms variable increments by 1 for each loop to count
				//the number of integers 
				terms ++;
		}
		/*
		 * If no values are entered and terms is 0, state that and end program.
		 * Otherwise, prints the output of the sum divided by number of terms.
		 */
		if (terms == 0) {
			println("No values entered.");
			} else {
				println("The total is " + sum / terms + ".");
			}
		//Asks the user if they want to run the program again and asks for 
		// an input for integer variable runagain.
		int runagain = readInt("Do you want to calculate another average? Enter 1 or 0: ");
		//If conditional returning to the run method if runagain is 1 
		if (runagain == 1) {
			run();
			} 
	}
}