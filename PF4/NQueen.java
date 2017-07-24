/**
 * Solves the N Queen problem i.e. the problem of placing N number
 * of queens on an N×N board so that no two queens attack each other.
 * 
 * @author Neel Singhal
 */
public class NQueen {
	/**
	 * Checks whether position of board in a particular cell (i.e. board[row][column])
	 * is not under attack by any other queen adjacent to that cell.
	 * 
	 * @param board     2-D array in which queen is to be placed.
	 * @param row       row for placing queen.
	 * @param column    column for placing queen.
	 * @return true if position is safe from attack otherwise false.
	 */
	boolean checkSafeToPlace(int board[][], int row, int column, int dimensionOfBoard){
		int count1, count2;

		// Check the column upwards.
		for (count1 = 0; count1 < row; count1++) {
			if (board[count1][column] == 1) {
				return false;
			}
		}

		// Check upper diagonal on left side.
		for (count1 = row, count2 = column; count1 >= 0 && count2 >= 0; count1--, count2--) {
			if (board[count1][count2] == 1) {
				return false;
			}
		}

		// Check upper diagonal on right side. 
		for (count1 = row, count2 = column; count2 < dimensionOfBoard && count1 >= 0; count1--, count2++) {
			if (board[count1][count2] == 1) {
				return false;
			}
		}

		return true;
	}

	boolean  nQueen(int[][] board, int startRow, int dimensionOfBoard){
		//If all queens are placed then return true.
		if (startRow >= dimensionOfBoard)
			return true;

		// Placing the queen in all columns one by one.
		for (int row = 0; row < dimensionOfBoard; row++) {
			if (checkSafeToPlace(board, startRow, row, dimensionOfBoard)) {
				board[startRow][row] = 1;

				// Recursive call to place rest of the queens. 
				if (nQueen(board, startRow + 1, dimensionOfBoard) == true) {

					return true;
				}
				/* If placing queen in board[row][column] doesn't lead to a solution
				 * then remove queen from board[row][column] by backtracking.
				 */
				board[startRow][row] = 0;
			}
		}
		// Return false when no queen can be placed in any cell of this row.
		return false;
	}
}