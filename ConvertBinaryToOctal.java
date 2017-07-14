/**
 * This program is to convert a binary number to an octal number.
 * @author Neel
 * 
 */
public class ConvertBinaryToOctal {
	/**
	 * This function converts binary number by taking pairs of 3 digits and then
	 * converting them to it their respective octal values using switch case statements.
	 * @param n
	 * @return octal value
	 */

	public int convertBinaryToOctal(int n) {

		int triad; // This variable stores the pair of 3 digits of given binary number.
		int flag = 0; // This variable contains octal value of the triad.
		int octal = 0; // This variable is the final octal value of the binary number.
		int count = 1; // This variable places the octal value at unit's place, ten's place and so on.
		/*
		 * This loop goes on until all the possible triads are converted
		 * to their respective octal values. 
		 */
		while (n > 0) {
			triad = n % 1000;
			n /= 1000;

			//These statements convert all the triads to their respective octal values.
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
			default: flag = 8; // This flag used if number is not binary.
			break;
			}
			// It runs only if number is a binary number.
			if (flag != 8) {
				octal += flag * count;
				count *= 10;
			}
			// It runs if number is not a binary number.
			else{
				octal = 8; // 8 is used because it can never be in octal number.
			}
		}
		return octal;
	}
}