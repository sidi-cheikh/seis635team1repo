import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class CopyTest {

	
	@Test
	public void testCopy() {
		Copy b1 = new Copy ("123", "Software Analysis and Design");
		assertEquals("Software Analysis and Design", b1.getTitle());
		assertEquals("123", b1.getCopyID());
	}

	@Test
	public void testToString() {
	
		Copy c1 = new Copy("C1", "Fun with Objects");
			assertEquals("Title:Fun with Objects"+"\nCopy ID:C1"+"\nAvailable", 
					c1.toString());	
		}
	

	@Test
	public void testEqualsObject() {
		Copy b1 = new Copy ("123", "Software Analysis and Design");
		equals(b1.getCopyID().equals("123"));
		assertNotSame(b1.getCopyID(), "345");
	}

}

