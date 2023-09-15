/* As an example of an educational application, write a program that poses a series of
simple arithmetic problems for a student to answer*/

//imports required libraries
import acm.program.*;
import acm.util.*;

//extends for console output
public class MathQuiz extends ConsoleProgram {

//sets constant for how many questions are asked, 
// how many retries are allowed and the range for correct answers	
//to ensure no addition problem answer is above 20 and no subtraction one is below 0
private static final int NUM_PROBLEMS = 5;
private static final int MAX_SUM = 20;
private static final int MIN_SUM = 0;
private static final int TRIES = 3;

public void run() {
//states program purpose
	println("Welcome to Math Quiz");
	println("You have three tries per question.");
//Sets for loop to ask specified number of questions
//Determines operation and generates question
	for (int i = 0; i < NUM_PROBLEMS; i++) {
		askQuestion(checkOperation());
	}
}

//determines operation for question and returns result to generate questions
private String checkOperation() {
	String operation;
	if (rgen.nextBoolean()) {
		operation = "+";
	} else {
		operation = "-";
	}
	return operation;
}

//Receives type of operation for question and generates question and checks the
//answer
private void askQuestion(String operation) {
//sets variables for numbers in question depending on the operation type
	int firstNumber = rgen.nextInt(MIN_SUM, MAX_SUM);
	int secondNumber = operation.equals("+") ? 	rgen.nextInt(MIN_SUM, MAX_SUM - firstNumber) : rgen.nextInt(MIN_SUM, firstNumber);
	int correctAnswer = operation.equals("+") ? firstNumber + secondNumber : firstNumber - secondNumber;
//sets counter for tries after a wrong answer and sets indefinite loop until
//the counter is reached
	int tryCounter = TRIES;
	while (tryCounter > 0) {
	int userAnswer = readInt("What is " + firstNumber + (operation.equals("+") ? " + " : " - "  ) + secondNumber + "? ");
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

//generates a random kudos response upon input of correct answer
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
