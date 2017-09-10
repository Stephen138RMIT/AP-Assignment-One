import java.util.ArrayList;
import java.util.Iterator;

public class SwimmingGame implements Game{
	
	private String gameID;
	private ArrayList<Athlete> allAthlete;
	private Result storedResult;
	private Referee currentReferee;
	
	//Constant to shorten lengthy enum
	private static final Athlete.Event SWIMEVENT = Athlete.Event.SWIMMING;
	private static final Athlete.AthleteType SWIMMER = Athlete.AthleteType.SWIMMER;

	public SwimmingGame(String newGameID, ArrayList<Athlete> athleteList, Referee newReferee){
		gameID = "SWIM" + newGameID;
		allAthlete = athleteList;
		currentReferee = newReferee;
		//Create an empty result
	}
	
	@Override
	public boolean competition() {

		ArrayList<Athlete> swimmingAthletes = new ArrayList<Athlete>();
		Iterator<Athlete> x = allAthlete.iterator();
		
		while(x.hasNext()) {
			Athlete tempAthlete = x.next();
			if(tempAthlete.isAthleteType(SWIMMER)) {
				//System.out.println(tempAthlete.getAthleteName() + " added");
				swimmingAthletes.add(tempAthlete);
			}
		}
		//Create result
		
		//Create a check for number of Athlete, cancel competition when less than 6 athlete detected.
		if(swimmingAthletes.size() < 6) {
			System.out.println("Less than 6 athlete detected, Cancelling event.");
			return false;
		}
		else {
			//Check if the referee is present, if not game can't happen.
			if(currentReferee != null) {
				//Check if right referee.
				if(currentReferee.getEvent() == SWIMEVENT)
				{
					//Give the method to referee.
					//get Result back
					storedResult = currentReferee.SumGame(gameID, swimmingAthletes);
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
		//Beware of null result.
		return storedResult;
	}
	
}
