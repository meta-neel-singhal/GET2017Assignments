/**
 * Checks if an array is sorted or not and if sorted, it also provides 
 * the way in which it is sorted.
 * @author Neel
 */
public class CheckSorted {
	/**
	 * Checks if an array is sorted or not. Initially compares first and last value of array to
	 * check the possibility of being sorted.
	 * Then if the whole array follow a fixed pattern flag is initialized according to it.
	 * @param input is the given array
	 * @return flag value based on which array will be judged
	 */

	public int checkSorted (int input[]) {
		int size = input.length; // Gives size of input array
		int flag=0; // Helps to judge an array
		// Tests if array may be ascending or not
		if (input[0] < input[size - 1]) {
			for (int i = 0; i < size - 1; i++) {
				if (input[i] <= input[i+1]) {
					flag = 1; // 1 implies ascending sequence
					continue;
				}
				else {
					flag = 0; // 0 implies unsorted sequence
					break;
				}
			}
		}
		// Tests if array may be descending or not
		else if (input[0] > input[size - 1]) {
			for (int i = 0; i < size - 1; i++) {
				if (input[i] >= input[i + 1]) {
					flag = 2; // 0 implies descending sequence
					continue;
				}
				else{
					flag = 0; // 0 implies unsorted sequence
					break;
				}
			}
		}
		// Below is a special case handled for a constant array.
		else if (input[0] == input[size - 1]) {
			for (int i = 1; i < size - 1; i++) {
				if (input[i] == input[i + 1]) {
					flag = 3; // 0 implies constant sequence
					continue;
				}
				else {
					flag = 0; // 0 implies unsorted sequence
					break;
				}
			}
		}

		return flag;

	}
	/**
	 * Takes the flag value from checkSorted() and decides
	 * type of array according to it.
	 * @param input is the given array
	 * @return result is the type of array
	 */
	public String displayMessage(int[] input) {
		int flag = checkSorted(input); // Gets value of catch from checkSorted()
		String result = null; // Stores the type of array
		if (flag == 0) {
			result = "Unsorted Array";
		}
		else if (flag == 1) {
			result = "Ascending Array";
		}
		else if (flag == 2) {
			result = "Descending Array";
		}
		else if (flag == 3) {
			result = "Constant Array";
		}
		return result; // returns the final type of array
	}
}
