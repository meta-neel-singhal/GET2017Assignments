import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Implements the matrix class and performs various functions on the matrix.
 * 
 * @author Neel Singhal
 */
public class Matrix {
	private int data[][];
	private int noOfRows;
	private int noOfColumns;

	/**
	 * Default constructor initializing no. of rows and no. of columns.
	 * 
	 * @param row       total no. of rows in the matrix.
	 * @param column    total no. of columns in the matrix.
	 */
	public Matrix(int row, int column) {
		this.noOfRows = row;
		this.noOfColumns = column;
		data = new int[row][column];
	}

	/**
	 * Getter method to get value of private variable data.
	 * 
	 * @return 2-D integer array
	 */
	public int[][] getData() {
		return data;
	}

	/**
	 * Adds the value at the provided position of row and column.
	 * 
	 * @param row       total no. of rows in the matrix.
	 * @param column    total no. of columns in the matrix.
	 * @param value     value to be added at Matrix position [row][column]
	 */
	public void addElements(int row, int column, int value) {
		this.data[row][column] = value;
	}

	/**
	 * For each value of first matrix at position [row][column] sets value of
	 * second matrix at position [column][row].
	 * 
	 * @return the transposed matrix.
	 */
	public Matrix transpose() {
		Matrix transposeMatrix = new  Matrix(noOfColumns, noOfRows); 

		for (int rowCount = 0; rowCount < noOfColumns; rowCount++) {
			for (int columnCount = 0; columnCount < noOfRows; columnCount++) {
				transposeMatrix.addElements(rowCount, columnCount, data[columnCount][rowCount]);
			}
		}

		return transposeMatrix;
	}

	/**
	 * Adds the values of the matrix in a string using loops.
	 * 
	 * @return a string containing the value of the matrix.
	 */
	public String show() {
		String display = "";
		for (int rowIndex = 0; rowIndex < noOfRows; rowIndex++) {
			for (int columnIndex = 0; columnIndex < noOfColumns; columnIndex++) {
				display += data[rowIndex][columnIndex] + " ";
			}
			display += "\n";
		}

		return display;
	}

	/**
	 * Multiplies first matrix with second matrix. Stores the value of each element by
	 * multiplying elements of rows of first matrix by elements of columns of second matrix.
	 * 
	 * @param matrix1    first matrix to be multiplied.
	 * @param matrix2    second matrix to be multiplied.
	 * @return the multiplied matrix.
	 */
	public Matrix multiplication(Matrix matrix2) {
		Matrix multipliedMatrix = new Matrix(this.noOfRows, matrix2.noOfColumns);

		if (this.noOfColumns == matrix2.noOfRows) {
			for (int i = 0; i < this.noOfRows; i++) {
				for (int j = 0; j < matrix2.noOfColumns; j++) {
					int sum = 0;
					for (int k= 0; k < this.noOfColumns; k++) {
						sum += this.data[i][k] * matrix2.data[k][j];
					}
					multipliedMatrix.addElements(i, j, sum);
				}
			}
		}
		else {
			
			return null;
		}

		return multipliedMatrix;
	}
}

