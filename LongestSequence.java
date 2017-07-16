/**
 * To find longest increasing sequence from an array of n integer values 
 * @author Neel
 */
public class LongestSequence {
	/**
	 * Finds the longest sequence in input array by initially finding length of 
	 * largest sequence (max) using a variable count and thereby getting the 
	 * start index of the largest sequence and hence display it.
	 * @param input array
	 * @return sequence of largest length
	 */
	public int[] longestSequence(int input[]){
		int size = input.length;
		int count = 1; // helps to get length of largest sequence
		int i; // for index value of initial sequence
		int max = 0; // length of largest sequence
		int index = 0; // end index of largest sequence
		int k = 0; // for index value of final sequence

		// gives length of largest sequence
		for (i = 0; i < size - 1; i++){
			if ((input[i] < input[i + 1])){
				count++;
			}
			else{
				if (count > max){
					max = count;
					count = 1;
					index = i;
				}
			}
		}

		if (count > max){
			max = count;
			count = 1;
			index = i;
		}

		// finds the largest sequence
		int sequence[] = new int[max];
		for (int j = (index - max + 1); j <= index; j++){
			sequence[k] = input[j];
			k++;
		}

		return sequence; // return largest sequence
	}
}