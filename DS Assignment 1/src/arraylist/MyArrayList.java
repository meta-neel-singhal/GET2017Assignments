package arraylist;

/**
 * The Class MyArrayList.
 *
 * @author Neel Singhal
 *
 * @param <T> the element type
 */
public class MyArrayList<T> {

	Object[] array = null;
	final static int MAX = 5;

	/**
	 * Instantiates a new my array list.
	 */
	public MyArrayList() {
		array = new Object[MAX];
	}

	/**
	 * Adds the element.
	 *
	 * @param element    Element to be added.
	 */
	public void addElement(T element) {
		if (getSize() == array.length) {
			this.array = resize(this.array);
		} 
		int index = getSize();
		array[index] = element;
	}

	/**
	 * Sets the element at specified position.
	 *
	 * @param index      index where element is to be added.
	 * @param element    element to be added.
	 * @return true, if successful
	 */
	public boolean addElementByIndex(int index, T element) {
		boolean flag;
		if (index > getSize()) {
			flag = false;
		}
		else {
			if (getSize() == array.length) {
				array = resize(array);
			}
			for (int count = getSize() - 1; count >= index; count--) {
				array[count + 1] = array[count];
			}
			array[index] = element;
			flag = true;
		}

		return flag;
	}

	/**
	 * Resize the array when it gets full.
	 *
	 * @param array    array list.
	 * @return the new array list.
	 */
	public Object[] resize(Object[] array) {
		Object[] newArray = new Object[array.length + MAX];
		for (int index = 0; index < array.length; index++) {
			newArray[index] = array[index];
		}

		return newArray;
	}

	/**
	 * Gets the size of the array list.
	 *
	 * @return the size of the array list.
	 */
	public int getSize() {
		int index = 0;
		for (index = 0; index < this.array.length; index++) {
			if (array[index] == null) {
				break;
			}
		}

		return index;
	}

	/**
	 * Gets the element.
	 *
	 * @param element    element to search.
	 * @return the element
	 */
	public int getElement(T element) {
		int index;
		for (index = 0; index < getSize(); index++) {
			if ((array[index]).equals(element)) {
				return index + 1;
			}
		}

		return -1;
	}

	/**
	 * Removes the element from position.
	 *
	 * @param position    position from which element is to be removed.
	 * @return true, if successful
	 */
	public boolean removeElementFromPosition(int position) {
		boolean flag = true;
		if (position >= getSize()) {
			flag = false;
		}
		else {
			for (int index = position; index < getSize() - 1; index++) {
				array[index] = array[index + 1];
			}
			array[getSize() - 1] = null;
			flag = true;
		}

		return flag;
	}

	/**
	 * Removes the element.
	 *
	 * @param element    element to delete.
	 * @return true, if successful
	 */
	public boolean removeElement(T element) {
		boolean flag = false;
		for (int index = 0; index < getSize(); index++) {
			if ((array[index]).equals(element)) {
				for (int count = index; count < getSize() - 1; count++) {
					array[count] = array[count + 1];
				}
				array[getSize() - 1] = null;
				flag = true;
			}
		}

		return flag;
	}

	/**
	 * Clear array list.
	 */
	public void deleteAllElements() {
		Object[] newArray = new Object[MAX];
		array = newArray;
	}

	/**
	 * Reverse array list.
	 */
	public void reverseArrayList() {
		Object[] newArray = new Object[array.length];
		int count = 0;
		for (int index = getSize() - 1 ; index >= 0  ; index--) {
			newArray[count++] = array[index];
		}
		this.array = newArray;
	}

	/**
	 * Gets the element by position.
	 *
	 * @param position    position of the element to be found.
	 * @return the element at position
	 */
	public T getElementByPosition(int position) {
		return (T) array[position];
	}

	/**
	 * Prints the array list.
	 *
	 * @return the object[]
	 */
	public Object[] printArrayList() {
		return this.array;
	}

	/**
	 * Sort array list.
	 */
	public void sortArrayList() {
		for (int index = 0; index < getSize() ; index++) {
			for (int count = index + 1; count < getSize(); count++) {
				if (((Comparable<T>) array[index]).compareTo((T) array[count]) > 0) {
					Object temp = array[count];
					array[count] = array[index];
					array[index] = temp;
				}
			}
		}
	}
}
