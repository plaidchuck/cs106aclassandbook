import acm.program.*;

/**
 * A Java class to implement StringTokenizer as an exercise in
 * manipulating Strings.
 * @author Johnny
 *
 */

public class StringBlockinator {
	
	/**
	 * Creates StringBlockinator object that takes a String and creates
	 * blocks from all characters within whitespaces or before the end
	 * of the String.
	 * @param str String to pass through the Blockinator.
	 */
	
	public StringBlockinator(String str) {
		this.str = str;
		index = 0;
		block = "";
	}
	
	/**
	 * Creates StringBlockinator object that takes a String and creates
	 * blocks from all characters within specified deliminators
	 * or before the end of the String.
	 * @param str String to pass through the Blockinator.
	 * @param delims String containing deliminators that blockinator
	 * will use to make blocks instead of the default whitespaces.
	 */
	
	public StringBlockinator(String str, String delims) {
		this.str = str;
		this.delims = delims;
		index = 0;
		block = "";
	}
	
	/**
	 * Returns the first (or next) block in the blockinated String based
	 * on whether whitespace or specified delimiters separate blocks.
	 * @return Next blockinated block
	 */
	
	public String nextBlock() {
		
		boolean delimFound = false;
		
		if (delims != null) {
			for (int i = index; i <= str.length() - delims.length(); i++) {
				if (isDelimiter(str.charAt(i))) {
			        block = str.substring(index, i);
			        index = i + 1;
			        return block;
			}
			
		}
			
		} else {
		
		for (int i = index; i < str.length(); i++) {  
			
			 
			if (Character.isWhitespace(str.charAt(i))) {
				
				if (!delimFound) {
					delimFound = true;
					block = str.substring(index, i);  
					index = i + 1;
					return block;
				}
				
				else if (delimFound) {
					index = i + 1;
				}
			
				
				}
			
			if (!Character.isWhitespace(str.charAt(i))) {
				delimFound = false;
			}
		}
		
		}
		if (index < str.length()) {
			block = str.substring(index);
			index = str.length();
			return block;
			
		} else {
			
			return null;
		}
		
		
	}
	
	public boolean hasMoreBlocks() {
		
		if (index == str.length()) return false;
		else return true;
	}
	
	private boolean isDelimiter(char ch) {
		for (int i = 0; i < delims.length(); i++) {
			if (ch == delims.charAt(i)) {
				return true;
			}
		}
		return false;
	}
	
	
	String str; //holds original input string
	String delims; //holds specified delimiters for blocks
	String block; //holds current block from original String
	int index; //holds index to return next block in string
}
