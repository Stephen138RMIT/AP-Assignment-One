import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver {

	
	public void init() {
		
	}
	
	public void Instruction() {
		System.out.println("Here are you current option: ");
		System.out.println("0: quit");
		System.out.println("1: Run event test");
		System.out.println("2: Repeat Instruction");
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
					Event anEvent = new Event();
					anEvent.test();
					break;
				case 2:
					Instruction();
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
