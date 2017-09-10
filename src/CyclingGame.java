import java.util.ArrayList;
import java.util.Iterator;

public class CyclingGame implements Game{
	
	private String gameID;
	private ArrayList<Athlete> allAthlete;
	private Result storedResult;
	private Referee currentReferee;
	
	//constant to shorten the lengthy enum typing
	
	private static final Athlete.Event CYCLEEVENT = Athlete.Event.CYCLING;
	private static final Athlete.AthleteType CYCLIST = Athlete.AthleteType.CYCLIST;

	public CyclingGame(String newGameID, ArrayList<Athlete> athleteList, Referee newReferee){
		gameID = "CYC" + newGameID;
		allAthlete = athleteList;
		currentReferee = newReferee;
	}
	
	@Override
	public boolean competition() {

		ArrayList<Athlete> cyclingAthletes = new ArrayList<Athlete>();
		Iterator<Athlete> x = allAthlete.iterator();
		
		while(x.hasNext()) {
			Athlete tempAthlete = x.next();
			if(tempAthlete.isAthleteType(CYCLIST)) {
				//System.out.println(tempAthlete.getAthleteName() + " added");
				cyclingAthletes.add(tempAthlete);
			}
		}
		//Create result
		if(cyclingAthletes.size() < 5) {
			System.out.println("Less than 5 athlete detected, Cancelling event.");
			return false;
		}
		else {
			//Check if the referee is present, if not game can't happen.
			if(currentReferee != null) {
				//Check if right referee.
				if(currentReferee.getEvent() == CYCLEEVENT)
				{
					//Give the method to referee.
					//get Result back
					storedResult = currentReferee.SumGame(gameID, cyclingAthletes);
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
