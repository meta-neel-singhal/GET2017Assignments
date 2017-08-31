package sorting;

/**
 * Class to perform Linear sorting using either:
 * 1. Radix Sort
 * 2. Counting Sort
 * 
 * @author Neel Singhal
 */
public class LinearSort {

	/**
	 * Performs Radix sort by initially sorting the elements on the basis
	 * of their unit's digit, then further sorting the obtained array on 
	 * the basis of their hundred's digit and so on.
	 * 
	 * @param array    array to be sorted.
	 * @param max      maximum element of the array.
	 * @return the sorted array.
	 */
	public static int[] radixSort(int[] array, int max) {
		/*
		 * Invokes Counting sort to sort each element of the array using
		 * radix sort principle.
		 */
		for (int count = 1; max / count > 0; count *= 10) {
			array = countingSort(array, array.length, 9, count, 10); 
		}
		
		return array;
	}

	/**
	 * Operates by counting the number of integers that have each distinct key value,
	 * and using arithmetic on those counts to determine the positions of each key value
	 * in the output sequence.
	 * 
	 * @param array       array to be sorted.
	 * @param length      length of the array.
	 * @param max	      maximum element of the array.
	 * @param exponent    helps to perform count sort specifically.	
	 * @return the sorted array.
	 */
	public static int[] countingSort(int[] array, int length, int max, int exponent, int mod) {
		int[] countArray = new int[max + 1];
		int[] sortedArray;
		// Store the count of each unique object.
		for (int count = 0; count < length; count++) {
			countArray[(array[count] / exponent) % mod]++;
		}
		/*
		 * Modify the count array such that each element at each index 
		 * stores the sum of previous counts.
		 */
		for (int count = 1; count < countArray.length; count++) {
			countArray[count] += countArray[count - 1];
		}
		
		sortedArray = new int[length];
		// Output each element from the input sequence and then decreasing its count by 1.
		for (int count = length - 1; count >= 0; count--) {
			sortedArray[--countArray[(array[count] / exponent) % mod]] = array[count];
		}
		
		return sortedArray;
	}
}
