package queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

/**
 * The Class for Queue Test.
 */
public class QueueTest {

	CustomQueue<Integer> queue;

	// Initializes the queue.
	@Before
	public void init() {
		queue = new CustomQueue<Integer>();
	}

	// Positive Test Case.
	@Test
	public void enqueueTestCase1() {
		Boolean actual = queue.enqueue(5);
		Boolean expected = true;
		assertEquals(actual,expected);
	}

	// Positive Test Case.
	@Test
	public void dequeueTestCase1() {
		queue.enqueue(5);
		queue.enqueue(6);
		queue.enqueue(7);
		queue.enqueue(8);
		int actual = queue.dequeue();
		int expected = 5;
		assertEquals(actual,expected);
	}

	// Positive Test Case.
	@Test
	public void peekTestCase1() {
		queue.enqueue(5);
		queue.enqueue(6);
		queue.enqueue(7);
		queue.enqueue(8);
		int actual = queue.peek();
		int expected = 5;
		assertEquals(actual,expected);
	}

	// Positive Test Case.
	@Test
	public void printTestCase1() {
		queue.enqueue(5);
		queue.enqueue(6);
		queue.enqueue(7);
		queue.enqueue(8);
		String actual = queue.print();
		String expected = "[5, 6, 7, 8]";
		assertEquals(actual,expected);
	}

	// Positive Test Case.
	@Test
	public void clearTestCase1() {
		assertEquals(queue.clearQueue(), true);
	}

	// Positive Test Case.
	@Test
	public void isEmptyTestCase1() {
		assertEquals(queue.isEmpty(), true);
	}

	// Negative Test Case.
	@Test
	public void enqueueTestCase2() {
		Boolean actual = queue.enqueue(5);
		Boolean expected = false;
		assertFalse(actual == expected);
	}

	// Negative Test Case.
	@Test
	public void dequeueTestCase2() {
		queue.enqueue(5);
		queue.enqueue(6);
		queue.enqueue(7);
		queue.enqueue(8);
		int actual = queue.dequeue();
		int expected = 6;
		assertFalse(actual == expected);
	}

	// Negative Test Case.
	@Test
	public void peekTestCase2() {
		queue.enqueue(5);
		queue.enqueue(6);
		queue.enqueue(7);
		queue.enqueue(8);
		int actual = queue.peek();
		int expected = 6;
		assertFalse(actual == expected);
	}

	// Negative Test Case.
	@Test
	public void printTestCase2() {
		queue.enqueue(5);
		queue.enqueue(6);
		queue.enqueue(7);
		queue.enqueue(8);
		String actual = queue.print();
		String expected = "[5, 7, 6, 8]";
		assertFalse(actual == expected);
	}

	// Negative Test Case.
	@Test
	public void clearTestCase2() {
		assertFalse(queue.clearQueue() == false);
	}

	// Negative Test Case.
	@Test
	public void isEmptyTestCase2() {
		assertFalse(queue.clearQueue() == false);
	}
}
