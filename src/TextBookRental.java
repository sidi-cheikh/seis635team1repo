import java.util.List;
import java.util.Scanner;

public class TextBookRental {
	public static void main(String args[]) {
		//List<Worker> storeWorker = LoadUsers();
		
		Controller controller = new Controller();
		
		// Ask user for username and password
		Scanner reader = new Scanner(System.in);
		
		System.out.println("Enter a valid username: ");
		String username = reader.nextLine();
		
		System.out.println("Enter the password: ");
		String password = reader.nextLine();
		
		Worker w = controller.login(username, password);
		if (w == null){
			System.out.println(" login and/or password are invalid!!");
			return;
		}
		
		
		boolean loggedIn = true;

		
		while (loggedIn) {
			System.out.println();

			System.out.println("Please select from the following options");
			System.out.println("Enter 1 to Check Copies out");
			System.out.println("Enter 2 to Check Copies in");
			System.out.println(" Enter 3 Overdue Reports");
			System.out.println("Enter 4 to Log out");
			System.out.println("Please enter your choice");
			int option = reader.nextInt();
			reader.nextLine();
			
			switch (option) {
			
			case 1:
				checkoutUI(controller);
				//p.checkCopyOut(null);
				//System.out.println("Displaying patron information after checkout");
				//System.out.println(p);
				break;
			case 2:
				checkinUI(controller);
				break;
				
			case 3:
				overdueUI(controller);//error 
				break;
				
			case 4:
				System.out.printf("Session closed");
				loggedIn= false;
				break;
			default: 
				System.out.println("Invalid option ");
				break;
			}
			
		}
		System.out.println();
		System.out.println("You are logged out,'RESTART THE APPLICATION'");

		}
	
	private static void overdueUI(Controller controller) {
		// TODO Auto-generated method stub
		Patron p = new Patron();
		if(p.hasOverdueCopy()){
		p.getOverdueCopies();
		}
		else{
			System.out.println("No over due copies ");
		}
	}

	private static void checkinUI(Controller controller) {
		// TODO Auto-generated method stub
		System.out.println("Enter PatronID");
		Scanner reader = new Scanner(System.in);
		String read1= reader.nextLine();
		
		Patron p = controller.startSession(read1);
		if(p == null){
			System.out.println("Could not find a patron with the id "+read1);
			return;
		}

		System.out.println("Displaying Patron information before Checkin");
		System.out.println(p);

		
		if(p.hasOverdueCopy())
		{
		System.out.println("You have a overdue notice pending Please pay fine");
		System.out.println("Do you want to pay fine (Y/N)");
		String opt= reader.nextLine();
			if (opt == "y"||opt == "Y"){
				
			//	Copy c =new Copy();
				//c.getFine();
				checkingInCopies(controller, reader, p);
			
			}
			else
			{
				System.out.println("You can not checkin books until you pay fine");
			}
			}
		else
		{
			checkingInCopies(controller, reader, p);
		}

	}

	public static void checkingInCopies(Controller controller, Scanner reader, Patron p) {
		boolean cont = true;
		System.out.println("Enter CopyID");
		String copyId = reader.nextLine();
		
		while(cont)
		{

			Copy cp = controller.checkinCopy(copyId);
			
			if(cp == null)
			{
				System.out.println("Copy not found");
			}
			else
			{
				System.out.println(cp);
			}
		
			System.out.println("enter copy id or 'exit' if you want to end scanning");
			
			String response = reader.nextLine();
			if(response.equals("exit"))
			{
				System.out.println("displaying the patron informations after checkin");
				System.out.println(p);
				
				cont = false;
			}
			else
			{
				copyId = response;
			}
		}
	}

	public static void checkoutUI(Controller controller){
		System.out.println("Enter PatronID");
		Scanner reader = new Scanner(System.in);
		String read1= reader.nextLine();
		
		Patron p = controller.startSession(read1);
		if(p == null){
			System.out.println("Could not find a patron with the id "+read1);
			return;
		}

		System.out.println("Displaying Patron information before Checkout");
		System.out.println(p);

		
	/*	if(p.hasOverdueCopy())
		{
		System.out.println("You have a overdue notice pending Please pay fine");
		System.out.println("Do you want to pay fine (Y/N)");
		String opt= reader.nextLine();
			if (opt=="y"||opt=="Y"){
				
				Copy c =new Copy();
				c.getFine();
			
			}
			else
			{
				System.out.println("You can not checkout new books");
			}
			}
		else
		{
			boolean cont = true;
			System.out.println("Enter CopyID");
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
			
				System.out.println("enter copy id or 'exit' if you want to end scanning");
				
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
		}*/
		if(!p.hasOverdueCopy())
		{
			boolean cont = true;
			System.out.println("Enter CopyID");
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
			
				System.out.println("enter copy id or 'exit' if you want to end scanning");
				
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

		
	}
}
