import acm.program.*;

public class StandardDeviation extends ConsoleProgram {
	
private static final int N_SCORES = 10;

	public void run() {
		/*
		 * Read in number of scores based on constant
		 */
		double[] scores = new double[N_SCORES];
		inputScores(scores);
		double mean = mean(scores);
		double total = runningTotal(scores, mean);
		double stdev = Math.sqrt((total / scores.length));
		println("Mean: " + mean);
	    println("Total: " + total);
		println("Standard deviation: " + stdev);
	}

	private double runningTotal(double[]scores, double mean) {
		double total = 0;
		for (int i = 0; i < scores.length; i++) {
			total += Math.pow((scores[i] - mean), 2);
		}
		return total;
	}
	
	/*
	 * Return mean of values in array.
	 */
	private double mean(double[] array) {
		double total = 0;
		for (int i = 0; i < array.length; i++) {
			total += array[i];
		}
		return total / array.length;
	}
	
	private void inputScores(double[] scores) {
		for (int i = 0; i < scores.length; i++) {
			scores[i] = readDouble("Score " + (i + 1) + ": ");
		}
	}
}


