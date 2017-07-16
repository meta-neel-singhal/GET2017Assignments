import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class NumberPyramidTest {

	// Object declaration of NumberPyramid class
	NumberPyramid pyramid = new NumberPyramid();

	// Positive test case for numbers function
	@Test
	public void spacesTestCase1() {

		int row = 8; // Current row
		int totalRows = 11; // Total no of rows in pattern

		// Gets value of numbers string
		String actual = pyramid.numbers(row, totalRows);

		// Compares expected and actual values of numbers string
		assertEquals("1234321", actual);
	}

	// Positive test case for spaces function
	@Test
	public void numbersTestCase1() {

		int row = 11; // Current row
		int totalRows = 11; // Total no of rows in pattern

		// Gets value of spaces string
		String actual = pyramid.spaces(row, totalRows);

		// Compares expected and actual values of spaces string
		assertEquals("     ", actual);
	}

	// Positive test case for printWholePyramid function
	@Test
	public void wholePyramidTestCase1() {

		int totalRows = 5; // Total no of rows in pattern

		// Expected pattern as array of strings
		String[] expected = { "  1  ", " 121 ", "12321", " 121 ", "  1  " };

		// Gets value of final pattern
		String[] actual = pyramid.printWholePyramid(totalRows);

		// Compares expected and actual values of final pyramid
		assertArrayEquals(expected, actual);
	}

	// Negative test case for numbers function
	@Test
	public void spacesTestCase2() {

		int row = 8; // Current row
		int totalRows = 11; // Total no of rows in pattern

		// Gets value of numbers string
		String actual = pyramid.numbers(row, totalRows);

		// Compares expected and actual values of numbers string
		assertEquals("123321", actual);
	}

	// Negative test case for spaces function
	@Test
	public void numbersTestCase2() {

		int row = 11; // Current row
		int totalRows = 11; // Total no of rows in pattern

		// Gets value of spaces string
		String actual = pyramid.spaces(row, totalRows);

		// Compares expected and actual values of spaces string
		assertEquals("    ", actual);
	}

	// Negative test case for printWholePyramid function
	@Test
	public void wholePyramidTestCase2() {

		int totalRows = 5; // Total no of rows in pattern

		// Expected pattern as array of strings
		String[] expected = { "  1  ", " 121 ", "1221", " 121 ", "  1  " };

		// Gets value of final pattern
		String[] actual = pyramid.printWholePyramid(totalRows);

		// Compares expected and actual values of final pyramid
		assertArrayEquals(expected, actual);
	}
}
