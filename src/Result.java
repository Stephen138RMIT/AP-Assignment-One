import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collections;
import java.util.Comparator;

public class Result {
	
	//Contains a array list of AthleteScore. GameID and referee. Athletescore is tiny class, perhapse inner class can work.
	//Inner class
	private class AthleteScore{
		
		private String athleteID;
		private double timeScore;
		
		public AthleteScore(String newAthleteID, double newTimeScore) {
			athleteID = newAthleteID;
			timeScore = newTimeScore;
		}
		
		public String getAthleteID() {
			return athleteID;
		}
		
		public double getTimeScore() {
			return timeScore;
		}
		
	}
	/*
	This is comparator class for sorting. This allow for object sorting by specific elements.
	In this case sort athlete by time. 
	Solution derived from here. https://stackoverflow.com/questions/5805602/how-to-sort-list-of-objects-by-some-property
	*/
	public static Comparator<AthleteScore> AthleteTimeComparer = new Comparator<AthleteScore>(){
		@Override
		public int compare(AthleteScore x, AthleteScore y) {
			int startComparison	= compare(x.getTimeScore(), y.getTimeScore());
			return startComparison;
		}
		
		private int compare(double a, double b) {
			/*
			if(a< b) {
				return - 1;
			}
			else if(a > b) {
				return 1;
			}
			else {
				return 0;
			}
			*/
			//Below code is short hand for above code.
			return a < b ? -1
				:  a > b ? 1
				:0;
		}
	};
	
	//Get a list of the competing athlete.
	private ArrayList<Athlete> competingAthletes;
	private ArrayList<AthleteScore>  scoreList;
	private String gameID;
	private Athlete.Event gameEvent;
	private Official referee;
	
	public Result(String newGameID, ArrayList<Athlete> newCompetingAthletes, Athlete.Event newEvent, Official newReferee) {
		gameID = newGameID;
		scoreList = new ArrayList<AthleteScore>();
		competingAthletes = newCompetingAthletes;
		gameEvent = newEvent;
		referee = newReferee;
	}
	
	//Using athleteID get name
	//Probably could of implemented key value pair instead.
	public String getAthleteName(String athleteID) {
		Iterator<Athlete> athleteIterator = competingAthletes.listIterator();
		//Indicate name can't be found
		String athleteName = "NaN";
		while(athleteIterator.hasNext()) {
			Athlete tempAthlete;
			tempAthlete = athleteIterator.next();
			if(athleteID == tempAthlete.getAthleteID()) {
				athleteName = tempAthlete.getAthleteName();
				//found athlete name quit loop
				break;
			}
		}
		
		return athleteName;
		
	}
	
	
	public void addScore(String newAthleteID, double newTimeScore) {
		AthleteScore newScore = new AthleteScore(newAthleteID, newTimeScore);
		scoreList.add(newScore);
	}
	
	//This can not access name, it needs a referenced passed through.
	public void printScore() {
		
		//Something went wrong, the game should not of ran with less than 6
		if(scoreList.size() < 6){
			System.out.println("Error, less than 5 participant. " + scoreList.size() + " Participant detected.");
		}
		else {
			Iterator<AthleteScore> scoreIterator = scoreList.iterator();
			System.out.println();
			System.out.println("Game ID : " + gameID);
			printRefereeDetail();
			//This keeps track of iteration for naming winner.
			int i = 0;
			System.out.println("************************************************");
			while(scoreIterator.hasNext()) {
				AthleteScore tempScore = scoreIterator.next();
				System.out.printf(getAthleteName(tempScore.getAthleteID()) + " " + "%.3f" , tempScore.getTimeScore());
				System.out.print(" second ");
				
				if(i == 0) {
					//Seperation line
					//1st Place
					System.out.print(" Winner: 5 point");
					i++;
				}else if(i == 1) {
					//2nd Place
					System.out.print(" 2nd Place: 3 Point");
					i++;
				}else if(i == 2) {
					//3rd Place
					System.out.print(" 3rd Place: 1 Point");
					i++;
					//now that i is more than 2, it will be ignored
					//Print extra line for spacing
					System.out.println();
					System.out.println("---------------------------------------------");
				}
				
				System.out.println();
			}
			System.out.println("************************************************");
		}
	}
	
	//Sort the list from highest to lowest.
	public void sortList() {
		//Use collection to sort, use comparator.
		Collections.sort(scoreList, AthleteTimeComparer);
		
	}

	public void printRefereeDetail() {
		System.out.println("Referee " + referee.getID() + " Name: " + referee.getName() + " Age: " + referee.getAge() + " State: " + referee.getState());
	}
	
	public Athlete.Event getEvent(){
		return gameEvent;
	}
	
	//Similar to printScore, except it only show the winner.
	public void printWinner() {
		if(scoreList.size() < 5){
			System.out.println("Error, less than 5 participant.");
		}
		else {
			Iterator<AthleteScore> scoreIterator = scoreList.iterator();
			System.out.println("Game ID : " + gameID);
			printRefereeDetail();
			int i = 0;
			
			System.out.println("************************************************");
			while(scoreIterator.hasNext()) {
				AthleteScore tempScore = scoreIterator.next();
				System.out.printf(getAthleteName(tempScore.getAthleteID()) + " " + "%.3f" , tempScore.getTimeScore());
				System.out.print(" second ");
				
				if(i == 0) {
					//Seperation line
					//1st Place
					System.out.print(" Winner: 5 point");
					i++;
				}else if(i == 1) {
					//2nd Place
					System.out.print(" 2nd Place: 2 Point");
					i++;
				}else if(i == 2) {
					//3rd Place
					System.out.print(" 3rd Place: 1 Point");
					i++;
					//now that i is more than 2, it will be ignored
					//Print extra line for spacing
					break;
				}
				
				System.out.println();
			}
			System.out.println();
			System.out.println("************************************************");
		}
	}
		
	//Create a get ID using index, let result handler know which one
		
	public String getAthleteID(int index){
		if(scoreList.size() > 4)
		{
			return scoreList.get(index).getAthleteID();
			
		}
		else {
			//be wary of empty fields
			return null;
		}
	}
}
