import java.util.HashMap;
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
		
		patronStore.put("P1", new Patron("P1", "Eric"));
		Patron P2 = new Patron("P2", "Ashraya");
		patronStore.put("P2",P2);
		
		copyStore.put("C1", new Copy("C1", "Fun with Objects"));
		copyStore.put("C2", new Copy("C2", "More Fun with Objects"));
		
		Copy C3 = new Copy("C3", "Even More Fun with Objects");
		copyStore.put("C3", C3);
		P2.checkCopyOut(C3);
		
		workerStore.put("worker1", new Worker("worker1", "pass"));
	}

	public static Patron getPatron(String patronID)
	{
		return patronStore.get(patronID);
	}
	
	public static Copy getCopy(String copyID)
	{
		return copyStore.get(copyID);
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
