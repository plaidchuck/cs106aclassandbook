/*
 * A console program that takes at line of text and converts it
 * to pig platin. Will translate down to a single vowel word.
 */

import acm.program.*;
//import java.util.*;

public class PigLatin extends ConsoleProgram {
	
//private static final String DELIMITERS = "!@#$%^&*()[]\\;',./-=_+{}|:<>?`~;\"+";
	public void run() {

//state program purpose
		println("This program translates a text line into Pig Latin.");
//Keep requesting input and translating the line
		while (true) {
			String textLine = readLine("Enter a line of text: ");
//Output translated line
			println(translationLine(textLine));
			println("");
		}
	}

/*
 * Take inputed string  line and check each character until a space
 * is encountered to signify the end of a word. Take each word
 * and translate it into pig latin with a space between the words then
 * return the word.
 */
	private String translationLine(String line) {
		String result = "";
		int start = 0;
		for (int i = 0; i < line.length(); i++) {
			
			if (Character.isWhitespace(line.charAt(i))) {
				String word = line.substring(start, i);
				
				result += translateWord(word) + " ";
				start = i + 1;
			}

		}
	
//Translates the last word of the line
		if (start < line.length()) {
			String word = line.substring(start);
			result += translateWord(word);
		}

		return result.trim();
	}
	


/*
 * Check that the word subtring is an actual word with no
 * specical characters in it.
 */
	
	private boolean isWord(String token) {
		for (int i = 0; i < token.length(); i++) {
			char ch = token.charAt(i);
			if (!Character.isLetter(ch)) return false;
			
		}
		return true;
	}
	
/*
 * Translates a word into pig latin by finding the first vowel and
 * changing word based on if the first letter is a vowel or not.
 * Also returns any word that contains special characters or no vowels
 * except in the case where the word contains a special character at the
 * end of the word(punctuation). In that case, the character is placed into
 * a char variable and added to the end of the translated word. Also
 * check if word is capitalized so the actual pig latin word starts with
 * an uppercase letter as well.
 */
	private String translateWord(String word) {
		String result = "";
		char ch = ' ';
		if (!Character.isLetterOrDigit(word.charAt(word.length() - 1))) {
		    ch = word.charAt(word.length() - 1);
		    word = word.substring(0, word.length() - 1);
		}
		int vp = findFirstVowel(word);
		if (vp == -1 || !isWord(word)) {
			return word + ch;
		} else if (vp == 0) {
			if (ch != ' ' && startsWithUppercase(word)) return capitalize(word) + "way" + ch;
			else if (ch != ' ') return word + "way" + ch;
			else if (startsWithUppercase(word)) {
				result = word + "way";
				return capitalize(result);
			}
			else return word + "way";
		} else {
			String head = word.substring(0, vp);
			String tail = word.substring(vp);
			if (ch != ' ' && startsWithUppercase(word)){
				result = tail.trim() + head.trim() + "ay" + ch;
				return capitalize(result);
			} else if (ch != ' ') {
				result = tail.trim() + head.trim() + "ay" + ch;
				return result;
			} else if (startsWithUppercase(word)){
				result = tail.trim() + head.trim() + "ay";
				return capitalize(result);
			} else {
				result = tail.trim() + head.trim() + "ay";
				return result;
			}
		}
	}
	
	private boolean startsWithUppercase(String word) {
		for (char ch = 'A'; ch <= 'Z'; ch++) {
			if (word.charAt(0) == ch) {
				return true;
			}
		}
		return false;
			
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
	 * Helper method to identify location of the first vowel in
	 * a string
	 */
	private int findFirstVowel(String word) {
		for (int i = 0; i < word.length(); i ++) {
			if (isEnglishVowel(word.charAt(i))) return i;
		}
		return -1;
	}
	
	/*
	 * Helper method to determine if a character is a standard English
	 * vowel.
	 */
	private boolean isEnglishVowel(char ch) {
		switch (Character.toLowerCase(ch)) {
		case 'a': case 'e': case 'i': case 'o': case 'u':
			return true;
		default:
			return false;
		}
	}
}
