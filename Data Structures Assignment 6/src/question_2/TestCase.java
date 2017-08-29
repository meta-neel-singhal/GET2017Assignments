package question_2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import java.util.LinkedHashMap;
import org.junit.Before;
import org.junit.Test;

public class TestCase {

	// Initialize LinkedHashMap.
	@Before
	public void init() {
		UniqueCharacters.strings = new LinkedHashMap<String, Integer>();
	}

	// Positive Test Case.
	@Test
	public void uniqueCharactersTestCase1() {
		int output = UniqueCharacters.uniqueCharacters("asdsadasdasdasd");
		assertEquals(output, 3);
	}

	// Positive Test Case.
	@Test
	public void uniqueCharactersTestCase2() {
		int output = UniqueCharacters.uniqueCharacters("asd asd asd");
		assertEquals(output, 4);
	}

	// Negative Test case.
	@Test
	public void uniqueCharactersTestCase3() {
		int output = UniqueCharacters.uniqueCharacters("asdsadasdasdasd");
		assertNotEquals(output, 15);
	}

	// Negative Test case.
	@Test
	public void uniqueCharactersTestCase4() {
		int output = UniqueCharacters.uniqueCharacters("asd asd asd");
		assertNotEquals(output, 11);
	}
}