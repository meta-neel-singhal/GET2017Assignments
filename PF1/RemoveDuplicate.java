/**
 * Remove duplicate elements from an unsorted array
 * @author Neel
 */
public class RemoveDuplicate {
	/**
	 * Remove duplicate elements from an array by taking a new array and 
	 * filling it by non recurring values.
	 * @param input array
	 * @return result array with removed duplicate values
	 */
	public int[] removeDuplicate(int input[]) {

		int len = input.length;
		int flag = 0; // check for duplicate element (flag=1 for duplicate elements)
		int newsize = 1; // length for result array
		int[] output = new int[input.length]; //array for storing dissimilar elements
		output[0] = input[0]; // copy first element from input array to output array 

		// insert dissimilar elements from input array to output array
		for (int i = 1; i < len; i++) {
			flag = 0;
			for (int j = 0; j < newsize; j++) {
				//checking duplicate elements
				if (input[i] == output[j]) {
					flag = 1;
					break;
				}
			}
			if (flag == 0) {

				output[newsize] = input[i]; // copying dissimilar elements into output array
				newsize++;
			}
		}

		int[] result = new int[newsize]; // array for storing final array of length = size
		// copy output array to result array 
		for(int i = 0; i < newsize; i++) {

			result[i] = output[i];
		}

		return result; // returns final array with non repeating elements

	}

}
