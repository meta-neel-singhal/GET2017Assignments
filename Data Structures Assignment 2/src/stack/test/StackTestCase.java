package stack.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

import stack.stack.Stack;

/**
 * Class to test Stack class.
 * 
 * @author Neel Singhal
 */
public class StackTestCase {

	Stack<Integer> stackTest;
	
	// Executes before the execution of each test case.
	@Before
	public void initialize() {
		stackTest = new Stack<Integer>();
	}

	// Positive test case.
	@Test
	public void pushTestCase1() {
		stackTest.push(1);
		int expected = stackTest.top.data;
		assertEquals(expected, 1);
	}

	// Positive test case.
	@Test
	public void popTestCase1() {
		stackTest.push(1);
		int expected = stackTest.pop();
		assertEquals(expected, 1);
	}
	
	// Positive test case.
	@Test
	public void convertInfixToPostfixTestCase1() {
		String[] expected = stackTest.convertInfixToPostfix("5+5+5+5");
		String[] actual = {"5", "5", "+", "5", "+", "5", "+"};
		assertArrayEquals(actual, expected);
	}

	// Positive test case.
	@Test
	public void convertInfixToPostfixTestCase2() {
		String[] expected = stackTest.convertInfixToPostfix("2/3*4-5+6-5*4/3");
		String[] actual = {"2", "3", "/", "4", "*", "5", "-", "6", "+", "5", "4", "*", "3", "/", "-"};
		assertArrayEquals(actual, expected);
	}

	// Negative test case.
	@Test
	public void pushTestCase2() {
		stackTest.push(1);
		stackTest.push(2);
		int expected = stackTest.top.data;
		assertFalse(expected == 1);
	}

	// Negative test case.
	@Test
	public void popTestCase2() {
		stackTest.push(1);
		stackTest.push(2);
		int expected = stackTest.pop();
		assertFalse(expected == 1);
	}
	
	// Negative test case.
	@Test
	public void convertInfixToPostfixTestCase3() {
		String[] expected = stackTest.convertInfixToPostfix("5+5+5+5");
		String[] actual = {"5", "+", "+", "5", "+", "5", "+"};
		assertNotEquals(actual, expected);
	}

	// Negative test case.
	@Test
	public void convertInfixToPostfixTestCase4() {
		String[] expected = stackTest.convertInfixToPostfix("2/3*4-5+6-5*4/3");
		String[] actual = {"2", "3", "/", "4", "*", "5", "-", "6", "+", "5", "4", "*", "/", "-", "3"};
		assertNotEquals(actual, expected);
	}
}