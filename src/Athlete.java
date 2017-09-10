public abstract class Athlete{
	
	//TODO privatise all function and use getter and setter to retrieve information
	private String athleteName;
	public enum Event{NONE, CYCLING, RUNNING, SWIMMING};
	public enum AthleteType{CYCLIST, RUNNER, SWIMMER};
	public enum States{VIC, WA, SA, QLD, NT, NSW};
	private Event currentEvent;
	private String athleteID;
	
	//Could use array or container to store, but with only 3 athlete type
	//There is no need.
	protected boolean isSwimmer = false;
	protected boolean isRunner = false;
	protected boolean isCyclist = false;
	
	public String getAthleteName() {
		return this.athleteName;
	}
	
	public Event getEvent() {
		return currentEvent;
	}
	
	public void setEvent(Event newEvent) {
		currentEvent = newEvent;
	}
	
	public String getAthleteID() {
		return athleteID;
	}
	
	
	public Athlete(String name, String id) {
		this.athleteName = name;
		currentEvent = Event.NONE;
		//Append a to given id.
		this.athleteID = 'A' + id;
		
	}

	public boolean isAthleteType(AthleteType athleteType) {
		
		//Why won't this switch statement work
		switch(athleteType){
		case CYCLIST:
			if(isCyclist) {
				return true;
			}
			break;
		case RUNNER:
			if(isRunner) {
				return true;
			}
			break;
		case SWIMMER:
			if(isSwimmer) { 
				return true;
			}
			break;
		}
		return false;
	}
	
	//This method needs to be overidden, 
	public double compete() {
		return 0;
	}
}
