package binarysearch;

/**
 * Searches a number in a array using binary search algorithm 
 * assuming that the array is sorted.
 * 
 * @author Neel Singhal
 */
public class BinarySearch {

	/**
	 * Checks if the element is present in the array or not by dividing
	 * the searching area of the array into two sub-arrays and then
	 * comparing its middle value to the element to be searched. If 
	 * present, it will return the location of the element otherwise it
	 * will return 0.
	 * 
	 * @param  array         array to be searched.
	 * @param  lowerBound    lower bound of the array.
	 * @param  upperBound    upper bound of the array.
	 * @param  element       element to be searched.
	 * @return location      location of the element to be searched.
	 */
	public int findElement (int[] array, int lowerBound, int upperBound, int element) {
		int begin = lowerBound,
				end = upperBound,
				middle = (begin + end) / 2,
				location = middle;

		// Checks if the array search is complete and if the element is found or not.
		if (begin <= end && array[middle] != element) {
			// If element to be searched is smaller than the middle value.
			if (element < array[middle]) {
				end = middle - 1;
			}
			// If element to be searched is larger than the middle value.
			else {
				begin = middle + 1;
			}
			location = findElement(array, begin, end, element);
		}
		// Checks if element is not present in the array.
		else if (array[location] != element) {
			location = -1;
		}
		else {
			//Sets location of the element if it is found.
			if (location != 0 && array[location - 1] == element) {
				location = findElement(array, 0, location - 1, element);
			}
		}

		return location;
	}
}	