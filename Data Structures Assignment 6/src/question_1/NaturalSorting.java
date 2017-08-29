package question_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Performs Natural Order Sorting.
 * 
 * @author Neel Singhal
 */
public class NaturalSorting {

	/**
	 * Add employees to the list and perform natural order sorting.
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
		Collections.sort(empList);
		System.out.println(empList);
	}
}
