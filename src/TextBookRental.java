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
			System.out.println("le login and/or password are invalide!");
			return;
		}
		
		
		boolean loggedIn = true;

		
		while (loggedIn) {
			System.out.println();

			System.out.println("Please select from the following options");
			System.out.println("Enter 1 to Check Copies out");
			System.out.println("Enter 2 to Log out");
			
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
				System.out.printf("Session closed, you are logged out!");
				break;
			default: 
				System.out.println("Invalid option ");
				break;
			}
			
		}

		System.out.printf("Session closed, you are logged out!");
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
