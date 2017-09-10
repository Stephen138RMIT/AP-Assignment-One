
public class Swimmer extends Athlete{
	private Swimming swimmingComponent;
	public Swimmer(String name, String id) {
		super(name, id);
		swimmingComponent = new Swimming();
		isSwimmer = true;
	}

	//Swimmer has a swimmingComponent
	public void compete() {
		//Only swim if the event is swmming
		if (getEvent() == Event.SWIMMING){
			swimmingComponent.Swim();
		}else {
			System.out.println(getAthleteName() + " can't compete");
		}
		
	}
}
