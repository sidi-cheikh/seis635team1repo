
public class Model {
	
	public Model(){
	}
	
	public Patron getPatron(String  patronId){
		return FakeDB.getPatron(patronId);
	}
	
	public Copy findCopy(String copyId){
		return FakeDB.getCopy(copyId);
	} 
	
}
