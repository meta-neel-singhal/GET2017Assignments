package binarysearchtree;

/**
 * Makes the Binary Search Tree.
 * 
 * @author Neel Singhal
 */
public class BinarySearchTree {
	Node root;
	static int size = 0;
	static int index = 0;
	static int[] array;
	String result = "";
	/**
	 * Constructor.
	 */
	public BinarySearchTree() {
		root = null;
	}

	/**
	 * Inserts a student in the Binary Search Tree.
	 * 
	 * @param student    the student to add.
	 */
	void insert(Student student) {
		root = buildTree(root, student);
		index++;
		size++;
	}

	/**
	 * Build the Binary Search Tree. Add the node with value smaller
	 * than the parent in the left subtree of the parent and the node
	 * with value greater than the parent in the right subtree of the parent.
	 * 
	 * @param node       the added node.
	 * @param student    the student to add in the Binary Search Tree.
	 * @return the node added in the Binary Search Tree.
	 */
	public Node buildTree(Node node, Student student) {
		// Base Condition : If no further node is found.
		if (node == null) {
			node = new Node(student, index);
			return node;
		}
		// If roll no. of the student to add is smaller than that of the root node.
		if (student.getRollNo() < node.student.getRollNo()) {
			node.left = buildTree(node.left, student);
		}
		// If roll no. of the student to add is greater than that of the root node.
		else if (student.getRollNo() > node.student.getRollNo()) {
			node.right = buildTree(node.right, student);
		}

		return node;
	}

	/**
	 * Finds the inoder of the Binary Search Tree.
	 * 
	 * @param node    the root node of the Binary Search Tree.
	 * @return the inorder of the Binary Search Tree.
	 */
	public String inorder(Node node) {
		if (node != null) {
			inorder(node.left);
			result += "Roll No. : " + node.student.getRollNo() + "\tStudent Name : " + node.student.getName() + "\n";
			inorder(node.right);
		}

		return result;
	}
}
