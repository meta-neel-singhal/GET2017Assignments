/**
 * Find the greatest common divisor between two numbers. 
 * 
 * @author Neel Singhal
 */
public class GreatestCommonDivisor {

	/**
	 * Calculates greatest common divisor using Euclid's Algorithm.
	 * 
	 * @param  num1    First number.
	 * @param  num2    Second number.
	 * @return gcd     Greatest Common Divisor of num1 and num2.
	 */
	public int calculateGcd (int num1, int num2) {

		int gcd;	
		// Base case for recursion when num2 gets 0. 
		if (num2 == 0) {
			gcd = num1;
		}
		// Recursion of program using Euclid's algorithm.
		else {
			gcd = calculateGcd (num2 , num1 % num2);
		}

		return gcd;
	}
}
