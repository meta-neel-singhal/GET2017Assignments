package jobprinter;


/**
 * The Task class containing information about the task.
 * 
 * @author Neel Singhal
 */
public class Task implements Comparable<Task>{
	private String designation;
	private int priority;
	private String messageToPrint;
	
	public String getDesignation() {
		return designation;
	}
	
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	public int getPriority() {
		return priority;
	}
	
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	public String getMessage() {
		return messageToPrint;
	}

	public void setMessage(String message) {
		this.messageToPrint = message;
	}	
	
	/**
	 * Overridden compareTo method to compare two object of task class.
	 */
	@Override
	public int compareTo(Task arg0) {
		int result = 0;
		int priority1 = this.priority;
		int priority2 = arg0.priority;
		
		// If priority of calling object is greater.
		if (priority1 < priority2) {
			result = -1;
		}
		// If priority of calling object is less than the other object
		else if (priority1 > priority2) {
			result = 1;
		}
		
		return result;
	}
}
