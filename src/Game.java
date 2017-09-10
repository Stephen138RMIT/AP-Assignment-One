import java.util.ArrayList;
import java.util.Iterator;


public interface Game {
	// String gameID;
	//ArrayList<Athlete> allAthlete;
	//Athlete.Event currentEvent;
	//ArrayList<Result> gameResult
	
	//Competition must be guaranteed.
	//Return false if game failed.
	public boolean competition();
	
	//Return result
	public Result getResult();
}
