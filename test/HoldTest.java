import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class HoldTest {

	@Test
	public void canCheckIfPatronHasHod() {
		Patron p = new Patron("P1", "TestHod");
		p.hasHold();
	}

}
