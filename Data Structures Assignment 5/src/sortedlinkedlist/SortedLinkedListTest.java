package sortedlinkedlist;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * The Class to test Sorted Linked List.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SortedLinkedListTest {
	
	// Positive test case.
	@Test
	public void sortingTest1() {
		SortedList.add(12);
		SortedList.add(6);
		SortedList.add(8);
		SortedList.add(16);
		SortedList.add(3);
				
		String expected = SortedList.sortedList.toString();
		String actual = "[3, 6, 8, 12, 16]";
		assertEquals(actual, expected);
	} 

	// Negative test case.
	@Test
	public void sortingTest2() {
		SortedList.add(12);
		SortedList.add(24);
		SortedList.add(1);
		SortedList.add(2);
		SortedList.add(30);
		
		String expected = SortedList.sortedList.toString();
		String actual = "[1, 12, 2, 24, 30]";
		assertFalse(expected == actual);
	}
}
