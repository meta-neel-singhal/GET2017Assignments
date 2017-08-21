package com.employee.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * The services served by the program.
 * 
 * @author Neel Singhal
 */
@Path("/EmployeeService")
public class EmployeeService {
	EmployeeDao employeeDao = EmployeeDao.getInstance();

	/**
	 * To create an employee.
	 * 
	 * @param empId        Employee ID.
	 * @param firstName    Employee's First Name.
	 * @param lastName     Employee's Last Name.
	 * @param age          Employee Age.
	 * @return
	 */
	@POST
	@Path("/employees/{id}/{firstName}/{lastName}/{age}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String createEmployee(@PathParam("id") int empId,
			@PathParam("firstName") String firstName,
			@PathParam("lastName") String lastName,
			@PathParam("age") int age) {
		String status = Constants.FAILURE_RESULT;
		Employee employee = new Employee(empId, firstName, lastName, age);
		boolean result = employeeDao.createEmployee(employee);
		if(result){
			status = Constants.SUCCESS_RESULT;
		}

		return status;
	}

	/**
	 * To get details of all the employees.
	 * 
	 * @return all employees details.
	 */
	@GET
	@Path("/employees")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllEmployees(){
		return employeeDao.getAllEmployees();
	}

	/**
	 * To get details of the employees by ID.
	 * 
	 * @param empId    Employee ID.
	 * @return employee details.
	 */
	@GET
	@Path("/employees/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Employee getEmployee(@PathParam("id") int empId){
		return employeeDao.getEmployee(empId);
	}

	/**
	 * To get details of the employees by Name.
	 * 
	 * @param firstName    Employee's First Name.
	 * @param lastName     Employee's Last Name.
	 * @return employees details.
	 */
	@GET
	@Path("/employees/{firstName}/{lastName}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> getEmployeeByName(@PathParam("firstName") String firstName, 
			@PathParam("lastName") String lastName){
		return (List<Employee>)employeeDao.getAllEmployeeWithName(firstName, lastName);
	}

	/**
	 * Delete an employee details.
	 * 
	 * @param empId    Employee ID.
	 * @return the status message.
	 */
	@DELETE
	@Path("/employees/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteEmployee(@PathParam("id") int empId){
		String status = Constants.FAILURE_RESULT;
		boolean result = employeeDao.deleteEmployee(empId);
		if(result){
			status = Constants.SUCCESS_RESULT;
		}

		return status;
	}
}