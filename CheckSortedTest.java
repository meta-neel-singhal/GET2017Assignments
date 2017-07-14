import org.junit.Assert;
import org.junit.Test;
	
public class CheckSortedTest {
	
	@Test
	 public void evaluatesExpression1() {
		
		CheckSorted sortedArray = new CheckSorted();
		
		int[] input = {3,4,1,5,6,2,3};
		String result = sortedArray.displayMessage(input);		
		Assert.assertEquals("Unsorted Array",result);
	 }
	@Test
	 public void evaluatesExpression2() {
		
		CheckSorted sortedArray = new CheckSorted();
		
		int[] input = {5,4,3,2,1,1};
		String result = sortedArray.displayMessage(input);		
		Assert.assertEquals("Descending Array",result);
	 }
	@Test
	 public void evaluatesExpression3() {
		
		CheckSorted sortedArray = new CheckSorted();
		
		int[] input = {1,2,2,3,4,5};
		String result = sortedArray.displayMessage(input);		
		Assert.assertEquals("Ascending Array",result);
	 }
	@Test
	 public void evaluatesExpression4() {
		
		CheckSorted sortedArray = new CheckSorted();
		
		int[] input = {5,5,5,5,5};
		String result = sortedArray.displayMessage(input);		
		Assert.assertEquals("Constant Array",result);
	 }
}
