public abstract class Athlete {
	protected String athleteName;
	protected enum Event{NONE, CYCLING, RUNNING, SWIMMING};
	protected Event currentEvent;
	
	
	
	public Athlete(String name) {
		this.athleteName = name;
		currentEvent = Event.NONE;
	}
	
	public void setEvent(Event newEvent) {
		currentEvent = newEvent;
	}
	//This method is to be overidden
	public void complete() {};
}
