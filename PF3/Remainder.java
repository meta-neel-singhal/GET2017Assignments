/**
 * Find the remainder when a number (dividend) is divided by 
 * another number (divisor). 
 * 
 * @author Neel Singhal
 */
public class Remainder {

	/**
	 * Calculates the remainder when the dividend is divided by
	 * the divisor.
	 * 
	 * @param  dividend    the number which is divided by divisor.
	 * @param  divisor     the number by which dividend is divided.
	 * @return remainder   when dividend is divided by divisor.
	 */
	public int calculateRemainder(int dividend, int divisor) {
		
		/**
		 * Calculates remainder using recursion by checking if divisor is not 0
		 * and the final remainder is not obtained.
		 */
		if(dividend >= divisor && divisor != 0) {
			dividend = calculateRemainder(dividend - divisor, divisor);
		}		
		else if (divisor == 0) {
			dividend = -1; 
		}
		
		return dividend;
	}
}
