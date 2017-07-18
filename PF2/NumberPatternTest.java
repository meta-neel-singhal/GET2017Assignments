import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class NumberPatternTest {

	// Object declaration of NumberPattern class
	NumberPattern pattern = new NumberPattern();

	// Positive test case for numbers function
	@Test
	public void numbersTestCase1() {

		// Current row
		int row = 1;

		// Total no of rows in pattern
		int totalRows = 8;

		// Gets value of numbers string
		String actual = pattern.numbers(row, totalRows);

		// Compares expected and actual values of numbers string
		assertEquals("12345678", actual);
	}

	// Positive test case for spaces function
	@Test
	public void spacesTestCase1() {

		// Current row
		int row = 5;

		// Gets value of spaces string
		String actual = pattern.spaces(row);

		// Compares expected and actual values of spaces string
		assertEquals("    ", actual);
	}

	// Positive test case for printWholePattern function
	@Test
	public void wholePatternTestCase1() {

		// Total no of rows in pattern
		int totalRows = 5;

		// Expected pattern as array of strings
		String[] expected = { "12345", " 1234", "  123", "   12", "    1" };

		// Gets value of final pattern
		String[] actual = pattern.printWholePattern(totalRows);

		// Compares expected and actual values of final pattern
		assertArrayEquals(expected, actual);
	}

	// Negative test case for numbers function
	@Test
	public void numbersTestCase2() {

		// Current row
		int row = 1;

		// Total no of rows in pattern
		int totalRows = 8;

		// Gets value of numbers string
		String actual = pattern.numbers(row, totalRows);

		// Compares expected and actual values of numbers string
		assertEquals("1234578", actual);
	}

	// Negative test case for spaces function
	@Test
	public void spacesTestCase2() {

		// Current row
		int row = 5;

		// Gets value of spaces string
		String actual = pattern.spaces(row);

		// Compares expected and actual values of spaces string
		assertEquals("     ", actual);
	}

	// Negative test case for printWholePattern function
	@Test
	public void wholePatternTestCase2() {

		// Total no of rows in pattern
		int totalRows = 5;

		// Expected pattern as array of strings
		String[] expected = { "12345", " 1234", "  123", "   12", "    1", "" };

		// Gets value of final pattern
		String[] actual = pattern.printWholePattern(totalRows);

		// Compares expected and actual values of final pattern
		assertArrayEquals(expected, actual);
	}
}
