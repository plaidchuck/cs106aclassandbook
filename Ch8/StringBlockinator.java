import acm.program.*;

public class StringBlockinator {

    public StringBlockinator(String inputLine) {
        this.inputLine = inputLine;
        index = 0;
        delims = null; //set so that the only delimiter is white space
    }

    public StringBlockinator(String inputLine, String delims) {
        this.inputLine = inputLine;
        this.delims = delims;
        index = 0;
    }

    public String nextBlock() {

    	
    	for (int i = index; i < inputLine.length(); i++) {
    		char inputChar = inputLine.charAt(i);
    		
    		if (Character.isWhitespace(inputChar)) {
 
    			block = inputLine.substring(index, i);
    			index = i + 1;
    			return block;
    		}
    	}
    	
    	if (index < inputLine.length()) {
    		block = inputLine.substring(index);
			index = inputLine.length();
			return block;
    	} 
    	else return null;
    }
     
    
    public boolean hasMoreBlocks() {
        return index < inputLine.length();
    }

    private boolean isDelimiter(char ch) {
        return delims != null && delims.indexOf(ch) != -1;
    }


	
	
	private String inputLine; //holds original input string
	private String delims; //holds specified delimiters for blocks
	private String block; //holds current block from original String
	private int index; //holds index position during string loops
}

