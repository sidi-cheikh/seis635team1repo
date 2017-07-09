import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ControllerTest {
	Model model = new Model();
	Session session = new Session();
	@Test
	public void testController() {
		Controller test = new Controller();
		assertNotNull(test.model);
	}

	@Test
	public void testLogin() {
		Worker testWorker = new Worker("worker1", "pass");
		Controller testController = new Controller();
		model.findWorker("worker1", "pass");
		assertEquals(testWorker, testController.login("worker1", "pass"));
	}

	@Test
	public void testStartSession() {
		Controller testController = new Controller();
		Patron p1 = new Patron("P47", "Eric");
         model.getPatron("p47");
		 session.patron = p1;
		assertEquals( testController.session,testController.startSession("p47") );
		
	}

	@Test
	public void testCheckoutCopy() {
		Controller testController = new Controller();
		Patron p1 = new Patron("P47", "Eric");
		Copy copy = new Copy("c1", "test c1");
		p1.checkCopyOut(copy);
		Copy c11 = model.findCopy("c1");
		assertEquals(c11, testController.checkoutCopy("c1"));
	}

	@Test
	public void testCheckInCopy() {
		Controller testController = new Controller();
		Patron p1 = new Patron("P47", "Eric");
		Copy copy1 = new Copy("c1", "test c1");
		testController.checkoutCopy("c1");
		model.findCopy("c1");
		p1=session.getPatron();
		//Patron p11=session.getPatron();
		assertEquals(copy1, testController.checkInCopy("c1"));
	}

}
