import java.util.Date;

public class Manager {
	//"Manager Marks Overdue Holds" and "Manager Generates Overdue Notices"

	protected Date timestamp;
	protected String generatedReport;
	
	public Manager () {
		this.timestamp = new Date();
		this.generatedReport = "Generates Overdue Notices";
	}
	public String toString() {
		return this.generatedReport;
	}


	
	
	
}
