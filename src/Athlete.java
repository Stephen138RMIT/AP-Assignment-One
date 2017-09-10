public abstract class Athlete {
	protected String athleteName;
	protected enum Event{NONE, CYCLING, RUNNING, SWIMMING};
	protected enum AthleteType{CYCLIST, RUNNER, SWIMMER};
	protected Event currentEvent;
	protected String athleteID;
	
	//Could use array or container to store, but with only 3 athlete type
	//There is no need.
	protected boolean isSwimmer = false;
	protected boolean isRunner = false;
	protected boolean isCyclist = false;
	
	public Athlete(String name, String id) {
		this.athleteName = name;
		currentEvent = Event.NONE;
		//Append a to given id.
		this.athleteID = 'A' + id;
		
	}
	
	public void setEvent(Event newEvent) {
		currentEvent = newEvent;
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
	//This method needs to be overidden
	public void compete() {};
}
