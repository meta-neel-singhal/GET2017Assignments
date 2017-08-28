package sortedlinkedlist;

import static org.junit.Assert.*;
import org.junit.runners.MethodSorters;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;

/**
 * The Class to test Sorted Linked List.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SortedLinkedListTest {
	
	SortedList list;
	
	@Before
	public  void init() {
		list = new SortedList();
	}
	
	// Positive test case.
	@Test
	public void sortingTest1() {
		list.add(12);
		list.add(6);
		list.add(8);
		list.add(16);
		SortedList.add(3);
				
		String expected = list.sortedList.toString();
		String actual = "[3, 6, 8, 12, 16]";
		assertEquals(actual,expected);
	} 

	// Positive test case.
	@Test
	public void sortingTest2() {
		list.add(12);
		list.add(24);
		list.add(1);
		list.add(2);
		list.add(30);
		String expected = list.sortedList.toString();
		String actual = "[1, 2, 12, 24, 30]";
		assertEquals(actual,expected);
	} 

	// Negative test case.
	@Test
	public void sortingTest3() {
		list.add(12);
		list.add(6);
		list.add(8);
		list.add(16);
		list.add(3);
		String expected = list.sortedList.toString();
		String actual = "[3, 8, 6, 12, 16]";
		assertFalse(expected == actual);
	} 

	// Negative test case.
	@Test
	public void sortingTest4() {
		list.add(12);
		list.add(24);
		list.add(1);
		list.add(2);
		list.add(30);
		String expected = list.sortedList.toString();
		String actual = "[1, 12, 2, 24, 30]";
		assertFalse(expected == actual);
	}
}
