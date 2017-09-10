import java.util.ArrayList;
import java.util.Iterator;

public class RunningGame implements Game{
	
	private String gameID;
	private ArrayList<Athlete> allAthlete;
	private Result storedResult;
	private Referee currentReferee;
	
	//Constant to shorten lengthy enmum typing.
	private static final Athlete.Event RUNEVENT = Athlete.Event.RUNNING;
	private static final Athlete.AthleteType RUNNER = Athlete.AthleteType.RUNNER;
	
	public RunningGame(String newGameID, ArrayList<Athlete> athleteList, Referee newReferee){
		gameID = "RUN" + newGameID;
		allAthlete = athleteList;
		currentReferee = newReferee;
	}
	
	@Override
	public boolean competition() {
		

		//Create a list of runner
		ArrayList<Athlete> runningAthletes = new ArrayList<Athlete>();
		Iterator<Athlete> x = allAthlete.iterator();
		//Filter out non runner.
		while(x.hasNext()) {
			Athlete tempAthlete = x.next();
			if(tempAthlete.isAthleteType(RUNNER)) {
				//System.out.println(tempAthlete.getAthleteName() + " added");
				runningAthletes.add(tempAthlete);
			}
		}
		
		//Create a check for number of Athlete, cancel competition when less than 6 athlete detected.
		if(runningAthletes.size() < 5) {
			System.out.println("Less than 5 athlete detected, Cancelling event.");
			return false;
		}
		else {
			//Check if the referee is present, if not game can't happen.
			if(currentReferee != null) {
				//Check if right referee.
				if(currentReferee.getEvent() == RUNEVENT)
				{
					//Give the method to referee.
					//get Result back
					storedResult = currentReferee.SumGame(gameID, runningAthletes);
					return true;
				}else {
					System.out.println("Game can't start, wrong referee");
					return false;
				}
			}
			else {
				System.out.println("Game can't start, referee not present.");
				return false;
			}
			
		}
	}
	@Override
	public Result getResult() {
		return storedResult;
	}
	
}
