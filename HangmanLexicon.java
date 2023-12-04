/*
 * File: HangmanLexicon.java
 * -------------------------
 * Implementation to read a text file lexicon with a word on each line
 * and add each line to an ArrayList which then can be retrieved with an index number.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import acm.util.*;

public class HangmanLexicon {
	
/**
 * Creates BufferedReader object to open the specified text file
 * and set each line to an element in the ArrayList.
 */
	public HangmanLexicon() {
			try {
				BufferedReader rd = new BufferedReader(new FileReader("scrabble.txt"));
				String line;
				while ((line = rd.readLine()) != null) {
					lexiconArray.add(line);
				}
				rd.close();
			} catch (IOException ex) {
				throw new ErrorException(ex);
			}
		}


/** Returns the number of words in the lexicon. */
	public int getWordCount() {
		return lexiconArray.size();
	}

/** Returns the word at the specified index. */
	public String getWord(int index) {
		return lexiconArray.get(index);
	}
	
	private ArrayList<String> lexiconArray = new ArrayList<String>(); //stores lexicon from specified text file
}
