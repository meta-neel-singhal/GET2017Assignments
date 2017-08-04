package menu;

import java.util.ArrayList;
import java.util.List;

/**
 * Helps to get the selected choice by the user.
 * 
 * @author Neel Singhal
 */
public class Menu extends MenuItem {

	private Menu parentMenu;
	private List<MenuItem> subMenu = new ArrayList<MenuItem>();

	public List<MenuItem> getSubMenu() {
		return subMenu;
	}

	public void setSubMenu(List<MenuItem> list) {
		this.subMenu = list;
	}

	public Menu getParentMenu() {
		return parentMenu;
	}

	public void setParentMenu(Menu parentMenu) {
		this.parentMenu = parentMenu;
	}

	/**
	 * Checks if the user input is valid and provides the menu item selected
	 * if the choice is valid.
	 * 
	 * @param choice    entered by the user.
	 * @return the menu item as selected by the user.
	 */
	public MenuItem getSelection(int choice) {
		if (choice >= subMenu.size()) {
			return null;
		}

		return subMenu.get(choice);
	}
}
