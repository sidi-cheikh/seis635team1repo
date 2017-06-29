//sohana
public class Controller {

	Model model;
	Session session;
	
	public Controller()
	{
		model = new Model();
	}
	
	public Session startSession(){
		return new Session();
	}
	
	public Patron scanPatronId(String patronId){
		Patron p = model.getPatron(patronId);
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
