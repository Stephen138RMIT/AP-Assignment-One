import java.util.ArrayList;
import java.util.Iterator;


public class Game {
	//TODO Make this into interface, create subclass and port the code over.
	private String gameID;
	private ArrayList<Athlete> allAthlete;
	private Athlete.Event currentEvent;
	private ArrayList<Result> gameResult;
	
	public Game(String newGameID, ArrayList<Athlete> athleteList, Athlete.Event newEvent){
		gameID = "G" + newGameID;
		allAthlete = athleteList;
		currentEvent = newEvent;
	}
	
	//Make into inheritance structure.
	
	public void cyclingCompetition() {

		ArrayList<Athlete> cyclingAthletes = new ArrayList<Athlete>();
		Iterator<Athlete> x = allAthlete.iterator();
		
		while(x.hasNext()) {
			Athlete tempAthlete = (Athlete) x.next();
			if(tempAthlete.isAthleteType(Athlete.AthleteType.CYCLIST)) {
				cyclingAthletes.add(tempAthlete);
			}
		}
	}
	
	public void swimmingCompetition() {

		ArrayList<Athlete> swimmingAthletes = new ArrayList<Athlete>();
		Iterator<Athlete> x = allAthlete.iterator();
		
		while(x.hasNext()) {
			Athlete tempAthlete = (Athlete) x.next();
			if(tempAthlete.isAthleteType(Athlete.AthleteType.SWIMMER)) {
				swimmingAthletes.add(tempAthlete);
			}
		}
	}
	
	public void runningCompetition() {

		ArrayList<Athlete> runningAthletes = new ArrayList<Athlete>();
		Iterator<Athlete> x = allAthlete.iterator();
		
		while(x.hasNext()) {
			Athlete tempAthlete = x.next();
			if(tempAthlete.isAthleteType(Athlete.AthleteType.RUNNER)) {
				System.out.println(tempAthlete.getAthleteName() + " added");
				runningAthletes.add(tempAthlete);
			}
		}
		//Create result
		Result runningResult = new Result(gameID, runningAthletes);
		
		Iterator<Athlete> runningAthleteIterator = runningAthletes.iterator();
		
		while(runningAthleteIterator.hasNext()) {
			Athlete tempRunner = runningAthleteIterator.next();
			tempRunner.setEvent(Athlete.Event.RUNNING);
			//Figure out how to create timer class later.
			//For now instant create result and store first.
			runningResult.addScore(tempRunner.getAthleteID(),tempRunner.compete());
		}
		runningResult.sortList();
		runningResult.printScore();
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
