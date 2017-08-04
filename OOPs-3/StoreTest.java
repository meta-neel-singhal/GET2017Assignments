import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
public class StoreTest {
	Store store;

	@Before
	public void setUpObject(){
		store = new Store();

	}
	
	// Positive test case.
	@Test
	public void storeTest1(){
		boolean actual = store.isIdValid(1001);
		boolean expected = true;
		assertEquals(expected, actual);
	}
	
	// Negative test case.
	@Test
	public void storeTest2(){
		boolean actual = store.isIdValid(4101);
		boolean expected = true;
		assertFalse(expected == actual);
	}

}