
package jobprinter;

import jobprinter.Task;
import utility.Input;
import utility.Utility;
import queue.Queue;

/**
 * The Printer class to print jobs according to their priority.
 * 
 * @author Neel Singhal
 */
public class Printer {
	static private Queue<Task> jobQueue = new Queue<>();

	/**
	 * The main method to initialize printing.
	 *
	 * @param args    the arguments.
	 */
	public static void main(String[] args) {
		Task job;
		while (true) {
			Input.printMenu();
			int choice = Input.takeIntegerAsInput();
			switch (choice) {
			// For assigning a task.
			case 1:
				job = new Task();
				addTask(job);
				break;
				// For printing the jobs.
			case 2:	
				Utility.sort(jobQueue);
				while (jobQueue.size() > 0) {
					System.out.println(jobQueue.dequeue().getMessage());
				}
				System.out.println("All jobs are completed.");
				break;
				// Exit.
			case 3:
				Input.close();
				System.exit(0);
				break;
			default:
				System.out.println("Please Enter a valid option !");
			}
		}
	}

	/**
	 * Set priority of job according to the priority of the sender.
	 *
	 * @param designation    the designation of job sender.
	 * @return priority of job sender.
	 */
	public static int prioritySetter(String designation) {
		int result = 0;
		designation = designation.toLowerCase();

		switch (designation) {
		/*If designation is chairman*/
		case "chairman":
			result = 4;
			break;
			/*If designation is professor*/
		case "professor":
			result = 3;
			break;
			/*If designation is graduate*/	
		case "graduate":
			result = 2;
			break;
			/*If designation is undergraduate*/	
		case "undergraduates":
			result = 1;
			break;
			/*If not from any of these than assign 0*/
		default:
			result = 0;
		}

		return result;
	}	

	/**
	 * Method to assign a task to job queue.
	 *
	 * @param job    Object of task.
	 */
	private static void addTask(Task job) {
		String message = "";
		String designation = "";
		System.out.println("Enter Designation : ");
		designation = Input.takeStringAsInput();
		System.out.println("Enter message to print : ");
		message = Input.takeStringAsInput();
		job.setDesignation(designation);
		job.setMessage(message);
		job.setPriority(prioritySetter(designation));
		jobQueue.enqueue(job);
	}
}
