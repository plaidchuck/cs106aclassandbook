import acm.program.*;

public class MagicSquare extends ConsoleProgram {

    public void run() {
        int[][] square = {
        		{ 17, 24,  1,  8, 15 },
        		{ 23,  5,  7, 14, 16 },
        		{  4,  6, 13, 20, 22 },
        		{ 10, 12, 19, 21,  3 },
        		{ 11, 18, 25,  2,  9 }
        };

        if (isMagicSquare(square)) {
            println("MAGIC!");
        } else {
            println("NOT MAGIC!");
        }
    }

    private boolean isMagicSquare(int[][] array) {
        int size = array.length;
        int magicNumber = getMagicNumber(array, size);

        return checkSums(array, magicNumber);
    }

    private int getMagicNumber(int[][] array, int size) {
        int total = 0;
        for (int i = 0; i < size; i++) {
            total += array[0][i];
        }
        return total;
    }

    private boolean checkSums(int[][] array, int magicNumber) {
        int size = array.length;

        // Check rows, columns, and diagonals
        for (int i = 0; i < size; i++) {
            int rowSum = 0;
            int colSum = 0;

            for (int j = 0; j < size; j++) {
                rowSum += array[i][j];
                colSum += array[j][i];
            }

            // Check rows and columns
            if (rowSum != magicNumber || colSum != magicNumber) {
                return false;
            }
        }

        // Check main diagonal
        int diagSum = 0;
        for (int i = 0; i < size; i++) {
            diagSum += array[i][i];
        }

        return diagSum == magicNumber;
    }
}