import java.util.Calendar;
import java.util.Date;

public class Copy
{
	private String copyID;
	private String title;
	private Patron outTo;
	private Date checkoutDate;
	private Date dueDate;
	public Date getDueDate() {
		return dueDate;
	}

	private int duration = 5; //10 days
	private Date date;

	public Copy(String copyID, String title)
	{
		this.setCopyID(copyID);
		this.setTitle(title);
		this.date = new Date();
	}
	
	public String getCopyID() {
		return copyID;
	}

	public void setCopyID(String copyID) {
		this.copyID = copyID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Patron getOutTo() {
		return outTo;
	}

	public void setOutTo(Patron outTo) {
		this.outTo = outTo;
		this.checkoutDate = new Date();
		
		Calendar c = Calendar.getInstance();
		c.setTime(this.checkoutDate);
		c.add(Calendar.DATE, this.duration);
		this.dueDate = c.getTime();
	}
// generate getters and setters using Eclipse Source menu

	public boolean isOverdue(){
		Date now = new Date();
		if( now.compareTo(dueDate) > 0){
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public String toString()
	{
		Copy c1 = new Copy("C1", "Fun with Objects");
		String available;
		if (this.getOutTo() == null) {
			available = "Available";
		}
		else {
			available = "Checked out to " + 
			this.getOutTo().getName();
		}
		
		return "Title:"+this.getTitle() + 
		"\nCopy ID: " + this.getCopyID() +
		"\n" + available;
	


}

	
	public boolean equals(Object o)
	{
		// finish this: two are equals iff same copy ID
		if (o == null) return false;
		if (o == this) return true;

		if (!(o instanceof Copy)) return false; // OR
		if (o.getClass() != getClass()) return false;

		Copy copy = (Copy) o;
		return this.copyID.equals(copy.copyID);
		
	} 


	public boolean isAvailable()
	{
		return outTo == null;
	}
	
	public static void main(String[] args)
	{
		Copy c1 = new Copy("C1", "Fun with Objects");
		Patron p1 = new Patron("Eric", "P47");

		System.out.println(c1);
		System.out.println(p1);
		
		Copy c2 = FakeDB.getCopy("C2");
	}

	public void setDueDate(Date date) {
		dueDate = date;
	}
	
}
