
public class Swimmer extends Athlete{
	private Swimming swimmingComponent;
	public Swimmer(String name) {
		super(name);
		swimmingComponent = new Swimming();
	}

	//Swimmer has a swimmingComponent
	public void compete() {
		//Only swim if the event is swmming
		if (currentEvent == Event.SWIMMING){
			swimmingComponent.Swim();
		}else {
			System.out.println(this.athleteName + " can't compete");
		}
		
	}
}
