import static org.junit.Assert.*;
import org.junit.Test;

public class QuickSortTest {

	// Object declaration of QuickSort class
	QuickSort sort = new QuickSort();

	// Positive test case 1
	@Test
	public void QuickSortTest1() {
		int[] array = { 2, 5, 8, 9, 10, 77, 55, 11 }; // Array to be searched.
		int[] expected = { 2, 5, 8, 9, 10, 11, 55, 77 }; // Expected result.
		int leftPointer = 0; // Left pointer of the array.
		int rightPointer = array.length - 1; // Right pointer of the array.
		// Sorting the array.
		int[] sortedArray = sort.quickSort(array, leftPointer, rightPointer);
		// Compares expected and actual sorted arrays.
		assertArrayEquals(expected, sortedArray);
	}

	// Positive test case 2
	@Test
	public void QuickSortTest2() {
		int[] array = {}; // Array to be searched.
		int[] expected = {}; // Expected result.
		int leftPointer = 0; // Left pointer of the array.
		int rightPointer = array.length - 1; // Right pointer of the array.
		// Sorting the array.
		int[] sortedArray = sort.quickSort(array, leftPointer, rightPointer);
		// Compares expected and actual sorted arrays.
		assertArrayEquals(expected, sortedArray);
	}

	// Negative test case 1
	@Test
	public void QuickSortTest3() {
		int[] array = { 2, 5, 8, 9, 10, 77, 55, 11 }; // Array to be searched.
		int[] expected = { 2, 5, 8, 9, 10, 11, 55 }; // Expected result.
		int leftPointer = 0; // Left pointer of the array.
		int rightPointer = array.length - 1; // Right pointer of the array.
		// Sorting the array.
		int[] sortedArray = sort.quickSort(array, leftPointer, rightPointer);
		// Compares expected and actual sorted arrays.
		assertArrayEquals(expected, sortedArray);
	}

	// Negative test case 2
	@Test
	public void QuickSortTest4() {
		int[] array = {}; // Array to be searched.
		int[] expected = {0}; // Expected result.
		int leftPointer = 0; // Left pointer of the array.
		int rightPointer = array.length - 1; // Right pointer of the array.
		// Sorting the array.
		int[] sortedArray = sort.quickSort(array, leftPointer, rightPointer);
		// Compares expected and actual sorted arrays.
		assertArrayEquals(expected, sortedArray);
	}
}
