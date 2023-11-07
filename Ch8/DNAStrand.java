import acm.program.*;

public class DNAStrand extends ConsoleProgram {
	
	public void run() {
		
		println("This program will take two DNA strands and return" +
				" the first index position at which the short strand" +
				" will bind with the second. Only enter A, C, G, or T,");
		println("");
		String shortDNA = readLine("Enter short DNA strand: ");
		String longDNA = readLine("Enter long DNA strand: ");
		
		println("The first position for the short strand to bind is " + 
				(findFirstMatchingPosition(shortDNA, longDNA)));
	}
	

/*
 * Sets variables to track if each pair in the strands are consecutive
 * and complementary, and what the first binding position is.
 */
	private int findFirstMatchingPosition (String shortDNA, String longDNA) {
		int matchCounter = 0;
	    int startIndex = -1;
	    for (int i = 0; i <= longDNA.length() - shortDNA.length(); i++) {
	        matchCounter = 0;

	        for (int j = 0; j < shortDNA.length(); j++) {
	            char longCh = longDNA.charAt(i + j);
	            char shortCh = shortDNA.charAt(j);
	            
	            if (isPairMatch(longCh, shortCh)) {
	                matchCounter++;
	            } else {
	                break; // Break the inner loop if a mismatch is found
	            }
	        }

	        if (matchCounter == shortDNA.length()) {
	            startIndex = i;
	            break; // Break the outer loop if a complete match is found
	        }
	    }

	    return startIndex;
		
	 }	
		
	/*
	 * Helper method to detremine if the characters from the strands
	 * that are being compaired are complementary.
	 */
	
	private boolean isPairMatch(char longCh, char shortCh) {
		if (longCh == 'A' && shortCh == 'T') {
			return true;
		}
		else if (longCh == 'T' && shortCh == 'A') {
			return true;
		}
		else if (longCh == 'G' && shortCh == 'C') {
			return true;
		}
		else if (longCh == 'C' && shortCh == 'G') {
			return true;
		}
			else {
				
				return false;
			}
		
	}
}
