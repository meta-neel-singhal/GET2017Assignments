import java.util.ArrayList;
import java.util.List;

/**
 * Finds all the possible permutations of a string.
 * 
 * @author Neel Singhal
 */
public class PermutationsOfString {
	/*
	 * Global list of string type is defined so as to fix the changes
	 * done in the list.
	 */
	List<String> possiblePermutations = new ArrayList<String>();

	/**
	 * Finds low index and upper index value for the string and 
	 * sends the control to the overloaded function.
	 * 
	 * @param inputString    the string to be permuted.
	 * @return List received from the overloaded function.
	 */
	List<String> generatePermutations(String inputString) {

		return generatePermutations(inputString, 0, inputString.length() - 1);
	}

	/**
	 * Generates all possible permutations. Initially check the list for the prior
	 * occurrence of the permuted string. If the string is not already present in
	 * the list then it is added to the list. And the loop generates the permutations
	 * by taking the initial to the final index of the string. It then recursively
	 * swaps the characters at iterationIndex and lowIndex and generates permuted 
	 * string. 
	 *
	 * @param inputString    the string to be permuted.
	 * @param lowIndex       index value of first character.
	 * @param highIndex      index value of last character.
	 * @return ArrayList<String> containing all the possible permutations of the input string.
	 */
	List<String> generatePermutations(String inputString, int lowIndex, int highIndex) {
		if (!possiblePermutations.contains(inputString)) {
			possiblePermutations.add(inputString);
		}

		for (int iterationIndex = lowIndex; iterationIndex <= highIndex; iterationIndex++) {
			inputString = swap(inputString, iterationIndex, lowIndex);
			generatePermutations(inputString, lowIndex + 1, highIndex);
			inputString = swap(inputString, iterationIndex, lowIndex); // Backtrack to original string.
		}

		return possiblePermutations;
	}

	/**
	 * Receive the string and indices of the characters to be swapped. 
	 * Converts the string into a character array for swapping the particular
	 * characters. After swapping the characters returns the string. 
	 * 
	 * 
	 * @param inputString    the string to be permuted.
	 * @param firstIndex     index value of first character.
	 * @param secondIndex    index value of second character.
	 * @return String after swapping the desired characters.
	 */
	public String swap(String inputString, int firstIndex, int secondIndex) {
		char[] characterArray = inputString.toCharArray();
		char temp = characterArray[firstIndex];
		characterArray[firstIndex] = characterArray[secondIndex];
		characterArray[secondIndex] = temp;

		return String.valueOf(characterArray);
	}
}
