import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class CopyTest {

	
	@Test
	public void testCopy() {
		Copy b1 = new Copy ("123", "Software Analysis and Design");
		assertTrue("Software Analysis and Design".equals( b1.getTitle()));
		assertEquals("123", b1.getCopyID());
	}

	@Test
	public void testToString() {
	
		    Copy c1 = new Copy("C1", "Fun with Objects");
		    System.out.println(c1);
			assertTrue(c1.toString().equals("Title:Fun with Objects"+"\nCopy ID: C1"+"\nAvailable"));	
		}
	

	@Test
	public void testEqualsObject() {
		Copy b1 = new Copy ("123", "Software Analysis and Design");
		equals(b1.getCopyID().equals("123"));
		assertNotSame(b1.getCopyID(), "345");
	}

}

