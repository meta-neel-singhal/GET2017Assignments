package question_2;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;

/**
 * Finds the number of unique characters in a string.
 * 
 * @author Neel Singhal
 */
public class UniqueCharacters {
	// Linked hash map used to cache the input strings.
	public static LinkedHashMap<String, Integer> strings;
	
	/**
	 * Checks the cache memory if the input string is already available else
	 * calculates the total number of unique characters in a string.
	 * 
	 * @param input    The input string.
	 * @return the number of unique characters in a string.
	 */
	public static int uniqueCharacters(String input) {
		Set<Character> characters;
		int output = 0;
		/* 
		 * If the input string is already present in the cache memory 
		 * directly fetches the result.
		 */
		if (strings.containsKey(input)) {
			output = strings.get(input);
		}
		/*
		 * Else calculates the total number of unique characters in the
		 * input string.
		 */
		else {
			characters = new HashSet<Character>();
			// Add every unique character to the set.
			for (int index = 0; index < input.length(); index++) {
				characters.add(input.charAt(index));
			}
			output = characters.size();
			strings.put(input, output);
		}

		return output;
	}
}