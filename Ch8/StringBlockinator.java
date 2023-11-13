/**
 * A class to mimic the implementation of the java StringTokenizer class.
 * @author Johnny
 *
 */

public class StringBlockinator {

    public StringBlockinator(String inputLine) {
        this(inputLine, null);
        this.startIndex = 0;
      
    }

    public StringBlockinator(String inputLine, String delims) {
        this.inputLine = inputLine;
        this.delims = delims;
        this.startIndex = 0;
        includeDelims = false;
    }
    
    public StringBlockinator(String inputLine, String delims, boolean includeDelims) {
    	this(inputLine, delims);
    	this.includeDelims = includeDelims;
    	this.startIndex = 0;
    }

    public String nextBlock() {
   	
    	boolean inDelimiterRun = false;
    	int endIndex = 0;
    	
    	
    	for (int i = startIndex; i < inputLine.length(); i++) {
    		char inputChar = inputLine.charAt(i);
    		
    		
    		if (delims != null && isDelimiter(inputChar) && !inDelimiterRun) {
    
    			endIndex = i;
    			inDelimiterRun = true;
    			
    			
    			
    			if (startIndex < endIndex) {
    				block = inputLine.substring(startIndex, endIndex);
    				
    				 if (includeDelims) {
    					 
    				 }
    				 
    				 else while (endIndex < inputLine.length() && isDelimiter(inputLine.charAt(endIndex))) {
    				        endIndex++;
    				    }

    				startIndex = endIndex;
    				return block;
    			}
    		}
    		
    		
    		else if (delims == null && Character.isWhitespace(inputChar) && !inDelimiterRun) {
    			
    			endIndex = i;
    			inDelimiterRun = true;
    			
    			if (startIndex < endIndex) {
    				block = inputLine.substring(startIndex, endIndex);
    				
    				 while (endIndex < inputLine.length() && Character.isWhitespace(inputLine.charAt(endIndex))) {
    				        endIndex++;
    				    }

    				startIndex = endIndex;
    				return block;
    			}
    		
    		}
    		
    		
    		if (delims != null && !isDelimiter(inputChar) && inDelimiterRun) {
    			
    			inDelimiterRun = false;
    			startIndex = i;
    			
    		}
    		
    		if (delims == null && !Character.isWhitespace(inputChar) && inDelimiterRun) {
    			
    			inDelimiterRun = false;
    			startIndex = i;
  
    		}
    		
    		if (includeDelims && isDelimiter(inputChar)) {
    			block = "" + inputChar;
    			startIndex++;
    			return block;
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


	
	
	private String inputLine; 
	private String delims; //holds specified delimiters for blocks
	private String block; //holds current block from original String
	private int startIndex; //holds start index position during String loops
	boolean includeDelims; //flag for delimiters to be returned as blocks
}
