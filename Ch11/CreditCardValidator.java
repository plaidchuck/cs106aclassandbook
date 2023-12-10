import acm.program.*;
import java.util.*;

public class CreditCardValidator extends ConsoleProgram {
	public void run() {
		String creditCardNumber = "";
		ArrayList<Integer> digits = new ArrayList<Integer>(); 	
		creditCardNumber = inputCardNumber();
		// add each digit of number to array
		for (int i = 0; i < creditCardNumber.length(); i++) {
			digits.add(Character.getNumericValue(creditCardNumber.charAt(i)));
		}
		if (passesChecksum(digits)) {
			identifyCardIssuer(digits);
		} else {
			println("INVALID");
		}
	}
	
	/*
	 * If checksum passes, checks if the number is valud for an issuer
	 * based on the number of digits and starting digits
	 */
	private void identifyCardIssuer(ArrayList<Integer> digits) {
		String firstTwoDigits = "" + digits.get(0) + digits.get(1); 
		if(isMastercard(digits, firstTwoDigits)) {
			println("MASTERCARD");
		} 
		else if (isAmex(digits, firstTwoDigits)) {
			println("AMEX");
		}
		else if (isVisa(digits, firstTwoDigits)) {
			println("VISA");
		} else {
			println("INVALID");
		}
	}
	
	private boolean isVisa(ArrayList<Integer> digits, String firstTwoDigits) {
		return (digits.size() == 13 || digits.size() == 16)
				&& firstTwoDigits.startsWith("4");
	}
	
	private boolean isAmex(ArrayList<Integer> digits, String firstTwoDigits) {
		return (digits.size() == 15 && (Integer.parseInt(firstTwoDigits) == 34
				|| Integer.parseInt(firstTwoDigits) == 37));
	}
	
	private boolean isMastercard(ArrayList<Integer> digits, String firstTwoDigits)
	{
		return (digits.size() == 16 && (Integer.parseInt(firstTwoDigits) > 50 
				&& Integer.parseInt(firstTwoDigits) < 56 ));
	}
	
	
	/*
	 * Determines if number in array passes credit card checksum
	 */
	private boolean passesChecksum(ArrayList<Integer> digits) {
		int oddOrEvenDigitCounter = 0;
		int evenDigitSum = 0;
		int oddDigitSum = 0;
		for (int i = digits.size() - 1; i >= 0; i--  ) {
			int currentDigit = digits.get(i);
			if (oddOrEvenDigitCounter % 2 == 0) {
				evenDigitSum += currentDigit;
			} else {
				oddDigitSum += processOddDigit(currentDigit);
			}
			oddOrEvenDigitCounter++;
		}
		int digitsTotal = evenDigitSum + oddDigitSum;
		return digitsTotal % 10 == 0;
	}
	
	private int processOddDigit(int digit) {
		if (2 * digit > 9) {
			return splitTwoDigits(2 * digit);
		} else {
			return 2 * digit;
		}
	}
	
	
	/*
	 * Takes card number input from user and rejects any input
	 * that has any non integer digits
	 */
	private String inputCardNumber() {
		String number = "";
		while (true) { //Keep prompting for number if input contains non integer digit
			number = readLine("Number? ");
			if(containsAllDigits(number)) {
				break;
			}
		}
		return number;
	}
	
	/*
	 * Return false if any non integer digit is found in String
	 */
	private boolean containsAllDigits(String input) {
		if (input.equals("")) return false;
		for (int i = 0; i < input.length(); i++) {
			if (!Character.isDigit(input.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	
	/*
	 * Helper splits tens number into two digits and adds them together
	 */
	private int splitTwoDigits(int number) {
		int sum = 0;
		while (number > 0) {
			sum += number % 10;
			number /= 10;
		}
		return sum;
	}
}

	