package doublylinkedlist;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * The JUnit test class.
 * 
 * @author Neel Singhal
 */
public class DoublyLinkedListTest {
	static DoublyLinkedList<Integer> linkedList;

	// Loads before the class loads.
	@BeforeClass
	public static void  setUpClass(){
		linkedList = new DoublyLinkedList<Integer>();
	}

	// Positive Test Case 1.
	@Test
	public void addTestCase1() {
		linkedList.addNode(5);
		int expected = linkedList.getElementFromPosition(0);
		assertEquals(5, expected);
	}

	// Positive Test Case 2.
	@Test
	public void addByIndexTestCase1() {
		linkedList.addNode(5);
		linkedList.addNode(6);
		boolean expected = linkedList.addNodeAtLocation(2, 7);
		assertEquals(true, expected);
	}

	// Positive Test Case 3.
	@Test
	public void sizeTestCase1() {
		linkedList.addNode(5);
		linkedList.addNode(6);
		linkedList.addNode(8);
		int expected = linkedList.getSize();
		assertEquals(5, expected);
	}

	// Positive Test Case 4.
	@Test
	public void removeElementByPositionTestCase1() {
		linkedList.addNode(5);
		linkedList.addNode(6);
		linkedList.addNode(8);
		boolean expected =  linkedList.removeItemFromPosition(1);
		assertEquals(true, expected );
	}

	// Positive Test Case 5.
	@Test
	public void removeElementTestCase1() {
		linkedList.addNode(5);
		linkedList.addNode(6);
		linkedList.addNode(8);
		assertEquals(true, linkedList.removeItem(8));
	}

	// Negative Test Case 1.
	@Test
	public void addTestCase2() {
		linkedList.addNode(5);
		int expected = linkedList.getElementFromPosition(0);
		assertNotEquals(0, expected);
	}

	// Negative Test Case 2.
	@Test
	public void addByIndexTestCase2() {
		linkedList.addNode(5);
		linkedList.addNode(6);
		boolean expected = linkedList.addNodeAtLocation(2, 7);
		assertNotEquals(false, expected);
	}

	// Negative Test Case 3.
	@Test
	public void sizeTestCase2() {
		linkedList.addNode(5);
		linkedList.addNode(6);
		linkedList.addNode(8);
		int expected = linkedList.getSize() - 1;
		assertNotEquals(0, expected);
	}

	// Negative Test Case 4.
	@Test
	public void removeElementByPositionTestCase2() {
		linkedList.addNode(5);
		linkedList.addNode(6);
		linkedList.addNode(8);
		linkedList.removeItemFromPosition(1);
		assertFalse(1 == linkedList.getElementFromPosition(6));
	}

	// Negative Test Case 5.
	@Test
	public void removeElementTestCase2() {
		linkedList.addNode(5);
		linkedList.addNode(6);
		linkedList.addNode(8);
		assertFalse(false == linkedList.removeItem(8));
	}
}
