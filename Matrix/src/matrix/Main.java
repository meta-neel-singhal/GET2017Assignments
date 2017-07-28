package matrix;

import menu.Menu;
import menu.MenuSetup;

/**
 * (Main Class) Initializes the matrix to provide various options and perform 
 * operation as selected by the user from the given options.
 * 
 * @author Neel Singhal
 */
public class Main {

	public static void main(String[] args) {
		System.out.println("Welcome to Matrix Plaza where you can perform all the matrix operations.\n");
		System.out.println("-------------------------------------------------------------------------\n ");

		MenuSetup menuSetup = new MenuSetup();
		Menu menu = menuSetup.createMenu();
		menu.setParentMenu(menu);
		while (true) {
			menuSetup.displayAndPerformAction(menu);
		}
	}
}
