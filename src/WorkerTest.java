import static org.junit.Assert.*;
import org.junit.Test;

public class WorkerTest {

	@Test
	public void testWorker() {
		Worker test=new Worker("Sohana", "password");
		assertEquals("Sohana", test.getWorkerName());
		assertEquals("password", test.getPassword());
	}

	@Test
	public void testGetWorkerName() {
		Worker test=new Worker("Sohana", "password");
		String excepted=test.getWorkerName();
		assertEquals(test.getWorkerName(),excepted);
	}

	@Test
	public void testSetWorkerName() {
		Worker test=new Worker("Sohana","password");
		String name="Sohana";
		test.setWorkerName("Sohana");
		assertEquals(test.getWorkerName(),name);
	}

	@Test
	public void testGetPassword() {
		Worker test=new Worker("Sohana","password");
		assertEquals(test.getPassword(),"password");
	}

	@Test
	public void testSetPassword() {
		Worker test=new Worker("Sohana","password");
		String passWord="passWord";
		test.setPassword("passWord");
		assertEquals(test.getPassword(),passWord);
	}

	@Test
	public void testEqualsWorker() {
		Worker test=new Worker("Sohana", "password");
		equals(test.getWorkerName().equals("Sohana"));
		assertNotSame(test.getWorkerName(), "Mash");
	}

	@Test
	public void testToString() {
		Worker test=new Worker("Sohana", "password");
		String toString = test.toString();
	    assertTrue(toString.contains("Sohana"));
	}	

}


