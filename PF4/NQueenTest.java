import static org.junit.Assert.*;


import org.junit.Test;

public class NQueenTest {

	NQueen nQueenObject = new NQueen();

	// Positive Test Case 1.
	@Test
	public void nQueenTest1() {
		int[][] board = { {0, 0, 0, 0}, {0, 0, 0, 0},{0, 0, 0, 0}, {0, 0, 0, 0} };
		boolean result = nQueenObject.nQueen(board, 0, 4);
		boolean expected = true;
		assertEquals(expected, result);
		System.out.println("Output for Positive Test Case 1 !!!\nResult : " + result);
		for (int count1 = 0; count1 < board.length; count1++) {
			for (int j = 0; j < board.length; j++)
				System.out.print(board[count1][j] + " ");

			System.out.println();
		}
	}

	// Positive Test Case 2.
	@Test
	public void nQueenTest2() {
		int[][] board = { {0, 0}, {0, 0} };
		boolean result = nQueenObject.nQueen(board, 0, 2);
		boolean expected = false;
		assertEquals(expected, result);
		System.out.println("Output for Positive Test Case 2 !!!\nResult : " + result);
		for (int count1 = 0; count1 < board.length; count1++) {
			for (int j = 0; j < board.length; j++)
				System.out.print(board[count1][j] + " ");

			System.out.println();
		}
	}

	// Positive Test Case 3.
	@Test
	public void nQueenTest3() {
		int[][] board = { {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0},{0, 0, 0, 0, 0}, 
				{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0} };
		boolean result = nQueenObject.nQueen(board, 0, 5);
		boolean expected = true;
		assertEquals(expected, result);
		System.out.println("Output for Positive Test Case 3 !!!\nResult : " + result);
		for (int count1 = 0; count1 < board.length; count1++) {
			for (int j = 0; j < board.length; j++)
				System.out.print(board[count1][j] + " ");

			System.out.println();
		}
	}

	// Negative Test Case 1.
	@Test
	public void nQueenTest4() {
		int[][] board = { {0, 0, 0, 0}, {0, 0, 0, 0},{0, 0, 0, 0}, {0, 0, 0, 0} };
		boolean result = nQueenObject.nQueen(board, 0, 4);
		boolean expected = false;
		assertFalse(expected == result);
		System.out.println("Output for Negative Test Case 1 !!!\nResult : " + result);
		for (int count1 = 0; count1 < board.length; count1++) {
			for (int j = 0; j < board.length; j++)
				System.out.print(board[count1][j] + " ");

			System.out.println();
		}
	}

	// Negative Test Case 2.
	@Test
	public void nQueenTest5() {
		int[][] board = { {0, 0}, {0, 0} };
		boolean result = nQueenObject.nQueen(board, 0, 2);
		boolean expected = true;
		assertFalse(expected == result);
		System.out.println("Output for Negative Test Case 2 !!!\nResult : " + result);
		for (int count1 = 0; count1 < board.length; count1++) {
			for (int j = 0; j < board.length; j++)
				System.out.print(board[count1][j] + " ");

			System.out.println();
		}
	}

	// Negative Test Case 3.
	@Test
	public void nQueenTest6() {
		int[][] board = { {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0},{0, 0, 0, 0, 0}, 
				{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0} };
		boolean result = nQueenObject.nQueen(board, 0, 5);
		boolean expected = false;
		assertFalse(expected == result);
		System.out.println("Output for Negative Test Case 3 !!!\nResult : " + result);
		for (int count1 = 0; count1 < board.length; count1++) {
			for (int j = 0; j < board.length; j++)
				System.out.print(board[count1][j] + " ");

			System.out.println();
		}
	}
}
