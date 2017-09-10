import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;


public class Game {
	//TODO Make this into interface, create subclass and port the code over.
	private String gameID;
	private ArrayList<Athlete> allAthlete;
	private Athlete.Event currentEvent;
	
	public Game(String newGameID, ArrayList<Athlete> athleteList, Athlete.Event newEvent){
		gameID = "G" + newGameID;
		allAthlete = athleteList;
		currentEvent = newEvent;
	}
	
	//Make into inheritance structure.
	
	public void cyclingCompetition() {

		LinkedList<Athlete> cyclingAthletes = new LinkedList<Athlete>();
		Iterator<Athlete> x = allAthlete.listIterator();
		
		while(x.hasNext()) {
			Athlete tempAthlete = (Athlete) x.next();
			if(tempAthlete.isAthleteType(Athlete.AthleteType.CYCLIST)) {
				cyclingAthletes.add(tempAthlete);
			}
		}
	}
	
	public void swimmingCompetition() {

		LinkedList<Athlete> swimmingAthletes = new LinkedList<Athlete>();
		Iterator<Athlete> x = allAthlete.listIterator();
		
		while(x.hasNext()) {
			Athlete tempAthlete = (Athlete) x.next();
			if(tempAthlete.isAthleteType(Athlete.AthleteType.SWIMMER)) {
				swimmingAthletes.add(tempAthlete);
			}
		}
	}
	
	public void runningCompetition() {

		LinkedList<Athlete> runningAthletes = new LinkedList<Athlete>();
		Iterator<Athlete> x = allAthlete.listIterator();
		
		while(x.hasNext()) {
			Athlete tempAthlete = x.next();
			if(tempAthlete.isAthleteType(Athlete.AthleteType.RUNNER)) {
				runningAthletes.add(tempAthlete);
			}
		}
		
		Iterator<Athlete> runningAthlete = allAthlete.listIterator();
		
		while(runningAthlete.hasNext()) {
			Athlete tempRunner = runningAthlete.next();
			tempRunner.setEvent(Athlete.Event.RUNNING);
			tempRunner.compete();
		}
		
	}
	
	public void competition() {
		switch (currentEvent) {
		case CYCLING:
			cyclingCompetition();
			break;
		case RUNNING:
			runningCompetition();
			break;
		case SWIMMING:
			swimmingCompetition();
			break;
		default:
			//There is an error, event not recognised or null
		}
				
	}
	//TODO Concept finished move function to event.
}
