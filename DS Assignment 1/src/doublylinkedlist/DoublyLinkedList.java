package doublylinkedlist;

/**
 * The Class for Doubly Linked List.
 *
 * @author Neel Singhal
 * 
 * @param <T> the element type
 */
public class DoublyLinkedList<T> {

	Node<T> head = null;
	Node<T> node = new Node<T>();
	static int size = 0;


	/**
	 * Adds the node at a specified location.
	 *
	 * @param location    location where node is to added.
	 * @param data        data of the node to be added.
	 * @return true, if successful
	 */
	public boolean addNodeAtLocation(int location, T data) {
		Node<T> newNode = node.getNode(data);
		Node<T> temp = this.head;
		int index = 2;
		boolean flag = false;
		if (location == 1) {
			newNode.next = temp;
			if(temp != null){
				temp.previous = newNode;
			}
			this.head = newNode;
			size++;
			flag = true;
		}
		else {
			while (temp != null) {		
				if (index == location) {
					newNode.previous = temp;
					newNode.next = temp.next();
					if (temp.next != null) {
						temp.next.previous = newNode;
					}
					temp.next = newNode;
					size++;
					flag = true;
				}
				index++;
				temp=temp.next();
			}	
		}
		
		return flag;	
	}

	/**
	 * Gets the size of linked list.
	 *
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Adds the node to the linked list.
	 *
	 * @param data    data of the node to be added.
	 */
	public void addNode(T data) {
		Node<T> newNode = node.getNode(data);
		if (size == 0) {
			this.head = newNode;
		}
		else {
			Node<T> temp = this.head;
			while (temp.next() != null) {
				temp = temp.next();
			}
			newNode.previous = temp;
			temp.next = newNode;
		}
		size++;
	}

	/**
	 * Removes the item from the linked list.
	 *
	 * @param data    data of the node to be deleted.
	 * @return true, if successful
	 */
	public boolean removeItem(T data) {
		Node<T> temp = this.head;
		boolean flag = false;
		if ( size > 0 && head.data.equals(data)) {
			head = head.next();
			if(head != null){
				head.previous = null;
			}
			size--;
			flag = true;
		}
		else {
			while (temp != null) {
				if (temp.data.equals(data)) {
					temp.previous.next = temp.next();
					if (temp.next != null) {
						temp.next.previous = temp.previous();	
					}
					size--;
					flag = true;
				}
				temp = temp.next();
			}
		}
		
		return flag;
	}

	/**
	 * Removes the item from a specified position.
	 *
	 * @param location    location of the node to be deleted.
	 * @return true, if successful
	 */
	public boolean removeItemFromPosition(int location) {
		Node<T> temp = this.head;
		int index = 0;
		boolean flag = false;
		if (location == 0 && size > 0) {
			this.head = this.head.next();
			if (head != null) {
				head.previous = null;
			}
			size--;
			flag = true;
		}
		else {
			while (temp != null) {
				if (index == location) {
					temp.previous.next = temp.next();
					if(temp.next != null){
						temp.next.previous = temp.previous();
					}
					size--;
					flag = true;
				}
				index++;
				temp = temp.next();
			}
		}
		
		return flag;
	}

	/**
	 * Gets the element from a specified position.
	 *
	 * @param location    location of the required element.
	 * @return the element from the position
	 */
	public T getElementFromPosition(int location) {
		Node<T> temp = this.head;
		int index = 0;
		while (temp != null) {
			if (index == location) {
				return temp.data;
			}
			temp = temp.next();
			index++;
		}
		
		return (T) "-1";
	}

	/**
	 * Reverse linked list.
	 */
	public void reverseLinkedList() {
		Node<T> temp = null;
		Node<T> current = head;

		while (current != null) {
			temp = current.previous();
			current.previous = current.next;
			current.next = temp;
			current = current.previous();
		}
		/* Before changing head, check for the cases like empty 
         list and list with only one node */
		if (temp != null) {
			head = temp.previous();
		}
	}

	/**
	 * Sort linked list.
	 */
	public void sort() {
		Node<T> temp1 = this.head;
		Node<T> temp2 = null;
		while ( temp1 != null ) {
			temp2 = temp1.next();
			while (temp2 != null) {
				if ( temp1.data.toString().compareTo(temp2.data.toString()) > 0 ) {
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
