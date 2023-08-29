/* 
* This program will take the floating point number pi (3.14)
* and return the calculation of the powers of it from -4 to 4.
*/

//imports standard library
import acm.program.*;
 
//sets class and extends for console ouput 
public class MiscJunk extends ConsoleProgram {
   
	//sets private method to with a double and integer variable
	private double raiseToIntPower(double n , int k) {
		//sets if loop if k parameter is negative
		if (k < 0) {
		//gives double variable of 1 divided by n to a negative power
		double result = (1 / (Math.pow(n, k)));
		//sends calculated result variable to main run method
		return result;
		//if k is not negative, just calculates n to the k power and
		//returns result to main run method
		} else {
			double result = (Math.pow(n, k));
			return result;
		}
	}
    
	//main run method
	public void run () {
        //sets n double variable to pi (3.14) 
		double n = 3.14;
        //sets for loop to run from -4 to 4 via the index variable
		//and uses this variable for the power argument to send to raiseToIntPower
		for (int i = -4; i < 5; i++) {
			//prints returned double variable result of the 
			//method after sending n and i
			println(raiseToIntPower(n, i));
         }
         
        
    }
}