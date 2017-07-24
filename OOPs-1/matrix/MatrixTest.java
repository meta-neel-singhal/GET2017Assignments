import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotEquals;

public class MatrixTest {

	// Positive Test Case for addElements.
	@Test
	public void addElementsTestCase1() {
		Matrix newMatrix = new Matrix(3, 3);
		newMatrix.addElements(0, 0, 1);
		newMatrix.addElements(0, 1, 2);
		newMatrix.addElements(1, 1, 3);
		newMatrix.addElements(1, 2, 3);
		newMatrix.addElements(2, 1, 1);
		newMatrix.addElements(2, 2, 2);
		int expected[][] = { { 1, 2, 0 }, { 0, 3, 3 }, { 0, 1, 2 } };
		assertArrayEquals(expected, newMatrix.getData());
	}

	// Positive Test Case for transpose.
	@Test
	public void transposeTestCase1() {
		Matrix newMatrix = new Matrix(4, 3);
		newMatrix.addElements(0, 0, 1);
		newMatrix.addElements(0, 1, 2);
		newMatrix.addElements(1, 1, 3);
		newMatrix.addElements(1, 2, 3);
		newMatrix.addElements(2, 1, 1);
		newMatrix.addElements(2, 2, 2);
		newMatrix.addElements(3, 0, 1);
		newMatrix.addElements(3, 1, 2);
		newMatrix.addElements(3, 2, 3);
		int expected[][] = { { 1, 0, 0, 1 }, { 2, 3, 1, 2 }, { 0, 3, 2, 3 } };
		Matrix transposedMatrix = newMatrix.transpose();
		assertArrayEquals(expected, transposedMatrix.getData());
	}

	// Positive Test Case for show.
	@Test
	public void showTestCase1() {
		Matrix newMatrix = new Matrix(3, 3);
		newMatrix.addElements(0, 0, 1);
		newMatrix.addElements(0, 1, 2);
		newMatrix.addElements(1, 1, 3);
		newMatrix.addElements(1, 2, 3);
		newMatrix.addElements(2, 1, 1);
		newMatrix.addElements(2, 2, 2);
		String expected = "1 2 0 \n0 3 3 \n0 1 2 \n";
		assertEquals(expected, newMatrix.show());
	}

	// Positive Test Case for multiplication.
	@Test
	public void multiplicationTestCase1() {
		Matrix firstMatrix = new Matrix(2, 3);
		firstMatrix.addElements(0, 0, 1);
		firstMatrix.addElements(0, 1, 2);
		firstMatrix.addElements(0, 2, 3);
		firstMatrix.addElements(1, 0, 4);
		firstMatrix.addElements(1, 1, 5);
		firstMatrix.addElements(1, 2, 6);

		Matrix 	secondMatrix = new Matrix(3, 2);
		secondMatrix.addElements(0, 0, 1);
		secondMatrix.addElements(0, 1, 2);
		secondMatrix.addElements(1, 0, 3);
		secondMatrix.addElements(1, 1, 4);
		secondMatrix.addElements(2, 0, 5);
		secondMatrix.addElements(2, 1, 6);

		Matrix actual = firstMatrix.multiplication(secondMatrix);
		int expected[][] = { { 22, 28 }, { 49, 64 } };
		assertArrayEquals(expected, actual.getData());
	}

	// Negative Test Case for addElements.
	@Test
	public void addElementsTestCase2() {
		Matrix newMatrix = new Matrix(3, 3);
		newMatrix.addElements(0, 0, 1);
		newMatrix.addElements(0, 1, 2);
		newMatrix.addElements(1, 1, 3);
		newMatrix.addElements(1, 2, 3);
		newMatrix.addElements(2, 1, 1);
		newMatrix.addElements(2, 2, 2);
		int expected[][] = { { 1, 2, 0 }, { 0, 3, 3 }, { 0, 1, 0 } };
		assertNotEquals(expected, newMatrix.getData());
	}

	// Negative Test Case for transpose.
	@Test
	public void transposeTestCase2() {
		Matrix newMatrix = new Matrix(4, 3);
		newMatrix.addElements(0, 0, 1);
		newMatrix.addElements(0, 1, 2);
		newMatrix.addElements(1, 1, 3);
		newMatrix.addElements(1, 2, 3);
		newMatrix.addElements(2, 1, 1);
		newMatrix.addElements(2, 2, 2);
		newMatrix.addElements(3, 0, 1);
		newMatrix.addElements(3, 1, 2);
		newMatrix.addElements(3, 2, 3);
		int expected[][] = { { 1, 0, 0, 1 }, { 2, 3, 1, 2 }, { 0, 0, 0, 0 } };
		Matrix transposedMatrix = newMatrix.transpose();
		assertNotEquals(expected, transposedMatrix.getData());
	}

	// Negative Test Case for show.
	@Test
	public void showTestCase2() {
		Matrix newMatrix = new Matrix(3, 3);
		newMatrix.addElements(0, 0, 1);
		newMatrix.addElements(0, 1, 2);
		newMatrix.addElements(1, 1, 3);
		newMatrix.addElements(1, 2, 3);
		newMatrix.addElements(2, 1, 1);
		newMatrix.addElements(2, 2, 2);
		String expected = "0 0 0 \n0 3 3 \n0 1 2 \n";
		assertNotEquals(expected, newMatrix.show());
	}
	
	// Negative Test case for multiplication.
	@Test
	public void multiplicationTestCase2() {
		Matrix firstMatrix = new Matrix(3, 2);
		firstMatrix.addElements(0, 0, 1);
		firstMatrix.addElements(0, 1, 2);
		firstMatrix.addElements(1, 0, 3);
		firstMatrix.addElements(1, 1, 4);
		firstMatrix.addElements(2, 0, 5);
		firstMatrix.addElements(2, 1, 6);

		Matrix secondMatrix = new Matrix(3, 2);
		secondMatrix.addElements(0, 0, 1);
		secondMatrix.addElements(0, 1, 2);
		secondMatrix.addElements(1, 0, 3);
		secondMatrix.addElements(1, 1, 4);
		secondMatrix.addElements(2, 0, 5);
		secondMatrix.addElements(2, 1, 6);

		Matrix actual = firstMatrix.multiplication(secondMatrix);
		assertNull(actual);
	}
}