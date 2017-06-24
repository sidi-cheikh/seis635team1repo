
public class Copy
{
	private String copyID;
	private String title;
	private Patron outTo;

	public Copy(String copyID, String title)
	{
		this.setCopyID(copyID);
		this.setTitle(title);
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
	}
// generate getters and setters using Eclipse Source menu

	public String toString()
	{
		String available;
		if (this.getOutTo() == null) {
			available = "Available";
		}
		else {
			available = "Checked out to " + 
			this.getOutTo().getName();
		}
		
		return this.getTitle() + 
		" by " + this.getCopyID() +
		"; " + available;
	


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


	public static void main(String[] args)
	{
		Copy c1 = new Copy("C1", "Fun with Objects");
		Patron p1 = new Patron("Eric", "P47");

		System.out.println(c1);
		System.out.println(p1);
		
		Copy c2 = FakeDB.getCopy("C2");
	}

	
}
