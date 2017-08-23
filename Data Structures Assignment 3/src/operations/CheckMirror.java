package operations;

import binarytree.Node;
import menu.Action;

/**
 * Checks if two trees are mirror images of each other or not.
 * 
 * @author Neel Singhal
 */
public class CheckMirror implements Action {

	/**
	 * Given two trees, return true if they are mirror of each other.
	 *
	 * @param firstTreeNode     Root node of first tree.
	 * @param secondTreeNode    Root node of second tree.
	 * @return true, if successful.
	 */
	public static boolean checkMirror(Node firstTreeNode, Node secondTreeNode) 
	{
		boolean answer;
		// Base case : Both empty
		if (firstTreeNode == null && secondTreeNode == null) {
			answer = true;
		}
		// If only one is empty
		else if (firstTreeNode == null || secondTreeNode == null) {
			answer = false;
		}
		// If both are non-empty, compare left of one tree and right of other tree recursively.
		else {
			answer = ((firstTreeNode.data == secondTreeNode.data) 
					&& (checkMirror(firstTreeNode.getLeft(), secondTreeNode.getRight()))
					&& (checkMirror(firstTreeNode.getRight(), secondTreeNode.getLeft())));
		}

		return answer;
	}

	/*
	 * Overriden method to perform action on check mirror menu item.
	 */
	@Override
	public void performAction(int choice) {
		boolean answer;
		Node firstTreeNode = new Node(1);
		Node secondTreeNode = new Node(1);
		// Nodes of first tree.
		firstTreeNode.left = new Node(2);
		firstTreeNode.right = new Node(3);
		firstTreeNode.left.left = new Node(4);
		firstTreeNode.left.right = new Node(5);

		// Nodes of second tree.
		secondTreeNode.left = new Node(3);
		secondTreeNode.right = new Node(2);
		secondTreeNode.right.left = new Node(5);
		secondTreeNode.right.right = new Node(4);

		/* 
		* Check mirror is true if left subtree of first tree is same as the right subtree
		* of the second tree and vice versa.
		*/
		answer = checkMirror(firstTreeNode, secondTreeNode);
		if (answer) {
			System.out.println("Both the trees are mirror images of each other.");
		}
		else {
			System.out.println("Both the trees are not the mirror images of each other.");
		}
	}
}
