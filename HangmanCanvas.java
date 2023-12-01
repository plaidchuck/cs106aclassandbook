/*
 * File: HangmanCanvas.java
 * ------------------------
 * This file keeps track of the Hangman display.
 */

import acm.graphics.*;

public class HangmanCanvas extends GCanvas {

/** Resets the display so that only the scaffold appears */
	public void reset() {
		removeAll();
		incorrectLetter = "";
		tries = 0;
		drawScaffold();
		
	}

/**
 * Updates the word on the screen to correspond to the current
 * state of the game.  The argument string shows what letters have
 * been guessed so far; unguessed letters are indicated by hyphens.
 */
	public void displayWord(String word) {
		if (gameWord != null) {
			remove(gameWord);
		}
		gameWord = new GLabel(word);
		gameWord.setFont("Courier-30");
		gameWord.setLocation(getWidth() / 2 - gameWord.getWidth() / 2, 
				getHeight() - DISPLAY_WORD_OFFSET);
		add(gameWord);
	}

/**
 * Updates the display to correspond to an incorrect guess by the
 * user.  Calling this method causes the next body part to appear
 * on the scaffold and adds the letter to the list of incorrect
 * guesses that appears at the bottom of the window.
 */
	public void noteIncorrectGuess(char letter) {
		if (incorrectString != null) {
			remove(incorrectString);
		}
		incorrectLetter += letter;
		drawHangman();
		incorrectString = new GLabel(incorrectLetter);
		incorrectString.setFont("Times New Roman");
		add(incorrectString, getWidth() / 2 - incorrectString.getWidth() / 2, getHeight() - HIP_WIDTH);
		tries++;
		if (tries == 8) tries = 0; //reset for new game
	}
	
	private void drawHangman() {
		double centerX = getWidth() / 2;
		double centerY = getHeight() / 3;
		switch (tries) {
		case 0: add(new GOval(centerX - HEAD_RADIUS, centerY - HEAD_RADIUS * 2, //head
				HEAD_RADIUS * 2, HEAD_RADIUS * 2));  break;
		case 1: add(new GLine(centerX, centerY, centerX, centerY + BODY_LENGTH)); break; //body
		case 2: add(new GLine (centerX - UPPER_ARM_LENGTH, centerY + ARM_OFFSET_FROM_HEAD, //left arm
				centerX, centerY + ARM_OFFSET_FROM_HEAD)); 
				add(new GLine(centerX - UPPER_ARM_LENGTH, centerY  + ARM_OFFSET_FROM_HEAD,
				centerX - UPPER_ARM_LENGTH, centerY + ARM_OFFSET_FROM_HEAD + LOWER_ARM_LENGTH));
				break;
		
		case 3: add(new GLine (centerX + UPPER_ARM_LENGTH, centerY + ARM_OFFSET_FROM_HEAD, //right arm
				centerX, centerY + ARM_OFFSET_FROM_HEAD));
				add(new GLine(centerX + UPPER_ARM_LENGTH, centerY  + ARM_OFFSET_FROM_HEAD,
				centerX + UPPER_ARM_LENGTH, centerY + ARM_OFFSET_FROM_HEAD + LOWER_ARM_LENGTH));
				break;
		
		case 4: add(new GLine (centerX, centerY + BODY_LENGTH,
				centerX - HIP_WIDTH, centerY + BODY_LENGTH));
				add(new GLine (centerX - HIP_WIDTH, centerY + BODY_LENGTH,
						centerX - HIP_WIDTH, centerY + BODY_LENGTH + LEG_LENGTH));
				break;
				
		case 5: add(new GLine (centerX, centerY + BODY_LENGTH,
				centerX + HIP_WIDTH, centerY + BODY_LENGTH));
				add(new GLine (centerX + HIP_WIDTH, centerY + BODY_LENGTH,
				centerX + HIP_WIDTH, centerY + BODY_LENGTH + LEG_LENGTH));
				break;
				
		case 6: add(new GLine (centerX - HIP_WIDTH, centerY + BODY_LENGTH + LEG_LENGTH,
				centerX - HIP_WIDTH - FOOT_LENGTH, centerY + BODY_LENGTH+ LEG_LENGTH));
				break;
		
		case 7: add(new GLine (centerX + HIP_WIDTH, centerY + BODY_LENGTH + LEG_LENGTH,
				centerX + HIP_WIDTH + FOOT_LENGTH, centerY + BODY_LENGTH+ LEG_LENGTH));
				break;
		default: break;
		}
	}
	
	private void drawScaffold() {
		double centerX = getWidth() / 2;
		double centerY = getHeight() / 3;
		add(new GLine(centerX, centerY - ROPE_LENGTH - (HEAD_RADIUS * 2),
				centerX, centerY - (HEAD_RADIUS * 2)));
		add(new GLine(centerX - BEAM_LENGTH, centerY - ROPE_LENGTH - (HEAD_RADIUS * 2), 
				centerX - BEAM_LENGTH, SCAFFOLD_HEIGHT));		
		add(new GLine(centerX - BEAM_LENGTH, centerY - ROPE_LENGTH - (HEAD_RADIUS * 2),
				centerX, centerY - ROPE_LENGTH - (HEAD_RADIUS * 2)));
	}

/* Constants for the simple version of the picture (in pixels) */
	private static final int SCAFFOLD_HEIGHT = 360;
	private static final int BEAM_LENGTH = 144;
	private static final int ROPE_LENGTH = 18;
	private static final int HEAD_RADIUS = 36;
	private static final int BODY_LENGTH = 144;
	private static final int ARM_OFFSET_FROM_HEAD = 28;
	private static final int UPPER_ARM_LENGTH = 72;
	private static final int LOWER_ARM_LENGTH = 44;
	private static final int HIP_WIDTH = 36;
	private static final int LEG_LENGTH = 58;
	private static final int FOOT_LENGTH = 28;
	private static final int DISPLAY_WORD_OFFSET = 60;
	
	private int tries; //count number of  incorrect guesses for hangman picture
	
	private GLabel gameWord; //displays correctly guessed letters if any
	private GLabel incorrectString; //label display of incorrect guesses
	private String incorrectLetter; //string sent to GLabel for display
}
