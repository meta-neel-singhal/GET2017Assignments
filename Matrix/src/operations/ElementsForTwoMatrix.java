package operations;

import java.util.Scanner;

import matrix.Matrix;

/**
 * Helps to insert the elements in a matrix used for TwoMatrixOperations.
 * 
 * @author Neel Singhal
 */
public class ElementsForTwoMatrix extends Matrix{

	/**
	 * Inserts the value in the matrix.
	 * 
	 * @return the final matrix.
	 */
	public Matrix matrixInsertion() {
		Scanner scan = new Scanner(System.in);
		Matrix matrix = null;
		int row;
		int column;
		int value;

		System.out.println("Enter rows and columns in the matrix");
		row = scan.nextInt();
		column = scan.nextInt();
		while (row < 1 || column < 1) {
			System.out.println("Enter a valid input");
			row = scan.nextInt();
			column = scan.nextInt();
		}
		matrix = new TwoMatrixOperations(row, column);

		System.out.println("Enter elements of matrix");
		for (int count1 = 0; count1 < matrix.noOfRows; count1++) {
			for (int count2 = 0; count2 < matrix.noOfColumns; count2++) {
				value = scan.nextInt();
				matrix.addElements(count1, count2, value);
			}
		}

		return matrix;
	}
}
