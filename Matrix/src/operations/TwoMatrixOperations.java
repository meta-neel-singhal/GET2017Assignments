package operations;

import java.util.InputMismatchException;

import matrix.Matrix;
import action.Action;
/**
 * Contains the operations performed on two matrices.
 * 
 * @author Neel Singhal
 */
public class TwoMatrixOperations extends Matrix implements Action {

	public TwoMatrixOperations() {
	}

	public TwoMatrixOperations(int row, int column) {
		super(row, column);
	}

	/**
	 * Helps to multiply two matrices if number of columns of first matrix is equal
	 * to the number of rows of second matrix.
	 * 
	 * @param secondMatrix     Second matrix for multiplication
	 * @return final multiplied matrix.
	 */
	public TwoMatrixOperations multiplyMatrix(TwoMatrixOperations secondMatrix) {

		// Condition when multiplication is not possible
		if (this.noOfColumns != secondMatrix.noOfRows) {
			throw new InputMismatchException();
		} 
		else {
			TwoMatrixOperations multipliedMatrix = new TwoMatrixOperations(noOfRows, secondMatrix.noOfColumns);
			for (int row = 0; row < this.noOfRows; row++) {
				for (int column = 0; column < secondMatrix.noOfColumns; column++) {
					for (int count = 0; count < this.noOfColumns; count++) {
						multipliedMatrix.data[row][column] += data[row][count] * secondMatrix.data[count][column];
					}
				}
			}

			return multipliedMatrix;
		}
	}

	/**
	 * Helps to add two matrices if they are of same dimensions.
	 * 
	 * @param secondMatrix    socond matrix to be added in the first matrix.
	 * @return the resultant matrix with addition of both the matrices.
	 */
	public TwoMatrixOperations addMatrix(TwoMatrixOperations secondMatrix) {

		if (noOfRows < 0 || noOfColumns < 0) {
			throw new IllegalArgumentException();
		} 
		else {
			TwoMatrixOperations addedMatrix = new TwoMatrixOperations(noOfRows, noOfColumns);
			for (int count1 = 0; count1 < noOfRows; count1++) {
				for (int count2 = 0; count2 < noOfColumns; count2++) {
					addedMatrix.addElements(count1, count2, this.data[count1][count2] + secondMatrix.data[count1][count2]);
				}
			}

			return addedMatrix;
		}
	}

	/**
	 * Overridden performAction method to perform action according to the choice
	 * selected by the user.
	 */
	@Override
	public void performAction(int choice) {

		ElementsForTwoMatrix insert = new ElementsForTwoMatrix();
		TwoMatrixOperations addedMatrix;
		TwoMatrixOperations multipliedMatrix;

		System.out.println("Enter first matrix: ");
		TwoMatrixOperations matrix1 = (TwoMatrixOperations) insert.matrixInsertion();
		System.out.println("Enter second matrix: ");
		TwoMatrixOperations matrix2 = (TwoMatrixOperations) insert.matrixInsertion();
		System.out.println("First matrix");
		matrix1.show();
		System.out.println("Second matrix: ");
		matrix2.show();

		switch (choice) {
		case 0:
			// Checks if the matrix are of same dimensions or not.
			if (matrix2.noOfRows != matrix1.noOfRows || matrix2.noOfColumns != matrix1.noOfColumns) {
				System.out.println("Matrix cannot be added!!");
				break;
			}
			System.out.println("Matrix after addition : ");
			addedMatrix = new TwoMatrixOperations(matrix1.noOfRows, matrix1.noOfColumns);
			addedMatrix = matrix1.addMatrix(matrix2);
			addedMatrix.show();

			break;
		case 1:
			// Checks if the number of columns of first matrix is not equal to the number
			// of rows of the second matrix then shows a message.
			if (matrix2.noOfRows != matrix1.noOfColumns) {
				System.out.println("Matrix cannot be multiplied!!");
				break;
			}
			System.out.println("Matrix after multiplication is:");
			multipliedMatrix = new TwoMatrixOperations(matrix1.noOfRows, matrix2.noOfColumns);
			multipliedMatrix = matrix1.multiplyMatrix(matrix2);
			multipliedMatrix.show();
			break;
		default:
			System.exit(0);
		}
	}
}
