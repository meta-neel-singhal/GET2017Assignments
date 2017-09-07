package concordanceofcharacters;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class to find the concordance of characters in a string.
 * 
 * @author Neel Singhal
 */
public class Concordance {
	/**
	 * Find concordance of characters in the input string.
	 * 
	 * @param input    Input string.
	 * @return output string containing concordance of characters.
	 */
	public static String findConcordance(String input) {
		int index;
		String output = "";
		ArrayList<Integer> position;
		HashMap<Character, ArrayList<Integer>> concordance = new HashMap<Character, ArrayList<Integer>>();
		
		// Make concordance map for each character in the string.
		for (index = 0; index < input.length(); index++) {
			// If the character is already present in the map get its present array list.
			// Add the next index value of the character in it.
			if (concordance.containsKey(input.charAt(index))) {
				position = concordance.get(input.charAt(index));
			}
			// Else add the index value of the character in the new array list.
			else {
				position = new ArrayList<Integer>();
			}
			position.add(index);
			concordance.put(input.charAt(index), position);
		}

		// Display the concordance of characters.
		for (char value : concordance.keySet()) {
			output += value + ": " + concordance.get(value) + "  ";
		}
		
		return output;
	}
}
