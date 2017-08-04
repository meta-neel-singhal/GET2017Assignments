package junittest;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotEquals;
import matrix.Matrix;
import operations.SingleMatrixOperations;
import operations.TwoMatrixOperations;

import org.junit.Test;

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
		SingleMatrixOperations newMatrix = new SingleMatrixOperations(4, 3);
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
		SingleMatrixOperations transposedMatrix = newMatrix.transposeMatrix();
		assertArrayEquals(expected, transposedMatrix.getData());
	}

	// Positive Test Case for multiplication.
	@Test
	public void multiplicationTestCase1() {
		TwoMatrixOperations firstMatrix = new TwoMatrixOperations(2, 3);
		firstMatrix.addElements(0, 0, 1);
		firstMatrix.addElements(0, 1, 2);
		firstMatrix.addElements(0, 2, 3);
		firstMatrix.addElements(1, 0, 4);
		firstMatrix.addElements(1, 1, 5);
		firstMatrix.addElements(1, 2, 6);

		TwoMatrixOperations	secondMatrix = new TwoMatrixOperations(3, 2);
		secondMatrix.addElements(0, 0, 1);
		secondMatrix.addElements(0, 1, 2);
		secondMatrix.addElements(1, 0, 3);
		secondMatrix.addElements(1, 1, 4);
		secondMatrix.addElements(2, 0, 5);
		secondMatrix.addElements(2, 1, 6);

		TwoMatrixOperations actual = firstMatrix.multiplyMatrix(secondMatrix);
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
		int unexpected[][] = { { 1, 2, 0 }, { 0, 3, 3 }, { 0, 1, 0 } };
		assertNotEquals(unexpected, newMatrix.getData());
	}

	// Negative Test Case for transpose.
	@Test
	public void transposeTestCase2() {
		SingleMatrixOperations newMatrix = new SingleMatrixOperations(4, 3);
		newMatrix.addElements(0, 0, 1);
		newMatrix.addElements(0, 1, 2);
		newMatrix.addElements(1, 1, 3);
		newMatrix.addElements(1, 2, 3);
		newMatrix.addElements(2, 1, 1);
		newMatrix.addElements(2, 2, 2);
		newMatrix.addElements(3, 0, 1);
		newMatrix.addElements(3, 1, 2);
		newMatrix.addElements(3, 2, 3);
		int unexpected[][] = { { 1, 0, 0, 1 }, { 2, 3, 1, 2 }, { 0, 0, 0, 0 } };
		SingleMatrixOperations transposedMatrix = newMatrix.transposeMatrix();
		assertNotEquals(unexpected, transposedMatrix.getData());
	}

	// Negative Test case for multiplication.
	@Test
	public void multiplicationTestCase2() {
		TwoMatrixOperations firstMatrix = new TwoMatrixOperations(3, 2);
		firstMatrix.addElements(0, 0, 1);
		firstMatrix.addElements(0, 1, 2);
		firstMatrix.addElements(1, 0, 3);
		firstMatrix.addElements(1, 1, 4);
		firstMatrix.addElements(2, 0, 5);
		firstMatrix.addElements(2, 1, 6);

		TwoMatrixOperations secondMatrix = new TwoMatrixOperations(2, 2);
		secondMatrix.addElements(0, 0, 1);
		secondMatrix.addElements(0, 1, 2);
		secondMatrix.addElements(1, 0, 3);
		secondMatrix.addElements(1, 1, 4);
		
		TwoMatrixOperations actual = firstMatrix.multiplyMatrix(secondMatrix);
		int unexpected[][] = { { 22, 28 }, { 22, 28 } };
		assertNotEquals(unexpected, actual);
	}
}