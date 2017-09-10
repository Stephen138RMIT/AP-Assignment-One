
public class IDGenerator {
	//Counter does not need to be big.
	private int counter;
	
	public IDGenerator() {
		counter = 0;
	}
	
	public String generateID() {
		return String.valueOf(counter++);
	}
	
}
