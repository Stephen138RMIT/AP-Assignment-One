import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;


public class Driver {

	
	private ArrayList<Athlete> allAthlete;
	
	//See IDGenerator for explanation.
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
		Runner Fiona = new Runner("Fiona", athleteIDGenerator.generateID());
		Cyclist Cathy = new Cyclist("Cathy", athleteIDGenerator.generateID());
		Cyclist Danny = new Cyclist("Danny", athleteIDGenerator.generateID());
		SuperAthlete Bob = new SuperAthlete("Bobby", athleteIDGenerator.generateID());
		SuperAthlete Andy = new SuperAthlete("Andy", athleteIDGenerator.generateID());
		
		allAthlete.add(Joe);
		allAthlete.add(Greg);
		allAthlete.add(Smith);
		allAthlete.add(Dean);
		allAthlete.add(Fiona);
		allAthlete.add(Cathy);
		allAthlete.add(Danny);
		allAthlete.add(Bob);
		allAthlete.add(Andy);

	}
	
	public void Instruction() {
		System.out.println("Here are you current option: ");
		System.out.println("0: quit");
		System.out.println("1: Start Game");
		System.out.println("2: Repeat Instruction");
	}
	
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
	
	public void printGameOption() {
		System.out.println("0 : Back to Main Menu");
		System.out.println("1 : Start Running Competition");
		System.out.println("2 : Start Swimming Competition");
		System.out.println("3 : Start Cycling Competition");
	}
	
	public void gameMenu() {
		Scanner gameSC = new Scanner(System.in);
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
					RunningGame runGame = new RunningGame(gameIDGenerator.generateID(), allAthlete);
					runGame.competition();
					printGameOption();
					break;
				case 2: // Swim Game
					SwimmingGame swimGame = new SwimmingGame(gameIDGenerator.generateID(), allAthlete);
					swimGame.competition();
					printGameOption();
					break;
				case 3: // Cycle Game
					CyclingGame cycleGame = new CyclingGame(gameIDGenerator.generateID(), allAthlete);
					cycleGame.competition();
					printGameOption();
					break;
				default:
					System.out.println("Out of bound");
				}
				System.out.print("Input Integer: ");
				userIntInput = gameSC.nextInt();
			}
		
			catch(InputMismatchException exception){
				System.out.println("Input not Integer.");
				gameSC.next();
				userIntInput = -1;
			}
		}
		gameSC.close();
		System.out.println("exiting...");
		
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
					gameMenu();
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
		sc.close();
		System.out.println("exiting...");
	}
}
