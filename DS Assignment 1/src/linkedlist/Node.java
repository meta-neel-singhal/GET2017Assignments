package linkedlist;

/**
 * The Class Node.
 *
 * @author Neel Singhal
 *
 * @param <T> the element type
 */
public class Node<T> {
	
	T data;
	Node<T> next;

	/**
	 * Next of a node.
	 *
	 * @return the node
	 */
	public Node<T> next() {
		return this.next;
	}

	/**
	 * Gets the data of a node.
	 *
	 * @param data    data of the node.
	 * @return the node
	 */
	public Node<T> getNode(T data) {
		Node<T> node = new Node<T>();
		node.data = data;
		node.next = null;
		
		return node;
	}
}
