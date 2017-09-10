
public class Cyclist extends Athlete{
	private Cycling cyclingComponent;
	
	public Cyclist(String name, String id) {
		super(name, id);
		cyclingComponent = new Cycling();
		isCyclist = true;
	}
	
	public void compete() {
		if(currentEvent == Event.CYCLING) {
			cyclingComponent.Cycle();
		}else {
			System.out.println(this.athleteName + " can't compete");
		}
		
	}
	
}
