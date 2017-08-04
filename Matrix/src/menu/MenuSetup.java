package menu;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import operations.Back;
import operations.Exit;
import operations.SingleMatrixOperations;
import operations.TwoMatrixOperations;
import action.ActionableMenuItem;

/**
 * Helps to set up the structure of the menu.
 * 
 * @author Neel Singhal
 */
public class MenuSetup {

	/**
	 * Creates structure of menu.
	 * 
	 * @return the menu.
	 */
	public static Menu createMenu() {
		Menu mainMenu = new Menu();
		List<MenuItem> subMenu = mainMenu.getSubMenu();

		MenuItem item = new Menu();
		item.setDisplayName("1. Perform a single matrix operation");
		subMenu.add(item);

		List<MenuItem> displaySubMenu = ((Menu) item).getSubMenu();
		item = new ActionableMenuItem(new SingleMatrixOperations());         
		item.setDisplayName("1. Transpose");
		displaySubMenu.add(item);

		item = new ActionableMenuItem(new SingleMatrixOperations());          
		item.setDisplayName("2. Negation");
		displaySubMenu.add(item);

		item = new Back();    
		item.setDisplayName("3. Back to Main Menu");
		displaySubMenu.add(item);

		item = new ActionableMenuItem(new Exit());         
		item.setDisplayName("4. Exit");
		displaySubMenu.add(item);

		item = new Menu();                       
		item.setDisplayName("2. Perform a two matrix operation");
		subMenu.add(item);

		List<MenuItem> operationSubMenu = ((Menu) item).getSubMenu();
		item = new ActionableMenuItem(new TwoMatrixOperations());        
		item.setDisplayName("1. Addition");
		operationSubMenu.add(item);

		item = new ActionableMenuItem(new TwoMatrixOperations());           
		item.setDisplayName("2. Multiplication");
		operationSubMenu.add(item);

		item = new Back();       
		item.setDisplayName("3. Back to Main Menu");
		operationSubMenu.add(item);

		item = new ActionableMenuItem(new Exit());     
		item.setDisplayName("4. Exit");
		operationSubMenu.add(item);

		item = new ActionableMenuItem(new Exit());  
		item.setDisplayName("3. Exit");
		subMenu.add(item);

		return mainMenu;

	}

	/**
	 * Displays the menu items according to the structure.
	 * 
	 * @param menu    object of menu type.
	 */
	public static void display(Menu menu) {
		Iterator<MenuItem> iterate = menu.getSubMenu().iterator();

		while (iterate.hasNext()) {
			System.out.println(iterate.next().getDisplayName());
		}

	}

	/**
	 * Helps to identify the choice of the user.
	 * 
	 * @return the choice index selected by the user.
	 */
	public static int getInput(){
		Scanner scan = new Scanner(System.in);
		int choice = 0;
		boolean flag = true;
		do {
			try {
				choice = scan.nextInt();
				if(choice < 1 || choice > 5) {
					throw new InputMismatchException();
				}
				flag = false;
			} 
			catch (InputMismatchException exception) {
				System.out.println("Enter valid choice");
			}
		}while (flag);

		return choice - 1;
	}

	/**
	 * Helps to decide the type of menu and set the parent of the submenu.
	 * 
	 * @param menu    object of menu type.
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
		else if(menuItem instanceof Menu){
			((Menu) menuItem).setParentMenu(menu);
			displayAndPerformAction((Menu)menuItem);
		} 
		else{
			displayAndPerformAction(menu.getParentMenu());
		}
	}
}
