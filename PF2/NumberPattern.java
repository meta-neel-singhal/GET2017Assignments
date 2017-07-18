/**
 * Generates a pattern of numbers like shown below using modular approach.
 * 12345
 *  1234
 *   123
 *    12
 *     1
 *     
 * @author Neel Singhal
 */
public class NumberPattern {

	/**
	 * Generates the spaces string. The no. of spaces will always be 1 less than
	 * the no. of current row.
	 * 
	 * @param row        current row
	 * @return spaces    required spaces string
	 */
	public String spaces(int row) {

		int spaces = row - 1;
		String totalSpaces = ""; // Required spaces string

		/*
		 * Generates the spaces string according to the no. of spaces
		 * calculated.
		 */
		for (int count = 1; count <= spaces; count++) {

			totalSpaces = totalSpaces + " ";
		}

		return totalSpaces; // Returns spaces string

	}

	/**
	 * Generates the numbers string for particular row by using the current row
	 * no. and the total no. of rows.
	 * 
	 * @param row          current row
	 * @param totalRows    total no. of rows in the pattern
	 * @return sequence	   required number string
	 */
	public String numbers(int row, int totalRows) {

		String sequence = ""; // Required numbers string

		/*
		 * Generates number string by counting from 1 to (totalRows - row + 1)
		 * because the numbers string is decreasing with the increasing row
		 * count.
		 */
		for (int count = 1; count <= (totalRows - row + 1); count++) {

			sequence = sequence + String.valueOf(count);
		}

		return sequence; // Returns numbers string

	}

	/**
	 * Generates the whole pattern of numbers by repeatedly calling spaces
	 * and numbers functions.
	 * 
	 * @param totalRows    total no. of rows in the pattern
	 * @return output      whole pattern of numbers
	 */
	public String[] printWholePattern(int totalRows) {

		// Array containing the final pattern
		String[] output = new String[totalRows]; 

		/*
		 * Fills the string array by combining spaces and numbers
		 * to get the desired pattern. 
		 */
		for (int row = 1; row <= totalRows; row++) {

			int index = row - 1; // index value for final array

			output[index] = spaces(row) + numbers(row, totalRows);

		}
		return output; // Returns the final pattern
	}
}
