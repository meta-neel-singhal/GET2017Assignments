/**
 * Simulate FCFS (First come First Server) scheduler of a machine
 * @author Neel
 */
public class FirstComeFirstServe {
	/**
	 * Calculates job wait time by subtracting job start and job arrival time and
	 * calculates job finish time by adding job start time and job size and subtracting 1
	 * to get required result.
	 * @param arrivalTime is arrivial time of job
	 * @param jobSize is the total size of job
	 * @return output as 2d array of FCFS machine
	 */
	public int[][] getWaitingTime(int[] arrivalTime, int[] jobSize){
		int [][] output=new int[arrivalTime.length][5]; // Stores output as 2d array of FCFS machine

		output[0][3] = arrivalTime[0];

		// sequence of job
		for(int i = 0; i < arrivalTime.length; i++) {
	
			output[i][0]=i+1;
		}

		// job arrived time
		for(int i = 0;i < arrivalTime.length; i++) {
			
			output[i][1] = arrivalTime[i];
		}	

		// job start time
		for(int i = 1; i < arrivalTime.length; i++) {
			
			output[i][3] = Math.max(output[i - 1][3] + jobSize[i - 1], arrivalTime[i]);
		}

		// job wait time
		for(int i = 0; i<arrivalTime.length; i++) {
			
			output[i][2] = output[i][3] - output[i][1];
		}

		// job finished time
		for(int i = 0; i < arrivalTime.length; i++)
			
			output[i][4] = output[i][3] + jobSize[i] - 1;

		return output; // final FCFS output

	}
}
