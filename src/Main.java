
public class Main {

	public static void main(String[] args)
	{
		// retrieving the patron from the db 
		Patron p = FakeDB.getPatron("P1");
		
		System.out.println("1. CHECKING OUT COPIES");
		System.out.println("1.1 Displying patron infos before checkout");
		System.out.println(p);
		
		System.out.println("1.2 Checking out the first copy 'C1'");
		Copy c1 = FakeDB.getCopy("C1");
		p.checkCopyOut(c1);
		
		System.out.println("1.3 Displying patron infos after first checkout");
		System.out.println(p);
		
		System.out.println("1.4 Checking out the second copy 'C2'");
		Copy c2 = FakeDB.getCopy("C2");
		p.checkCopyOut(c2);
		
		System.out.println("1.5 Displying patron infos after second checkout");
		System.out.println(p);
		
		System.out.println("2. CHECKING IN COPIES");
		System.out.println("2.1 Displying patron infos before checking in");
		System.out.println(p);
		
		System.out.println("2.1 Checking in the first copy 'C1'");
		p.checkCopyIn(c1);
		
		System.out.println("2.2 Displying patron infos after checking in the copy 'C1'");
		System.out.println(p);
		
		System.out.println("2.1 Checking in the second copy 'C2'");
		p.checkCopyIn(c2);
		
		System.out.println("2.2 Displying patron infos after checking in the copy 'C2'");
		System.out.println(p);
		
	}	
}
