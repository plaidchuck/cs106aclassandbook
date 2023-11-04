/*
 * A console program that takes at line of text and converts it
 * to pig platin. Will translate down to a single vowel word.
 */

import acm.program.*;
import java.util.*;

public class PigLatin extends ConsoleProgram {
	
private static final String DELIMITERS = "!@#$%^&*()[]\\;',./-=_+{}|:<>?`~ ;\" +";
	public void run() {

//state program purpose
		println("This program translates a text line into Pig Latin.");
//Receive input of text line into String variable
		String textLine = readLine("Enter a line of text: ");
//Output translated line
		println(translationLine(textLine));
	}

/*
 * Turn the inputted line into String tokens and check that each word
 * has no characters in it, if so translate the word into pig latin.
 */
	private String translationLine(String line) {
		String result = "";
		StringTokenizer tokenizer =
		  new StringTokenizer(line, DELIMITERS, true);
		while (tokenizer.hasMoreTokens()) {
			String token = tokenizer.nextToken();
			if (isWord(token)) {
				token = translateWord(token);
			}
			result += token;
		}
		return result;
	}
	
/*
 * Check that each character in the token is an actual letter.
 * If it isn't, the world is left alone and outputted as it was
 * originally.
 */
	
	private boolean isWord(String token) {
		for (int i = 0; i < token.length(); i++) {
			char ch = token.charAt(i);
			if (!Character.isLetter(ch)) return false;
			
		}
		return true;
	}
	
	private String translateWord(String word) {
		int vp = findFirstVowel(word);
		if (vp == -1) {
			return word;
		} else if (vp == 0) {
			return word + "way";
		} else {
			String head = word.substring(0, vp);
			String tail = word.substring(vp);
			return tail + head + "ay";
		}
	}
	
	private int findFirstVowel(String word) {
		for (int i = 0; i < word.length(); i ++) {
			if (isEnglishVowel(word.charAt(i))) return i;
		}
		return -1;
	}
	
	private boolean isEnglishVowel(char ch) {
		switch (Character.toLowerCase(ch)) {
		case 'a': case 'e': case 'i': case 'o': case 'u':
			return true;
		default:
			return false;
		}
	}
}
