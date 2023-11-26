/*
 * File: Hangman.java
 * ------------------
 * This program will eventually play the Hangman game from
 * Assignment #4.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.awt.*;

public class Hangman extends ConsoleProgram {
	
private static final int MAX_TRIES = 8;

    public void run() {
    	triesLeft = MAX_TRIES;
    	HangmanLexicon lexicon = new HangmanLexicon();
		String str = lexicon.getWord(rgen.nextInt(0, lexicon.getWordCount() - 1));
		println("The word now looks like this: " + gameWord(str));
		while (gameWord.indexOf("-") != -1 && triesLeft > 0) {
			playGame(str);
		}
		if (triesLeft == 0) {
			println("You're completely hung.");
			println("The word was: " + str);
			println("You lose!");
		} else {
			println("You win!");
		}
	}
    
    private void playGame(String str) {
    	if (triesLeft == 1) {
			println("You have only one guess left.");
		}
		else println("You have " + triesLeft + " tries left.");
		String guess = readLine("Guess a letter: ");
		while (guess.length() == 0 || guess.length() > 1 || 
				!Character.isLetter(guess.charAt(0)))
		{
			println("Please enter a single letter only.");
			guess = readLine("Guess a letter: ");
		}
		if (triesLeft > 0) {
			println("The word now looks like this: " + guessLetter(str, guess));
		}
    }
    
    private String gameWord(String str) {
    	gameWord = "";
    	for (int i = 0; i < str.length(); i++) {
    		gameWord += "-";
    	}
    	return gameWord;
    }
    
    private String guessLetter(String str, String ch) {
    	ch = ch.toUpperCase();
    	if (str.indexOf(ch) != -1) {
    		println("That's correct.");
    	}
    		for (int startIndex = 0; startIndex < str.length();) {
    			if (str.indexOf(ch) == -1) {
    				triesLeft--;
    				println("There are no " + ch + "'s in the word.");
    				return gameWord;
    			}
    			int index = str.indexOf(ch, startIndex);
    			if (index == -1) return gameWord;
    			gameWord = gameWord.substring(0, index) + ch + gameWord.substring(index + 1);
    			startIndex = index + 1;
    		}
    	return gameWord;
    }
    
    private String gameWord;
    private int triesLeft;
    private RandomGenerator rgen = RandomGenerator.getInstance();
}
