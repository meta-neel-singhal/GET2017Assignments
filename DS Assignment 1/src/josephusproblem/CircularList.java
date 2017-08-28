package josephusproblem;

/**
 * Class to create a a circular linked list.
 * 
 * @author Neel Singhal
 */
public class CircularList {

	private Node first;
	private Node last;
	private Node current;
	private int totalItems;
	public CircularList getCurrent;

	public CircularList() {
		first = null;
		setLast(null);
		current = null;
		totalItems = 0;
	}

	public Node getCurrent() {
		return current;
	}

	public Node getFirst() {
		return first;
	}

	public Node getLast() {
		return last;
	}

	public void setLast(Node last) {
		this.last = last;
	}

	/**
	 * Checks if list is empty.
	 *
	 * @return true, if is empty.
	 */
	public boolean isEmpty() {
		return first == null;
	}

	/**
	 * Next of the current node.
	 */
	public void next() {
		current = current.getNext();
	}

	/**
	 * Insert the node to the linked list.
	 *
	 * @param data    the data
	 */
	public void insert(int data) {
		Node newNode = new Node(data);

		if (isEmpty()) {
			first = newNode;
			current = first;
		} 
		else {
			current.setNext(newNode);
		}

		newNode.setNext(first);
		setLast(newNode);
		next();
		totalItems++;
	}

	/**
	 * Delete a node from the list.
	 *
	 * @param data    the data
	 */
	public void delete(int data) {
		Node prev = first;
		Node curr = first.getNext();

		while (curr.getData() != data) {
			prev = curr;
			curr = curr.getNext();

		}

		if (totalItems == 1) {
			first = null;
			totalItems--;
		} 
		else if (curr == first) {
			prev.setNext(curr.getNext());
			first = curr.getNext();
			totalItems--;
		} 
		else {
			prev.setNext(curr.getNext());
			totalItems--;
		}

	}

	/**
	 * Display list.
	 */
	public void displayList() {
		int count = 0;
		Node pointer = first;

		while (count < totalItems) {
			System.out.print(pointer.getData() + " ");
			pointer = pointer.getNext();
			count++;
		}
		System.out.println("");
	}
}