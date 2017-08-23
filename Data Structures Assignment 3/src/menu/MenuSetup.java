package menu;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import operations.CheckMirror;
import operations.Exit;
import operations.InsertElement;
import operations.PostorderTreeTraversal;
import operations.PreorderTreeTraversal;

/**
 * Set up the Menu.
 *
 * @author Neel Singhal
 */
public class MenuSetup {

	/**
	 * Creates the menu.
	 *
	 * @return the menu
	 */
	public static Menu createMenu() {
		Menu mainMenu = new Menu();
		List<MenuItem> subMenu = mainMenu.getSubMenu();
		MenuItem item = new Menu();

		item = new ActionableMenuItem(new PreorderTreeTraversal());
		item.setDisplayName("1. Print Preorder");
		subMenu.add(item);

		item = new ActionableMenuItem(new PostorderTreeTraversal());
		item.setDisplayName("2. Print Postorder");
		subMenu.add(item);

		item = new ActionableMenuItem(new CheckMirror());
		item.setDisplayName("3. Check Mirror Image");
		subMenu.add(item);

		item = new ActionableMenuItem(new InsertElement());
		item.setDisplayName("4. Add more elements");
		subMenu.add(item);		

		item = new ActionableMenuItem(new Exit());  
		item.setDisplayName("5. Exit");
		subMenu.add(item);

		return mainMenu;

	}

	/**
	 * Display the menu.
	 *
	 * @param menu    menu to display
	 */
	public static void display(Menu menu) {
		Iterator<MenuItem> iterate = menu.getSubMenu().iterator();

		while (iterate.hasNext()) {
			System.out.println(iterate.next().getDisplayName());
		}
	}

	/**
	 * Gets the input of the user.
	 *
	 * @return the choice.
	 */
	public static int getInput() {
		Scanner scan = new Scanner(System.in);
		int choice = 0;
		boolean flag = true;
		do {
			try {
				choice = scan.nextInt();
				if (choice < 1 || choice > 5) {
					throw new InputMismatchException();
				}
				flag = false;
			} 
			catch (InputMismatchException exception) {
				System.out.println("Enter valid choice");
				scan.next();
			}
		} while (flag);

		return choice - 1;
	}

	/**
	 * Display and perform action.
	 *
	 * @param menu to display and perform action.
	 */
	public static void displayAndPerformAction(Menu menu) {

		display(menu);
		int choice = getInput();
		MenuItem menuItem = menu.getSelection(choice);

		if (menuItem == null) {
			displayAndPerformAction(menu);
		} 
		else if (menuItem instanceof ActionableMenuItem) {
			((ActionableMenuItem) menuItem).triggerAction(choice);
		} 
	}
}
