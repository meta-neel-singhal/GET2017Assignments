package sorting;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCase {

	// Positive Test Case.
	@Test
	public void BubbleSortTestCase1() {
		int expected[];
		int flag;
		int array[] = {12, 53, 236, 56, 54, 210, 235};
		int actual[] = {12, 53, 54, 56, 210, 235, 236};
		
		if (array.length <= 10) {
			expected = ComparisonSort.bubbleSort(array);
			flag = 1;
		}
		else {
			expected = ComparisonSort.quickSort(array, 0, array.length - 1);
			flag = 2;
		}
		assertEquals("Sorting Method", 1, flag);
		assertArrayEquals("Sorted Array", expected, actual);	
	}

	// Positive Test Case.
	@Test
	public void QuickSortTestCase1() {
		int expected[];
		int flag;
		int array[] = {6752, 12, 53, 236, 56, 256, 54, 194, 210, 235, 284, 34435};
		int actual[] = {12, 53, 54, 56, 194, 210, 235, 236, 256, 284, 6752, 34435};
	
		if (array.length <= 10) {
			expected = ComparisonSort.bubbleSort(array);
			flag = 1;
		}
		else {
			expected = ComparisonSort.quickSort(array, 0, array.length - 1);
			flag = 2;
		}
		assertEquals("Sorting Method", 2, flag);
		assertArrayEquals("Sorted Array", expected, actual);	
	}
	
	// Positive Test Case.
	@Test
	public void RadixSortTestCase1() {
		int expected[];
		int flag;
		int array[] = {12, 536, 29, 565, 56, 7, 54, 214, 233, 32, 92, 4};
		int actual[] = {4, 7, 12, 29, 32, 54, 56, 92, 214, 233, 536, 565};
		int max = Main.findMax(array);
		
		if ((max / 100) > 0) {
			expected = LinearSort.radixSort(array, max);
			flag = 1;
		}
		else {
			expected = LinearSort.countingSort(array, array.length, max, 1, max + 1);
			flag = 2;
		}
		assertEquals("Sorting Method", 1, flag);
		assertArrayEquals("Sorted Array", expected, actual);	
	}

	// Positive Test Case.
	@Test
	public void CountingSortTestCase1() {
		int expected[];
		int flag;
		int array[] = {12, 53, 29, 5, 56, 7, 54, 21, 23, 2, 92, 4};
		int actual[] = {2, 4, 5, 7, 12, 21, 23, 29, 53, 54, 56, 92};
		int max = Main.findMax(array);
		
		if ((max / 100) > 0) {
			expected = LinearSort.radixSort(array, max);
			flag = 1;
		}
		else {
			expected = LinearSort.countingSort(array, array.length, max, 1, max + 1);
			flag = 2;
		}
		assertEquals("Sorting Method", 2, flag);
		assertArrayEquals("Sorted Array", expected, actual);	
	}

	// Negative Test Case.
	@Test
	public void BubbleSortTestCase2() {
		int expected[];
		int flag;
		int array[] = {12, 53, 236, 56, 54, 210, 235};
		int actual[] = {236, 235, 210, 56, 54, 53, 12};

		if (array.length <= 10) {
			expected = ComparisonSort.bubbleSort(array);
			flag = 1;
		}
		// Else use Quick Sort.
		else {
			expected = ComparisonSort.quickSort(array, 0, array.length - 1);
			flag = 2;
		}
		assertFalse("Sorting Method", 2 == flag);
		assertNotEquals("Sorted Array", expected, actual);	
	}

	// Negative Test Case.
	@Test
	public void QuickSortTestCase2() {
		int expected[];
		int flag;
		int array[] = {6752, 12, 53, 236, 56, 256, 54, 194, 210, 235, 284, 34435};
		int actual[] = {12, 53, 54, 56, 6752, 34435, 194, 210, 235, 236, 256, 284};

		if (array.length <= 10) {
			expected = ComparisonSort.bubbleSort(array);
			flag = 1;
		}
		// Else use Quick Sort.
		else {
			expected = ComparisonSort.quickSort(array, 0, array.length - 1);
			flag = 2;
		}
		assertFalse("Sorting Method", 1 == flag);
		assertNotEquals("Sorted Array", expected, actual);	
	}
	
	// Negative Test Case.
	@Test
	public void RadixSortTestCase2() {
		int expected[];
		int flag;
		int array[] = {12, 536, 29, 565, 56, 7, 54, 214, 233, 32, 92, 4};
		int actual[] = {12, 29, 32, 54, 56, 92, 4, 7, 214, 233, 536, 565};
		int max = Main.findMax(array);
		
		if ((max / 100) > 0) {
			expected = LinearSort.radixSort(array, max);
			flag = 1;
		}
		else {
			expected = LinearSort.countingSort(array, array.length, max, 1, max + 1);
			flag = 2;
		}
		assertFalse("Sorting Method", 2 == flag);
		assertNotEquals("Sorted Array", expected, actual);	
	}
	
	// Negative Test Case.
	@Test
	public void CountingSortTestCase2() {
		int expected[];
		int flag;
		int array[] = {12, 53, 29, 5, 56, 7, 54, 21, 23, 2, 92, 4};
		int actual[] = {12, 21, 23, 29, 53, 54, 56, 92, 2, 4, 5, 7};
		int max = Main.findMax(array);
		
		if ((max / 100) > 0) {
			expected = LinearSort.radixSort(array, max);
			flag = 1;
		}
		// Else use Counting Sort.
		else {
			expected = LinearSort.countingSort(array, array.length, max, 1, max + 1);
			flag = 2;
		}
		assertFalse("Sorting Method", 1 == flag);
		assertNotEquals("Sorted Array", expected, actual);	
	}
}