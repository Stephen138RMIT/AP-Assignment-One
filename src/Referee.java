import java.util.ArrayList;

public class Referee implements Official{
	
	private Athlete.Event eventJudge;
	private String officialID;
	private String name;
	private int age;
	private Athlete.States state;
	
	public Referee(String newID, String newName,int newAge, Athlete.States newState, Athlete.Event newEvent){
		
		officialID = "REF" + newID;
		name = newName;
		age = newAge;
		state = newState;
		eventJudge = newEvent;
	}

	//Take Result, Athlete list, sum the game and return.
	@Override
	public Result SumGame(String gameID, ArrayList<Athlete> gameAthletes) {
		//Event does not need to pass in, assume a proper check has been done.
		Result gameResult = new Result(gameID, gameAthletes, eventJudge, this);
		
		int noAthlete = gameAthletes.size();
		//System.out.println("size of swimming Athlete " + gameAthletes.size());
		if(noAthlete > 8) {
			System.out.println("Athlete number exceed 8, only first 8 may compete.");
			noAthlete = 8;
		}
		
		
		
		for(int i = 0; i < noAthlete; i++) {
			Athlete tempAthlete = gameAthletes.get(i);
			tempAthlete.setEvent(eventJudge);
			//Figure out how to create timer class later.
			//For now instant create result and store first.
			gameResult.addScore(tempAthlete.getAthleteID(),tempAthlete.compete());
		}
		
		gameResult.sortList();
		gameResult.printScore();
		return gameResult;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Athlete.States getState() {
		return state;
	}

	@Override
	public String getID() {
		return officialID;
	}

	@Override
	public int getAge() {
		return age;
	}

	@Override
	public Athlete.Event getEvent() {
		return eventJudge;
	}
	
	
	
	
	//Referee can't judge thing that are not responsible for
}
