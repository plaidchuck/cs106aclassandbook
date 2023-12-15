import acm.program.*;

public class Sieve extends ConsoleProgram {
	public void run() {
		int lastNumber = readInt("Display all prime numbers up to: ");
		displayPrimeNumbers(lastNumber);
	}
	
	private void displayPrimeNumbers(int n) {
		boolean[] primes = new boolean[n + 1];
		for (int k = 0; k < primes.length; k++) {
			primes[k] = true;
		}
		
		for (int i = 2; i <= Math.sqrt(n); i++) {
			for (int j = i * i; j <= n; j += i) {
				primes[j] = false;
			}
		}
		for (int m = 2; m <= n; m++) {
			if (primes[m] == true) {
				println(m);
			}
		}
	}
}
