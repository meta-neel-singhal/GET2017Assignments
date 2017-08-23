package queue;

import java.util.Arrays;

/**
 * Queue Implementation.
 * 
 * @author Neel Singhal
 *
 * @param <T>    Generic data type.
 */
public class Queue<T> {

	private static final int MAX = 5;
	private Object[] array;
	private int front;
	private int rear;

	/**
	 * Parameterized constructor.
	 * 
	 * @param capacity    capacity of the queue.
	 */
	public Queue(int capacity) {
		if (capacity < 0) {
			throw new IllegalArgumentException("Illegal Capacity: " + capacity);
		}
		array = new Object[capacity];
		front = 0;
		rear = 0;
	}

	/**
	 * Default Constructor.
	 */
	public Queue() {
		array = new Object[10];
		front = 0;
		rear = 0;
	}

	/**
	 * Adds an item to queue.
	 * 
	 * @param item    item to add in the queue.
	 * @return true. if the element is added.
	 */
	public boolean enqueue(T item) {
		if ((rear - array.length + 1) > 0) {
			growCapacity();
		}
		array[rear++] = item;

		return true;
	}

	/**
	 * Removes an element from queue.
	 * 
	 * @return the removed element from queue.
	 */
	public T dequeue() {
		if (front == rear) {
			throw new IndexOutOfBoundsException("Queue Underflow");
		}

		return (T) array[front++];
	}

	/**
	 * Makes the queue empty.
	 * 
	 * @return true when queue is empty.
	 */
	public boolean makeEmpty() {
		front = 0;
		rear = 0;

		return true;
	}

	/**
	 * Gets the element at front.
	 * 
	 * @return the front element.
	 */
	public T getFront() {

		return (T) array[front];
	}

	/**
	 * Increases the capacity of the array whenever required.
	 * 
	 * @param minCapacity
	 */
	public void growCapacity() {
		array = Arrays.copyOf(array, array.length + MAX);
	}

	/**
	 * Check if the queue is empty.
	 * 
	 * @return true, if the queue is empty.
	 */
	public boolean isEmpty(){
		boolean flag = false;
		if (rear == front) {
			flag = true;
		}

		return flag;
	}

	/**
	 * Gets the size of the queue.
	 * 
	 * @return size of queue
	 */
	public int getSize() {
		int size = rear - front ;

		return size;
	}

	/**
	 * Print the whole queue.
	 */
	public void print() {
		for (int count = front; count < rear; ++count) {
			System.out.println(array[count]);
		}
	}	
}