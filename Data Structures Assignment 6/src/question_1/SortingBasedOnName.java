package question_1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Performs sorting based on employee name.
 * 
 * @author Neel Singhal
 */
public class SortingBasedOnName {

	/**
	 * Add employees to the list and perform sorting of employee
	 * on the basis of their name.
	 * 
	 * @param args    the arguments.
	 */
	public static void main(String[] args) {
		List<Employee> empList = new ArrayList<Employee>();
		empList.add(new Employee(1, "Neel", "Sector 18"));
		empList.add(new Employee(3, "Mahesh", "Sector 19"));
		empList.add(new Employee(2, "Udit", "Sector 8"));
		empList.add(new Employee(5, "Prateek", "Sector 13"));
		empList.add(new Employee(4, "Gaurav", "Sector 12"));
		System.out.println(empList);
		Collections.sort(empList, Employee.nameComparator);
		System.out.println(empList);
	}
}
