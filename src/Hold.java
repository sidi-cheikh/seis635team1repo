public class Hold {
	Patron p = new Patron();
public boolean getHold(){
	if(p.hasOverdueCopy()){
		return true;
	}
	return false;
	
}

}
