import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Patron {
	private String name;
	private String patronID;
	private ArrayList<Copy> copiesOut = new ArrayList<Copy>();
	private Date date;
	private List<Hold> holds = new ArrayList<Hold>();

	public Patron()
	{ 
	
	}

	public Patron(String id, String name) {
		this.name=name;
		this.patronID=id;
	    this.date = new Date();
	}

	
	public String getPatronID() {
		return patronID;
	}

	public boolean checkCopyOut(Copy c) {

		if(c.isAvailable()){
			copiesOut.add(c);
			c.setOutTo(this);
			return true;
		}
		else
		{
			return true;
		}
		
		
	}

	public boolean checkCopyIn(Copy c) {
		
		if(this.equals(c.getOutTo())){
			copiesOut.remove(c);
			c.setOutTo(null);
			return true;
		}
		else
		{
			return false;
		}
	}
	

	public String toString() {
		// finish this: return basic Patron info as String
		Patron p1 = new Patron("P47", "Eric");
		String result = null;
		if(copiesOut.isEmpty()){
			 result = "Name: " + name + " \nPatronID: " + patronID +"\n";
			result += "Checked out copies: 0" + "\n";
		}
		else
		{
			result = "Name: " + name + " \nPatronID: " + patronID +";"+ "\n";
			result += "Number of checked out copies: "+ copiesOut.size()+ "\n";
			for(Copy c: copiesOut){
				result += "\n  -Title:"+c.getTitle() +"\n   Copy ID:"+c.getCopyID()+" \n   Due Date:"+c.getDueDate();
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
		
	}

	public boolean hasOverdueCopy(){
		for(Copy c: copiesOut){
			if (c.isOverdue()) {
				return true;
			}
		}
		
		return false;
	}
	
	public List<Copy> getOverdueCopies(){
		List<Copy> overdueCopies = new ArrayList<Copy>();
		for(Copy c: copiesOut){
			if (c.isOverdue()) {
				overdueCopies.add(c);
			}
		}
		
		return overdueCopies;
	}

	public String getName() {
		
		return name;
	}

	public boolean hasCheckedOutCopies() {
		// TODO Auto-generated method stub
		return copiesOut.size() > 0;
	}

	public boolean hasHold() {
		return !holds.isEmpty();
		
	}

	public void markHold() {
		holds = new ArrayList<Hold>();
		for(Copy c: copiesOut){
			if(c.isOverdue()){
				holds.add(new Hold(this, c));
			}
		}
	}

	public List<Hold> getHolds() {
		return holds;
	}
	
	
	

}

