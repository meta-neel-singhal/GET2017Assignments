package linkedlist;

/**
 * Contains all the operations of the singly linked list.
 * 
 * @author Neel Singhal
 *
 * @param <T>     Generic data type.
 */
public class SinglyLinkedList<T> {

	Node<T> head = null;
	Node<T> node = new Node<T>();
	static int size = 0;

	/**
	 * Adds the node at location.
	 *
	 * @param location    location of the list where the data is to be added.
	 * @param data        data to be added in list.
	 * @return true, if successful
	 */
	public boolean addNodeAtLocation(int location, T data) {
		Node<T> newNode = node.getNode(data);
		Node<T> temp = this.head;
		Node<T> prev = null;
		boolean flag = false;
		if (location == 1) {
			newNode.next = temp;
			this.head = newNode;
			size++;
			flag = true;
		}
		else {
			while (temp != null) {
				location--;
				if (location == 0) {
					prev.next = newNode;
					newNode.next = temp;
					size++;
					flag = true;
				}
				prev = temp;
				temp = temp.next();
			}
		}
		return flag;	
	}

	/**
	 * Gets the size of the list.
	 *
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Adds the node to the list.
	 *
	 * @param data    data of the node to be added.
	 */
	public void addNode(T data) {
		if (size == 0) {
			Node<T> newNode = node.getNode(data);
			this.head = newNode;
		} 
		else {
			Node<T> newNode = node.getNode(data);
			Node<T> temp = this.head;
			while (temp.next() != null) {
				temp = temp.next();
			}
			temp.next = newNode;
		}
		size++;
	}

	/**
	 * Removes the item from the list.
	 *
	 * @param data    data of the node to be removed.
	 * @return true, if successful.
	 */
	public boolean removeItem(T data) {
		Node<T> temp = this.head;
		Node<T> prev = null;
		boolean flag = false;
		if (head.data.equals(data)) {
			head = head.next();
			size--;
			flag = true;
		} 
		else {
			while (temp != null) {
				if (temp.data.equals(data)) {
					prev.next = temp.next();
					size--;
					flag = true;
				}
				prev = temp;
				temp = temp.next();
			}
		}
		return flag;
	}

	/**
	 * Removes the item from a specified position.
	 *
	 * @param location    location from where node is to be deleted.
	 * @return true, if successful
	 */
	public boolean removeItemFromPosition(int location) {
		Node<T> temp = this.head;
		Node<T> prev = null;
		int index = 0;
		boolean flag = false;
		if (location == 0) {
			this.head = this.head.next();
			size--;
			flag = true;
		} 
		else {
			while (temp != null) {
				if (index == location) {
					prev.next = temp.next();
					size--;
					flag = true;
				}
				index++;
				prev = temp;
				temp = temp.next();
			}
		}
		return flag;
	}

	/**
	 * Gets the element from a specified position.
	 *
	 * @param location    location of the required node.
	 * @return the element at position.
	 */
	public T getElementFromPosition(int location) {
		Node<T> temp = this.head;
		int index = 0;
		while (temp != null) {
			if (index == location) {
				return temp.data;
			}
			temp=temp.next();
			index++;
		}
		return (T) "-1";
	}

	/**
	 * Reverse linked list.
	 */
	public void reverseLinkedList() {
		Node<T> temp = this.head;
		Node<T> newHead = null;
		while (head != null) {
			temp = head;
			head = head.next();
			temp.next = newHead;
			newHead = temp;
		}
		head = newHead;
	}

	/**
	 * Sort linked list.
	 */
	public void sort() {
		Node<T> temp1 = this.head;
		Node<T> temp2 = null;
		while( temp1 != null) {
			temp2 = temp1.next();
			while (temp2 != null) {
				if (temp1.data.toString().compareTo(temp2.data.toString()) > 0) {
					T temp = temp1.data;
					temp1.data = temp2.data;
					temp2.data = temp;
				}
				temp2 = temp2.next();
			}
			temp1 = temp1.next();
		}
	}
}
