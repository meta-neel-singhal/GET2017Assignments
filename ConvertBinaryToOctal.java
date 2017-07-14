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
		int count = 1; // This variable is used for placing the octal value at unit's place, ten's place and so on.
		
		while (n > 0){
			triad = n % 1000;
			n /= 1000;
			
			switch (triad){
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
			default: flag = 8;
				break;
			}
			if(flag!=8){
				octal += flag * count;
				count *= 10;
			}
			else{
				octal = 8;
			}
		}
		return octal;
}
}