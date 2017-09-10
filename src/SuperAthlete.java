
public class SuperAthlete extends Athlete{
	private Swimming swimmingComponent;
	private Running runningComponent;
	private Cycling cyclingComponent;
	
	/*
	 * TODO since component behaviour do not change, 
	 * Athlete should reference component instead of using up memory
	 * 
	 */
	
	
	public SuperAthlete(String name, String id) {
		super(name, id);
		swimmingComponent = new Swimming();
		runningComponent = new Running();
		cyclingComponent = new Cycling();
		isSwimmer = true;
		isRunner = true;
		isCyclist = true;
	}
	
	
	
	public void compete() {
		//Error on switch null error oops
		if (getEvent() == null){
			System.out.println("hello");
		}
		switch(getEvent()) {
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
			System.out.println(getAthleteName() + " can't compete");
		}
	}

}
