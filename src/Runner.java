
public class Runner extends Athlete {
	private Running runningComponent;
	public Runner(String name, String id) {
		super(name, id);
		runningComponent = new Running();
		isRunner = true;
	}
	
	public double compete() {
		if(getEvent() == Event.RUNNING) {
			return runningComponent.Run();
		}else{
			System.out.println(getAthleteName() + " can't compete");
			return 0;
		}
	}
}
