package utility;

import java.util.Scanner;


/**
 * The Input class to take specific input from the user.
 * 
 * @author Neel Singhal
 */
public class Input {
	private static Scanner scan = new Scanner(System.in);
	
	/**
	 * Prints the menu.
	 */
	public static void printMenu() {
		System.out.println("1. Add a task\n2. Print tasks\n3. Exit");
	}
	
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
				System.out.println("Please Enter a valid Element");
			}
		}
		
		return input;
	}
	
	/**
	 * Take only string as input.
	 *
	 * @return the input.
	 */
	public static String takeStringAsInput() {
		String input = "";
		input = scan.nextLine().trim();
		return input;
	}
	
	/**
	 * Closing the scanner.
	 */
	public static void close(){
		scan.close();
	}
}
