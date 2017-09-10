
public class Cyclist extends Athlete{
	private Cycling cyclingComponent;
	
	public Cyclist(String name, String id) {
		super(name, id);
		cyclingComponent = new Cycling();
		isCyclist = true;
	}
	
	public void compete() {
		if(getEvent() == Event.CYCLING) {
			cyclingComponent.Cycle();
		}else {
			System.out.println(getAthleteName() + " can't compete");
		}
		
	}
	
}
