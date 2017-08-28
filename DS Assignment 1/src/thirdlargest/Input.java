package thirdlargest;

import java.util.Scanner;

/**
 * The Input class to take specific input from the user.
 * 
 * @author Neel Singhal
 */
public class Input {
	private static Scanner scan = new Scanner(System.in);
	
	/**
	 * Take only double as input.
	 *
	 * @return the input.
	 */
	public static double takeDoubleAsInput() {
		boolean flag = true;
		double input = 0;
		String temp = "";
		while (flag) {
			try {
				temp = scan.nextLine().trim();
				input = Double.parseDouble(temp);
				flag = false;
			} 
			catch (Exception e) {
				System.out.println("Please Enter a valid input !");
			}
		}
		
		return input;
	}
}
