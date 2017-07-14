
public class RemoveDuplicate {

	public int[] removeDuplicate(int input[]){
		
		int len = input.length, flag = 0, newsize = 1;
		int[] output = new int[input.length];
        output[0]=input[0];
        for (int i = 1; i < len; i++){
        	flag = 0;
            for (int j = 0; j < newsize; j++){
            	
                if (input[i] == output[j]){
                	flag = 1;
                	break;
                }
            }
            if (flag == 0){
            	
                output[newsize] = input[i];
                newsize++;
            }
        }
        
        int[] result = new int[newsize];
        for(int i = 0; i < newsize; i++){
        	
        	result[i] = output[i];
        }
        output = null; //Free the memory of array not in use.
       
        return result;
        
	}

}
