import static org.junit.Assert.*;

import org.junit.Test;

public class TestLargestDigitOfNumber {

	// Object declaration of LargestDigitOfNumber class
	LargestDigitOfNumber largestDigitObject = new LargestDigitOfNumber();

	// Positive Test Case 1
	@Test
	public void LargestDigitOfNumberTest1() {
		int largestDigit = largestDigitObject.findLargestDigit(2);
		// Compares expected and actual largest digit of the number.
		assertEquals(2, largestDigit);
	}

	// Positive Test Case 2
	@Test
	public void LargestDigitOfNumberTest2() {
		int largestDigit = largestDigitObject.findLargestDigit(1257369);
		// Compares expected and actual largest digit of the number.
		assertEquals(9, largestDigit);
	}

	// Positive Test Case 3
	@Test
	public void LargestDigitOfNumberTest3() {
		int largestDigit = largestDigitObject.findLargestDigit(444);
		// Compares expected and actual largest digit of the number.
		assertEquals(4, largestDigit);
	}

	// Negative Test Case 1
	@Test
	public void LargestDigitOfNumberTest4() {
		int largestDigit = largestDigitObject.findLargestDigit(2);
		// Compares expected and actual largest digit of the number.
		//assertEquals(5, largestDigit);
		assertFalse("It fails", largestDigit == 0);
	}
	
	// Negative Test Case 2
	@Test
	public void LargestDigitOfNumberTest5() {
		int largestDigit = largestDigitObject.findLargestDigit(1257369);
		// Compares expected and actual largest digit of the number.
		//assertEquals(5, largestDigit);
		assertFalse("It fails", largestDigit == 1);
	}
	
	// Negative Test Case 3
	@Test
	public void LargestDigitOfNumberTest6() {
		int largestDigit = largestDigitObject.findLargestDigit(444);
		// Compares expected and actual largest digit of the number.
		//assertEquals(5, largestDigit);
		assertFalse("It fails", largestDigit == 5);
	}
}
