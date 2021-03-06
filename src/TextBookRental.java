import java.util.List;
import java.util.Scanner;

public class TextBookRental {
	public static void main(String args[]) {
		
		Controller controller = new Controller();
		
		workerLoginUI(controller);

		mainMenuUI(controller);

	}

	private static void mainMenuUI(Controller controller) {
		
		System.out.println("------------------------------------------------------------------\n");
		System.out.println(" The system initially has the folloing patrons and copies :\n");
		System.out.println(" Patrons :\n");
		System.out.println(" * P1 : doesn't have any checked out copy\n");
		System.out.println(" * P2 : has the copy C2 checked out to him");
		System.out.println(" * P3 : has an OVERDUE copy C3 checked out to him");
		System.out.println(" Copies :\n");
		System.out.println(" * C1 : Available\n");
		System.out.println(" * C2 : Checked out to P2\n");
		System.out.println(" * C3 : Overdue and Checked out to P3\n");
		System.out.println(" * C4 : Available\n");
		System.out.println(" * C5 : Available\n");
		System.out.println("-----------------------------------------------------------------\n");

		boolean endsession =false;

		do {
			int option = mainMenuUIOptionsReader();

			switch (option) {

			case 1:
				checkoutUI(controller);
				break;
			case 2:
				checkInUI(controller);
				break;
			case 3:
				MarkHoldsUI(controller);
				break;
			case 4:
				System.out.printf("Session closed, you are logged out!");
				endsession = true;
				break;

			default:
				System.out.println("Invalid option ");
				break;
			}

		} while (!endsession);
		System.out.printf("Session closed, you are logged out!");
	}

	private static void workerLoginUI(Controller controller) {
		
		System.out.println("------------------------------------------------------------------\n");
		System.out.println(" the system initially contains one worker with the credentials :\n");
		System.out.println(" * username : worker1\n");
		System.out.println(" * password : pass\n");
		System.out.println("-----------------------------------------------------------------\n");
		
		
		
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

	private static int mainMenuUIOptionsReader() {
		Scanner input = new Scanner(System.in);
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
	
	private static void MarkHoldsUI(Controller controller) {
		
		Scanner input = new Scanner(System.in);
		
		String option;
		do{
		     
			// Display the Menu
			String holdsprompt = "\n Marking holds, please enter\n" 
						+ "Y: to continue\n"
						+ "N: to cancel\n";
			System.out.print(holdsprompt);
			System.out.println("Enter a choice:");
			option = input.nextLine();
			
		} while (!option.toLowerCase().equals("y") || option.toLowerCase().equals("n"));
		
		if(option.toLowerCase().equals("y")){
			int numberOfMarks = controller.markholds();
			System.out.println("** Done: hold was marked on "+numberOfMarks+" Patron(s)");
		}
	}
}
