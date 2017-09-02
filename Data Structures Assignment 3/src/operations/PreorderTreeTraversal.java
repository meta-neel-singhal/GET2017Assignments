package operations;

import binarytree.Main;
import menu.Action;

/**
 * Perform action on print preorder menu.
 * 
 * @author Neel Singhal
 */
public class PreorderTreeTraversal implements Action {

	/*
	 * Overriden method to perform action on print preorder.
	 */
	@Override
	public void performAction(int choice) {
		System.out.print("\nPreorder : ");
		Main.tree.preorder();
		System.out.println();
	}
}
