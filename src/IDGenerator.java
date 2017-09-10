
public class IDGenerator {
	//Pretty simple just start with 0 and increment.
	private int counter;
	
	public IDGenerator() {
		counter = 0;
	}
	
	public String generateID() {
		//Post increment, current value will be returned, afterwards the variable will be incremented
		return String.valueOf(counter++);
	}
	
}
