import static org.junit.Assert.*;

import org.junit.Test;

public class BinarySearchTest {

	// Object declaration of BinarySearch class
	BinarySearch searchObject = new BinarySearch();

	// Positive Test Case 1
	@Test
	public void BinarySearchTest1() {
		int[] array = { 2 , 5 , 8 , 9 , 10 , 55, 77 }; // Array to be searched.
		int lowerBound = 0; // Lower bound of the array.
		int upperBound = array.length - 1;  // Upper bound of the array
		int element = 88; // Element to be searched.
		// Finding location of element.
		int locationOfElement = searchObject.findElement(array, lowerBound, upperBound, element) ;
		// Compares expected and actual values of the location of element.
		assertEquals(0, locationOfElement);
	}

	// Positive Test Case 2
	@Test
	public void BinarySearchTest2() {
		int[] array = { 2 , 5 , 8 , 9 , 10 , 55, 77 }; // Array to be searched.
		int lowerBound = 0; // Lower bound of the array.
		int upperBound = array.length - 1;  // Upper bound of the array
		int element = 77; // Element to be searched.
		// Finding location of element.
		int locationOfElement = searchObject.findElement(array, lowerBound, upperBound, element) ;
		// Compares expected and actual values of the location of element.
		assertEquals(7, locationOfElement);
	}

	// Negative Test Case 1
	@Test
	public void BinarySearchTest3() {
		int[] array = { 2 , 5 , 8 , 9 , 10 , 55, 77 }; // Array to be searched.
		int lowerBound = 0; // Lower bound of the array.
		int upperBound = array.length - 1;  // Upper bound of the array
		int element = 88; // Element to be searched.
		// Finding location of element.
		int locationOfElement = searchObject.findElement(array, lowerBound, upperBound, element) ;
		// Compares expected and actual values of the location of element.
		assertFalse("It fails", locationOfElement == 7);
	}

	// Negative Test Case 2
	@Test
	public void BinarySearchTest4() {
		int[] array = { 2 , 5 , 8 , 9 , 10 , 55, 77 }; // Array to be searched.
		int lowerBound = 0; // Lower bound of the array.
		int upperBound = array.length - 1;  // Upper bound of the array
		int element = 77; // Element to be searched.
		// Finding location of element.
		int locationOfElement = searchObject.findElement(array, lowerBound, upperBound, element) ;
		// Compares expected and actual values of the location of element.
		assertFalse("It fails", locationOfElement == 4);
	}
}
