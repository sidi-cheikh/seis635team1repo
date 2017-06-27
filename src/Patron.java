
import java.util.ArrayList;

public class Patron {
	private String name;
	private String patronID;
	private Copy C1, C2;
	private ArrayList<Copy> copiesOut;

	public Patron()
	{ setC1(null); 
	setC2(null); 
	
	}

	public Patron(String id, String name) {
		this.name=name;
		this.patronID=id;
		copiesOut = new ArrayList<Copy>();
	}

	public String getName() {
		return name;
	}

	public Copy getC1() {
		return C1;
	}

	public void setC1(Copy c1) {
		C1 = c1;
	}

	public Copy getC2() {
		return C2;
	}

	public void setC2(Copy c2) {
		C2 = c2;
	}


	public String getPatronID() {
		return patronID;
	}
	
	
	public boolean checkCopyOut(Copy c) {
		copiesOut.add(c);
		
		return true;
	}

	public boolean checkCopyIn(Copy title) {
		
		copiesOut.remove(title);
		
		return false;
	}

	/*
	 * @Override public boolean equals(Object o) { // finish this: two are
	 * equals iff same patron ID
	 * 
	 * return false; }
	 */

	public String toString() {
		// finish this: return basic Patron info as String
		String result = "Name: " + name + "; PatronID: " + patronID + "\n";
		if(copiesOut.isEmpty()){
			result += "  Number of checked out copies: 0";
		}
		else
		{
			result += "Number of checked out copies: "+ copiesOut.size()+"\n";
			result += "  Checked out copies: \n";
			for(Copy c: copiesOut){
				result += "  - Title:"+c.getTitle() + "; ID:"+c.getCopyID()+" \n";
			}
		}
		
		return result;
	}

	public static void main(String[] args) {
		Patron p1 = new Patron("P47", "Eric");
		Copy copy = new Copy("c1", "test c1");
		
		System.out.println(p1);

		p1.checkCopyOut(copy);
		System.out.println(p1);
		
		p1.checkCopyIn(copy);
		System.out.println(p1);
		

		//Patron p2 = FakeDB.getPatron("P47");
		//Copy c1 = FakeDB.getCopy("C1");
	}

}