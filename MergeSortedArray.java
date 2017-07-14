
public class MergeSortedArray {

	public int [] join (int a[],int asize,int b[],int bsize,int c[]){
		//if ((a[0]>a[1]) && (b[0]>b[1]))
			
		// In this we have assumed that sorted list is always ascending.

		c = new int[asize + bsize];
		int i = 0, j = 0, k = 0;
		while (i < asize && j < bsize){
			if (a[i] < b[j]){
				c[k++]=a[i++];
			}
			else{
				c[k++]=b[j++];
			}
		}
	
	while (i < asize){
		c[k++] = a[i++];
	}
	
	while (j < bsize){
		c[k++] = b[j++];
	}
	while (i < asize){
		c[k++] = b[i++];
	}
	
		return c;
	}
}


