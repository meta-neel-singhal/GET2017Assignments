import static org.junit.Assert.*;

import org.junit.Test;

public class LinearSearchTest {

	// Object declaration of LinearSearch class
	LinearSearch searchObject = new LinearSearch();

	// Positive Test Case 1
	@Test
	public void LinearSearchTest1() {
		int[] array = { 2, 5, 8, 9, 10, 77, 55 }; // array to be searched.
		int size = array.length; // size of array.
		int element = 88; // element to be searched.
		int initialLocation = 1; // location to start searching.
		// Finding location of element.
		int locationOfElement = searchObject.findElement(array, size, element,
				initialLocation);
		// Compares expected and actual values of the location of element.
		assertEquals(0, locationOfElement);
	}

	// Positive Test Case 2
	@Test
	public void LinearSearchTest2() {
		int[] array = { 2, 5, 8, 9, 10, 77, 55, 11 }; // array to be searched.
		int size = array.length; // size of array.
		int element = 77; // element to be searched.
		int initialLocation = 1; // location to start searching.
		// Finding location of element.
		int locationOfElement = searchObject.findElement(array, size, element,
				initialLocation);
		// Compares expected and actual values of the location of element.
		assertEquals(6, locationOfElement);
	}

	// Negative Test Case 1
	@Test
	public void LinearSearchTest3() {
		int[] array = { 2, 5, 8, 9, 10, 77, 55 }; // array to be searched.
		int size = array.length; // size of array.
		int element = 88; // element to be searched.
		int initialLocation = 1; // location to start searching.
		// Finding location of element.
		int locationOfElement = searchObject.findElement(array, size, element,
				initialLocation);
		// Compares expected and actual values of the location of element.
		assertFalse("It fails", locationOfElement == 8);
	}

	// Negative Test Case 2
	@Test
	public void LinearSearchTest4() {
		int[] array = { 2, 5, 8, 9, 10, 77, 55, 11 }; // array to be searched.
		int size = array.length; // size of array.
		int element = 77; // element to be searched.
		int initialLocation = 1; // location to start searching.
		// Finding location of element.
		int locationOfElement = searchObject.findElement(array, size, element,
				initialLocation);
		// Compares expected and actual values of the location of element.
		assertFalse("It fails", locationOfElement == 7);
	}
}
