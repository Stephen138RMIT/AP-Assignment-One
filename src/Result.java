import java.io.IOException;
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
	private String predictedWinnerID;
	
	public Result(String newGameID, ArrayList<Athlete> newCompetingAthletes, Athlete.Event newEvent, Official newReferee) {
		gameID = newGameID;
		scoreList = new ArrayList<AthleteScore>();
		competingAthletes = newCompetingAthletes;
		gameEvent = newEvent;
		referee = newReferee;
	}
	
	//Using athleteID get name
	//Probably could of implemented key value pair instead.
	//This may be depecrated
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
	
	//Public all athlete detail plus score
	public void printAthleteDetail(AthleteScore score) {
		
		String athleteID = score.getAthleteID();
		
		Iterator<Athlete> athleteIterator = competingAthletes.listIterator();
		while(athleteIterator.hasNext()) {
			Athlete tempAthlete;
			tempAthlete = athleteIterator.next();
			if(athleteID == tempAthlete.getAthleteID()) {
				
				String athleteName = tempAthlete.getAthleteName();
				int athleteAge = tempAthlete.getAge();
				Athlete.States athleteState = tempAthlete.getState();
				
				System.out.print("ID: " + athleteID  + " Name: " + athleteName + " Age: " + athleteAge + " State: " + athleteState);
				System.out.printf(" Time: %.3f" , score.getTimeScore());
				//found athlete name quit loop
				break;
			}
		}
		
		
		System.out.printf("%.3f" , score.getTimeScore());
	}
	
	
	public void addScore(String newAthleteID, double newTimeScore) {
		AthleteScore newScore = new AthleteScore(newAthleteID, newTimeScore);
		scoreList.add(newScore);
	}
	
	// A misnomer, it actually runs the game.
	
	// This function is important, it will tell if the game can be ran or not.
	
	public boolean canCompete() {
		if(scoreList.size() < 6){
			System.out.println("Error, less than 5 participant. " + scoreList.size() + " Participant detected.");
			return false;
		}
		return true;
	}
	
	//Return number of athlete
	public int getNoAthlete() {
		return competingAthletes.size();
	}
	
	//Print out list of competing Athlete, no score, with index number for reference
	
	public void printCompetingAthlete() {
		
		int noAthlete = competingAthletes.size();
		
		for(int i = 0; i < noAthlete; i++) {
			
			String athleteID = competingAthletes.get(i).getAthleteID();
			String athleteName = competingAthletes.get(i).getAthleteName();
			Athlete.States athleteState = competingAthletes.get(i).getState();
			int athleteAge = competingAthletes.get(i).getAge();
			System.out.println("Index :" + i + " ID: " + athleteID  + " Name: " + athleteName + " Age: " + athleteAge + " State: " + athleteState);	
		}
		
		
	}
	
	public void printScore() {
		
		//Something went wrong, the game should not of ran with less than 6
		
		if(canCompete()) {
			Iterator<AthleteScore> scoreIterator = scoreList.iterator();
			System.out.println();
			System.out.println("Game ID : " + gameID);
			System.out.println("Predicted Winner: " + predictedWinnerID + " Name: " + getAthleteName(predictedWinnerID));
			printRefereeDetail();
			//This keeps track of iteration for naming winner.
			int i = 0;
			System.out.println("************************************************");
			while(scoreIterator.hasNext()) {
				AthleteScore tempScore = scoreIterator.next();
				printAthleteDetail(tempScore);
								
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
	
	//Something like should go in a game loop.
	//Similar to printScore except it will be delayed.
	//Time can be optionally skipped.
	
	//Attempt to implement code from here
	//https://stackoverflow.com/questions/3491027/java-console-code-for-stopwatch-timer
	public void printScoreTimed() {
		
		
		
		if(canCompete()) {
			//Iterator<AthleteScore> scoreIterator = scoreList.iterator();
			System.out.println();
			System.out.println("Game ID : " + gameID);
			System.out.println("Predicted Winner: " + predictedWinnerID + " Name: " + getAthleteName(predictedWinnerID));
			printRefereeDetail();
			//This keeps track of iteration for naming winner.
			int i = 0;
			System.out.println("************************************************");
			
			//Since this is already sorted, we delay. 
			//Once the current time score elapse, go to next one
			
			int charsWritten = 0;
			long start = System.currentTimeMillis();
			//This keep track of current athlete timeScore.
			//Start the time score at the first one
			double timeScore = scoreList.get(0).getTimeScore();
			boolean endTime = false;
			AthleteScore tempScore = null;
			
			//Check if the scoreList has stuff
			if(scoreList.size() < 1) {
				endTime = true;
			}
			
			int scoreIndex = 0;
			//Can not display stop watch. Instead wait in real time.
			while (!endTime) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				long elapsedTime = System.currentTimeMillis() - start;
				elapsedTime = elapsedTime / 1000;
				
				
				//Operate with iterator.
				//When timeScore has been reached get the nextAthlete score.
				if(elapsedTime % 60 > timeScore) {
					if(scoreIndex < scoreList.size()) {
						tempScore = scoreList.get(scoreIndex);
						printAthleteDetail(tempScore);
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
							//now that i is more than 2, There is no more winner.
							//Print extra line for spacing
							System.out.println();
							System.out.println("---------------------------------------------");
						}
						System.out.println();
						
						scoreIndex++;
						if(scoreIndex < scoreList.size() -1) {
							timeScore = scoreList.get(scoreIndex + 1).getTimeScore();
						}
						
					}else {
						//There is no more score, end the time loop
						endTime = true;
						System.out.println();
					}
				}
			}
			//Finally outside the loop
			System.out.println();
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
	
	//set Winner by index
	public void predictWinner(int index) {
		//Set the winner to be predicted
		predictedWinnerID = competingAthletes.get(index).getAthleteID();
	}
	
	public boolean isWinner() {
		if(predictedWinnerID == null) {
			return false;
		}
		
		//Is the predicted winner id in the top?
		if(predictedWinnerID == getAthleteID(0)) {
			return true;
		}
		return false;
	}
	
	//Similar to printScore, except it only show the winner.
	public void printWinner() {
		if(canCompete()){
			Iterator<AthleteScore> scoreIterator = scoreList.iterator();
			System.out.println("Game ID : " + gameID);
			printRefereeDetail();
			int i = 0;
			
			System.out.println("************************************************");
			while(scoreIterator.hasNext()) {
				AthleteScore tempScore = scoreIterator.next();
				printAthleteDetail(tempScore);
				
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
