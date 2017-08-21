package linkedlist;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * The JUnit Test class.
 * 
 * @author Neel Singhal
 */
public class SinglyLinkedListTest {

	static SinglyLinkedList<Integer> linkedList;

	// Creates object before executing any test case.
	@BeforeClass
	public static void setUpClassTestCase1() {
		linkedList = new SinglyLinkedList<Integer>();
	}

	// Positive Test Case 1.
	@Test
	public void addElementAtLastTestCase1() {
		linkedList.addNode(12);
		int expected  = linkedList.getElementFromPosition(0);
		assertEquals(12,expected);
	}

	// Positive Test Case 2.
	@Test
	public void addElementAtPosTestCase1() {
		linkedList.addNode(12);
		linkedList.addNode(24);
		linkedList.addNode(36);
		linkedList.addNodeAtLocation(2, 30);
		assertTrue(linkedList.addNodeAtLocation(2, 30));
	}

	// Positive Test Case 3.
	@Test
	public void removeElementAtPosTestCase1() {
		linkedList.addNode(12);
		linkedList.addNode(24);
		linkedList.addNode(36);
		assertTrue(linkedList.removeItem(24));
	}

	// Positive Test Case 4.
	@Test
	public void removeElementByPosTestCase1() {
		linkedList.addNode(12);
		linkedList.addNode(24);
		linkedList.addNode(36);
		assertTrue(linkedList.removeItemFromPosition(2));
	}

	// Positive Test Case 5.
	@Test
	public void getElementByPosTestCase1() {
		linkedList.addNode(30);
		linkedList.addNode(24);
		linkedList.addNode(36);
		int expected = linkedList.getElementFromPosition(1);
		assertEquals(30, expected);
	}

	// Positive Test Case 6.
	@Test
	public void getSizeTestCase1() {
		linkedList.addNode(12);
		linkedList.addNode(24);
		linkedList.addNode(36);
		int expected = linkedList.getSize();
		assertEquals(3, expected);
	}
	
	// Negative Test Case.
	@Test
	public void addElementAtLastTestCase2() {
		linkedList.addNode(12);
		int expected  = linkedList.getElementFromPosition(0);
		assertFalse(0 == expected);
	}

	// Negative Test Case.
	@Test
	public void addElementAtPosTestCase2() {
		linkedList.addNode(12);
		linkedList.addNode(24);
		linkedList.addNode(36);
		linkedList.addNodeAtLocation(2, 30);
		assertFalse(!linkedList.addNodeAtLocation(2, 30));
	}

	// Negative Test Case.
	@Test
	public void removeElementAtPosTestCase2() {
		linkedList.addNode(12);
		linkedList.addNode(24);
		linkedList.addNode(36);
		assertFalse(!linkedList.removeItem(24));
	}

	// Negative Test Case.
	@Test
	public void removeElementByPosTestCase2() {
		linkedList.addNode(12);
		linkedList.addNode(24);
		linkedList.addNode(36);
		assertFalse(!linkedList.removeItemFromPosition(2));
	}

	// Negative Test Case.
	@Test
	public void getElementByPosTestCase2() {
		linkedList.addNode(12);
		linkedList.addNode(24);
		linkedList.addNode(36);
		int expected = linkedList.getElementFromPosition(1);
		assertFalse(24 == expected);
	}

	// Negative Test Case.
	@Test
	public void getSizeTestCase2() {
		linkedList.addNode(12);
		linkedList.addNode(24);
		linkedList.addNode(36);
		int expected = linkedList.getSize();
		assertFalse(4 == expected);
	}
}
