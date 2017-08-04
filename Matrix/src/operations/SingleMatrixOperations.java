package operations;

import matrix.Matrix;
import action.Action;

/**
 * Contains the operations performed on a single matrix.
 * 
 * @author Neel Singhal
 */
public class SingleMatrixOperations extends Matrix implements Action {

	public SingleMatrixOperations() {
	}

	public SingleMatrixOperations(int row, int column) {
		super(row, column);
	}

	/**
	 * Helps to calculate the transpose of the matrix.
	 * 
	 * @return transpose of the matrix.
	 */
	public SingleMatrixOperations transposeMatrix() {

		// Condition when value of row and column is less than zero
		if (noOfRows < 0 || noOfColumns < 0) {
			throw new IllegalArgumentException();
		}
		else {
			SingleMatrixOperations transMatrix = new SingleMatrixOperations(noOfColumns, noOfRows);
			for (int i = 0; i < noOfRows; i++) {
				for (int j = 0; j < noOfColumns; j++) {
					transMatrix.addElements(j, i, data[i][j]);
				}
			}
			
			return transMatrix;
		}
	}

	/**
	 * Helps to calculate the negation of the matrix.
	 * 
	 * @return the negated matrix
	 */
	public SingleMatrixOperations negateMatrix() {

		if (noOfRows < 0 || noOfColumns < 0) {
			throw new IllegalArgumentException();
		} 
		else {
			SingleMatrixOperations negMatrix = new SingleMatrixOperations(noOfRows, noOfColumns);
			for (int count1 = 0; count1 < noOfRows; count1++) {
				for (int count2 = 0; count2 < noOfColumns; count2++) {
					negMatrix.addElements(count1, count2, - this.data[count1][count2]);
				}
			}

			return negMatrix;
		}
	}

	/**
	 * Overridden performAction method to perform action according to the choice
	 * selected by the user.
	 */
	@Override
	public void performAction(int choice) {
		ElementsForSingleMatrix insert = new ElementsForSingleMatrix();
		SingleMatrixOperations transMatrix;
		SingleMatrixOperations negMatrix;

		System.out.println("Enter the matrix: ");
		SingleMatrixOperations matrix1 = (SingleMatrixOperations) insert.matrixInsertion();
		System.out.println("Original matrix");
		matrix1.show();

		switch (choice) {
		case 0:
			System.out.println("Matrix after Transpose : ");
			transMatrix = new SingleMatrixOperations(matrix1.noOfRows, matrix1.noOfColumns);
			transMatrix = matrix1.transposeMatrix();
			transMatrix.show();
			break;
		case 1:
			System.out.println("Matrix after Negation : ");
			negMatrix = new SingleMatrixOperations(matrix1.noOfRows, matrix1.noOfColumns);
			negMatrix = matrix1.negateMatrix();
			negMatrix.show();
			break;
		default:
			System.exit(0);
		}
	}
}
