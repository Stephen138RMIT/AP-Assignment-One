
public class SuperAthlete extends Athlete{
	private Swimming swimmingComponent;
	private Running runningComponent;
	private Cycling cyclingComponent;
	
	/*
	 * TODO since component behaviour do not change, 
	 * Athlete should reference component instead of using up memory
	 * 
	 */
	
	
	public SuperAthlete(String name) {
		super(name);
		swimmingComponent = new Swimming();
		runningComponent = new Running();
		cyclingComponent = new Cycling();
		
	}
	
	public void compete() {
		//Error on switch null error oops
		if (currentEvent == null){
			System.out.println("hello");
		}
		switch(currentEvent) {
		case CYCLING:
			cyclingComponent.Cycle();
			break;
		case RUNNING:
			runningComponent.Run();
			break;
		case SWIMMING:
			swimmingComponent.Swim();
			break;
		default:
			System.out.println(this.athleteName + " can't compete");
		}
	}

}
