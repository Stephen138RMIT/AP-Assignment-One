
public class Runner extends Athlete {
	private Running runningComponent;
	public Runner(String name, String id) {
		super(name, id);
		runningComponent = new Running();
		isRunner = true;
	}
	
	public void compete() {
		if(currentEvent == Event.RUNNING) {
			runningComponent.Run();
		}else{
			System.out.println(this.athleteName + " can't compete");
		}
	}
}
