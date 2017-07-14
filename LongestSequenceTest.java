import org.junit.Assert;
import org.junit.Test;

public class LongestSequenceTest {

	@Test
	 public void evaluatesExpression1() {
		LongestSequence sequence = new LongestSequence();
		int[] input = {1,2,3,1,2,3,4,1,2,3,4,5,5,5,5,6,7,8,9,12,13,14,15};
		int[] expected = {5,6,7,8,9,12,13,14,15};
		int[] longestSequence = sequence.longestSequence(input);
		Assert.assertArrayEquals(expected, longestSequence);
	 }
}