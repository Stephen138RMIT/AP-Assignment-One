
public class Main {
	
	//Proof of concept for composition of Super Athlete
	public static void main(String args[]) {
		
		Swimmer Joe_Swimmer = new Swimmer("Joe");
		//Test no event
		Joe_Swimmer.compete();
		//Set event
		Joe_Swimmer.setEvent(Athlete.Event.SWIMMING);
		//He should swim now
		Joe_Swimmer.compete();
		
		Cyclist smith = new Cyclist("Smith");
		smith.compete();
		smith.setEvent(Athlete.Event.CYCLING);
		smith.compete();
		
		Runner chloe = new Runner("Cloe");
		chloe.compete();
		chloe.setEvent(Athlete.Event.RUNNING);
		chloe.compete();
		
		SuperAthlete clair = new SuperAthlete("Clair");
		
		clair.compete();
		clair.setEvent(Athlete.Event.CYCLING);
		clair.compete();
		clair.setEvent(Athlete.Event.RUNNING);
		clair.compete();
		clair.setEvent(Athlete.Event.SWIMMING);
		clair.compete();
		
	}
	
}
