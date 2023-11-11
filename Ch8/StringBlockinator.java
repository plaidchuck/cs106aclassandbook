

public class StringBlockinator {

    public StringBlockinator(String inputLine) {
        this.inputLine = inputLine;
        startIndex = 0;
        delims = null; //set so that the only delimiter is white space
    }

    public StringBlockinator(String inputLine, String delims) {
        this.inputLine = inputLine;
        this.delims = delims;
        startIndex = 0;
    }

    public String nextBlock() {
   
    	inputLine = inputLine.trim();
    	boolean inDelimiterRun = false;
    	int endIndex = 0;
    	
    	for (int i = startIndex; i < inputLine.length(); i++) {
    		char inputChar = inputLine.charAt(i);
    		
    		if (Character.isWhitespace(inputChar) && !inDelimiterRun) {
    			endIndex = i;
    			inDelimiterRun = true;
    			
    			if (startIndex < endIndex) {
    				block = inputLine.substring(startIndex, endIndex);
    				startIndex = endIndex;
    				return block;
    			}
    			
    		}
    		
    		if (!Character.isWhitespace(inputChar) && inDelimiterRun) {
    			
    			inDelimiterRun = false;
    			startIndex = i;
  
    		}
    		
    	}
  
    	
    	if (startIndex < inputLine.length()) {
    		block = inputLine.substring(startIndex);
    		startIndex = inputLine.length();
    		return block;
    	}
    	
    	else return null;
     }
     
    
    public boolean hasMoreBlocks() {
        return startIndex < inputLine.length();
    }

    private boolean isDelimiter(char ch) {
        return delims != null && delims.indexOf(ch) != -1;
    }


	
	
	private String inputLine; //holds original input string
	private String delims; //holds specified delimiters for blocks
	private String block; //holds current block from original String
	private int startIndex; //holds start index position during string loops
}
