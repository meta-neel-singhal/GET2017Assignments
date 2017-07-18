/**
 * Generates a pyramid of numbers like below using modular approach.
 *    1   
 *   121  
 *  12321
 * 1234321
 *  12321
 *   121
 *    1
 * Assume that total no. of rows provided are always in odd number as to get
 * a perfect pyramid.  
 *  
 * @author Neel Singhal
 */
public class NumberPyramid {

	/**
	 * Generates the spaces string. Uses the numbers function to calculate
	 * length of numbers string and thus calculates the no. of spaces by
	 * subtracting it from total no. of rows and dividing it by 2 as the number
	 * string will be in the center and surrounded by the spaces string.
	 * 
	 * @param row          current row
	 * @param totalRows    total no. of rows in the pattern
	 * @return spaces      required spaces string
	 */
	public String spaces(int row, int totalRows) {

		// length of the numbers string
		int numberSize = numbers(row, totalRows).length();

		// total no. of spaces
		int spaces = (totalRows - numberSize) / 2;

		String totalSpaces = ""; //Required spaces string

		/*
		 * Generates the spaces string according to the no. of spaces
		 * calculated.
		 */
		for (int count = 1; count <= spaces; count++) {
			totalSpaces = totalSpaces + " ";
		}

		return totalSpaces;  // Returns spaces string

	}

	/**
	 * Generates the numbers string for particular row by using current row
	 * no. and the total no. of rows.
	 * 
	 * @param row          current row
	 * @param totalRows    total no. of rows in the pattern
	 * @return sequence	   required number string
	 */
	public String numbers(int row, int totalRows) {

		String sequence = ""; // Required numbers string

		/*
		 * Runs if no. of row is less then or equal to half of the no.
		 * of total rows in pyramid and makes up the sequence.
		 */
		if (row <= (totalRows + 1) / 2) {

			// Generates first half of sequence in ascending order.
			for (int count = 1; count <= row; count++) {

				sequence = sequence + String.valueOf(count);

			}

			// Generates other half of sequence in descending order.
			for (int count = (row - 1); count >= 1; count--) {

				sequence = sequence + String.valueOf(count);

			}

		}

		/*
		 * Runs if no. of row is more then half of the no. of total rows in
		 * pyramid and makes up the sequence by getting a new row no. and
		 * then recursively calling the numbers function.
		 */
		else {

			int newrow = totalRows - row + 1; // To get the new row no.

			// Recursively calling numbers function with new row no.
			sequence = numbers(newrow, totalRows); 

		}

		return sequence; // Returns numbers string

	}

	/**
	 * Generates the whole pyramid of numbers by repeatedly calling spaces
	 * then numbers and then again spaces functions to get desired  pyramid
	 * pattern.
	 * 
	 * @param totalRows    total no. of rows in the pyramid
	 * @return output      whole pyramid of numbers
	 */
	public String[] printWholePyramid(int totalRows) {

		// Array containing the final pattern
		String[] output = new String[totalRows];

		/*
		 * Fills the string array by combining spaces and numbers
		 * to get the desired pattern. 
		 */
		for (int row = 1; row <= totalRows; row++) {

			int index = row - 1; // index value for final array

			output[index] = spaces(row, totalRows) + numbers(row, totalRows)
					+ spaces(row, totalRows);

		}

		return output; // Returns the final pattern

	}

}
