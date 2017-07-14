public class LongestSequence {

	public int[] longestSequence(int input[]){
		int size = input.length, count = 1, i, max = 0, index = 0, k=0;

		for (i=0; i < size - 1; i++){
			if ((input[i] < input[i+1])){
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
				
		int seq[] = new int[max];
		for (int j = (index - max + 1); j <= index; j++){
			seq[k] = input[j];
			k++;
		}
		/*for (int j = (index - max + 1); j <= index; j++){
			System.out.println(input[j]);
		}
		System.out.println(max);
		System.out.println(index);
		*/
		return seq;
	}
}