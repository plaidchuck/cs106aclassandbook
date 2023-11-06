import acm.program.*;

public class Obenglobish extends ConsoleProgram {
	

	public void run() {
		while (true) {
			setFont("bold");
			String str = readLine("Enter a word: ");
			if (str.equals("")) break;
			obenglobish(str);
		}
	}

/*
 * Checks each letter in the word string to find a vowel and adds the "ob"
 * before it if there was no vowel before it. It also checks for the special
 * case where the word ends in a vowel and adjusts the returned string so
 * the "ob" is not added before the vowel in that case.
 */
	private void obenglobish(String str) {
		String result = "";
		int start = 0;
		for (int i = 0; i < str.length(); i++) {
			if (isEnglishVowel(str.charAt(i)) 
				&& (i == 0 || !isEnglishVowel(str.charAt(i - 1)))) {
				result += str.substring(start, i) + "ob" + str.charAt(i);
				start = i + 1;
			}
		}
		//adds last part of string after the loop
		result += str.substring(start, str.length()); 
		
/*
 * 	Checks if the last letter of original word is a vowel, and if so
 *  changes translated word so that the last vowel does not receive
 *  the "ob" prefix.
 */
		if (isEnglishVowel(str.charAt(str.length() - 1))) {
			char ch = str.charAt(str.length() -1);
			result = result.substring(0, result.length() - 3) + ch;
		}
		println("English --> " + result);
		println("");
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
