import static org.junit.Assert.*;

import org.junit.Test;

public class GreatestCommonDivisorTest {

	// Object declaration of GreatestCommonDivisor class
	GreatestCommonDivisor gcdObject = new GreatestCommonDivisor();

	// Positive Test Case 1
	@Test
	public void gcdTestCase1() {
		int gcd = gcdObject.calculateGcd(2, 1);
		// Compares expected and actual values of remainder
		assertEquals(1, gcd);
	}

	// Positive Test Case 2
	@Test
	public void gcdTestCase2() {
		int gcd = gcdObject.calculateGcd(12, 18);
		// Compares expected and actual values of remainder
		assertEquals(6, gcd);
	}

	// Positive Test Case 3
	@Test
	public void gcdTestCase3() {
		int gcd = gcdObject.calculateGcd(100, 3);
		// Compares expected and actual values of remainder
		assertEquals(1, gcd);
	}

	// Negative Test Case 1
	@Test
	public void gcdTestCase4() {
		int gcd = gcdObject.calculateGcd(2, 1);
		// Compares expected and actual values of remainder
		assertFalse("It fails", gcd == 2);
	}

	// Negative Test Case 2
	@Test
	public void gcdTestCase5() {
		int gcd = gcdObject.calculateGcd(12, 18);
		// Compares expected and actual values of remainder
		assertFalse("It fails", gcd == 18);
	}

	// Negative Test Case 3
	@Test
	public void gcdTestCase6() {
		int gcd = gcdObject.calculateGcd(100, 3);
		// Compares expected and actual values of remainder
		assertFalse("It fails", gcd == 0);
	}
}
