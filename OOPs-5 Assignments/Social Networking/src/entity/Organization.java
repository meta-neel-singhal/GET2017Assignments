package entity;

/**
 * Organization class have all the details related to organization.
 * 
 * @author Neel Singhal
 */
public class Organization extends Entity {
	private String address;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Parameterized constructor.
	 * 
	 * @param id          Organization id
	 * @param name        Organization name
	 * @param type        Type of entity
	 * @param contact     Contact number
	 * @param password    Password
	 */
	public Organization(String id, String name, String password, long contact,
			String address, String type) {
		super(id, name, password, contact, type);
		this.address = address;
	}
}
