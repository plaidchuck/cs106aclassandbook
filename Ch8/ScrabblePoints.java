import acm.program.*;

/*
 * A program to take a word and calculate points of each letter
 * like in a scrabble game. Only uppercase letters receive points.
 */

public class ScrabblePoints extends ConsoleProgram {
	
	public void run() {
		String str = readLine("Enter a word, only capital letters receive points: ");
		println("Score: " + getPointTotal(str));
	}

/*
 * Method to take each char from the string parameter and 
 * assign the appropriate point value to a running total for each word.
 */
	private int getPointTotal(String str) {
		int total = 0;
		for (int i = 0; i < str.length(); i ++) {
			switch (str.charAt(i)) {
			case 'A': case 'E': case 'I': case 'L': case 'N': case 'O':
			case 'R': case 'S': case 'T': case 'U': total +=1; break;
			
			case 'D': case 'G': total += 2; break;
			
			case 'B': case 'C': case 'M': case 'P': total += 3; break;
			
			case 'F': case 'H': case 'V': case 'W': case 'Y': total += 4; break;
			
			case 'K': total += 5; break;
			
			case 'J': case  'X': total +=8; break;
			
			case 'Q': case 'Z': total += 10; break;
			
			default: total += 0;
			}
			
			
		}
		return total;
	}
}
