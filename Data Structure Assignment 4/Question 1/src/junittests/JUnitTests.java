package junittests;

import org.junit.Before;
import org.junit.Test;

import queue.Queue;
import utility.Utility;
import jobprinter.Task;

public class JUnitTests {
	Task job;
	Queue<Task> jobQueue;
	
	@Before
	public void init() {
		job = new Task();
		jobQueue = new Queue<Task>();
	}

	// Positive Test Case.
	@Test
	public void jobPrinterTestCase1() {
		//job.setDesignation("chairman");
		job.setMessage("I am chairman.");
		job.setPriority(4);
		jobQueue.enqueue(job);
		//job.setDesignation("professor");
		job.setMessage("I am professor.");
		job.setPriority(3);
		jobQueue.enqueue(job);
		//job.setDesignation("graduate");
		job.setMessage("I am graduate.");
		job.setPriority(2);
		jobQueue.enqueue(job);
		//.setDesignation("undergraduates");
		job.setMessage("I am undergraduate.");
		job.setPriority(1);
		jobQueue.enqueue(job);
		//job.setDesignation("default");
		job.setMessage("I am default.");
		job.setPriority(0);
		jobQueue.enqueue(job);

		Utility.sort(jobQueue);
		while (jobQueue.size() > 0) {
			System.out.println(jobQueue.dequeue().getMessage());
		}
		//assertEquals(expected, actual);
	}

/*	// Negative Test case.
	@Test
	public void roomAllotmentTestCase2() {

	}*/
	
	
	
}
