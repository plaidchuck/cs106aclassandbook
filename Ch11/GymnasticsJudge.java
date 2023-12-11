import acm.program.*;

public class GymnasticsJudge extends ConsoleProgram {

private static final int N_JUDGES = 7;
private static final int N_THROWN_OUT = 2;
	
public void run() {
    double[] scores = new double[N_JUDGES];
    for (int i = 0; i < scores.length; i++) {
        scores[i] = readDouble("Score for judge " + (i + 1) + ": ");
    }

    // Initialize smallestNumber and largestNumber with the first score
    double smallestNumber = scores[0];
    double largestNumber = scores[0];

    // Iterate through the array starting from index 1
    for (int i = 1; i < scores.length; i++) {
        if (scores[i] > largestNumber) {
            largestNumber = scores[i];
        } else if (scores[i] < smallestNumber) {
            smallestNumber = scores[i];
        }
    }

    // Calculate the total excluding the smallest and largest scores
    double total = 0;
    for (int i = 0; i < scores.length; i++) {
    	total += scores[i];
    	}
    total -= smallestNumber + largestNumber;

    // Calculate the average of the adjusted scores
    double averageScore = total / (scores.length - N_THROWN_OUT);

    println("Total excluding smallest and largest scores: " + total);
    println("The average score is " + averageScore);
	}
}
