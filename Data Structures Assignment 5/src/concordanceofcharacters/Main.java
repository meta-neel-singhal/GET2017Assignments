package concordanceofcharacters;


/**
 * Helps to find the position of the characters.
 * 
 * @author Neel Singhal
 */
public class Main {

	/**
	 * Find concordance of the characters of the input string.
	 * 
	 * @param args    the arguments containing the input string to find concordance of its characters.
	 */
	public static void main(String args[]) {
		String input = "";
		String output = "";

		// To convert the arguments into a single string.
		for (int index = 0; index < args.length; index++) {
			input += args[index];
		}

		// Display the final input string.
		System.out.println(input);
		// Call the method to find concordance of characters in the string.
		output = Concordance.findConcordance(input);
		// Display the final output string.
		System.out.println(output);
	}
}
