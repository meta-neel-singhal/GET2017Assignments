package operations;

import binarytree.Node;

public class InorderTreeTraversal {

	int count = 0;
	int inorder[] = new int[5];
	
	/**
	 * Returns the inorder of the tree.
	 * 
	 * @param node    The root node.
	 * @return the array of the inorder of the tree.
	 */
	public int[] getInorder(Node node) {
		InorderTreeTraversal tree = new InorderTreeTraversal();
		tree.inorder(node);

		return inorder;
	}
	
	/**
	 * Helps to get the inorder of the tree.
	 * 
	 * @param node    The current node.
	 * @return the node in inorder.
	 */
	public Node inorder(Node node) {
		if (node != null) {
			// Follows "Left Subtree --> Root Node --> Right Subtree" pattern.
			inorder(node.getLeft());  
			inorder[count] = node.data;
			count++;
			inorder(node.getRight());	
		}
		
		return node;
	}
}
