/*
 * File: Hangman.java
 * ------------------
 * A simple hangman game with dual console and graphic representation.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.awt.*;

public class Hangman extends ConsoleProgram {
	
private static final int MAX_TRIES = 8; //Number of incorrect guesses allowed

	public void init() {
		canvas = new HangmanCanvas();
		add(canvas);
	}


	/*
	 * Creates an instance of the game lexicon, initializes the game,
	 * and then enters the play loop of the game until the correct word is guessed or
	 * the number of guesses left is zero.
	 * (non-Javadoc)
	 * @see acm.program.ConsoleProgram#run()
	 */
    public void run() {
    	lexicon = new HangmanLexicon();
    	gameSetup();
		while (gameWord.indexOf("-") != -1 && triesLeft > 0) {
			playGame();
		}
		endgame();
	}
    
    /*
     * States how many guesses the player has left. Then prompts the player to guess only
     * a single non-case sensitive letter. Then displays the current state of the
     * guessed word.
     */
    private void playGame() {
    	String guess = "";
    	if (triesLeft == 1) {
			println("You have only one guess left.");
		} else {
			println("You have " + triesLeft + " guesses left.");
		}
    	while (true) {
    		guess = readLine("Guess a letter: ");
    		if (guess.length() == 1 &&  Character.isLetter(guess.charAt(0))) {
    			break;
    		}
    		println("Please enter a single letter only.");
    	}
		if (triesLeft > 0) {
			println("The word now looks like this: " + guessLetter(guess.toUpperCase()));
			canvas.displayWord(gameWord);
		}
    }
    
    /*
     * Initializes the amount of guesses the player has and then
     * randomly chooses the secret word from the lexicon class/array list.
     */
    private void gameSetup() {
    	canvas.reset();
    	triesLeft = MAX_TRIES;
		secretWord = lexicon.getWord(rgen.nextInt(0, lexicon.getWordCount() - 1));
		println("Guess the word: " + gameWord());
		canvas.displayWord(gameWord);
    }
    
    /*
     * Generate the game word which represents the current
     * state in the players guesses, first representing the secret word by all -'s
     * and then replacing them with correctly guessed letters.
     */
    private String gameWord() {
    	gameWord = "";
    	for (int i = 0; i < secretWord.length(); i++) {
    		gameWord += "-";
    	}
    	return gameWord;
    }
    
    /*
     * Confirms if player guessed a correct letter o not. If not, removes a remaining guess
     * and confirms that the guessed letter is not in the secret word before returning the 
     * unchanged state of the game word. Otherwise, the correctly guessed letter replaces
     * all instances of the -'s in the game word state where the letter exists
     * in the secret word and then returns the current game word state.
     */
    private String guessLetter(String ch) {
    	char letter = ch.charAt(0); // to send to canvas method
    	int chIndex = secretWord.indexOf(ch);
    	if (chIndex != -1) {
    		println("That's correct.");
    	}
    		for (int startIndex = 0; startIndex < secretWord.length();) {
    			if (chIndex == -1) {
    				triesLeft--;
    				println("There are no " + ch + "'s in the word.");
    				canvas.noteIncorrectGuess(letter);
    				return gameWord;
    			}
    			int index = secretWord.indexOf(ch, startIndex);
    			if (index == -1) {
    				return gameWord;
    			}
    			gameWord = gameWord.substring(0, index) + ch + gameWord.substring(index + 1);
    			startIndex = index + 1;
    		}
    	return gameWord;
    }
    
    /*
     * If the player has no more guesses remaining, displays the secret word and states
     * the player lost. Otherwise, confirms the secret word and states that the player won.
     */
    private void endgame() {
    	if (triesLeft == 0) {
			println("You're completely hung.");
			println("The word was: " + secretWord);
			println("You lose!");
		} else {
			println("You guessed the word: " + secretWord);
			println("You win!");
		}
    }
    
    private String secretWord; // Word to be guessed
    private String gameWord; // Current state of correctly guessed letters
    private int triesLeft; // How many guesses left
    private HangmanLexicon lexicon; //Initializes which holds array list of secret words
    
    private HangmanCanvas canvas; // Initialize right side graphic canvas
    
    private RandomGenerator rgen =  //Used to randomly choose a word from the lexicon
    	RandomGenerator.getInstance();
}
