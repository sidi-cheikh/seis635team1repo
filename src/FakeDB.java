import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FakeDB
{

	private static Map<String, Patron> patronStore;
	private static Map<String, Copy> copyStore;
	private static Map<Integer, Session> sessionStore;
	private static Map<String, Worker> workerStore;


	static // the following runs once when class is loaded: "static initializer"
	{
		patronStore = new HashMap<String,Patron>();
		copyStore = new HashMap<String,Copy>();
		sessionStore = new HashMap<Integer, Session>();
		workerStore = new HashMap<String, Worker>();
		
		// P1 desn't have any copy checked out
		patronStore.put("P1", new Patron("P1", "Eric"));
		
		// P2 have the copy C2 checked out to him
		Patron P2 = new Patron("P2", "Ashraya");
		patronStore.put("P2",P2);
		Copy C2 = new Copy("C2", "More Fun with Objects");
		copyStore.put("C2", C2);
		
		// P3 with overdue copy
		Patron P3 = new Patron("P3", "Patron 3");
		Copy C3 = new Copy("C3", "Even More Fun with Objects");
		copyStore.put("C3", C3);
		P3.checkCopyOut(C3);
		// making the copy overdue
		Date now = new Date();
		long yesterdaytime = now.getTime() - 24*3600*1000;
		C3.setDueDate(new Date(yesterdaytime));
		patronStore.put("P3", P3);
		
		//adding more copies
		
		copyStore.put("C1", new Copy("C1", "Clean Code"));
		copyStore.put("C4", new Copy("C4", "Code Smells"));
		copyStore.put("C5", new Copy("C5", "Refactoring"));
		

		
		workerStore.put("worker1", new Worker("worker1", "pass"));
	}

	public static List<Patron> getPatrons(){
		List<Patron> patrons = new ArrayList<Patron>();	
		for(String key: patronStore.keySet()){
			patrons.add(patronStore.get(key));
		}
		
		return patrons;
	}
	
	public static Patron getPatron(String patronID)
	{
		return patronStore.get(patronID);
	}
	
	public static Copy getCopy(String copy)
	{
		return copyStore.get(copy);
	}
	

	public static void SaveSessionData(Session s)
	{
		Integer count = sessionStore.size();
		sessionStore.put(count +1 , s);
	}
	
	public static Worker getWorker(String workerName){
		return  workerStore.get(workerName);
	}
	
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		Worker sidi = workerStore.get("sidi");
		

	}
	

}
