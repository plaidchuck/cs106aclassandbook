import acm.program.*;

public class Nim extends ConsoleProgram {
	public void run() {
		int matches = 11;
		int playerRemovedMatches = 0;
		int computerRemovedMatches = 0;
		int turn = 0;
		println("The game starts with 11 matches.");
		while (matches > 0) {
			if (turn % 2 == 0) {
				do {
					playerRemovedMatches = readInt("You can take 1, 2, or 3 matches at one time: ");
				}
				while (playerRemovedMatches < 1 || playerRemovedMatches > 3);
				matches -= playerRemovedMatches;
				} else {
					if (matches > 4 && matches != 5 && matches != 6) {
						computerRemovedMatches = 4 - playerRemovedMatches;
						matches -= computerRemovedMatches;
						println("The computer removed " + computerRemovedMatches + " matches.");	
				}
					else if (matches <= 4) {
						computerRemovedMatches = matches - 1;
						matches -= computerRemovedMatches;
						println("The computer removed " + computerRemovedMatches + " matches.");
				}
					else {
						computerRemovedMatches = 1;
						matches -= computerRemovedMatches;
						println("The computer removed " + computerRemovedMatches + " matches.");
					}
			}
					
			if (matches > 1) println("There are " + matches + " matches left.");
			else if (matches == 1) println("There is " + matches + " match left.");
			else if (matches <= 0) {
				println("You took the last match. You lose!");
			}
			pause(1500);
			turn++;
		}
	}

}
