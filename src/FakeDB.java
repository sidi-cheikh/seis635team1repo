import java.util.HashMap;
import java.util.Map;

public class FakeDB
{
	private static Map<String, Patron> patronStore;
	private static Map<String, Copy> copyStore;
	private static Map<Integer, Session> sessionStore;
	
	static // the following runs once when class is loaded: "static initializer"
	{
		patronStore = new HashMap<String,Patron>();
		copyStore = new HashMap<String,Copy>();
		sessionStore = new HashMap<Integer, Session>();
		
		patronStore.put("P1", new Patron("P1", "Eric"));
		copyStore.put("C1", new Copy("C1", "Fun with Objects"));
		copyStore.put("C2", new Copy("C2", "More Fun with Objects"));
		
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
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}
	

}
