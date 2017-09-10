import java.util.ArrayList;

public interface Official {
	
	//All official should sum game
	public Result SumGame(String gameID, ArrayList<Athlete> gameAthletes);

	//All official can return their information.
	public String getName();
	public Athlete.States getState();
	public String getID();
	public int getAge();
	public Athlete.Event getEvent();
	
}
