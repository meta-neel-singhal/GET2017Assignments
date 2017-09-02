package operations;

import menu.Action;

/**
 * The Exit class.
 *
 * @author Neel Singhal
 */
public class Exit implements Action {

	/*
	 * Overriden method to perform action on exit.
	 */
	@Override
	public void performAction(int choice) {
		System.out.println("Thank You.");
		System.exit(0);
	}
}