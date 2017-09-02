package com.employee.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.simple.JSONObject;

/**
 * The Class EmployeeDao.
 * 
 * @author Neel Singhal
 */
public class EmployeeDao {
	
	private List<JSONObject> employeesDetails;
	private Map<Integer, Employee> employeesList;
	private static EmployeeDao employeeDao;

	/**
	 * Instantiates a new employee dao.
	 */
	private EmployeeDao() {
		init();
	}

	/**
	 * Gets the single instance of EmployeeDao.
	 *
	 * @return single instance of EmployeeDao
	 */
	public static EmployeeDao getInstance() {
		if (employeeDao == null) {
			// To make it singleton.
			synchronized (EmployeeDao.class) {
				if (employeeDao == null) {
					employeeDao = new EmployeeDao();
				}
			}
		}

		return employeeDao;
	}

	/**
	 * Initializes the new employee dao.
	 */
	public void init() {
		employeesList = new HashMap<Integer, Employee>();
		employeesDetails = JsonFilehandling.read();
		for (JSONObject object : employeesDetails) {
			employeesList.put(Integer.parseInt((String) object.get("id")),
					new Employee(Integer.parseInt((String) object.get("id")),
							object.get("fistName").toString(), object.get("lastName").toString(),
							Integer.parseInt((String)object.get("age"))));
		}
	}

	/**
	 * Gets all the employees.
	 *
	 * @return all employees details.
	 */
	public String getAllEmployees() {
		String employee = "";
		Set<Integer> ids = employeesList.keySet();
		// Iterate over the list to get all the employees.
		for (int empId : ids) {
			employee += "<b>Employee Id : </b> " + empId + " <b> Employee Name : </b> " + 
					employeesList.get(empId).getFirstName() + " " + employeesList.get(empId).getLastName() +
					" <b> Employee Age : </b> " + employeesList.get(empId).getAge() + "<br>";
		}

		return employee;
	}

	/**
	 * Gets the employee by ID.
	 *
	 * @param id    Employee ID.
	 * @return the employee.
	 */
	public Employee getEmployee(int id) {
		Employee employee = null;
		// If the employee id is present in the list.
		if (employeesList.containsKey(id)) {
			employee = employeesList.get(id);
		}

		return employee;
	}

	/**
	 * Creates the employee.
	 *
	 * @param employee    Employee object.
	 * @return true, if successful.
	 */
	public boolean createEmployee(Employee employee) {
		boolean action = false;
		// Creates employee only if the id is not already present in the list. 
		if (!employeesList.containsKey(employee.getId())) {
			action = true;
			employeesList.put(employee.getId(), employee);
		}
		JsonFilehandling.write(employee);
		return action;
	}

	/**
	 * Delete employee.
	 *
	 * @param id    Employee ID.
	 * @return true, if successful.
	 */
	public boolean deleteEmployee(int id) {
		boolean flag = false;
		// Check if the employee id is present in the list and then deletes it.
		if(employeesList.containsKey(id)) {
			employeesList.remove(id);
			flag = true;
		}

		return flag;
	}

	/**
	 * Gets the all employee by name.
	 *
	 * @param firstName    Employee's first name
	 * @param lastName     Employee's last name.
	 * @return the all employee by name.
	 */
	public List<Employee> getAllEmployeeWithName(String firstName, String lastName){
		List<Employee> employee = new ArrayList<Employee>();
		Iterator iterator = (Iterator) employeesList.keySet().iterator();
		Map.Entry entry;
		Employee emp;
		// Iterate over the whole map and check if the name of any employee matches with the input name.
		while(iterator.hasNext()) {
		    entry = (Map.Entry) iterator.next();
		    emp = (Employee) entry.getValue();
			if (emp.getFirstName().equalsIgnoreCase(firstName) && emp.getLastName().equalsIgnoreCase(lastName)) {
				employee.add(emp);
			}
		}

		return employee;
	}
}