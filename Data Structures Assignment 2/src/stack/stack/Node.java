package stack.stack;

/**
 * Defines a Node of the stack.
 *
 * @author Neel Singhal
 *
 * @param <T> the element type
 */
public class Node<T> {
	
	public T data;
	Node<T> previous;
	

	/**
	 * Previous of a node.
	 *
	 * @return the node
	 */
	public Node<T> previous() {
		return this.previous;
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
		node.previous = null;
		
		return node;
	}
}
