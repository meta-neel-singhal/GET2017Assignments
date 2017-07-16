import org.junit.Assert;
import org.junit.Test;

public class LongestSequenceTest {

	// Positive case
	@Test
	public void evaluatesExpression1() {
		LongestSequence sequence = new LongestSequence();
		int[] input = {1,2,3,1,2,3,4,1,2,3,4,5,5,5,5,6,7,8,9,12,13,14,15};
		int[] expected = {5,6,7,8,9,12,13,14,15};
		int[] longestSequence = sequence.longestSequence(input);
		Assert.assertArrayEquals(expected, longestSequence);
	}

	// Negative case
	@Test
	public void evaluatesExpression2() {
		LongestSequence sequence = new LongestSequence();
		int[] input = {1,2,3,1,2,3,4,1,2,3,4,5,13,14,15,16,17,18,1,2,3};
		int[] expected = {1,2,3,4,5,13,14,15};
		int[] longestSequence = sequence.longestSequence(input);
		Assert.assertArrayEquals(expected, longestSequence);
	}
}