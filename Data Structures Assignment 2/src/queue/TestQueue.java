package queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

/**
 * The class for JUnit Tests.
 * 
 * @author Neel Singhal
 */
public class TestQueue {
	Queue<String> queue;

	@Before
	public void initialize() {
		queue = new Queue<String>();
	}

	// Test Cases 1.
	@Test
	public void testEnqueue() {
		assertEquals("Case 1", true, queue.enqueue("aaa"));
		assertEquals("Case 2", true, queue.enqueue("bbb"));
		assertFalse("Case 3", false == queue.enqueue("ccc"));
		assertFalse("Case 4", false == queue.enqueue("ddd"));
	}

	// Test Cases 2.
	@Test
	public void testDequeue() {
		queue.enqueue("aaa");
		queue.enqueue("bbb");
		queue.enqueue("ccc");
		assertEquals("Case 1", "aaa", queue.dequeue());
		assertFalse("Case 2", "aaa" == queue.dequeue());
	}

	// Test Cases 3.
	@Test
	public void testMakeEmpty() {
		queue.enqueue("aaa");
		queue.enqueue("bbb");
		queue.enqueue("ccc");
		assertEquals("Case 1", true, queue.makeEmpty());
		assertFalse("Case 2", false == queue.makeEmpty());
	}

	// Test Cases 4.
	@Test
	public void testGetFront() {
		queue.enqueue("aaa");
		queue.enqueue("bbb");
		queue.enqueue("ccc");
		assertEquals("Case 1", "aaa", queue.getFront());
		assertFalse("Case 2", "bbb" == queue.getFront());
	}

	// Test Cases 5.
	@Test
	public void testIsEmpty() {
		queue.enqueue("aaa");
		assertEquals("Case 1", false, queue.isEmpty());
		queue.dequeue();
		assertEquals("Case 2", true, queue.isEmpty());
	}

	// Test Cases 6.
	@Test
	public void testgetSize() {
		queue.enqueue("aaa");
		queue.enqueue("bbb");
		queue.enqueue("ccc");
		assertEquals("Case 1", 3, queue.getSize());
		queue.dequeue();
		assertFalse("Case 2", 3 == queue.getSize());
		queue.makeEmpty();
		assertEquals("Case 3", 0, queue.getSize());
	}
}