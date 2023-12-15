import acm.program.*;

public class MorseCode extends ConsoleProgram {
	public void run() {
		String[] morse = 
			 {
				" ",     // 0 index that will not be used
	            ".-",    // A 1
	            "-...",  // B
	            "-.-.",  // C
	            "-..",   // D
	            ".",     // E
	            "..-.",  // F
	            "--.",   // G
	            "....",  // H
	            "..",    // I
	            ".---",  // J
	            "-.-",   // K
	            ".-..",  // L
	            "--",    // M
	            "-.",    // N
	            "---",   // O
	            ".--.",  // P
	            "--.-",  // Q
	            ".-.",   // R
	            "...",   // S
	            "-",     // T
	            "..-",   // U
	            "...-",  // V
	            ".--",   // W
	            "-..-",  // X
	            "-.--",  // Y
	            "--.."   // Z 26
	        };
		String text = readLine("Enter english text: ");
		translateText(morse, text);
	}

	private void translateText(String[] morse, String text) {
		for (int i = 0; i < text.length(); i++) {
			char currentChar = Character.toUpperCase(text.charAt(i));
			if (Character.isWhitespace(currentChar)) {
				println("");
			} else {
				print(morse[(currentChar - 'A') + 1] + " ");
			}
		}
	}
}
