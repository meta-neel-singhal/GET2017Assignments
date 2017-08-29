package question_1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class TestCase {

	List<Employee> empList;
	Set<Employee> empSet;

	@Before
	public void init() {
		empList = new ArrayList<Employee>();
		empSet = new HashSet<Employee>();
	}

	// Positive Test Case.
	@Test
	public void naturalSortingTestCase1() {
		List<Employee> actual = new ArrayList<Employee>();

		empList.add(new Employee(1, "A", "Sector 18"));
		empList.add(new Employee(3, "B", "Sector 19"));
		empList.add(new Employee(2, "C", "Sector 8"));
		empList.add(new Employee(5, "D", "Sector 13"));
		empList.add(new Employee(4, "E", "Sector 12"));
		Collections.sort(empList);

		actual.add(new Employee(1, "A", "Sector 18"));
		actual.add(new Employee(2, "C", "Sector 8"));
		actual.add(new Employee(3, "B", "Sector 19"));
		actual.add(new Employee(4, "E", "Sector 12"));
		actual.add(new Employee(5, "D", "Sector 13"));

		assertEquals(empList, actual);
	}

	// Positive Test Case.
	@Test
	public void sortingByNameTestCase1() {
		List<Employee> actual = new ArrayList<Employee>();

		empList.add(new Employee(1, "A", "Sector 18"));
		empList.add(new Employee(3, "C", "Sector 19"));
		empList.add(new Employee(2, "B", "Sector 8"));
		empList.add(new Employee(5, "E", "Sector 13"));
		empList.add(new Employee(4, "D", "Sector 12"));
		Collections.sort(empList, Employee.nameComparator);

		actual.add(new Employee(1, "A", "Sector 18"));
		actual.add(new Employee(2, "B", "Sector 8"));
		actual.add(new Employee(3, "C", "Sector 19"));
		actual.add(new Employee(4, "D", "Sector 12"));
		actual.add(new Employee(5, "E", "Sector 13"));

		assertEquals(empList, actual);
	}
	
	// Positive Test Case.
	@Test
	public void uniqueEmployeeTestCase1() {
		Set<Employee> actual = new HashSet<Employee>();

		empSet.add(new Employee(1, "A", "Sector 18"));
		empSet.add(new Employee(3, "C", "Sector 19"));
		empSet.add(new Employee(2, "B", "Sector 8"));
		empSet.add(new Employee(5, "E", "Sector 13"));
		empSet.add(new Employee(4, "D", "Sector 12"));
		empSet.add(new Employee(1, "B", "Sector 8"));
		empSet.add(new Employee(6, "E", "Sector 13"));
		empSet.add(new Employee(4, "D", "Sector 12"));

		actual.add(new Employee(1, "A", "Sector 18"));
		actual.add(new Employee(2, "B", "Sector 8"));
		actual.add(new Employee(3, "C", "Sector 19"));
		actual.add(new Employee(4, "D", "Sector 12"));
		actual.add(new Employee(5, "E", "Sector 13"));		
		actual.add(new Employee(6, "E", "Sector 13"));
		assertEquals(empSet, actual);
	}

	// Negative Test Case.
	@Test
	public void naturalSortingTestCase2() {
		List<Employee> actual = new ArrayList<Employee>();

		empList.add(new Employee(1, "A", "Sector 18"));
		empList.add(new Employee(3, "B", "Sector 19"));
		empList.add(new Employee(2, "C", "Sector 8"));
		empList.add(new Employee(5, "D", "Sector 13"));
		empList.add(new Employee(4, "E", "Sector 12"));
		Collections.sort(empList);

		empList.add(new Employee(1, "A", "Sector 18"));
		empList.add(new Employee(3, "B", "Sector 19"));
		empList.add(new Employee(2, "C", "Sector 8"));
		empList.add(new Employee(5, "D", "Sector 13"));
		empList.add(new Employee(4, "E", "Sector 12"));

		assertNotEquals(empList, actual);
	}

	// Negative Test Case.
	@Test
	public void sortingByNameTestCase2() {
		List<Employee> actual = new ArrayList<Employee>();

		empList.add(new Employee(1, "A", "Sector 18"));
		empList.add(new Employee(3, "C", "Sector 19"));
		empList.add(new Employee(2, "B", "Sector 8"));
		empList.add(new Employee(5, "E", "Sector 13"));
		empList.add(new Employee(4, "D", "Sector 12"));
		Collections.sort(empList, Employee.nameComparator);

		actual.add(new Employee(1, "A", "Sector 18"));
		actual.add(new Employee(2, "B", "Sector 8"));
		actual.add(new Employee(3, "C", "Sector 19"));
		actual.add(new Employee(5, "E", "Sector 13"));
		actual.add(new Employee(4, "D", "Sector 12"));

		assertNotEquals(empList, actual);
	}
	
	// Negative Test Case.
	@Test
	public void uniqueEmployeeTestCase2() {
		Set<Employee> actual = new HashSet<Employee>();

		empSet.add(new Employee(1, "A", "Sector 18"));
		empSet.add(new Employee(3, "C", "Sector 19"));
		empSet.add(new Employee(2, "B", "Sector 8"));
		empSet.add(new Employee(5, "E", "Sector 13"));
		empSet.add(new Employee(4, "D", "Sector 12"));
		empSet.add(new Employee(1, "B", "Sector 8"));
		empSet.add(new Employee(6, "E", "Sector 13"));
		empSet.add(new Employee(4, "D", "Sector 12"));

		actual.add(new Employee(1, "A", "Sector 18"));
		actual.add(new Employee(2, "B", "Sector 8"));
		actual.add(new Employee(3, "C", "Sector 19"));
		actual.add(new Employee(4, "D", "Sector 12"));
		actual.add(new Employee(5, "E", "Sector 13"));		

		assertNotEquals(empSet, actual);
	}

}
