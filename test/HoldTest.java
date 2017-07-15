import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class HoldTest {
	
	public Patron createNewPatron(){
		return new Patron("P1", "TestHod");
	}
	
	public void makeCopyOverdue(Copy copy){
		Date now = new Date();
		long yesterdaytime = now.getTime() - 24*3600*1000;
		copy.setDueDate(new Date(yesterdaytime));
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
	
	@Test
	public void testMarkingHoldOnPatronWithOverduCopy(){
		Patron patron = createNewPatron();
		Copy copy = new Copy("C1", "Test Hold");
		patron.checkCopyOut(copy);
		makeCopyOverdue(copy);
		patron.markHold();
		
		assertTrue(patron.hasHold());
		
	}
	
	@Test
	public void testCopyInHolds(){
		Patron patron = createNewPatron();
		Copy copy = new Copy("C1", "Test Hold");
		patron.checkCopyOut(copy);
		makeCopyOverdue(copy);
		patron.markHold();
		
		Hold copyHold = patron.getHolds().get(0);
		assertTrue(copyHold.getCopy().equals(copy));
		
	}
	
	

}
