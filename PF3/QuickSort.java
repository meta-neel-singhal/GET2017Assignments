/**
 * Sort the given array in ascending order using quick sort.
 * 
 * @author Neel Singhal
 */
public class QuickSort {

	/**
	 * Sort an array by using a pivot value and divides the list into
	 * two parts. And recursively, dividing whole array into sub-lists 
	 * until all lists contains only one element.
	 * 
	 * @param array           array to be sorted.
	 * @param leftPointer     points to the lower index.
	 * @param rightPointer    points to the upper index.
	 * @return array          sorted array.
	 */
	public int[] quickSort (int[] array, int leftPointer, int rightPointer) {
		// Checks if array is not empty and applies quick sort on the array.
		if (leftPointer < rightPointer) {
			int partitionIndex = getPartitionIndex(array, leftPointer, rightPointer);
			// Sorts first half of the array.
			quickSort(array, partitionIndex + 1, rightPointer);
			// Sort second half of the array.
			quickSort(array, leftPointer, partitionIndex - 1);
		}
		
		return array;
	}
	
	/**
	 * Finds partition index of the array to be partitioned.
	 * 
	 * @param array			  Array to be partitioned.
	 * @param leftPointer     Lower index of array.
	 * @param rightPointer    Upper index of array.
	 * @return partitionIndex    Partition index of the array.
	 */
	int getPartitionIndex (int[] array, int leftPointer, int rightPointer) {
		int partitionIndex = leftPointer - 1;
		int pivot = array[rightPointer]; // Stores pivot element.
		int count; // Used as counter.
		
		for (count = leftPointer; count < rightPointer; count++) {
			if (array[count] < pivot) {
				partitionIndex++;
				swap(array, count, partitionIndex);
			}
		}
		swap(array, rightPointer, partitionIndex + 1);
		
		return partitionIndex + 1;
	}
	
	/**
	 * Swap two values in an array.
	 * 
	 * @param array          Array in which swapping is done.
	 * @param firstIndex     Index of first element.
	 * @param secondIndex    Index of second element.
	 */
	void swap(int[] array, int firstIndex, int secondIndex) {
		// Stores first element into a temporary variable.
		int temp = array[firstIndex];
		array[firstIndex] = array[secondIndex];
		array[secondIndex] = temp;
	}	        
}
