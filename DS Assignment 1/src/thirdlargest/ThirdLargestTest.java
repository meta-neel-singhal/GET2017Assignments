package thirdlargest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ThirdLargestTest {

	ThirdLargest object = new ThirdLargest();

	// Positive Test Case 1
	@Test
	public void thirdLargestTest1() {
		double[] array = { 22 , 54 , 8 , 9 , 10 , 55, 77 };
		double thirdLargest = object.thirdLargest(array, array.length);
		assertTrue(54 == thirdLargest);
	}

	// Positive Test Case 2
	@Test
	public void thirdLargestTest2() {
		double[] array = { 22.5 , 11.3 , 88.7 , 99.9 , 55.2 , 77.3 };
		double thirdLargest = object.thirdLargest(array, array.length);
		assertTrue(77.3 == thirdLargest);
	}

	// Negative Test Case 1
	@Test
	public void thirdLargestTest3() {
		double[] array = { 22 , 54 , 8 , 9 , 10 , 55, 77 };
		double thirdLargest = object.thirdLargest(array, array.length);
		assertFalse(77 == thirdLargest);
	}

	// Negative Test Case 2
	@Test
	public void thirdLargestTest4() {
		double[] array = { 22.5 , 11.3 , 88.7 , 99.9 , 55.2 , 77.3 };
		double thirdLargest = object.thirdLargest(array, array.length);
		assertFalse(88.7 == thirdLargest);
	}
}
