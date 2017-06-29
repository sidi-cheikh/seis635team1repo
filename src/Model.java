
public class Model {
	
	public Model(){
	}
	
	public Patron getPatron(String  patronId){
		return FakeDB.getPatron(patronId);
	}
	
	public Copy findCopy(String copyId){
		return FakeDB.getCopy(copyId);
	} 
	
	public Worker findWorker(String workerlogin, String workerpasswd){
		Worker w = FakeDB.getWorker(workerlogin);
		if(w != null && w.getPassword().equals(workerpasswd)){
			return w;
		}
		else
		{
			return null;
		}
	}
}
