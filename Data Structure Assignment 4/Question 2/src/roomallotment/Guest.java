package roomallotment;

/**
 * Guest class containing the details of the guests.
 * 
 * @author Neel Singhal
 */
public class Guest {
	private String name;
	private int age;

	/**
	 * Default Constructor
	 */
	public Guest() {

	}

	/**
	 * Parameterized constructor.
	 * 
	 * @param name    Name of the guest.
	 * @param age	  Age of the guest.
	 */
	public Guest(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
