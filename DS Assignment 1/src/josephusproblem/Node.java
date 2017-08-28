package josephusproblem;

/**
 * Class to create a node of the circular linked list.
 * 
 * @author Neel Singhal
 */
public class Node {
	private int data;
	private Node next;

	public Node(int data) {
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}   
}