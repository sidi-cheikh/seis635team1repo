import java.util.List;
import java.util.Scanner;

public class TextBookRental {
	public static void main(String args[]) {
		//List<Worker> storeWorker = LoadUsers();
		// Ask user for username and password
		Scanner reader = new Scanner(System.in);
		
		System.out.println("Enter a valid username: ");
		String username = reader.nextLine();
		
//		System.out.println("Enter the password: ");
//		String password = reader.nextLine();

		boolean loggedIn = false;

		
		while (loggedIn) {
			System.out.println();

			System.out.println("Please select from the following options");
			System.out.println("Enter 1 to Check Copies out");
			System.out.println("Enter 2 to Check Copies in");
			System.out.println("Enter 3 to Log out");

			Patron p = FakeDB.getPatron("P1");
			
			int option = reader.nextInt();
			
			switch (option) {
			
			case 1:
				System.out.println("Enter PatronID");
				String read1= reader.nextLine();
				System.out.println("Displaying Patron information before Checkout");
				System.out.println(p);
				p.checkCopyOut(null);
				System.out.println("Displaying patron information after checkout");
				System.out.println(p);
				break;
			case 2:
				
				System.out.println("Enter PatronID");
				String read2= reader.nextLine();
				System.out.println("Displaying Patron information before Checkout");
				System.out.println();
				p.checkCopyIn(null);
				System.out.println("Displaying patron information after checkout");
				System.out.println(p);
				break;
			case 3:
				System.out.printf("Session closed, you are logged out!");
				break;
			}
		}

		System.out.printf("Session closed, you are logged out!");
	}
}
