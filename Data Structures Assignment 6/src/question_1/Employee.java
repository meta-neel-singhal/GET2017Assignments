package question_1;

import java.util.Comparator;

public class Employee implements Comparable<Employee> {
	private int empId;
	private String name;
	private String address;

	/**
	 * Parameterized Constructor.
	 * 
	 * @param empId      Employee ID.
	 * @param name       Employee Name.
	 * @param address    Employee Address.
	 */
	public Employee(int empId, String name, String address) {
		this.empId = empId;
		this.name = name;
		this.address = address;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Comparator to sort employees list based on employee name.
	 */
	public static Comparator<Employee> nameComparator = new Comparator<Employee>() {
		@Override
		public int compare(Employee obj1, Employee obj2) {
			return obj1.getName().compareTo(obj2.getName());
		}
	};

	/**
	 * Override compareTo method to sort employees list based on employee id.
	 */
	@Override
	public int compareTo(Employee obj) {
		return this.empId - obj.getEmpId();
	}

	/**
	 * Overridden toString method to display data in specified format.
	 */
	@Override
	public String toString() {
		return "\n" + this.getEmpId() + "  " + this.getName() + " " + this.getAddress() + " ";
	}

	/* 
	 * Overridden hashCode method to prevent duplicate values..
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + empId;
		return result;
	}

	/* 
	 * Overridden equals method to compare two objects on basis of empId.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Employee)) {
			return false;
		}
		Employee other = (Employee) obj;
		if (empId != other.empId) {
			return false;
		}
		return true;
	}

}
