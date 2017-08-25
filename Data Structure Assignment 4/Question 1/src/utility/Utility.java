package utility;

import jobprinter.Task;
import queue.Queue;

/**
 * The Utility class for heap.
 * 
 * @author Neel Singhal
 */
public class Utility {
	private static int size;

	/**
	 * Sort the job using heap sort.
	 * 
	 * @param jobs    jobs to print.
	 */
	public static void sort(Queue<Task> jobs) {
		Object arr[] = jobs.toArray();
		try {
			size = arr.length - 1;
			heapify(arr);
			for (int index = size; index >= 0; index--) {
				swap(arr, 0, index);
				maxheap(arr, 0);
			}
			// Again putting the data into the queue.
			jobs.makeEmpty();
			size = arr.length;
			for (int index = 0; index < size; index++) {
				jobs.enqueue(arr[index]);
			}
		}
		catch (Exception e) {
			System.out.println("Error caught " + e.getMessage());
		}
	}

	/**
	 * Used to heapify the max heap.
	 * 
	 * @param array    array of object.
	 */
	private static void heapify(Object array[]) {
		size = array.length - 1;
		for (int index = size / 2; index >= 0; index--) {
			maxheap(array, index);
		}
	}

	/**
	 * Makes a max heap.
	 * 
	 * @param array    array of object.
	 * @param index    index of the parent.
	 */
	private static void maxheap(Object array[], int index) {
		int left = 2 * index;
		int right = 2 * index + 1;
		int max = index;
		// Check if left child is greater than parent.
		if (left <= size && ((Comparable<Task>) array[left]).compareTo((Task) array[index]) > 0) {
			max = left;
		}
		// Check if right child is greater than parent.
		if (right <= size && ((Comparable<Task>) array[right]).compareTo((Task) array[max]) > 0 ) {
			max = right;
		}
		// If max is changed than swap the values.
		if (max != index) {
			swap(array, index, max);
			maxheap(array, max);
		}
	}

	/**
	 * Swap two objects.
	 * 
	 * @param array        array of objects.
	 * @param index        index of first element.
	 * @param swapIndex    index of second element to swap.
	 */
	private static void swap(Object array[], int index, int swapIndex) {
		Object tmp = array[index];
		array[index] = array[swapIndex];
		array[swapIndex] = tmp;
	}
}
