import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.LinkedList;


public class Driver {

	//We need an ID generation.
	
	
	private ArrayList<Athlete> allAthlete;
	private IDGenerator athleteIDGenerator;
	private IDGenerator gameIDGenerator;
	
	
	public Driver() {
		//Hard code Athlete.
		athleteIDGenerator = new IDGenerator();
		gameIDGenerator = new IDGenerator();
		allAthlete = new ArrayList<Athlete>();
		
		Swimmer Joe = new Swimmer("Joe", athleteIDGenerator.generateID());
		Swimmer Greg = new Swimmer("Greg", athleteIDGenerator.generateID());
		Runner Smith = new Runner("Smith", athleteIDGenerator.generateID());
		Runner Dean = new Runner("Dean", athleteIDGenerator.generateID());
		Cyclist Cathy = new Cyclist("Cathy", athleteIDGenerator.generateID());
		Cyclist Danny = new Cyclist("Danny", athleteIDGenerator.generateID());
		SuperAthlete Bob = new SuperAthlete("Bobby", athleteIDGenerator.generateID());
		SuperAthlete Andy = new SuperAthlete("Andy", athleteIDGenerator.generateID());
		
		allAthlete.add(Joe);
		allAthlete.add(Greg);
		allAthlete.add(Smith);
		allAthlete.add(Dean);
		allAthlete.add(Cathy);
		allAthlete.add(Danny);
		allAthlete.add(Bob);
		allAthlete.add(Andy);

	}
	
	public void Instruction() {
		System.out.println("Here are you current option: ");
		System.out.println("0: quit");
		System.out.println("1: Run event test");
		System.out.println("2: Repeat Instruction");
	}
	
	public void printAthleteName()
	{
		
		Iterator<Athlete> athleteIterator = allAthlete.listIterator();	
		//There is two athlete but only one competed
		
		System.out.println("size of Athlete: " + allAthlete.size());
			
		while(athleteIterator.hasNext()) {
			Athlete currentAthlete = athleteIterator.next();
			System.out.println(currentAthlete.getAthleteName() + currentAthlete.getAthleteID());
		}	
	}
	
	public void mainMenu() {
		//For now simple interface
		
		Scanner sc = new Scanner(System.in);
		//int userIntInput = sc.nextInt();
		//System.out.println(userIntInput);
		
		
		//This makes menu come up first.
		int userIntInput = 2;
		//Repeat until user specify two quit
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
					Game anEvent = new Game(gameIDGenerator.generateID(), allAthlete, Athlete.Event.RUNNING);
					anEvent.competition();
					//anEvent.test();
					break;
				case 2:
					Instruction();
					break;
				case 3:
					printAthleteName();
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
		System.out.println("exiting...");
	}
}
