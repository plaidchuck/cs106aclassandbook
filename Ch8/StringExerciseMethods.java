/*
 * A collection of methods used in the chapter 8 String exercises.
 */

import acm.program.*;
import acm.util.*;

public class StringExerciseMethods extends ConsoleProgram {

// For randomWord method range of number of letters
private static final int MIN_LETTERS = 1;
private static final int MAX_LETTERS = 10;
	
/*
 * Constant to remove/delimit special characters from token strings
 */
private static final String DELIMITERS = "!@#$%^&*()[]\\;',./-=_+{}|:<>?`~ ;\" +";
	
	public void run() {

		String word = readLine("Enter a word to pluralize: ");
		println(createRegularPlural(word));
	}
	
	/*
	 * A method to take a word and pluralize
	 * it according to standard English rules involving words ending in
	 * vowels, s, z, x, ch, sh, and y.
	 */
	
	private String createRegularPlural(String str) {
		    // Input validation
		    if (str == null || str.isEmpty()) {
		        throw new IllegalArgumentException("Input string cannot be null or empty.");
		    }

		    char lastLetter = str.charAt(str.length() - 1);
		    char penultimateLetter = (str.length() > 1) ? str.charAt(str.length() - 2) : '\0';

		    if (lastLetter == 's' || lastLetter == 'x' || lastLetter == 'z') {
		        return str + "es";
		    } else if (lastLetter == 'y' && isEnglishConsonant(penultimateLetter)) {
		        return str.substring(0, str.length() - 1) + "ies";
		    } else if ((str.endsWith("ch") || str.endsWith("sh"))) {
		        return str + "es";
		    } else {
		        return str + "s";
		    }
		}
	
	
	/*
	 * Takes in three date integers and returns a string in the
	 * day-month-year format, truncating the first two digits in the year
	 * and converting a month number into a String abbreviation.
	 */
	
	private String createDateString(int day, int month, int year) {
		String result = "";
		String monthString = "";
		
		switch (month) {
			case 1: monthString = "Jan"; break;
			case 2: monthString = "Feb"; break;
			case 3: monthString = "Mar"; break;
			case 4: monthString = "Apr"; break;
			case 5: monthString = "May"; break;
			case 6: monthString = "Jun"; break;
			case 7: monthString = "Jul"; break;
			case 8: monthString = "Aug"; break;
			case 9: monthString = "Sep"; break;
			case 10: monthString = "Oct"; break;
			case 11: monthString = "Nov"; break;
			case 12: monthString = "Dec"; break;
			default: monthString = null;
			}
		
		year = year % 100;
		result = result + day + "-" + monthString + "-" + year;
		return result;
	}
	
	
	
/*
 * Returns a string that capitalizes the first letter in a string
 * and makes all the others lowercase if necessary. Does not affect non
 * letter characters.
 */
	private String capitalize(String str) {
		String result = "";
		result = result + Character.toUpperCase(str.charAt(0));
		for(int i = 1 ; i < str.length(); i++) {
			result = result + Character.toLowerCase(str.charAt(i));
			}
		return result;
	}
	
/*
 * A method that returns a randomly constructed word
 * consisting of randomly chosen letters. Number of letters
 * are chosen randomly within a defined number range. Uses
 * isEnglishConsonant method to make a string of either all
 * vowels or all consonants.
 */
	private String randomWord() {
		String result = "";
		int letterCount = (rgen.nextInt(MIN_LETTERS, MAX_LETTERS));
		for (int i = 0;  i < letterCount; i++) {
			char ch = (char)rgen.nextInt('A', 'Z');
			while (!isEnglishConsonant(ch)) {
				ch = (char)rgen.nextInt('A', 'Z');
			}
			result += ch;
		}
		return result;
	}
	
/* 
 * A method that receives a character, converts it to lowercase, 
 * and then returns true or false based on if it is an English
 * consonant or not. 
 */
	private boolean isEnglishConsonant(char ch) {
		switch (Character.toLowerCase(ch)) {
		case 'a': case 'e': case 'i': case 'o': case 'u':
			return false;
		default:
			return true;
		}
	}

//RandomGenerator instance
private RandomGenerator rgen = RandomGenerator.getInstance();
}
