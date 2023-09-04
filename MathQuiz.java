/* As an example of an educational application, write a program that poses a series of
simple arithmetic problems for a student to answer*/

//imports required libraries
import acm.program.*;
import acm.util.*;

//extends for console output
public class MathQuiz extends ConsoleProgram {

//sets constant for how many questions are asked, 
// how many retries are allowed and the number limits for problem answers	
//to ensure no addition problem answer is above 20 and no subtraction one is below 0
private static final int NUM_PROBLEMS = 5;
private static final int MAX_SUM = 20;
private static final int MIN_SUM = 0;
private static final int TRIES = 3;

public void run() {
//states program purpose
	println("Welcome to Math Quiz");
//generates random boolean to decide between addition and subtraction problem
//and asks the number of problems set by constant
	for (int i = 0; i < NUM_PROBLEMS; i++) {
		if (rgen.nextBoolean()) {
			askAdditionQuestion();
			} else {
				askSubtractionQuestion();
				}
	}
}

//private instance variables
/*Generates an addition problem of two numbers in the range specified by the constants
 * and displays them. Then it asks the user to answer the question and provides feedback.
 */
private void askAdditionQuestion() {
	int firstNumber = rgen.nextInt(MIN_SUM, MAX_SUM);
	int secondNumber = rgen.nextInt(MIN_SUM, MAX_SUM);
	int correctAnswer = (firstNumber + secondNumber);
	if (correctAnswer > MAX_SUM) {
		askAdditionQuestion();
		} else {
			int tryCounter = TRIES;
			//asks for user input to answer the problem and confirms answer or says it is wrong
			while (tryCounter > 0) {
				int userAnswer = readInt("What is " + firstNumber + " + " + secondNumber + "? ");
					if (userAnswer == correctAnswer) {
						println(congratsRandomizer());
						break;
						} else { 
//s counter that keeps track of how many retries are left for the answer
							tryCounter--;
							if (tryCounter == 0) {
								println("That's incorrect - the answer is: " + correctAnswer);
							} else {
								println("That's incorrect - try a different answer. ");
							}
						}
				}
			}
	}



/* Generates a subtraction problem of two numbers in the range specified by the constants
 * and displays them. Then it asks the user to answer the question and provides feedback.
 */
private void askSubtractionQuestion() {
	int firstNumber = rgen.nextInt(MIN_SUM, MAX_SUM);
	int secondNumber = rgen.nextInt(MIN_SUM, MAX_SUM);
	int correctAnswer = firstNumber - secondNumber;
	if (correctAnswer < MIN_SUM) {
		askSubtractionQuestion();
		} else {
//asks for user input to answer the problem and confirms answer or says it is wrong
			int tryCounter = TRIES;
			while (tryCounter > 0) {
			int userAnswer = readInt("What is " + firstNumber + " - " + secondNumber + "? ");
				if (userAnswer == correctAnswer) {
					println(congratsRandomizer());
					break;
					} else {
						tryCounter--;
						if (tryCounter == 0) {
							println("That's incorrect - the answer is: " + correctAnswer);
						} else {
							println("That's incorrect - try a different answer. ");
						}
					}
			}
		}
}

//a switch method that displays one of four different congratulatory responses for
//answering a question correctly
private String congratsRandomizer() {
	int kudos = rgen.nextInt(4);
	switch (kudos) {
	case 0: return "Fuck yeah!"; 
	case 1: return "You got it!"; 
	case 2: return "Correct!";
	case 3: return "That's the answer!";
	default: return "Correct!"; 
	}
}


//initiates random number object
private RandomGenerator rgen = RandomGenerator.getInstance();
}
