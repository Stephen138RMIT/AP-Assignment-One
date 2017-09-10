import java.util.ArrayList;
import java.util.Iterator;

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
	
	//Get a list of the competing athlete.
	private ArrayList<Athlete> competingAthletes;
	private ArrayList<AthleteScore>  scoreList;
	private String gameID;
	
	public Result(String newGameID, ArrayList<Athlete> newCompetingAthletes) {
		gameID = newGameID;
		scoreList = new ArrayList<AthleteScore>();
		competingAthletes = newCompetingAthletes;
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
		Iterator<AthleteScore> scoreIterator = scoreList.listIterator();
		System.out.println("Game ID :" + gameID);
		while(scoreIterator.hasNext()) {
			AthleteScore tempScore = scoreIterator.next();
			System.out.printf(getAthleteName(tempScore.getAthleteID()) + " Score : " + "%.3f%n" , tempScore.getTimeScore());
			
		}
		
	}
	
	
	//TODO return score list or something
	//Recognise game type.
	//Sort the list.
	//Get points
	//Result stores top 3 winner.
}
