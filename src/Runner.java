
public class Runner extends Athlete {
	private Running runningComponent;
	public Runner(String name) {
		super(name);
		runningComponent = new Running();
	}
	
	public void compete() {
		if(currentEvent == Event.RUNNING) {
			runningComponent.Run();
		}else{
			System.out.println(this.athleteName + " can't compete");
		}
	}
}
