package binarytree;

/**
 * Contains the operations for a binary tree.
 * 
 * @author Neel Singhal
 */
public class BinaryTree {

	// Root of Binary Tree.
	public Node root;

	// Default Constructor.
	public BinaryTree() {
		root = null;
	}

	// Functions to insert data in the Binary Tree.
	public void insert(int data) {
		root = insert(root, data);
	}

	// Function to insert data recursively in the Binary Tree.
	public Node insert(Node node, int data) {
		// Inserts value in tree if first node.
		if (node == null) {
			node = new Node(data);
		}
		else {
			// Inserts value in tree if right subtree of a node is null.
			if (node.getRight() == null) {
				node.right = insert(node.right, data);
			}
			// Inserts value in tree if right subtree of a node is not null.
			else {
				node.left = insert(node.left, data); 
			}
		}
		return node;
	}

	// Traverses the nodes of the binary tree in preorder.
	public Node preorder(Node node) {
		if (node != null) {
			// Follows "Root Node --> Left Subtree --> Right Subtree" pattern.
			System.out.print(node.getData() + " ");
			preorder(node.getLeft());             
			preorder(node.getRight());
		}
		return node;
	}

	// Used for preorder traversal.
	public void preorder() {
		preorder(root);
	}

	// Used for postorder traversal.
	public void postorder() {
		postorder(root);
	}

	// Traverses the nodes of the binary tree in postorder.
	public Node postorder(Node node) {
		if (node != null) {
			// Follows "Left Subtree --> Right Subtree --> Root Node" pattern.
			postorder(node.getLeft());             
			postorder(node.getRight());
			System.out.print(node.getData() + " ");
		}
		
		return node;
	}
}
