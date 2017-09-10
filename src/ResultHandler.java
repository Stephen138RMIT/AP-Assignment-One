import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;
import java.util.HashMap;

public class ResultHandler {
	private ArrayList<Result> resultList;
	private ArrayList<Athlete> athleteList;

	public ResultHandler() {
		resultList = new ArrayList<Result>();
		athleteList = new ArrayList<Athlete>();
	}
	
	//Setting new athlete list clears old result.
	//This prevent issue of new athlete not matching old result.
	public void setAthleteList(ArrayList<Athlete> newAthleteList) {
		athleteList = newAthleteList;
		resultList.clear();
	}
	
	public void addResult(Result newResult){
		resultList.add(newResult);
	}
	
	//Check if there any result
	public boolean hasResult() {
		if (resultList.size() > 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void printLastResultAll() {
		printLastSwimGame();
		printLastRunGame();
		printLastCycleGame();
	}
	
	public void printLastSwimGame() {
		
		if(hasResult()) {
			//Create iterator and collect all instance of swim game.
			//Repeat for other method
			//This time ListIterator is needed.
			//Result are appended to the end of the list, the last element is the most recent.
			ListIterator<Result> resultIterator = resultList.listIterator();
			ArrayList<Result> swimResultList = new ArrayList<Result>();
			System.out.println("we have swim result");
			while(resultIterator.hasNext()) {
				Result tempResult = resultIterator.next();
				if(tempResult.getEvent() == Athlete.Event.SWIMMING) {
					swimResultList.add(tempResult);
				}
			}
			
			if(swimResultList.size() > 0) {
				//Print the winner of the last element in the list.
				swimResultList.get(swimResultList.size() - 1).printWinner();
			}else {
				System.out.println("Swim result is empty, run some swim game.");
			}
			
			
		}else {
			System.out.println("Swim result is empty");
		}
			
		
	}
	
	public void printLastRunGame() {
		if(hasResult()) {
			//Create iterator and collect all instance of swim game.
			//Repeat for other method
			//This time ListIterator is needed.
			//Result are appended to the end of the list, the last element is the most recent.
			ListIterator<Result> resultIterator = resultList.listIterator();
			ArrayList<Result> runResultList = new ArrayList<Result>();
			
			while(resultIterator.hasNext()) {
				Result tempResult = resultIterator.next();
				if(tempResult.getEvent() == Athlete.Event.RUNNING) {
					runResultList.add(tempResult);
				}
			}
			
			if(runResultList.size() > 0) {
				//Print the winner of the last element in the list.
				runResultList.get(runResultList.size() - 1).printWinner();
			}else {
				System.out.println("Run result is empty, start some running game.");
			}
		}else {
			System.out.println("Run result is empty");
		}
		
	}
	
	public void printLastCycleGame() {
		if(hasResult()) {
			//Create iterator and collect all instance of swim game.
			//Repeat for other method
			//This time ListIterator is needed.
			//Result are appended to the end of the list, the last element is the most recent.
			ListIterator<Result> resultIterator = resultList.listIterator();
			ArrayList<Result> cycleResultList = new ArrayList<Result>();
			
			while(resultIterator.hasNext()) {
				Result tempResult = resultIterator.next();
				if(tempResult.getEvent() == Athlete.Event.CYCLING) {
					cycleResultList.add(tempResult);
				}
			}
			
			if(cycleResultList.size() > 0) {
				//Print the winner of the last element in the list.
				cycleResultList.get(cycleResultList.size() - 1).printWinner();
			}else {
				System.out.println("Cycle result is empty, run some Cycle game");
			}
		}else {
			System.out.println("Cycle result is empty");
		}
	}
	
	//Copied from result.
	public String getAthleteName(String athleteID) {
		Iterator<Athlete> athleteIterator = athleteList.iterator();
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
	
	//Print all the athlete and their score.
	public void printAllAthlete() {
		//Create a key value pair
		if(athleteList.size() > 0) {
			if(resultList.size() > 0) {
				HashMap<String,Integer> athleteMap = new HashMap<String,Integer>();
				
				//Create athleteList iterator
				Iterator<Athlete> athleteListIterator = athleteList.iterator();
				
				//Add all athlete ID to hashmap
				while(athleteListIterator.hasNext()) {
					String athleteID = athleteListIterator.next().getAthleteID();
					//athleteMap.put(athleteListIterator.next().getAthleteID(), 0);
					athleteMap.put(athleteID, 0);
					//System.out.println(athleteID + " : " + athleteMap.get(athleteID));
				}
				
				//Create result iterator
				Iterator<Result> resultListIterator = resultList.iterator();
				
				while(resultListIterator.hasNext()) {
					Result tempResult = resultListIterator.next();
					//This assume winner have been sorted.
					//Get winner number 1. Replace with the added value
					//This will fail if there is less than 5 athlete.
					String tempKey = tempResult.getAthleteID(0);
				
					
					if(tempKey != null) {
						int tempInt = athleteMap.get(tempKey);
						athleteMap.put(tempKey,tempInt + 5 );
						
						//Second place gets 2 point.
						athleteMap.put(tempResult.getAthleteID(1),athleteMap.get(tempResult.getAthleteID(0)) + 2 );
						
						//Third place get 1 point
						athleteMap.put(tempResult.getAthleteID(2),athleteMap.get(tempResult.getAthleteID(0)) + 1 );
					}else {
						System.out.println("Key is null. Less than 5 athlete");
					}
					
				}
				
				//There is sorting of position
				System.out.println();
				System.out.println("Athletes Scores ");
				System.out.println("***************************************");
				
				for (Map.Entry<String, Integer> currentEntry : athleteMap.entrySet()) {
					//Key(athleteID), value(athlete score)
					
					//Now to get athlete name as well.
					System.out.println("ID : " +currentEntry.getKey() + " Name : " + getAthleteName(currentEntry.getKey()) + " Score : " + currentEntry.getValue());
				}
				System.out.println("***************************************");
				
			}else {
				System.out.println("There is no result to display.");
			}
		}else {
			System.out.println("There is no athlete recorded.");
		}
		//Athlete id will be used for key, initialise all value to be 0
		
		
		
		
	}
}
