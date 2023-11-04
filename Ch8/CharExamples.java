import acm.program.*;
import acm.util.*;
import java.util.*;

public class CharExamples extends ConsoleProgram {

/*
 * Constant to remove/delimit special characters from token strings
 */
private static final String DELIMITERS = "!@#$%^&*()[]\\;',./-=_+{}|:<>?`~ ;\" +";

	public void run() {
		while (true) {
			String bs = readLine("Enter a line: ");
			println(acronym(bs));
			println("");
		}
	}
	
	private String acronym(String str) {
		String result = "";
		StringTokenizer tokenizer = new StringTokenizer(str, DELIMITERS);
		while (tokenizer.hasMoreTokens()) {
			String token = tokenizer.nextToken();
			result += token.substring(0, 1);
		}
		return result.toUpperCase();
	}	

	
	/*
	 * A method to take an integer of over 3 digits and
	 * add commas to separate the digits into groups of threes with a comma.
	 */
	private String addCommas(String digits) {
	    int length = digits.length();
	    if (length <= 3) {
	        return digits; // No need to add commas if the length is 3 or less
	    }

	    String result = "";
	    int commaCount = 0;

	    for (int i = length - 1; i >= 0; i--) {
	        result = digits.charAt(i) + result;
	        commaCount++;

	        // Insert comma after every third digit, except for the last group
	        if (commaCount % 3 == 0 && i > 0) {
	            result = "," + result;
	        }
	    }

	    return result;
	}
	/*
	 * Takes an integer and returns a string of the ordinal form
	 * abbreviation the number.
	 */
	
	private String createOrdinalForm(int n) {
		String result = "";
		result = result + n;
		if (result.endsWith("11") || result.endsWith("12") || result.endsWith("13")){
			result = n + "th";
		}
		else if (result.endsWith("1")) {
			result = n + "st";
		}
		else if (result.endsWith("2")) {
			result = n + "nd";
		}
		else if (result.endsWith("3")) {
			result = n + "rd";
		} else {
			result = n + "th";
		}
		return result;
	}
	
	private void printTokens(String str) {
		StringTokenizer tokenizer = new StringTokenizer(str, DELIMITERS);
		for (int count = 0; tokenizer.hasMoreTokens(); count++) {
			println("Token #" + count + ": " + tokenizer.nextToken());
		}
	}
	
	private String reverseString(String str) {
		String result = "";
		for(int i = 0 ; i < str.length(); i++) {
			result = str.charAt(i) + result;
			}
		
			return result;
			}
		
	private boolean isSentencePalindrome(String str) {
		String result = "";
		StringTokenizer tokenizer = new StringTokenizer(str);
		for (int count = 0; tokenizer.hasMoreTokens(); count++) {
			result = result + tokenizer.nextToken();
		}

		return(isPalindrome(result));
	}
	
	private boolean simpleIsPalindrome(String str) {
		str = str.toLowerCase();
			return (str.equals(reverseString(str)));
		}
	
	private boolean isPalindrome(String str) {
		str = str.toLowerCase();
		for(int i = 0; i < str.length() / 2; i++) {
			if (str.charAt(i) != str.charAt(str.length() - (i + 1))) {
				return false;
			}
		}
		return true;
	}
	
	/*
	 * Takes in string to be searched, word to be replaced,
	 * and word that will replace original. Basic word processing
	 * "find and replace"
	 */
	
	private String replaceOccurence(String str, String orig, String repl) {
		int index = str.indexOf(orig);
		println(index);
		if (index != -1) {
			println(str.substring(0, index));
			println(str.substring(index + orig.length()));
			str = str.substring(0, index) + repl + str.substring(index + orig.length());
		}
		return str;
	}
	
	private int countUppercase(String str) {
		int counter = 0;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (Character.isUpperCase(ch)) {
				counter++;
			}
		}
		return counter;
	}
	
	private boolean isEnglishConsonant(char ch) {
		switch (Character.toLowerCase(ch)) {
		case 'a': case 'e': case 'i': case 'o': case 'u':
			return false;
		default:
			return true;
		}
	}
	
	
	private String concatNCopies(int n, String str) {
		String result = "";
		for (int i = 0; i < n; i++) {
			result += str;
		}
		return result;
	}
	
	private String secondHalf(String str) {
		return str.substring(str.length()/ 2);
	}
	
	private char randomLetter() {
		return (char) rgen.nextInt('A', 'z');
	}
	
	private char toLower(char ch) {
		if (ch >= 'A' && ch <= 'Z') {
			return (char)(ch - 'A' + 'a');
		}
		return ch;
	}
	
private RandomGenerator rgen = RandomGenerator.getInstance();
	
}

