package queue;

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
	 * @param initialCapacity of the array list.
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
	 * Adds the.
	 *
	 * @param element the element
	 * @return true if element is added
	 * 
	 * this method adds an element e(value) to mergedList
	 */
	public boolean add(T element) {
		ensureCapacity(size + 1);
		array[size++] = element;

		return true;
	}

	/**
	 * Gets the element.
	 *
	 * @param location the location
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
	 * Overwrite element.
	 *
	 * @param location the location
	 * @param newValue the new value
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
	 * Ensure capacity.
	 *
	 * @param minCapacity this method checks if the capacity is less and grows the capacity of array
	 */
	public void ensureCapacity(int minCapacity) {
		// if capacity is less then grow the capacity 
		if (minCapacity - array.length > 0) {
			growCapacity();
		}
	}

	/**
	 * Gets the size.
	 *
	 * @return size of array
	 */
	public int getSize() {

		return size;
	}

	/**
	 * Grow capacity.
	 *
	 * @param minCapacity this method increases the capacity of array by making a new array with increased capacity
	 * and transferring the old array into new one
	 */
	public void growCapacity() {
		array = Arrays.copyOf(array, array.length + MAX);
	}

	/**
	 * Check for range.
	 *
	 * @param index This method checks the range of index
	 */
	public void checkForRange(int index) {
		if (index > size && index < 0) {
			throw new ArrayIndexOutOfBoundsException("index: " + index + "size: " + size);
		}
	}
}