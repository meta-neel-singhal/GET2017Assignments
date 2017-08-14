package junittests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import userdata.Graph;
import entity.User;

public class GraphTest {

	Graph graph = new Graph();

	// Positive Test Case.
	@Test
	public void isValidNodeIdTestCase1() {
		boolean actual = graph.isValidNodeId("123");
		boolean expected = true;
		assertEquals(actual, expected);
	}

	// Positive Test Case.
	@Test
	public void isValidNodeIdTestCase2() {
		graph.addNode("290", new User("290", "xyz", "123", 1234567890, 23, "User"));
		boolean actual = graph.isValidNodeId("290");
		boolean expected = true;
		assertEquals(actual, expected);
	}

	// Negative Test Case.
	@Test
	public void isValidNodeIdTestCase3() {
		boolean actual = graph.isValidNodeId("789");
		boolean expected = true;
		assertFalse(actual == expected);
	}

	// Negative Test Case.
	@Test
	public void isValidNodeIdTestCase4() {
		graph.removeNodeById("290");
		boolean actual = graph.isValidNodeId("290");
		boolean expected = true;
		assertFalse(actual == expected);
	}
}
