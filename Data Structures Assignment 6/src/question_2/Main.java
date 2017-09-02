package question_2;

import java.util.LinkedHashMap;
import java.util.Scanner;

/**
 * The Main class.
 * 
 * @author Neel Singhal
 */
public class Main {
	// Globally declared scanner.
	static Scanner scan;

	/**
	 * Main method to invoke the uniqueCharacters methods.
	 *  
	 * @param args    the arguments.
	 */
	public static void main(String[] args) {
		String input;
		UniqueCharacters.strings = new LinkedHashMap<String, Integer>();
		scan = new Scanner(System.in);

		System.out.println("Enter the string : ");
		input = scan.next();
		// Run until user wants to continue.
		do {
			// Displays the number of unique characters in the input string.
			System.out.println(UniqueCharacters.uniqueCharacters(input));
			System.out.println("Press Y to continue : ");
		} while (scan.next().equalsIgnoreCase("y"));
	}
}