import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class PatronTest {

	Patron testPatron;

	@Test
	public void testGetPatronID() {
		testPatron = new Patron("pId", "pName");
		assertEquals("pId", testPatron.getPatronID());
	}

	@Test
	public void testCheckCopyOut() {
		ArrayList<Copy> copiesOut = new ArrayList<Copy>();
		testPatron = new Patron();
		Copy testCopy = new Copy("c2", "testCopy");
		copiesOut.add(testCopy);
		assertEquals(copiesOut, testPatron.checkCopyOut(testCopy));
	}

	@Test
	public void testCheckCopyIn() {
		ArrayList<Copy> copiesOut = new ArrayList<Copy>();
		testPatron = new Patron();
		Copy testCopy = new Copy("c2", "testCopy");
		copiesOut.remove(testCopy);
		assertEquals(true, testPatron.checkCopyIn(testCopy));
	}

	@Test
	public void testToString() {
		testPatron = new Patron("pId", "pName");
		assertNotNull(testPatron.toString());	
	}

	@Test
	public void testHasOverdueCopy() {
		testPatron = new Patron("pId", "pName");
		assertNotNull(testPatron.hasOverdueCopy());
	}

	@Test
	public void testGetOverdueCopies() {
		testPatron = new Patron("pId", "pName");
		assertNotNull(testPatron.getOverdueCopies());
	}

	@Test
	public void testGetName() {
		testPatron = new Patron("pId", "pName");
		assertEquals("pName", testPatron.getName());
	}

}
