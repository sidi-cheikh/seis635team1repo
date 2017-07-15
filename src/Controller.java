import java.util.List;

//sohana
public class Controller {

	Model model;
	Session session;
	
	public Controller()
	{
		model = new Model();
	}
	
	public Worker login(String username, String password)
	{
		
		return model.findWorker(username, password);
	}
	
	public Patron startSession(String patronId){
		this.session = new Session();
		
		Patron p = model.getPatron(patronId);
		
		session.patron = p;
		
		return p;
	}
	

	public Copy checkoutCopy(String copyId){
		/*TODO make sure the patron doesn't have hold  */
		
		// check if the copy exists
		Copy c = model.findCopy(copyId);
		if(c != null && c.isAvailable()){
			Patron p = session.getPatron();
			p.checkCopyOut(c);
		}
		
		return c;
	}

	public Copy checkInCopy(String copyId) {
		// check if the copy exists
				Copy c = model.findCopy(copyId);
				Patron p = session.getPatron();
				if(c != null && c.getOutTo() == p){
					p.checkCopyIn(c);
				}
				else
					System.out.println ("Copy not found or not checked out to the patron!");
				
				return c;	
				
				//@TODO
				// 1.could not find the copy
				// 2.the copy is not checked out to the patron
				// 3.success
			
	}
	
   public void endSession(){
		
	}

	public int markholds() {
		List<Patron> patrons = model.getAllPatrons();
		
		int total = 0;
		for(Patron p: patrons){
			
			if(p.hasOverdueCopy() && !p.hasHold()){
				p.markHold();
				total++;
			}
		}
			
		return total;
	}
}
