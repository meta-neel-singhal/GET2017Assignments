/**
 * Finds the largest digit of a number.
 * 
 * @author Neel Singhal
 */
public class LargestDigitOfNumber {

	/**
	 * Calculates largest digit of a number using recursive function
	 * and comparing two digits recursively to get the largest number.
	 * 
	 * @param number    Number in which largest digit is to be found.
	 * @return largestDigit    Largest digit of the number.
	 */
	public int findLargestDigit(int number) {
		// Base case of recursion.
		if(number == 0) {
			return 0;
		}
		// Initialized with unit's digit.
		int largestDigit = number % 10; 
		// To get another digtit to compare with largestDigit.
		int checklargest = findLargestDigit(number / 10);
		// Compares two digits of a number recursively to find the largest digit.
		if(checklargest > largestDigit) {
			largestDigit = checklargest;
		}
		return largestDigit;
	}
}
