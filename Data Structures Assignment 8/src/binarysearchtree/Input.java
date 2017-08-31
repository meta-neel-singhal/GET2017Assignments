package binarysearchtree;

import java.util.Scanner;

/**
 * The Input class to take specific input from the user.
 * 
 * @author Neel Singhal
 */
public class Input {
	private static Scanner scan = new Scanner(System.in);

	/**
	 * Take only integer as input.
	 *
	 * @return the input.
	 */
	public static int takeIntegerAsInput() {
		boolean flag = true;
		int input = 0;
		String temp = "";
		while (flag) {
			try {
				temp = scan.nextLine().trim();
				input = Integer.parseInt(temp);
				flag = false;
			} 
			catch (Exception e) {
				System.out.println("Please Enter a valid input !");
			}
		}

		return input;
	}

	/**
	 * Take only String as input.
	 *
	 * @return the input string.
	 */
	public static String takeStringAsInput() {
		String input;
		input = scan.nextLine().trim();
		if (input.length() == 0) {
			System.out.println("Please enter some value !");
			input = takeStringAsInput();
		}
		return input;
	}
}