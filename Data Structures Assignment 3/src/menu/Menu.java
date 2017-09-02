package menu;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains the structure of the menu.
 *
 * @author Neel Singhal
 */
public class Menu extends MenuItem {

	private List<MenuItem> subMenu = new ArrayList<MenuItem>();

	/**
	 * Gets the sub menu.
	 *
	 * @return the sub menu
	 */
	public List<MenuItem> getSubMenu() {
		return subMenu;
	}

	/**
	 * Sets the sub menu.
	 *
	 * @param list the new sub menu
	 */
	public void setSubMenu(List<MenuItem> list) {
		this.subMenu = list;
	}

	/**
	 * Gets the selection of the user.
	 *
	 * @param choice    Choice entered by the user.
	 * @return the selection.
	 */
	public MenuItem getSelection(int choice) {
		if (choice >= subMenu.size()) {
			return null;
		}

		return subMenu.get(choice);
	}
}
