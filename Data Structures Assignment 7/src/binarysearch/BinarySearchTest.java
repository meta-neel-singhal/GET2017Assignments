package binarysearch;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class BinarySearchTest {

	// Object declaration of BinarySearch class
	BinarySearch searchObject = new BinarySearch();

	// Positive Test Case 1
	@Test
	public void BinarySearchTest1() {
		int[] array = { 2 , 5 , 5 , 5 , 10 , 55, 77 };
		int lowerBound = 0;
		int upperBound = array.length - 1;
		int element = 88;
		int locationOfElement = searchObject.findElement(array, lowerBound, upperBound, element) ;
		assertEquals(-1, locationOfElement);
	}

	// Positive Test Case 2
	@Test
	public void BinarySearchTest2() {
		int[] array = { 2 , 5 , 5 , 5 , 10 , 55, 77 };
		int lowerBound = 0;
		int upperBound = array.length - 1;
		int element = 5;
		int locationOfElement = searchObject.findElement(array, lowerBound, upperBound, element) ;
		assertEquals(1, locationOfElement);
	}

	// Positive Test Case 3
	@Test
	public void BinarySearchTest3() {
		int[] array = { -4, -4, -2, -2, 0, 6, 6 };
		int lowerBound = 0;
		int upperBound = array.length - 1;
		int element = -4;
		int locationOfElement = searchObject.findElement(array, lowerBound, upperBound, element) ;
		assertEquals(0, locationOfElement);
	}
		
	// Negative Test Case 1
	@Test
	public void BinarySearchTest4() {
		int[] array = { 2 , 5 , 8 , 9 , 10 , 55, 77 };
		int lowerBound = 0;
		int upperBound = array.length - 1;
		int element = 88;
		int locationOfElement = searchObject.findElement(array, lowerBound, upperBound, element) ;
		assertFalse(locationOfElement == 0);
	}

	// Negative Test Case 2
	@Test
	public void BinarySearchTest5() {
		int[] array = { 2 , 5 , 77 , 77 , 77 , 77, 77 };
		int lowerBound = 0;
		int upperBound = array.length - 1;
		int element = 77;
		int locationOfElement = searchObject.findElement(array, lowerBound, upperBound, element) ;
		assertFalse(locationOfElement == 6);
	}

	// Negative Test Case 3
	@Test
	public void BinarySearchTest6() {
		int[] array = { -4, -4, -2, -2, 0, 6, 6 };
		int lowerBound = 0;
		int upperBound = array.length - 1;
		int element = 0;
		int locationOfElement = searchObject.findElement(array, lowerBound, upperBound, element) ;
		assertFalse(locationOfElement == -1);
	}
}