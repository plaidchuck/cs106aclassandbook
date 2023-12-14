import acm.program.*;

public class Sudoku extends ConsoleProgram {
	
	/*
	 * Initializes array of completed Sudoku board, this 
	 * one having valid columns and rows but invalid 3x3 subgrids
	 * as this is the hardest condition to test.
	 */
    public void run() {
        int[][] board = {
        		{ 1, 2, 3, 4, 5, 6, 7, 8, 9 },
        		{ 2, 3, 4, 5, 6, 7, 8, 9, 1 },
        		{ 3, 4, 5, 6, 7, 8, 9, 1, 2 },
        		{ 4, 5, 6, 7, 8, 9, 1, 2, 3 },
        		{ 5, 6, 7, 8, 9, 1, 2, 3, 4 },
        		{ 6, 7, 8, 9, 1, 2, 3, 4, 5 },
        		{ 7, 8, 9, 1, 2, 3, 4, 5, 6 },
        		{ 8, 9, 1, 2, 3, 4, 5, 6, 7 },
        		{ 9, 1, 2, 3, 4, 5, 6, 7, 8 }
        };
        if (checkSudokuSolution(board)) {
            println("SUDOKU!");
        } else {
            println("NOT SUDOKU!");
        }
    }

    /*
     * Calls methods to check that no number repeats in any array
     * row, column, or 3x3 subgrid. 
     */
    private boolean checkSudokuSolution(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (!isValidRow(board, i) || !isValidColumn(board, i)) {
                return false;
            }
        }
            
        for (int j = 0; j < board.length; j += 3 ) {
        	for (int k = 0; k < board[j].length; k += 3) {
        		if (!isValidSubgrid(board, j, k)) {
        			return false;
        			}
        		}
        	}
        return true;
    }

    private boolean isValidRow(int[][] board, int row) {
    	boolean[] numberHolder = new boolean[10];
    	for (int i = 0; i < board[row].length; i++) {
    		int currentNumber = board[row][i];
    		if (numberHolder[currentNumber]) {
    			return false;
    		}
    		numberHolder[currentNumber] = true;
    	}
    	return true;
	}
    
    private boolean isValidColumn(int[][] board, int column) {
    	boolean[] numberHolder = new boolean[10];
    	for (int i = 0; i < board[column].length; i++) {
    		int currentNumber = board[i][column];
    		if (numberHolder[currentNumber]) {
    			return false;
    		}
    		numberHolder[currentNumber] = true;
    	}
    	return true;
    }
    
    private boolean isValidSubgrid(int[][] board, int row, int column) {
    	boolean[] numberHolder = new boolean[10];
    	for (int i = row; i < (row + 3); i++) {
    		for (int j = column; j < (column + 3); j++) {
    			int currentNumber = board[i][j];
    			if (numberHolder[currentNumber]) {
    				return false;
    			}
    			numberHolder[currentNumber] = true;
    		}
    	}
    	return true;
    }
}