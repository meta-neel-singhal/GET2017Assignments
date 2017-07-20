/**
 * Searches a number in a array using linear search algorithm.
 * 
 * @author Neel Singhal
 */
public class LinearSearch {

	/**
	 * Checks if the element is present in the array or not, by checking
	 * all the elements of the array in a linear manner. If present, it 
	 * will return the location of the element otherwise it will return 0.
	 * 
	 * @param  array       array to be searched.
	 * @param  size        size of the array.
	 * @param  element     element to be searched.
	 * @param  location    location to start search.
	 * @return finalLocation    location of the element to be searched.
	 */
	public int findElement (int[] array, int size, int element, int location) {

		int finalLocation = 0;
		// Checks if the location to be searched does not exceed the array size.
		if (location <= size){
			// Increment in location and use recursion when element is not found.
			if (array[location - 1] != element) {
				location++ ;
				finalLocation = findElement(array, size, element, location);
			}
			// Sets the final location of element if it is found.
			else {
				finalLocation = location;
			}
		}
		// Sets final location to 0 if element is not found.
		else {
			finalLocation = 0;
		}

		return finalLocation;
	}
}
