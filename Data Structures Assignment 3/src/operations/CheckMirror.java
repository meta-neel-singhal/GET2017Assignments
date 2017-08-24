package operations;

import menu.Action;
import binarytree.Node;

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
		boolean answer = false;
		int firstTreeInorder[]; // Inorder of the first tree.
		int secondTreeInorder[]; // Inorder of the second tree.

		InorderTreeTraversal firstTree = new InorderTreeTraversal();
		InorderTreeTraversal secondTree = new InorderTreeTraversal();
		
		firstTreeInorder = firstTree.getInorder(firstTreeNode);
		secondTreeInorder = secondTree.getInorder(secondTreeNode);
		int size = firstTreeInorder.length;
		// Return false if the array size of both the firstTreeInorder and secondTreeInorder is different.
		if (size != secondTreeInorder.length) {
			answer = false;
		} 
		else {
			// Compare the first array with the reverse of second array.
			for (int countFirst = 0, countSecond = secondTreeInorder.length - 1; countFirst < size; countFirst++, countSecond--) {
				// Returns true if all the elements are equal, otherwise false.
				if (firstTreeInorder[countFirst] == secondTreeInorder[countSecond]) {
					answer = true;
				}
				else {
					answer = false;
					break;
				}
			}
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
