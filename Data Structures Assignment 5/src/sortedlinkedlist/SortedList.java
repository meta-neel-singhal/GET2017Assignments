package sortedlinkedlist;

import java.util.LinkedList;
import java.util.List;

/**
 * The Class SortedList.
 * 
 * @author Neel Singhal
 */
public class SortedList {
	public static List<Integer> sortedList = new LinkedList<>();
	public static int position = 0;

	/**
	 * Add the data in list.
	 * 
	 * @param data    the data to add
	 */
	public static void add(int data) {
		getPosition(data);
		// If position is less than the size of the list then add the data to the position.
		if (position < sortedList.size()) {
			sortedList.add(position, data);
		} 
		else {
			sortedList.add(data);
		}

		position = 0;
	}

	/**
	 * Gets the position.
	 * 
	 * @param data the data
	 * @return the position
	 */
	public static void getPosition(int data) {
		int compare;
		// If position is less than the size of List.
		if (position < sortedList.size()) {
			/**
			 * Determining the order by comparing the value stored at position 
			 * to the data which has to be inserted.
			 */
			compare = sortedList.get(position).compareTo(data);
			// If the value stored at position is lesser than the value to be inserted
			if (compare < 0) {
				// Increment the position.
				position++;
				// Again call the data to be inserted.
				getPosition(data);
			}
		}
	}	
}
