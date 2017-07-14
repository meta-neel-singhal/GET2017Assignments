import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class MergeSortedArrayTest {

	// Positive case
	@Test
	public void evaluatesExpression1(){

		MergeSortedArray obj=new MergeSortedArray();
		int[] arr1 = {1,2,3,3,4,5,5};
		int[] arr2 = {0,1,1,4,4,6,7};
		int[] result = {};
		int[] expected = {0,1,1,1,2,3,3,4,4,4,5,5,6,7};
		int[] output = obj.join(arr1, arr1.length, arr2, arr2.length, result);
		System.out.println(output.length);
		assertArrayEquals(expected,output);

	}

	// Negative case
	@Test
	public void evaluatesExpression2(){

		MergeSortedArray obj=new MergeSortedArray();
		int[] arr1 = {1,2,3,3,4,5,5};
		int[] arr2 = {0,1,1,4,4,6,7};
		int[] result = {};
		int[] expected = {0,1,1,1,2,4,4,5,5,6,7};
		int[] output = obj.join(arr1, arr1.length, arr2, arr2.length, result);
		System.out.println(output.length);
		assertArrayEquals(expected,output);

	}

}
