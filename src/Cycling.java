/*
 * Cycling behaviour component
 */

import java.util.concurrent.ThreadLocalRandom;


public class Cycling {
	
	static private int MINIMUM = 500;
	static private int MAXIMUM = 800;
	
	public double Cycle() {
		double randomNum = ThreadLocalRandom.current().nextDouble(MINIMUM, MAXIMUM + 1);
		System.out.printf("I Cycled : %.3f%n", randomNum);
		return randomNum;
	}
}
