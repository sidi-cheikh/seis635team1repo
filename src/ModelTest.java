import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ModelTest {

	Model testModel;

	@Test
	public void testGetPatron() {
		testModel = new Model();
		Patron testPatron = new Patron("P2", "Ashraya");
		
		assertEquals(testPatron, testModel.getPatron(testPatron.getPatronID()));
	}

	@Test
	public void testFindCopy() {
		testModel = new Model();
		Copy testCopy = new Copy("C3", "Even More Fun with Objects");
		
		assertEquals(testCopy, testModel.findCopy(testCopy.getCopyID()));
	}

	@Test
	public void testFindWorker() {
		testModel = new Model();
		Worker testWorker = new Worker("worker1", "pass");
		
		assertEquals(testWorker, testModel.
				findWorker(testWorker.getWorkerName(), testWorker.getPassword()));
	}

}
