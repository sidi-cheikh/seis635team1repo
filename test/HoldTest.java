import static org.junit.Assert.*;

import java.util.List;

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
	
	@Test
	public void canCreateHold(){
		Patron patron = createNewPatron();
		Copy copy = new Copy("C1", "Test Hold");
		Hold hold = new Hold(patron, copy);
	}
	
	
	@Test
	public void ifHoldListIsEmplyOnNewPatron(){
		Patron patron = createNewPatron();
		List<Hold> holds = patron.getHolds();
		assertTrue(holds.isEmpty());
	}

}
