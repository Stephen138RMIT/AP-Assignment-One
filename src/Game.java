import java.util.ArrayList;
import java.util.Iterator;


public interface Game {
	//TODO Make this into interface, create subclass and port the code over.
	// String gameID;
	//ArrayList<Athlete> allAthlete;
	//Athlete.Event currentEvent;
	//ArrayList<Result> gameResult;
	
	//public Game();
	
	//Competition must be guaranteed.
	//Return false if game failed.
	public boolean competition();
	
	//Return result
	public Result getResult();

	
	//TODO Concept finished move function to event.
}
