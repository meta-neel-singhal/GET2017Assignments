public class CheckSorted {

	public int longestSequence(int input[]){
		int size = input.length, flag=0;
		if (input[0] < input[size - 1]){
			for (int i=0; i < size-1; i++){
				if (input[i] <= input[i+1]){
					flag = 1;
					continue;
				}
				else{
					flag = 0;
					break;
				}
			}
		}
		else if (input[0] > input[size - 1]){
			for (int i=0; i < size-1; i++){
				if (input[i] >= input[i+1]){
					flag = 2;
					continue;
				}
				else{
					flag = 0;
					break;
				}
			}
		}
		// Below is a special case handled for a constant array.
		else if (input[0] == input[size - 1]){
			for (int i=1; i < size-1; i++){
				if (input[i] == input[i+1]){
					flag = 3;
					continue;
				}
				else{
					flag = 0;
					break;
				}
			}
		}
				
		return flag;
		
	}

	public String displayMessage(int[] input) {
		int flag = longestSequence(input);
		String result = null;
		if (flag == 0){
			result = "Unsorted Array";
		}
		else if (flag == 1){
			result = "Ascending Array";
		}
		else if (flag == 2){
			result = "Descending Array";
		}
		else if (flag == 3){
			result = "Constant Array";
		}
		return result;
	}
}
