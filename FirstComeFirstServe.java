public class FirstComeFirstServe {

	public int[][] getWaitingTime(int[] arrival_time,int[] job_size){
		int [][] output=new int[arrival_time.length][5];
		
		output[0][3]=arrival_time[0];
		
		
		for(int i=0;i<arrival_time.length;i++)
			output[i][0]=i+1;
		
		for(int i=0;i<arrival_time.length;i++)
			output[i][1]=arrival_time[i];
		
		
		for(int i=1;i<arrival_time.length;i++){
			output[i][3]=Math.max(output[i-1][3]+job_size[i-1],arrival_time[i]);
			
		}
		
		for(int i=0;i<arrival_time.length;i++){
			
			output[i][2]=output[i][3]-output[i][1];
		}
		
		for(int i=0;i<arrival_time.length;i++)
			output[i][4]=output[i][3]+job_size[i]-1;
		
	
		return output;
		
	}
}
