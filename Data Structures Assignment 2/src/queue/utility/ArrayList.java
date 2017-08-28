package queue.utility;

import java.util.Arrays;

/**
 * Support all operations related to ArrayList.
 * 
 * @author Neel Singhal
 *
 * @param <T>    Generic data type.
 */
public class ArrayList<T> {
	private static final int MAX = 5;
	private int size;
	private Object[] array;

	/** 
	 * Parameterized Constructor.
	 * 
	 * @param initialCapacity    initial capacity of the array list.
	 */
	public ArrayList(int initialCapacity) {
		if (initialCapacity < 0) {
			throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
		}
		this.array = new Object[initialCapacity];
	}

	/**
	 * Default Constructor.
	 */
	public ArrayList() {
		this.array = new Object[10];
	}

	/**
	 * Adds the element to the array list.
	 *
	 * @param element    the element to add.
	 * @return true if element is added.
	 */
	public boolean add(T element) {
		ensureCapacity(size + 1);
		array[size++] = element;

		return true;
	}

	/**
	 * Gets the element at a specified location.
	 *
	 * @param location    the location to get.
	 * @return element at a particular index
	 */
	public T getElement(int location) {
		// check if index is in range else throw IndexOutOfBounds exception
		if (location > size - 1 || location < 0) {
			throw new IndexOutOfBoundsException("location: " + location + "," + "size: " + size);
		}

		return (T) array[location];
	}

	/**
	 * Overwrite element at a location with a new element.
	 *
	 * @param location    the location of element to change.
	 * @param newValue    the value of new element..
	 * @return true, if successful
	 */
	public boolean overwriteElement(int location, T newValue) {
		if (location > size - 1 || location < 0) {
			throw new IndexOutOfBoundsException("location: " + location + "," + "size: " + size);
		}
		array[location] = newValue;

		return true;
	}

	/**
	 * Checks if the capacity is less and grows the capacity of array.
	 *
	 * @param minCapacity    to check if the capacity needs to be increased. 
	 */
	public void ensureCapacity(int minCapacity) {
		// If capacity is less then grow the capacity. 
		if (minCapacity - array.length > 0) {
			growCapacity();
		}
	}

	/**
	 * Gets the size of the list.
	 *
	 * @return size of array
	 */
	public int getSize() {

		return size;
	}

	/**
	 * Increases the capacity of array.
	 */
	public void growCapacity() {
		array = Arrays.copyOf(array, array.length + MAX);
	}
}