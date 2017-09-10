/*
 * Swimming behaviour component
 */
import java.util.concurrent.ThreadLocalRandom;



public class Swimming {
	
	static private int MINIMUM = 100;
	static private int MAXIMUM = 200;
	
	//TODO component return output such as time
	public double Swim() {
		double randomNum = ThreadLocalRandom.current().nextDouble(MINIMUM, MAXIMUM + 1);
		System.out.printf("I swam : %.3f%n", randomNum);
		return randomNum;
	}
}
