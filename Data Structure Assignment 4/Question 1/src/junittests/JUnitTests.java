package junittests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import jobprinter.Task;

import org.junit.Before;
import org.junit.Test;

import queue.Queue;
import utility.Utility;

public class JUnitTests {
	Task job;
	Queue<Task> jobQueue ;

	@Before
	public void init() {
		jobQueue = new Queue<Task>();
	}

	// Positive Test Case.
	@Test
	public void jobPrinterTestCase1() {
		String expected = "";
		String actual = "";
		job = new Task();
		job.setMessage("I am chairman.");
		job.setPriority(4);
		jobQueue.enqueue(job);
		job = new Task();
		job.setMessage("I am professor.");
		job.setPriority(3);
		jobQueue.enqueue(job);
		job = new Task();
		job.setMessage("I am graduate.");
		job.setPriority(2);
		jobQueue.enqueue(job);
		job = new Task();
		job.setMessage("I am undergraduate.");
		job.setPriority(1);
		jobQueue.enqueue(job);
		job = new Task();
		job.setMessage("I am default.");
		job.setPriority(0);
		jobQueue.enqueue(job);
		Utility.sort(jobQueue);
		while (jobQueue.size() > 0) {
			expected += jobQueue.dequeue().getMessage();
		}
		actual = "I am chairman.I am professor.I am graduate.I am undergraduate.I am default.";
		assertEquals(expected, actual);
	}

	// Negative Test case.
	@Test
	public void jobPrinterTestCase2() {
		String expected = "";
		String actual = "";
		job = new Task();
		job.setMessage("I am default.");
		job.setPriority(0);
		jobQueue.enqueue(job);
		job = new Task();
		job.setMessage("I am undergraduate.");
		job.setPriority(1);
		jobQueue.enqueue(job);
		job = new Task();
		job.setMessage("I am graduate.");
		job.setPriority(2);
		jobQueue.enqueue(job);
		job = new Task();
		job.setMessage("I am professor.");
		job.setPriority(3);
		jobQueue.enqueue(job);
		job = new Task();
		job.setMessage("I am chairman.");
		job.setPriority(4);
		jobQueue.enqueue(job);
		Utility.sort(jobQueue);
		while (jobQueue.size() > 0) {
			expected += jobQueue.dequeue().getMessage();
		}
		actual = "I am default.I am undergraduate.I am graduate.I am professor.I am chairman.";
		assertNotEquals(expected, actual);
	}
}
