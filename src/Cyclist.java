
public class Cyclist extends Athlete{
	private Cycling cyclingComponent;
	
	public Cyclist(String name, String id, int age, Athlete.States state) {
		super(name, id, age, state);
		cyclingComponent = new Cycling();
		isCyclist = true;
	}
	
	public double compete() {
		if(getEvent() == Event.CYCLING) {
			return cyclingComponent.Cycle();
		}else {
			System.out.println(getAthleteName() + " can't compete");
			return 0;
		}
	}
	
}
