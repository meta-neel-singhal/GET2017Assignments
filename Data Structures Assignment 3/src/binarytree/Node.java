package binarytree;

/**
 * Defines a Node of the binary tree.
 * 
 * @author Neel Singhal
 */
public class Node {

	public int data;
	public Node left;
	public Node right;

	// Default Constructor
	public Node() {
		left = null;
		right = null;
		data = 0;
	}

	// Parameterized Constructor
	public Node(int item) {
		data = item;
		left = null;
		right = null;
	}

	/**
	 * Gets the data of a node.
	 *
	 * @return the data.
	 */
	public int getData() {
		return data;
	}

	/**
	 * Sets the data in a node.
	 *
	 * @param data    Data for a node.
	 */
	public void setData(int data) {
		this.data = data;
	}

	/**
	 * Gets the left subtree.
	 *
	 * @return the left subtree.
	 */
	public Node getLeft() {
		return left;
	}

	/**
	 * Sets the left subtree.
	 *
	 * @param left    Left child node.
	 */
	public void setLeft(Node left) {
		this.left = left;
	}

	/**
	 * Gets the right subtree.
	 *
	 * @return the right subtree.
	 */
	public Node getRight() {
		return right;
	}

	/**
	 * Sets the right subtree.
	 *
	 * @param right    Right child node.
	 */
	public void setRight(Node right) {
		this.right = right;
	}
}
