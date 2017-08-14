package entity;
/**
 * User class have all the details of the entities.
 * 
 * @author Neel Singhal
 */
public class User extends Entity {
	private int age;

	/**
	 * Parameterized constructor.
	 * 
	 * @param id          Organization id
	 * @param name        Organization name
	 * @param type        Type of entity
	 * @param contact     Contact number
	 * @param password    Password
	 */
	public User(String id, String name, String password, long contact,
			int age,String type) {
		super(id, name,password, contact, type);
		this.age=age;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
