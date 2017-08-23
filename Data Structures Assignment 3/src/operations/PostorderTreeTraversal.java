package operations;

import binarytree.Main;
import menu.Action;

/**
 * Perform action on print postorder menu.
 * 
 * @author Neel Singhal
 */
public class PostorderTreeTraversal implements Action {

	/*
	 * Overriden method to perform action on print postorder.
	 */
	@Override
	public void performAction(int choice) {
		System.out.print("\nPost order : ");
		Main.tree.postorder();
		System.out.println();
	}
}