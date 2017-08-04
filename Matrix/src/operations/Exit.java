package operations;

import action.Action;

/**
 * Helps the user to exit.
 * 
 * @author Neel Singhal
 */
public class Exit implements Action {

	/**
	 * Overridden method to help user to exit from the program. 
	 */
	@Override
	public void performAction(int choice) {
		System.exit(0);	
	}
}