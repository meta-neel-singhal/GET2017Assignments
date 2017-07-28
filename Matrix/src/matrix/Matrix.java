package matrix;

/**
 * Implements the matrix class and performs various functions on the matrix.
 * 
 * @author Neel Singhal
 */
public class Matrix {
	public int data[][];
	public int noOfRows;
	public int noOfColumns;

	/**
	 * Parameterized constructor initializing no. of rows and no. of columns.
	 * 
	 * @param row       total no. of rows in the matrix.
	 * @param column    total no. of columns in the matrix.
	 */
	public Matrix(int row, int column) {
		this.noOfRows = row;
		this.noOfColumns = column;
		data = new int[row][column];
	}

	public Matrix() {
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
	public boolean addElements(int row, int column, int value) {
		data[row][column] = value;

		return true;
	}

	/**
	 * Adds the values of the matrix in a string using loops.
	 * 
	 * @return a string containing the value of the matrix.
	 */
	public void show() {
		String display = "";
		for (int rowIndex = 0; rowIndex < noOfRows; rowIndex++) {
			for (int columnIndex = 0; columnIndex < noOfColumns; columnIndex++) {
				display += data[rowIndex][columnIndex] + " ";
			}
			display += "\n";
		}
		System.out.println(display);
	}
}

