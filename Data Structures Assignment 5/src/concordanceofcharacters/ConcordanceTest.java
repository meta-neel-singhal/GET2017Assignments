package concordanceofcharacters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class ConcordanceTest {

	// Positive test case 1.
	@Test
	public void concordanceTest1() {
		String input = "HelloNeel";
		String actual = Concordance.findConcordance(input);
		String expected = "e: [1, 6, 7]  H: [0]  l: [2, 3, 8]  N: [5]  o: [4]  ";
		
		assertEquals(expected, actual);
	}
	
	// Positive test case 2.
	@Test
	public void concordanceTest2() {
		String input = "JaipurIsMyCity";
		String actual = Concordance.findConcordance(input);
		String expected = "p: [3]  a: [1]  r: [5]  s: [7]  C: [10]  t: [12]  u: [4]"
				+ "  i: [2, 11]  I: [6]  y: [9, 13]  J: [0]  M: [8]  ";
		
		assertEquals(expected, actual);
	}
	
	// Negative test case 1.
	@Test
	public void concordanceTest3() {
		String input = "HelloNeel";
		String actual = Concordance.findConcordance(input);
		String expected = "e: [1] e:[6] e: [7]  H: [0]  l: [2] l: [3] l: [8]  N: [5]  o: [4]  ";
		
		assertNotEquals(expected, actual);
	}
	
	// Negative test case 2.
	@Test
	public void concordanceTest4() {
		String input = "JaipurIsMyCity";
		String actual = Concordance.findConcordance(input);
		String expected = "p: [3]  a: [1]  r: [5]  s: [7]  C: [10]  t: [12]  u: [4]  i: [2]"
				+ " i: [11]  I: [6]  y: [9] y: [13]  J: [0]  M: [8]  ";
		
		assertNotEquals(expected, actual);
	}
}
