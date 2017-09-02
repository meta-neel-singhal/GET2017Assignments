package question_1;

import java.util.HashSet;
import java.util.Set;

/**
 * Avoid any duplicate employee entry.
 * 
 * @author Neel Singhal
 */
public class UniqueEmployeeCollection {
	
	/**
	 * Add employees to the list and avoid any duplicate employee entry.
	 * 
	 * @param args    the arguments.
	 */
	public static void main(String[] args) {
		Set<Employee> empSet = new HashSet<Employee>();
		empSet.add(new Employee(1, "Neel", "Sector 18"));
		empSet.add(new Employee(3, "Mahesh", "Sector 19"));
		empSet.add(new Employee(2, "Udit", "Sector 8"));
		empSet.add(new Employee(5, "Prateek", "Sector 13"));
		empSet.add(new Employee(4, "Gaurav", "Sector 12"));
		empSet.add(new Employee(1, "Shivam", "Sector 18"));
		empSet.add(new Employee(3, "Pawan", "Sector 19"));
		empSet.add(new Employee(2, "Shubham", "Sector 8"));
		empSet.add(new Employee(5, "Rajat", "Sector 13"));
		empSet.add(new Employee(4, "Rahul", "Sector 12"));
		System.out.println(empSet);
	}
}
