/**
 * Display the application variables such as the operands, operations
 * to be performed and the result.
 * 
 * @author Neel Singhal
 */
public class Display {
	private String outputString = "";

	/**
	 * Runs if it is a operator.
	 * 
	 * @param value
	 */
	public Display(char value){
		// Check the value and append to previous value in outputString
		outputString += value;
		// Until operator equals to ('=') is pressed.
		outputString = String.valueOf(value);

	}

	/**
	 * Runs if it is a operand.
	 * 
	 * @param value 
	 */
	public Display(Double value){
		outputString = value.toString();
	}

}
