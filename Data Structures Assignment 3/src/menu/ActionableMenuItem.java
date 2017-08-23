package menu;

/**
 * Class to trigger an action for specific event.
 * 
 * @author Neel Singhal
 */
public class ActionableMenuItem extends MenuItem {

	Action action;

	/**
	 * Triggers the action according to the choice of the user.
	 */
	public void triggerAction(int choice) {
		this.action.performAction(choice);
	}

	/**
	 * Constructor
	 * 
	 * @param action    Action to perform
	 */
	public ActionableMenuItem(Action action) {
		this.action = action;
	}
}
