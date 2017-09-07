package queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Implements the custom queue.
 * 
 * @author Neel Singhal
 *
 * @param <E>    Generic data type.
 */
public class CustomQueue<E> {
	Queue<E> queue ;
	
	/**
	 * Makes the custom queue using linked list.
	 */
	public CustomQueue() {
		queue = new LinkedList<E>();
	}

	/**
	 * Add an element to the queue.
	 * 
	 * @param data    the data to add.
	 * @return true when enqueue is performed.
	 */
	public boolean enqueue(E data) {
		queue.add(data);
		return true;
	}

	/**
	 * Removes an element from the queue.
	 * 
	 * @return the element removed from the queue.
	 */
	public E dequeue() {
		E element = queue.poll();
		return element;
	}

	/**
	 * Gets the front of the queue without removing it.
	 * 
	 * @return the element at front of the queue.
	 */
	public E peek() {
		E element = queue.peek();
		return element;
	}

	/**
	 * Prints the queue.
	 * 
	 * @return the string.
	 */
	public String print() {
		System.out.println(queue.toString());
		return queue.toString();
	}

	/**
	 * Clears the queue.
	 * 
	 * @return true when queue is cleared.
	 */
	public boolean clearQueue() {
		queue.clear();
		return true;
	}
	
	/**
	 * Checks if the queue is empty.
	 * 
	 * @return true if queue is empty.
	 */
	public boolean isEmpty() {
		boolean flag = queue.isEmpty();
		return flag;
	}
}
