package action;

import menu.MenuItem;

/**
 * Triggers the action for the actionable menu items.
 * 
 * @author Neel Singhal
 */
public class ActionableMenuItem extends MenuItem {

	Action action;

	public void triggerAction(int choice) {
		this.action.performAction(choice);
	}

	public ActionableMenuItem(Action action) {

		this.action = action;
	}

}
