/*
 * This program simulates a slot machine that pays out based on certain
 * combinations and allows the player to play until they quit or are
 * out of money.
 */

import acm.program.*;
import acm.util.*;

public class SlotMachine extends ConsoleProgram {
//sets constant for how much money the player starts with
//and assigns instance variable to subtract or add payouts to that amount
    private static final int MONEY = 50;
    private int wallet = MONEY;
//sets constant for the various payouts for winning combinations
    private static final int PAYOUT_BAR = 250;
    private static final int PAYOUT_BELL = 20;
    private static final int PAYOUT_PLUM = 14;
    private static final int PAYOUT_ORANGE = 10;
    private static final int PAYOUT_CHERRY = 7;
    private static final int PAYOUT_TWO_CHERRY = 5;
    private static final int PAYOUT_ONE_CHERRY = 2;

    public void run() {
//prompts user if they want instructions on winning combinations
        String instructions = readLine("Would you like instructions? ");
        if (instructions.equalsIgnoreCase("yes")) {
            printInstructions();
        }

//sets while loop until player runs out of money or stops
        while (wallet > 0) {
//if player continues, charges $1 and calls method to spin wheels
            String playOrStop = readLine("You have $" + wallet + ", would you like to play? ");
            if (playOrStop.equalsIgnoreCase("yes")) {
                wallet--;
                spinWheels();
            } else {
                break;
            }
        }

        if (wallet == 0) {
            println("Out of money!");
        }
        println("You ended with $" + wallet +"." );
    }

//prints winning combinations and payouts
    private void printInstructions() {
        println("BAR    BAR    BAR         pays $" + PAYOUT_BAR);
        println("BELL   BELL   BELL/BAR    pays $" + PAYOUT_BELL);
        println("PLUM   PLUM   PLUM/BAR    pays $" + PAYOUT_PLUM);
        println("ORANGE ORANGE ORANGE/BAR  pays $" + PAYOUT_ORANGE);
        println("CHERRY CHERRY CHERRY      pays $" + PAYOUT_CHERRY);
        println("CHERRY CHERRY ----        pays $" + PAYOUT_TWO_CHERRY);
        println("CHERRY ----   ----        pays $" + PAYOUT_ONE_CHERRY);
    }

//generates three slots variables as integers and converts them into symbols
    private void spinWheels() {
        String firstSlot = makeSymbols(rgen.nextInt(1, 6));
        String secondSlot = makeSymbols(rgen.nextInt(1, 6));
        String thirdSlot = makeSymbols(rgen.nextInt(1, 6));
//prints the result as symbols is sends variables to determine win/lose and payout
        print(firstSlot + "    " + secondSlot + "    " + thirdSlot + " -- ");
        getResult(firstSlot, secondSlot, thirdSlot);
    }

//makes combination of symbol strings and determines if the combination
//is a winner. If so it makes the appropriate payout via method
    private void getResult(String firstSlot, String secondSlot, String thirdSlot) {
        String combination = firstSlot + " " + secondSlot + " " + thirdSlot;

        if (combination.equals("BAR BAR BAR")) {
            handleWin(PAYOUT_BAR);
        } else if (combination.equals("BELL BELL BELL") || combination.equals("BELL BELL BAR")) {
            handleWin(PAYOUT_BELL);
        } else if (combination.equals("PLUM PLUM PLUM") || combination.equals("PLUM PLUM BAR")) {
            handleWin(PAYOUT_PLUM);
        } else if (combination.equals("ORANGE ORANGE ORANGE") || combination.equals("ORANGE ORANGE BAR")) {
            handleWin(PAYOUT_ORANGE);
        } else if (combination.equals("CHERRY CHERRY CHERRY")) {
            handleWin(PAYOUT_CHERRY);
        } else if (combination.startsWith("CHERRY CHERRY")) {
            handleWin(PAYOUT_TWO_CHERRY);
        } else if (combination.startsWith("CHERRY")) {
            handleWin(PAYOUT_ONE_CHERRY);
        } else {
            println("You lose");
        }
    }

//adds winning combination payout amount to current wallet
    private void handleWin(int payout) {
        println("You win $" + payout);
        wallet += payout;
    }

//converts random generatered integer from 1 to 6 to a slots symbol
    private String makeSymbols(int slot) {
        switch (slot) {
            case 1: return "BAR";
            case 2: return "BELL";
            case 3: return "PLUM";
            case 4: return "ORANGE";
            case 5: return "CHERRY";
            case 6: return "LEMON";
            default: return "";
        }
    }
// instance variable for random number generator
    private RandomGenerator rgen = RandomGenerator.getInstance();
}
