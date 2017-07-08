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
			System.out.println("Re login and/or password are invalide!");
			return;
		}
		
		
		
		
		
		// Create a Scanner
	    Scanner input = new Scanner(System.in);
	   
	    
	  int option;
	    
	do {
	    do{
	      
	    // Display the Menu
		boolean loggedIn = true;
		String TextBookRental = 
			    "Please select from the following options\n"+
			    "1: Check Copies out\n" +
			    "2: Check Copies In\n" +
			    "3: Over Due Reports\n" +
			    "4: ?????\n" +
			    "5: Log out\n";
			     
			    // Prompt the user to the main menu
			    System.out.print(TextBookRental);
			    System.out.println ("Enter a choice:");
			    option = input.nextInt();
			    reader.nextLine();
				    } while(option > 5);
			     
			    
//			     
//			     switch (option) {
//			     
//
//		
//		while (loggedIn) {
//			System.out.println();
//
//			System.out.println("Please select from the following options");
//			System.out.println("Enter 1 to Check Copies out");
//			System.out.println("Enter 2 to Check Copies In");
//			System.out.println("Enter 3 to Log out");
//			
//			int option = reader.nextInt();
//			reader.nextLine();
			
			switch (option) {
			
			case 1:
				checkoutUI(controller);
				//p.checkCopyOut(null);
				//System.out.println("Displaying patron information after checkout");
				//System.out.println(p);
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
	
	

			     
			     
			     
			     
			     
			     
			     
			     
	public static String checkoutUI(Controller controller){
		System.out.println("Enter PatronID");
		Scanner reader = new Scanner(System.in);
		String read1= reader.nextLine();
		
		Patron p = controller.startSession(read1);
		if(p == null){
			System.out.println("Could not find a patron with the id "+read1);
			return read1;
		}

		System.out.println("Displaying Patron information before Checkout");
		System.out.println(p);

		
		if(!p.hasOverdueCopy())
		{
			boolean cont = true;
			System.out.println("Enter CopyID");
			String copyId = reader.nextLine();
			
//			while(cont)
//			{
	
				Copy cp = controller.checkoutCopy(copyId);
				
				if(cp == null)
				{
					System.out.println("Copy not found");
				}
				else
				{
					System.out.println(cp);
				}
			
				System.out.println("Enter your choice");
				
//				String response = reader.nextLine();
//				if(response.equals("exit"))
//				{
//					System.out.println("displaying the patron informations after checkout");
//					System.out.println(p);
//					
//					cont = false;
//				}
//				else
//				{
//					copyId = response;
//				}
//			}
		}
		return read1;
		}

	public static String checkInUI(Controller controller){
		System.out.println("Enter PatronID");
		Scanner reader = new Scanner(System.in);
		String read2= reader.nextLine();
		
		Patron p = controller.startSession(read2);
		if(p == null){
			System.out.println("Could not find a patron with the id "+read2);
			return read2;
		}

		System.out.println("Displaying Patron information before Checkout");
		System.out.println(p);

		
		if(!p.hasOverdueCopy())
		{
			boolean cont = true;
			System.out.println("Enter CopyID");
			String copyId = reader.nextLine();
		    Copy cp = controller.checkoutCopy(copyId);
				
				if(cp == null)
				{
					System.out.println("Copy not found");
				}
				else
				{
					System.out.println(cp);
				}
			
				System.out.println("Enter your choice");
				
//				String response = reader.nextLine();
//				if(response.equals("exit"))
//				{
//					System.out.println("displaying the patron informations after checkout");
//					System.out.println(p);
//					
//					cont = false;
//				}
//				else
//				{
//					copyId = response;
//				}
//			}
//			}
		}
		return read2;
		}
}
