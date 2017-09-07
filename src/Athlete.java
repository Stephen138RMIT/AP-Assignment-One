public abstract class Athlete {
	protected String athleteName;
	protected enum Event{NONE, CYCLING, RUNNING, SWIMMING};
	protected enum AthleteType{CYCLIST, RUNNER, SWIMMER};
	protected Event currentEvent;
	
	//Could use array or container to store, but with only 3 athlete type
	//There is no need.
	protected boolean isSwimmer = false;
	protected boolean isRunner = false;
	protected boolean isCyclist = false;
	
	public Athlete(String name) {
		this.athleteName = name;
		currentEvent = Event.NONE;
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
	//This method is to be overidden
	public void compete() {};
}
