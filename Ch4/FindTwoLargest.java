/* A program that reads integers until 0 is entered. Then the largest and
 * second largest values read are given.
 */

import acm.program.*;

public class FindTwoLargest extends ConsoleProgram {

//constant to end input
	private static final int SENTINEL = 0;

    public void run() {
//purpose of program and instructions
    	println("This program finds the two largest integers in a list.");
        println("Enter values, one per line, using 0 to signal the end of the list.");

//initializes variables to store largest and second largest values
        int largestNumber = 0;
        int secondLargest = 0;

//starts loop until sentinel is entered
        while (true) {
            int inputNumber = readInt("? ");

//ends loop when sentinel is entered and outputs largest and second largest values
            if (inputNumber == SENTINEL) {
                println("The largest value is " + largestNumber);
                println("The second largest value is " + secondLargest);
                break;
            } else {
//if input is larger than previous input, sets current largest as second largest
//and largest as most recent input
                if (inputNumber > largestNumber) {
                    secondLargest = largestNumber;
                    largestNumber = inputNumber;
//otherwise, check if input is greater than second largest and replace if true
                } else if (inputNumber > secondLargest) {
                    secondLargest = inputNumber;
                }
            }
        }
    }
}