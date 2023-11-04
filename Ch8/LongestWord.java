import java.util.StringTokenizer;
import acm.program.*;

/*
 * A program that reads an input of a string of words,
 * separates the words into tokens, and returns the largest word 
 * from the string.
 */

public class LongestWord extends ConsoleProgram {

/*
 *  Constant to remove/delimit special characters from token strings
 */
private static final String DELIMITERS = "!@#$%^&*()[]\\;',./-=_+{}|:<>?`~ ;\" +";
	
	public void run() {
		String line = readLine("Enter a line: ");
		println("The longest word is \"" + longestWord(line) + "\".") ;

		
}
	
	private String longestWord(String line) {
		String result = "";
		int longestWordLength = 0;
		StringTokenizer tokenizer = new StringTokenizer(line, DELIMITERS);
		while (tokenizer.hasMoreTokens()) {
			String token = tokenizer.nextToken();
				int wordLength = token.length();
				if (wordLength > longestWordLength) {
					result = token;
					longestWordLength = wordLength;
				}
			}
		return result;
		}
		

}