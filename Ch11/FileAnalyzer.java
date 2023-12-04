
import acm.program.*;
import java.io.*;
import acm.util.*;

public class FileAnalyzer extends ConsoleProgram {
	public void run() {
		BufferedReader rd = openFileReader();
		println("Number of lines in file: " + countLines(rd));
		println("Number of characters in file: " + charCount);
		println("Number of words in file: " + wordCount);
		try {
			rd.close();
		} catch (IOException ex) {
			throw new ErrorException(ex);
		}
		
	}
	
	private BufferedReader openFileReader() {
		BufferedReader rd = null;
		while (rd == null) {
			try {
				String prompt = readLine("Enter filename: ");
				rd = new BufferedReader(new FileReader(prompt));
			} catch (IOException ex) {
				println("Can't open that file.");
			}
		}
		return rd;
	}
	
	private int countLines(BufferedReader rd) {
		String line = "";
		int lineCount = 0;
		charCount = 0;
		wordCount = 0;
		boolean inWord = false;
		while (true) {
			try {
				line = rd.readLine();
				if (line == null) break;
				charCount += line.length();
				for (int i = 0; i < line.length(); i++) {
					char currentChar = line.charAt(i);
				    boolean isLetterOrDigit = Character.isLetterOrDigit(currentChar);

				    if (isLetterOrDigit && !inWord) {
				        inWord = true;
				    } else if (!isLetterOrDigit && inWord) {
				        inWord = false;
				        wordCount++;
				    }
				}

				// Check if the last word extends to the end of the line
				if (inWord) {
				    wordCount++;
				}
				lineCount++;
			} catch (IOException ex){
				throw new ErrorException(ex);
			}
		}
		return lineCount;
		
	}
	
	private int charCount;
	private int wordCount;
}
