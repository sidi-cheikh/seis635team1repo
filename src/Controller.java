//sohana
public class Controller {

	Model model;
	Session session;
	
	public Controller()
	{
		model = new Model();
	}
	
	public Worker login(String username, String password){
		
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
		if(c != null){
			Patron p = session.getPatron();
			p.checkCopyOut(c);
		}
		
		return c;
	}
	
	
	public void endSession(){
		
	}
}
