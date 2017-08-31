package binarysearchtree;

/**
 * Class defining a student.
 * 
 * @author Neel Singhal
 */
public class Student {
	private int rollNo;
	private String name;
	
	/**
	 * Parameterized Constructor.
	 * 
	 * @param rollNo    Roll No. of the student.
	 * @param name      Name of the student.
	 */
	public Student(int rollNo, String name) {
		this.rollNo = rollNo;
		this.name = name;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
