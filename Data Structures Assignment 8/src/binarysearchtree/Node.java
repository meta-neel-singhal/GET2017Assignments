package binarysearchtree;

/**
 * A binary tree node.
 * 
 * @author Neel Singhal
 */
public class Node {
	int index;
	Student student;
	Node left, right;

	/**
	 * Parameterized Constructor.
	 * 
	 * @param data     Data of node.
	 * @param index    Index value of node in the array.
	 */
	Node(Student student, int index) {
		this.student = student;
		this.index = index;
		this.left = null;
		this.right = null;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}
}
