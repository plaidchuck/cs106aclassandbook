import acm.program.*;

public class NumberToWords extends ConsoleProgram {

	public void run() {
		
/*
* Asks for a number indefinitely unless -1 is entered.
* Checks if user enters 0 by itself, otherwise goes to 
* number "translation" method
* 
*/	
		while (true) {
			int n = readInt("Enter a number: ");
			if (n == -1) break;
			if (n == 0) println("zero");
			else println(numberToWords(n));			
		}
	}
	
/*
 * Maps words to the Strings and returns them based on which range the
 * number falls into. 1-9  and 10 - 19 get their own mapping as they are unique
 */
	
	private String numberToWords(int n) {
		if (n < 10) return getOnes(n);
		else if (n > 9 && n < 20) return getTeens(n);
		else if (n >= 20 && n < 100) {
			return breakdownTens(n);
		}
		else if (n >= 100 && n < 1000) {
			return breakdownHundreds(n);
		}
		else if (n >= 1000 && n < 10000) {
			return breakdownThousands(n);
		}
		else if (n >= 10000 && n < 100000) {
			return breakdownTenThousands(n);
		}
		else if (n >= 100000 && n < 1000000) {
			return breakdownHundredThousands(n);
		}
		else return null;
	}
	
	private String breakdownTens(int n) {
		if (n > 9 && n < 20) return getTeens(n);
		else if (n > 0 && n < 10) return getOnes(n);
		int tens = (n / 10) * 10;
		int ones = (n % 10);
		if (n < 10) return getOnes(ones);
		else return getTens(tens) + " " + getOnes(ones);
	}
	
	private String breakdownHundreds(int n) {
		if (n == 0) return "";
		else if (n > 9 && n < 20) return getTeens(n);
		else if (n > 0 && n < 10) return getOnes(n); 
		else if (n >= 20 && n < 100) return breakdownTens(n);
		int hundreds = (n / 100);
		int tens = (n % 100);
		return getOnes(hundreds) + " hundred " + breakdownTens(tens);
	}
	
	
	private String breakdownThousands(int n) {
		int thousands = (n / 1000);
		int hundreds = (n % 1000);
		if (hundreds == 0 ) return getOnes(thousands) + " thousand";
		
		else if (hundreds > 0 && hundreds < 100 ) {
			return getOnes(thousands) + " thousand " + breakdownTens(hundreds);
		}
		
		else return getOnes(thousands) + " thousand " + breakdownHundreds(hundreds);
	}
	
	private String breakdownTenThousands(int n) {
		int tenThousands = (n / 1000);
		int thousands = (n % 1000);
		return breakdownTens(tenThousands) + " thousand " + breakdownHundreds(thousands); 
	}

	private String breakdownHundredThousands(int n) {
		int hundredThousands = (n / 1000);
		int hundreds = (n % 1000);
		return breakdownHundreds(hundredThousands) + " thousand " + breakdownHundreds(hundreds);
	}
/*
 * Returns numbers 1 - 9, for single digit numbers, the ending of two digit
 * numbers, and for the "header" number on thousands and hundreds.
 */
	
	private String getOnes(int n) {
		
		switch(n) {
		case 1: return "one";
		case 2: return "two";
		case 3: return "three";
		case 4: return "four";
		case 5: return "five";
		case 6: return "six";
		case 7: return "seven";
		case 8: return "eight";
		case 9: return "nine";
		default: return "";
		}
	}
		
	
	private String getTeens(int n) {
		
		switch(n) {
		case 10: return "ten";
		case 11: return "eleven";
		case 12: return "twelve";
		case 13: return "thirteen";
		case 14: return "fourteen";
		case 15: return "fifteen";
		case 16: return "sixteen";
		case 17: return "seventeen";
		case 18: return "eighteen";
		case 19: return "nineteen";
		default: return "";
		}
	}
		
	private String getTens(int n) {
		
		switch (n) {
		case 20: return "twenty";
		case 30: return "thirty";
		case 40: return "forty";
		case 50: return "fifty";
		case 60: return "sixty";
		case 70: return "seventy";
		case 80: return "eighty";
		case 90: return "ninety";
		default: return "";
		}
	}
			
}

