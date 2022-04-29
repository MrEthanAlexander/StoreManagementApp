import java.util.Scanner;

public class BackEnd {
	Scanner keyboard = new Scanner(System.in);
	static StoreManager storeManager = new StoreManager();
	static WorkerManager workerManager = new WorkerManager();
	static Store business = new Store();
	static String input;

	public void welcomeMessage() {
		System.out.println("Welcome to Ethan Alexander's store manager.");
	}
	
	public void initializeStore() {
		System.out.println("No store data has been detected; would you like to start now?\n"
				+ "Yes/No");
		
		setInputString();
		while(!input.equals("yes")&&!input.equals("no"))
			errorMessage("Please enter Yes or No.", "String");
		if (input.equals("no")) 
			endApplication();
		
		System.out.println("Please enter the store name.");
		setInputString();
		business.setName(input);
		System.out.println("Thank you. Going to the main menu.");
		startApplication();
	}
	
	public void startApplication() {
		welcomeMessage();
		if (business.getName().equals(""))
			initializeStore();
		else
			mainMenu();
	}
	
	public void mainMenu() {
		printMainMenuOptions();
		checkWarnings();
		setInputInt();
		while(Integer.parseInt(input) < 0 || Integer.parseInt(input) > 9)
			errorMessage("Please enter a value 0-9.", "Int");
		switch (Integer.parseInt(input)) {
		case 0:
			business.printWeekSchedule();
			break;
		case 1:
			
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		case 7:
			break;
		case 8:
			break;
		case 9:
			endApplication();
			break;
		default:
			errorMessage("Please enter 0-9.", "Int");
		}
	}
	
	public void printMainMenuOptions() {
		System.out.println("Main Menu for "+ business.getName()+"\n");
		
		System.out.println("0: View weekly schedule.");
		System.out.println("1: View schedule for a specific day.");
		System.out.println("2: Edit a specific day's schedule.");
		System.out.println("3: Edit the store's data.\n");
		
		System.out.println("4: View list of all team members.");
		System.out.println("5: View specific team member's schedule.");
		System.out.println("6: View specific team member's information.");
		System.out.println("7: Edit specific team member's information.\n");
		
		System.out.println("8: CSV store's weekly schedule.\n");
		
		System.out.println("9: Close application.");
		
	}

	
	public void checkWarnings() {
		
	}
	public void printWarnings() {
		System.out.println("=====Warning=====");
	}
	
	public void endApplication() {
		System.out.println("Closing application. Goodbye.");
		System.exit(0);
	}
	
	public void errorMessage(String message, String type) {
		System.out.println("Error: " + message);
		if (type.equals("String"))
			setInputString();
		else if (type.equals("Int")) {
			keyboard.nextLine();
			setInputInt();
		}
		else if (type.equals("Double")) {
			keyboard.nextLine();
			setInputDouble();
		}
	}
	
	public String setInputString() {
		input = keyboard.nextLine().toLowerCase();
		if (input.equals(""))
			errorMessage("Please enter text.", "String");
		return input;
	}
	
	public double setInputDouble() {
		input = "" + keyboard.nextDouble();
		if (!keyboard.hasNextDouble())
			errorMessage("Please enter a double.", "Double");
		return Double.parseDouble(input);
	}
	
	public int setInputInt() {
		try {
			input = Integer.toString(keyboard.nextInt());
		}
		catch (Exception e) {
			errorMessage("Please enter an integer.", "Int");
		}
		return Integer.parseInt(input);
	}

	private boolean dayCheck (String aName)
	{
		if (aName.equals("Monday") || aName.equals("Tuesday") || aName.equals("Wednesday") ||
				aName.equals("Thursday") || aName.equals("Friday") || aName.equals("Saturday") ||
				aName.equals("Sunday"))
			return true;
		return false;
	}
	
}
