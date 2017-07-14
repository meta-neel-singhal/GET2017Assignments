/**
 * Convert a binary number to an octal number.
 * @author Neel
 */
public class ConvertBinaryToOctal {
	/**
	 * Converts binary number by taking pairs of 3 digits and then
	 * converting them to it their respective octal values using switch case statements.
	 * @param n which is the binary number
	 * @return octal value of given binary number
	 */

	public int convertBinaryToOctal(int n) {

		int triad; // Stores the pair of 3 digits of given binary number.
		int flag = 0; // Contains octal value of the triad.
		int octal = 0; // Final octal value of the binary number.
		int count = 1; // Places the octal value at unit's place, ten's place and so on.
		/*
		 * Goes on until all the possible triads are converted
		 * to their respective octal values. 
		 */
		while (n > 0) {
			triad = n % 1000;
			n /= 1000;

			//Convert all the triads to their respective octal values.
			switch (triad) {
			case 0: flag = 0;
			break;
			case 1: flag = 1;
			break;
			case 10: flag = 2;
			break;
			case 11: flag = 3;
			break;
			case 100: flag = 4;
			break;
			case 101: flag = 5;
			break;
			case 110: flag = 6;
			break;
			case 111: flag = 7;
			break;
			default: flag = 8; // Used if number is not binary.
			break;
			}
			// Runs only if number is a binary number.
			if (flag != 8) {
				octal += flag * count;
				count *= 10;
			}
			// Runs if number is not a binary number.
			else{
				octal = 8; // 8 is used because it can never be in octal number.
			}
		}
		return octal; // returns the final octal value
	}
}