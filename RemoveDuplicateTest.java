import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class RemoveDuplicateTest {

	@Test
	 public void evaluatesExpression1() {
		RemoveDuplicate duplicate = new RemoveDuplicate();
		int[] input = {1,2,3,1,3,4,5,2,3,4,2,3,6,7,8,8,8};
		int[] expected = {1,2,3,4,5,6,7,8};
		int[] result = duplicate.removeDuplicate(input);
		assertArrayEquals(expected, result);
	}
	@Test
	 public void evaluatesExpression2() {
		RemoveDuplicate duplicate = new RemoveDuplicate();
		int[] input = {3,5,3,2,5,6,4,2,3,4,5};
		int[] expected = {3,5,2,6,4};
		int[] result = duplicate.removeDuplicate(input);
		assertArrayEquals(expected, result);
	}
	@Test
	 public void evaluatesExpression3() {
		RemoveDuplicate duplicate = new RemoveDuplicate();
		int[] input = {4,4,4,4,4,4,4};
		int[] expected = {4};
		int[] result = duplicate.removeDuplicate(input);
		assertArrayEquals(expected, result);
	}
}