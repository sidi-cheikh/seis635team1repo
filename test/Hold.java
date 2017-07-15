
public class Hold {

	Patron patron;
	Copy copy;
	
	public Hold(Patron p, Copy c) {
		patron = p;
		copy = c;
	}

	public Object getCopy() {
		return copy;
	}

}
