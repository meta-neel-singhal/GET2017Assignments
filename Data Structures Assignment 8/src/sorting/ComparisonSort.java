package sorting;

/**
 * Class to perform Comparison sorting using either:
 * 1. Bubble Sort
 * 2. Quick Sort
 * 
 * @author Neel Singhal
 */
public class ComparisonSort {

	/**
	 * Sort an array by repeatedly swapping the adjacent elements if 
	 * they are in wrong order.
	 * 
	 * @param array    array to be sorted.
	 * @return the sorted array.	   
	 */
	public static int[] bubbleSort(int[] array) {
		int next, 
			index,
			size = array.length;
		
		for (int count = 0; count < size - 1; count++) {
			for (index = 0; index < size - count - 1; index++) {
				next = index + 1;
				if (array[index] > array[next]) {
					swap(array, index, next);
				}
			}
		}
		return array;
	}
	
	/**
	 * Sort an array by using a pivot value and divides the list into
	 * two parts. And recursively, dividing whole array into sub-lists 
	 * until all lists contains only one element.
	 * 
	 * @param array           array to be sorted.
	 * @param leftPointer     points to the lower index.
	 * @param rightPointer    points to the upper index.
	 * @return the sorted array.
	 */
	public static int[] quickSort (int[] array, int leftPointer, int rightPointer) {
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
	private static int getPartitionIndex (int[] array, int leftPointer, int rightPointer) {
		int partitionIndex = leftPointer - 1;
		int pivot = array[rightPointer];
		int count;
		
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
	 * Swap two elements of the array.
	 * 
	 * @param array    array whose elements are to be swapped.
	 * @param index	   index of first value to be swapped.
	 * @param next	   index of the next value to be swapped.
	 */
	private static void swap(int[] array, int index, int next) {
		int temp = array[index];
		array[index] = array[next];
		array[next] = temp;
	}
}

