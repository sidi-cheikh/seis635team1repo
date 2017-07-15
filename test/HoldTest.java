import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class HoldTest {
	
	public Patron createNewPatron(){
		return new Patron("P1", "TestHod");
	}
	
	@Test
	public void canCheckIfTheHoldInitiallySetCorrectly(){
		Patron p = createNewPatron();
		assertFalse(p.hasHold());
	}
	
	@Test
	public void canMarkAHold(){
		Patron p = createNewPatron();
		p.markHold();
		
	}

}
