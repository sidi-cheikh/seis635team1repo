import static org.junit.Assert.*;
import java.util.HashMap;
import org.junit.Test;

public class TextBookTest {

	
	@Test
	public void testTextBookt() {
		Copy c1 = new Copy ("123", "Software Analysis and Design");
		TextBook b1=new TextBook(c1, 1);
		HashMap<String,TextBook> books=new HashMap<String,TextBook>();
		books.put(c1.getCopyID(), b1);
		
	}

	@Test
	public void testAdd() {
		Copy c1 = new Copy ("123", "Software Analysis and Design");
		TextBook b1=new TextBook(c1, 1);
		HashMap<String,TextBook> books=new HashMap<String,TextBook>();
		books.put(c1.getCopyID(), b1);
		b1.add(c1,2);
		assertEquals(b1.getQuantity(),null);
	}

	@Test
	public void testRemove() {
		Copy c1 = new Copy ("123", "Software Analysis and Design");
		TextBook b1=new TextBook(c1, 1);
		HashMap<String,TextBook> books=new HashMap<String,TextBook>();
		books.put(c1.getCopyID(), b1);
		b1.remove(c1, 1);
		assertEquals(b1.getQuantity(),null);
	}

	


}
