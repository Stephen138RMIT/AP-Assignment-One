import java.util.Iterator;
import java.util.LinkedList;

public class Event {
	//TODO remove this one test succesful and make proper event class.
	public void test(){
		Swimmer Joe_Swimmer = new Swimmer("Joe", "1");
		//Test no event
		Joe_Swimmer.compete();
		//Set event
		Joe_Swimmer.setEvent(Athlete.Event.SWIMMING);
		//He should swim now
		Joe_Swimmer.compete();
		
		Cyclist smith = new Cyclist("Smith", "2");
		smith.compete();
		smith.setEvent(Athlete.Event.CYCLING);
		smith.compete();
		
		Runner chloe = new Runner("Cloe", "3");
		chloe.compete();
		chloe.setEvent(Athlete.Event.RUNNING);
		chloe.compete();
		
		SuperAthlete clair = new SuperAthlete("Clair", "4");
		
		clair.compete();
		clair.setEvent(Athlete.Event.CYCLING);
		clair.compete();
		clair.setEvent(Athlete.Event.RUNNING);
		clair.compete();
		clair.setEvent(Athlete.Event.SWIMMING);
		clair.compete();
		
		//recognisition of athlete
		
		if(clair.isAthleteType(Athlete.AthleteType.SWIMMER)) {
			System.out.println("clair is a swimmer");
		}
		
		if(!chloe.isAthleteType(Athlete.AthleteType.SWIMMER)) {
			System.out.println("Chloe is not a swimmer");
		}
		
		//Test Array, use reference if possible.
		//Linked list of all athlete
		LinkedList<Athlete> allAthlete = new LinkedList<Athlete>();
		allAthlete.add(Joe_Swimmer);
		allAthlete.add(chloe);
		allAthlete.add(smith);
		allAthlete.add(clair);
		
		//Get only swimmers and add them into another list.
		
		LinkedList<Athlete> swimmerAthlete = new LinkedList<Athlete>();
		Iterator<Athlete> x = allAthlete.listIterator();
		
		while(x.hasNext()) {
			Athlete tempAthlete = (Athlete) x.next();
			if(tempAthlete.isAthleteType(Athlete.AthleteType.SWIMMER)) {
				swimmerAthlete.add(tempAthlete);
				System.out.println("added athlete");
			}
		}
		
		// Joe and clair should be competing
		
		Iterator<Athlete> competeX = swimmerAthlete.listIterator();
		
		//There is two athlete but only one competed
		
		System.out.println("size of swimmer athlete: " + swimmerAthlete.size());
		
		while(competeX.hasNext()) {
			Athlete currentAthlete = competeX.next();
			currentAthlete.setEvent(Athlete.Event.SWIMMING);
			//Override should happen.
			currentAthlete.compete();
		}
	}
	//TODO Concept finished move function to event.
}
