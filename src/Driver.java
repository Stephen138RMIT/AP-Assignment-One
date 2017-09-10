import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;


public class Driver {

	
	private ArrayList<Athlete> allAthlete;
	/*Instead of container of all result and using iterator to get last most
	 * game with eventID. I'll use 3 seperate ArrayList
	 * 
	 */
	private ResultHandler resultHandler;
	//See IDGenerator for explanation.
	private IDGenerator athleteIDGenerator;
	private IDGenerator gameIDGenerator;
	private IDGenerator refIDGenerator;
	private Scanner sc;
	
	private Referee swimJudge;
	private Referee runJudge;
	private Referee cycleJudge;
	
	//This method create a working set of athletes.
	//Its set this way so that allAthlete can be replaced again if another set is used.
	public void setMainAthlete() {
		Swimmer Joe = new Swimmer("Joe", athleteIDGenerator.generateID(), 20, Athlete.States.VIC);
		Swimmer Greg = new Swimmer("Greg", athleteIDGenerator.generateID(), 30, Athlete.States.NSW);
		Swimmer David = new Swimmer("David", athleteIDGenerator.generateID(), 24, Athlete.States.SA);
		Runner Smith = new Runner("Smith", athleteIDGenerator.generateID(),24, Athlete.States.WA);
		Runner Dean = new Runner("Dean", athleteIDGenerator.generateID(),40, Athlete.States.WA);
		Runner Fiona = new Runner("Fiona", athleteIDGenerator.generateID(),33, Athlete.States.NT);
		Cyclist Cathy = new Cyclist("Cathy", athleteIDGenerator.generateID(),22, Athlete.States.QLD);
		Cyclist Danny = new Cyclist("Danny", athleteIDGenerator.generateID(),26, Athlete.States.VIC);
		Cyclist George = new Cyclist("George", athleteIDGenerator.generateID(),29, Athlete.States.QLD);
		SuperAthlete Bob = new SuperAthlete("Bobby", athleteIDGenerator.generateID(),19, Athlete.States.NT);
		SuperAthlete Andy = new SuperAthlete("Andy", athleteIDGenerator.generateID(),21, Athlete.States.WA);
		SuperAthlete Megan = new SuperAthlete("Megan", athleteIDGenerator.generateID(),27, Athlete.States.SA);
		
		ArrayList<Athlete> tempList = new ArrayList<Athlete>();
		
		tempList.add(Joe);
		tempList.add(Greg);
		tempList.add(Smith);
		tempList.add(Dean);
		tempList.add(Fiona);
		tempList.add(Cathy);
		tempList.add(Danny);
		tempList.add(Bob);
		tempList.add(Andy);
		tempList.add(David);
		tempList.add(George);
		tempList.add(Megan);
		
		//Initialise referee
		swimJudge = new Referee(refIDGenerator.generateID(), "MCain", 44, Athlete.States.VIC, Athlete.Event.SWIMMING);
		cycleJudge = new Referee(refIDGenerator.generateID(), "Jebediah", 34, Athlete.States.NSW, Athlete.Event.CYCLING);
		runJudge = new Referee(refIDGenerator.generateID(), "Peter", 56, Athlete.States.SA, Athlete.Event.RUNNING);
		
		allAthlete = tempList;
		
		resultHandler.setAthleteList(tempList);
	}
	
	public Driver() {
		//Hard code Athlete.
		athleteIDGenerator = new IDGenerator();
		gameIDGenerator = new IDGenerator();
		refIDGenerator = new IDGenerator();
		allAthlete = new ArrayList<Athlete>();
		resultHandler = new ResultHandler();
		
		setMainAthlete();
		
		sc = new Scanner(System.in);
	}
	
	public void Instruction() {
		System.out.println("Here are you current option: ");
		System.out.println("0: quit");
		System.out.println("1: Start Game");
		System.out.println("2: Repeat Instruction");
		System.out.println("3: Print all Athlete Name and Score");
		System.out.println("4: Print all final result");
	}
	/* Redundant now that resultHandler can print result of all athlete
	public void printAthleteName()
	{
		
		Iterator<Athlete> athleteIterator = allAthlete.iterator();	
		//There is two athlete but only one competed
		
		System.out.println("size of Athlete: " + allAthlete.size());
			
		while(athleteIterator.hasNext()) {
			Athlete currentAthlete = athleteIterator.next();
			System.out.println(currentAthlete.getAthleteName() + currentAthlete.getAthleteID());
		}	
	}
	*/
	public void printGameOption() {
		System.out.println("0 : Back to Main Menu");
		System.out.println("1 : Start Running Competition");
		System.out.println("2 : Start Swimming Competition");
		System.out.println("3 : Start Cycling Competition");
	}
	
	
	//
	
