import acm.program.*;
import acm.util.*;
import java.util.*;

public class CharExamples extends ConsoleProgram {

	public void run() {
		
		setFont("Comic Sans MS-24");
		String line = readLine("Enter line to tokenize: ");
		println("The tokens of the string are:");
		printTokens(line);
		
		for ( char ch = 'A'; ch <= 'Z'; ch++) {
			if (isEnglishConsonant(ch)) print(ch + " ");
			}
	}
	
	private void printTokens(String str) {
		StringTokenizer tokenizer = new StringTokenizer(str, ", ");
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
		
	private boolean simpleIsPalindrome(String str) {
			return (str.equals(reverseString(str)));
		}
	
	private boolean isPalindrome(String str) {
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
		if (index != -1) {
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
	
	private String acronym(String str) {
		String result = str.substring(0, 1);
		int pos = str.indexOf(' ');
		while (pos != -1) {
			result += str.substring(pos + 1, pos + 2);
			pos = str.indexOf(' ', pos + 1);
		}
		return result.toUpperCase();
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
