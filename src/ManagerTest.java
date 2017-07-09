import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ManagerTest {

		@Test
		public void testToString()
		{
			Manager testManager = new Manager();
			assertEquals(testManager.generatedReport, testManager.toString());
		}
}
