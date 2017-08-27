package queue;

import java.util.Arrays;

/**
 * The class used to implement the queue.
 *
 * @author Neel Singhal
 */
public class Queue<T extends Object> {
	final static int MAX = 5;

	// Store elements of queue.
	private Object[] elementData;
	private int size = 0;
	private int front = 0;
	private int rear = -1;

	/**
	 * Constructs an empty queue with the specified initial capacity.
	 *
	 * @param capacity     the initial capacity of the queue
	 */
	public Queue(int capacity) {
		if (capacity < 0) {
			throw new IllegalArgumentException("Illegal Capacity: " + capacity);
		}
		this.elementData = new Object[capacity];
	}

	/**
	 * Default Constructor.
	 */
	public Queue() {
		this(10);
	}

	/**
	 * Returns the number of elements in this queue.
	 *
	 * @return the number of elements.
	 */
	public int size() {
		return size;
	}

	/**
	 * Increases the capacity of the array whenever required.
	 */
	public void growCapacity() {
		elementData = Arrays.copyOf(elementData, elementData.length + MAX);
	}

	/**
	 * Adds an item to queue.
	 *
	 * @param item    item to add in the queue.
	 */
	public void enqueue(Object item) {
		if ((rear - elementData.length + 1) > 0) {
			growCapacity();
		}
		elementData[++rear] = item;

		size++;
	}

	/**
	 * Deletes an element from queue
	 *
	 * @return the removed element from queue.
	 */
	public T dequeue() {
		T oldValue = null;
		try {
			if (size == 0) {
				throw new IndexOutOfBoundsException("Queue is Empty");
			}
			oldValue = (T) elementData[front];
			elementData[front++] = null;
			size--;
			if (size == 0) {
				front = 0;
				rear = -1;
			}
		}
		catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}

		return oldValue;
	}

	/**
	 * Clears the queue.
	 */
	public void makeEmpty() {
		while (size != 0) {
			dequeue();
		}
		front = 0;
		rear = -1;
	}

	/**
	 * Returns the array of queue elements.
	 * 
	 * @return the array.
	 */
	public Object[] toArray() {
		return Arrays.copyOf(elementData, size);
	}
}