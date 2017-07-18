import static org.junit.Assert.*;

import org.junit.Test;

public class TestRemainder {

	// Object declaration of Remainder class
	Remainder remainderObject = new Remainder();

	// Positive Test Case 1
	@Test
	public void remainderTestCase1() {
		int remainder = remainderObject.calculateRemainder(2, 1);
		// Compares expected and actual values of remainder
		assertEquals(0, remainder);
	}

	// Positive Test Case 2
	@Test
	public void remainderTestCase2() {
		int remainder = remainderObject.calculateRemainder(2, 0);
		String output = "";
		// Checks if divisor is 0.
		if (remainder == -1) {
			output = "The divisor cannot be zero !!!";
		}
		// Compares expected and actual results obtained when divisor = 0
		assertEquals("The divisor cannot be zero !!!", output);
	}

	// Positive Test Case 3
	@Test
	public void remainderTestCase3() {
		int remainder = remainderObject.calculateRemainder(100, 3);
		// Compares expected and actual values of remainder
		assertEquals(1, remainder);
	}

	// Negative Test Case 1
	@Test
	public void remainderTestCase4() {
		int remainder = remainderObject.calculateRemainder(2, 1);
		// Compares expected and actual values of remainder
		assertFalse("It fails", remainder == 2);
	}

	// Negative Test Case 2
	@Test
	public void remainderTestCase5() {
		int remainder = remainderObject.calculateRemainder(2, 0);
		// Compares expected and actual values of remainder
		assertFalse("It fails", remainder == 2);
	}

	// Negitive Test Case 3
	@Test
	public void remainderTestCase6() {
		int remainder = remainderObject.calculateRemainder(100, 3);
		// Compares expected and actual values of remainder
		assertFalse("It fails", remainder == 0);
	}
}
