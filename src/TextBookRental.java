import java.util.List;
import java.util.Scanner;

public class TextBookRental {
	public static void main(String args[]) {
		
		Controller controller = new Controller();
		
		workerLoginUI(controller);

		mainMenuUI(controller);

	}

	private static void mainMenuUI(Controller controller) {
		Scanner input = new Scanner(System.in);

		int option;

		do {
			option = mainMenuUIOptionsReader(input);

			switch (option) {

			case 1:
				checkoutUI(controller);
				break;
			case 2:
				checkInUI(controller);
				break;
			case 3:
				System.out.printf("Over Due Reports");
				break;
			case 4:
				System.out.printf("?????");
				break;

			case 5:
				System.out.printf("Session closed, you are logged out!");
				break;

			default:
				System.out.println("Invalid option ");
				break;
			}

		} while (option != 5);
		System.out.printf("Session closed, you are logged out!");
	}

	private static void workerLoginUI(Controller controller) {
		
		
		boolean loginOk = false;
		while(!loginOk){
			// Ask user for username and password
			Scanner reader = new Scanner(System.in);
			System.out.println("Enter a valid username: ");
			String username = reader.nextLine();
			System.out.println("Enter the password: ");
			String password = reader.nextLine();
			
			Worker w = controller.login(username, password);
			if (w == null){
				System.out.println("Re login and/or password are invalide!");
				loginOk = false;
			}
			else
			{
				loginOk = true;
			}
		}
	}

	private static int mainMenuUIOptionsReader(Scanner input) {
		int option;
		do{
     
			// Display the Menu
			boolean loggedIn = true;
			String TextBookRental = "\nPlease Enter your choice\n" 
						+ "1: Check Copies out\n"
						+ "2: Check Copies In\n" 
						+ "3: Mark Holds\n" 
						+ "4: Log out\n";

			// Prompt the user to the main menu
			System.out.print(TextBookRental);
			System.out.println("Enter a choice:");
			option = input.nextInt();
			
		} while (option > 4);
		return option;
	}     
			     
	public static void checkoutUI(Controller controller){
		System.out.println("Enter PatronID");
		Scanner reader = new Scanner(System.in);
		String read1= reader.nextLine();
		
		Patron p = controller.startSession(read1);
		if(p == null){
			System.out.println("Could not find a patron with the id "+read1);
			return ;//read1;
		}

		System.out.println("~~~~~~~~~~~Displaying Patron information before Checkout~~~~~~~~~~");
		System.out.println(p);

		
		if(!p.hasOverdueCopy())
		{
			boolean cont = true;
			System.out.println("To check out enter CopyID:");
			String copyId = reader.nextLine();
			
			while(cont)
			{
	
				Copy cp = controller.checkoutCopy(copyId);
				
				if(cp == null)
				{
					System.out.println("Copy not found");
				}
				else
				{
					System.out.println(cp);
				}
				
				System.out.println("Eenter a CopyID or 'exit' to end scannings:");
				String response = reader.nextLine();
				if(response.equals("exit"))
				{
					System.out.println("displaying the patron informations after checkout");
					System.out.println(p);
					
					cont = false;
				}
				else
				{
					copyId = response;
				}
			}
		}
		else
		{
			System.out.println("*** WARNING: the patron has overdue copies so he could not checkout new ones\n");
		}
	}

	public static void checkInUI(Controller controller){
		System.out.println("Enter PatronID");
		Scanner reader = new Scanner(System.in);
		String read2= reader.nextLine();
		
		Patron p = controller.startSession(read2);
		if(p == null){
			System.out.println("Could not find a patron with the id "+read2);
			return;
		}

		System.out.println("~~~~~~~~Displaying Patron information before Check in~~~~~~~");
		System.out.println(p);

		// case 1 **main case**: patron has some copies checked out
		if(!p.hasOverdueCopy() && p.hasCheckedOutCopies())
		{
			performCheckinUI(controller, p);
			
		}		
		// case 2: patron doen't have any copy checked out
		else if(!p.hasCheckedOutCopies()){
			
			System.out.println("*** This patron doesn't have any copy checked out");
		}
		// case 3: patron has some overdue copies
		else if(p.hasCheckedOutCopies() && !p.hasOverdueCopy()){
			System.out.println("*** WARNING: This patron doen't have any ");

			performCheckinUI(controller,p);
			
		}

		
	}

	private static void performCheckinUI(Controller controller,  Patron p) {
		
		Scanner reader = new Scanner(System.in);
		boolean cont = true;
		System.out.println("Enter CopyID");
		//@TODO make sure the copy is check to patron
		
		String copyId = reader.nextLine();
		Copy cp = controller.checkInCopy(copyId);
		
		while(cont && p.hasCheckedOutCopies())
		{	
			if(cp == null)
			{
				System.out.println("Copy not found");
			}
			else
			{
				System.out.println(cp);
			}
		
			System.out.println("Enter a CopyID to check-in or 'exit' to end Checkin sesssion");
			
			String response = reader.nextLine();
			if(response.equals("exit"))
			{
				System.out.println("displaying the patron informations after checkout");
				System.out.println(p);
				
				cont = false;
			}
			else
			{
				copyId = response;
			}
		}
		
		if(!p.hasCheckedOutCopies()){
			System.out.println("*** the patron has no more checked out copies !!");
		}
	}

}
