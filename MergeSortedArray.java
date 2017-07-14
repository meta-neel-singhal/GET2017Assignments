/**
 * Join two sorted arrays and generate third sorted array
 * @author Neel
 */
public class MergeSortedArray {
	/**
	 * this function merge two sorted array(assume both are in ascending order) 
	 * and generate third sorted array
	 * @param a is first array
	 * @param asize is size of first array
	 * @param b is second array
	 * @param bsize is size of second array
	 * @param c is final sorted array
	 * @return c is third and final sorted array  
	 */
	public int [] join (int a[],int asize,int b[],int bsize,int c[]){

		c = new int[asize + bsize]; // initialize length of final array
		int k=0;  //third array length 
		int i=0;  //first array length
		int j=0;  //second array length

		// fills places of the final array in ascending order
		while (i < asize && j < bsize){
			if (a[i] < b[j]){
				c[k++]=a[i++];
			}
			else{
				c[k++]=b[j++];
			}
		}

		// insert remaining elements of array 1 into c
		while (i < asize){
			c[k++] = a[i++];
		}

		// insert remaining elements of array 2 into c
		while (j < bsize){
			c[k++] = b[j++];
		}

		return c; // return final sorted array
	}
}


