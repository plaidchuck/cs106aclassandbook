import acm.program.*;

public class CountLetterFrequencies extends ConsoleProgram {
	public void run() {
		println("Counts letter frequencies.");
		println("Enter a blank line to indicate end of text.");
		initFrequencyTable();
		while (true) {
			String line = readLine();
			if (line.length() == 0) break;
			countLetterFrequencies(line);
		}
		printFrequencyTable();
	}
	
	private void initFrequencyTable() {
		frequencyTable = new int[26];
		for (int i = 0; i < 26; i++) {
			frequencyTable[i] = 0;
		}
	}
	
	private void countLetterFrequencies(String line) {
		for (int i = 0; i < line.length(); i++) {
			char ch = line.charAt(i);
			if (Character.isLetter(ch)) {
				int index = Character.toUpperCase(ch) - 'A';
				frequencyTable[index]++;
			}
		}
	}
	
	private void printFrequencyTable() {
		for (char ch = 'A'; ch <= 'Z'; ch++) {
			int index = ch - 'A';
			println(ch + ": " + frequencyTable[index]);
		}
	}
	
	private int[] frequencyTable;
}
