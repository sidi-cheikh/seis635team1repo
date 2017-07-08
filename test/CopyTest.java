import static org.junit.Assert.*;
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
	
		Copy b1 = new Copy ("123", "Software Analysis and Design");
			b1.getOutTo();
			assertEquals("Software Analysis and Design by 123; Available", 
					b1.toString());	
		}
	

	@Test
	public void testEqualsObject() {
		Copy b1 = new Copy ("123", "Software Analysis and Design");
		equals(b1.getCopyID().equals("123"));
		assertNotSame(b1.getCopyID(), "345");
	}

}

