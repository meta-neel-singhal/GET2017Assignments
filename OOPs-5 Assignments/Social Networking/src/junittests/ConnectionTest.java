package junittests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import helpers.Connection;

import org.junit.Test;

public class ConnectionTest {
	Connection connection = new Connection();

	// Positive Test Case.
	@Test
	public void isEntityIdPresentInListTestCase1() {
		boolean actual = connection.isEntityIdPresentInList("123", "125");
		boolean expected = false;
		assertEquals(expected, actual);
	}

	// Positive Test Case.
	@Test
	public void isEntityIdPresentInListTestCase2() {
		connection.addConnection("123", "124");
		boolean actual = connection.isEntityIdPresentInList("123", "124");
		boolean expected = true;
		assertEquals(expected, actual);
	}

	// Negative Test Case.
	@Test
	public void isEntityIdPresentInListTestCase3() {
		boolean actual = connection.isEntityIdPresentInList("123", "124");
		boolean expected = false;
		assertFalse(expected == actual);
	}

	// Negative Test Case.
	@Test
	public void isEntityIdPresentInListTestCase4() {
		connection.removeConnection("123", "124");
		boolean actual = connection.isEntityIdPresentInList("123", "124");
		boolean expected = true;
		assertFalse(expected == actual);
	}

}