	public Result predictWinner(Result currentResult) {
		//Give competer to bet on.
		
		int userIntInput = -2;
		
		//Don't leave loop until prediction has been made
		currentResult.printCompetingAthlete();
		while(userIntInput != -1) {
			try{
				System.out.println();
				System.out.print("Predict Winner, enter correlating index: ");
				userIntInput = sc.nextInt();
				
				//Keep repeating until valid input has been reached
				if(userIntInput < 0 || userIntInput >= currentResult.getNoAthlete()) {
					System.out.println("Out of bound");
					userIntInput = -2;
				}else {
					//Valid input, the loop will be exited
					currentResult.predictWinner(userIntInput);
					userIntInput = -1;
					if(currentResult.isWinner()) {
						System.out.println("*************************************");
						System.out.println("Congratulation, You predicted right.");
						System.out.println("*************************************");
					}
				}
			}
		
			catch(InputMismatchException exception){
				System.out.println("Input not Integer.");
				sc.next();
				userIntInput = -2;
			}
		}
		
		
		return currentResult;
	}
	public void gameMenu() {
		int userIntInput = -1;
		while(userIntInput != 0) {
			try{
				switch(userIntInput) {
				case -1:
					printGameOption();
					break;
				case 0: //quit
					break;
				case 1:
					RunningGame runGame = new RunningGame(gameIDGenerator.generateID(), allAthlete, runJudge);
					//If runnable give game to prediction
					if(runGame.competition()) {
						//While the winner are already determined under the hood the player can still predict.
						resultHandler.addResult(predictWinner(runGame.getResult()));
						runGame.getResult().printScore();
					}
					printGameOption();
					break;
				case 2: // Swim Game
					SwimmingGame swimGame = new SwimmingGame(gameIDGenerator.generateID(), allAthlete, swimJudge);
					if(swimGame.competition()) {
						resultHandler.addResult(predictWinner(swimGame.getResult()));
						swimGame.getResult().printScore();
					}
					printGameOption();
					break;
				case 3: // Cycle Game
					CyclingGame cycleGame = new CyclingGame(gameIDGenerator.generateID(), allAthlete, cycleJudge);
					if(cycleGame.competition()) {
						resultHandler.addResult(predictWinner(cycleGame.getResult()));
						cycleGame.getResult().printScore();
					}
					printGameOption();
					break;
				default:
					System.out.println("Out of bound");
				}
				System.out.print("Input Integer: ");
				userIntInput = sc.nextInt();
			}
		
			catch(InputMismatchException exception){
				System.out.println("Input not Integer.");
				sc.next();
				userIntInput = -1;
			}
		}
		Instruction();
		//System.out.println("exiting...");
		
	}
	
	public void mainMenu() {
		
		//This makes menu come up first.
		int userIntInput = 2;
		//Repeat until user specify quit
		while(userIntInput != 0) {
			try{
				switch(userIntInput) {
				case -1:
					//This is caused by input error, do not output anything
					break;
				case 0: 
					//Don't print out error message just break and exit
					break;
				case 1:
					gameMenu();
					break;
				case 2:
					Instruction();
					break;
				case 3:
					//Eventually display point of all athlete.
					resultHandler.printAllAthlete();
					break;
				case 4:
					//Display final result of all game
					resultHandler.printLastResultAll();
					break;
				default:
					System.out.println("Out of bound");
				}
				//Don't make new line.
				System.out.print("Input Integer: ");
				userIntInput = sc.nextInt();
			}
		
			catch(InputMismatchException exception){
				System.out.println("Input not Integer.");
				//This will bring it back to sc.nextInt()
				
				//Consume the invalid token so that sc.nextInt() can work
				sc.next();
				//When try is called again, skip to sc.nextInt()
				userIntInput = -1;
			}
		}
		
		
		//System.out.println(x);
		sc.close();
		System.out.println("exiting...");
	}
}
