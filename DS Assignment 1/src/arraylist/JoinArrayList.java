package arraylist;

/**
 * Join two array lists.
 * 
 * @author Neel Singhal
 *
 * @param <T>    Generic data type.
 */
public class JoinArrayList<T> extends MyArrayList<T> {

	/**
	 * Join two array lists.
	 *
	 * @param firstList 	First list to which second list will be added.
	 * @param secondList    Second list to be added in the first list.
	 */
	public void joinTwoArrayLists(MyArrayList<T> firstList, MyArrayList<T> secondList) {
		int size = secondList.getSize();
		for (int index = 0; index < size; index++) {
			firstList.addElement(secondList.getElementByPosition(index));
		}
	}

}