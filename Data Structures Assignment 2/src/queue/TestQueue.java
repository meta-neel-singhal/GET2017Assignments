package queue;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestQueue {
	Queue<String> queue;

	/**
	 * @throws Exception
	 */
	@Before
	public void initialize() throws Exception {
		queue = new Queue<String>();
	}

	// Test Cases 1.
	@Test
	public void testEnqueue() {
		assertEquals("Success",true,queue.enqueue("aaa"));
		assertEquals("Success",true,queue.enqueue("bbb"));
		assertEquals("Success",true,queue.enqueue("ccc"));
		assertEquals("Success",true,queue.enqueue("ddd"));
		assertEquals("Success",true,queue.enqueue("eee"));
	}

	// Test Cases 2.
	@Test
	public void testDequeue() {
		assertEquals("Success",true,queue.enqueue("aaa"));
		assertEquals("Success",true,queue.enqueue("bbb"));
		assertEquals("Success",true,queue.enqueue("ccc"));
		assertEquals("aaa",queue.dequeue());
		assertEquals("bbb",queue.dequeue());
		assertEquals("ccc",queue.dequeue());
	}

	// Test Cases 3.
	@Test
	public void testMakeEmpty() {
		assertEquals("Success",true,queue.enqueue("aaa"));
		assertEquals("Success",true,queue.enqueue("bbb"));
		assertEquals("Success",true,queue.enqueue("ccc"));
		assertEquals("Success",true,queue.makeEmpty());
	}

	// Test Cases 4.
	@Test
	public void testGetFront() {
		assertEquals("Success",true,queue.enqueue("aaa"));
		assertEquals("Success",true,queue.enqueue("bbb"));
		assertEquals("Success",true,queue.enqueue("ccc"));
		assertEquals("aaa",queue.getFront());
	}

	// Test Cases 5.
	@Test
	public void testIsEmpty() {
		assertEquals("Success",true,queue.enqueue("aaa"));
		assertEquals("Success",false,queue.isEmpty());
		assertEquals("aaa",queue.dequeue());
		assertEquals("Success",true,queue.isEmpty());
	}

	// Test Cases 6.
	@Test
	public void testgetSize() {
		assertEquals("Success",true,queue.enqueue("aaa"));
		assertEquals("Success",true,queue.enqueue("bbb"));
		assertEquals("Success",true,queue.enqueue("ccc"));
		assertEquals(3,queue.getSize());
		assertEquals("Success",true,queue.makeEmpty());
		assertEquals(0,queue.getSize());
	}
}