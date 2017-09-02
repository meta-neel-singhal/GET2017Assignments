package binarytree;

import java.util.InputMismatchException;
import java.util.Scanner;

import menu.Menu;
import menu.MenuSetup;

/**
 * The Main class using the operations of a binary tree.
 * 
 * @author Neel Singhal
 */
public class Main {
	public static BinaryTree tree = new BinaryTree();

	/**
	 * The main method.
	 *
	 * @param args    the arguments
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int data = 0;
		System.out.println("Enter a element to insert: ");
		// Checks if entered data is correct.
		try {
			data = scan.nextInt();
		} 
		catch (InputMismatchException exception) {
			System.out.println("Enter Correct Value !!!");
			scan.next();
		}
		tree.insert(data);
		System.out.println("Select the action you want to perform.");

		// Set up and displays the menu.
		Menu menu = MenuSetup.createMenu();
		while (true) {
			MenuSetup.displayAndPerformAction(menu);
		}
	}
}
