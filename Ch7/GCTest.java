import acm.program.*;

public class GCTest extends ConsoleProgram {
	
	public void run() {
		Runtime myRuntime = Runtime.getRuntime();
		println("Allocating 10000 Rational objects");
		for (int i = 0; i < 10000; i++) {
			new Rational(90, 20);
		}
		long beforeCollection = myRuntime.freeMemory();
		myRuntime.gc();
		long afterCollection = myRuntime.freeMemory();
		println("Garbage collection freed " + (afterCollection - beforeCollection) + " bytes");
	}
	

}
