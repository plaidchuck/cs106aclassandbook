import acm.program.*;

public class GymnasticsJudge extends ConsoleProgram {

private static final int N_JUDGES = 7;
private static final int N_THROWN_OUT = 2;
	
	public void run() {
		double[] scores = new double[N_JUDGES];
		for (int i = 0; i < scores.length; i++) {
			scores[i] = readDouble("Score for judge " + (i + 1) + ": ");
		}
		  
		int smallestIndex = 0;
		int largestIndex = 0;


		for (int i = 0; i < scores.length; i++) {
			if (scores[i] > scores[largestIndex]) {
				largestIndex = i;
			} else if (scores[i] < scores[smallestIndex]) {
				smallestIndex = i;
			}
		}
    
		scores[smallestIndex] = 0;
		scores[largestIndex] = 0;
		
		for (int i = 0; i < scores.length; i++) {
			System.out.println(scores[i]);
		}
		
		println("Average is: " + mean(scores));
	}

	private double mean(double[] array) {
		double total = 0;
		for (int i = 0; i < array.length; i++) {
			total += array[i];
		}
		return total / (array.length - N_THROWN_OUT);
	}
}
