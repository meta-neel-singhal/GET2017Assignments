import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class TestPermutationsOfString {

	PermutationsOfString PermutaionsObject = new PermutationsOfString();

	// Positive Test Case 1.
	@Test
	public void permutationsOfStringTest1() {
		List<String> permutations = PermutaionsObject.generatePermutations("ABC");
		List<String> actualPermutations = Arrays.asList ( "ABC", "ACB", "BAC", "BCA",
				"CBA", "CAB" );
		// Compares expected and actual permutations of the string.
		assertThat(permutations, is(actualPermutations));
	}
	
	// Positive Test Case 2.
	@Test
	public void permutationsOfStringTest2() {
		List<String> permutations = PermutaionsObject.generatePermutations("ABCD");
		List<String> actualPermutations = Arrays.asList ( "ABCD", "ABDC", "ACBD",
				"ACDB", "ADCB", "ADBC", "BACD", "BADC", "BCAD", "BCDA", "BDCA",
				"BDAC", "CBAD", "CBDA", "CABD", "CADB", "CDAB", "CDBA", "DBCA", 
				"DBAC", "DCBA", "DCAB", "DACB", "DABC" );
		// Compares expected and actual permutations of the string.
		assertThat(permutations, is(actualPermutations));
	}

	// Positive Test Case 3.
	@Test
	public void permutationsOfStringTest3() {
		List<String> permutations = PermutaionsObject.generatePermutations("AAAB");
		List<String> actualPermutations = Arrays.asList ( "AAAB", "AABA", "ABAA", "BAAA" );
		// Compares expected and actual permutations of the string.
		assertThat(permutations, is(actualPermutations));
	}

	// Negative Test Case 1.
	@Test
	public void permutationsOfStringTest4() {
		List<String> permutations = PermutaionsObject.generatePermutations("AAAA");
		List<String> actualPermutations = Arrays.asList ( "A" );
		// Compares expected and actual permutations of the string.
		assertThat(permutations, not(actualPermutations));
	}

	// Negative Test Case 2.
	@Test
	public void permutationsOfStringTest5() {
		List<String> permutations = PermutaionsObject.generatePermutations("AAA");
		List<String> actualPermutations = Arrays.asList ( "AAA", "AAA", "AAA", "AAA", "AAA", "AAA" );
		// Compares expected and actual permutations of the string.
		assertThat(permutations, not(actualPermutations));
	}

	// Negative Test Case 3.
	@Test
	public void permutationsOfStringTest6() {
		List<String> permutations = PermutaionsObject.generatePermutations("ABC");
		List<String> actualPermutations = Arrays.asList ( "ABC", "ACB", "BAC", "BCA", "CBA");
		// Compares expected and actual permutations of the string.
		assertThat(permutations, not(actualPermutations));
	}
}
