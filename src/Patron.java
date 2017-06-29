import java.util.ArrayList;

public class Patron {
	private String name;
	private String patronID;
	//private Copy C1, C2;
	private ArrayList<Copy> copiesOut;

	public Patron()
	{ 
	
	}

	public Patron(String id, String name) {
		this.name=name;
		this.patronID=id;
		copiesOut = new ArrayList<Copy>();
	}

	
	public String getPatronID() {
		return patronID;
	}

	public boolean checkCopyOut(Copy c) {
		// finish this
		/*if (C1 == null) {
			C1 = c;
			return true;
		} else if (C2 == null) {
			C2 = c;
			return true;
		}*/
		
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

	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

}

