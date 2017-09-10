import java.util.concurrent.ThreadLocalRandom;

/*
 * Running behaviour component
 */
public class Running {
	
	static private int MINIMUM = 10;
	static private int MAXIMUM = 20;
	
	public void Run() {
		double randomNum = ThreadLocalRandom.current().nextDouble(MINIMUM, MAXIMUM + 1);
		System.out.printf("I Ran : %.3f%n", randomNum);
	}
}
