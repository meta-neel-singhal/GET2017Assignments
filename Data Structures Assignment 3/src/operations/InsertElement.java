package operations;

import java.util.InputMismatchException;
import java.util.Scanner;

import binarytree.Main;
import menu.Action;

/**
 * Perform action for adding more element.
 * 
 * @author Neel Singhal
 */
public class InsertElement implements Action {

	/*
	 * Overriden method to perform action on adding more element.
	 */
	@Override
	public void performAction(int choice) {
		int data = 0;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a element to insert: ");
		// Checks if entered data is correct.
		try {
			data = scan.nextInt();
		} 
		catch (InputMismatchException exception) {
			System.out.println("Enter Correct Value !!!");
			scan.next();
		}
		Main.tree.insert(data);
	}
}
