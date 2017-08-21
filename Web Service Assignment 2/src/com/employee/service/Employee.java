package com.employee.service;

import java.io.Serializable;

/**
 * Contains details about the employee.
 * 
 * @author Neel Singhal
 */
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L; // Universal version identifier for a Serializable class.
	private int id;
	private String firstName;
	private String lastName;
	private int age;

	// Default Constructor.
	public Employee() {

	}

	// Parameterized constructor.
	public Employee(int id, String firstName, String lastName, int age) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * Used to check if an employee is already present in the list.
	 */
	@Override
	public boolean equals(Object object){
		boolean result = false;
		if (object == null) {
			result = false;
		}
		else if (!(object instanceof Employee)) {
			result = false;
		}
		else {
			Employee employee = (Employee) object;
			if (id == employee.getId() && firstName.equals(employee.getFirstName()) 
					&& lastName.equals(employee.getLastName()) && age == employee.getAge()) {
				result = true;
			}			
		}

		return result;
	}	
}