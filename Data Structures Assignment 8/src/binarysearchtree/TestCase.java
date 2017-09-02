package binarysearchtree;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Before;
import org.junit.Test;

/**
 * Class to test Tree Sort.
 * 
 * @author Neel Singhal
 */
public class TestCase {

	Student student;
	BinarySearchTree tree;

	// Initialize Binary Search Tree.
	@Before
	public void init() {
		tree = new BinarySearchTree();
	}

	// Positive Test Case.
	@Test
	public void treeSortTestCase1() {
		student = new Student(5, "Udit");
		tree.insert(student);
		student = new Student(3, "Neel");
		tree.insert(student);
		student = new Student(2, "Mahesh");
		tree.insert(student);
		student = new Student(4, "Rajat");
		tree.insert(student);
		student = new Student(1, "Gaurav");
		tree.insert(student);

		String result = tree.inorder(tree.root);
		String expected = "Roll No. : 1	Student Name : Gaurav\n"
						+ "Roll No. : 2	Student Name : Mahesh\n"
						+ "Roll No. : 3	Student Name : Neel\n"
						+ "Roll No. : 4	Student Name : Rajat\n"
						+ "Roll No. : 5	Student Name : Udit\n";

		assertEquals(result, expected);
	}

	// Positive Test Case.
	@Test
	public void treeSortTestCase2() {
		student = new Student(3, "Neel");
		tree.insert(student);
		student = new Student(2, "Mahesh");
		tree.insert(student);
		student = new Student(4, "Rajat");
		tree.insert(student);
		student = new Student(1, "Gaurav");
		tree.insert(student);
		student = new Student(3, "Udit");
		tree.insert(student);
		student = new Student(4, "Rajat");
		tree.insert(student);
		
		String result = tree.inorder(tree.root);
		String expected = "Roll No. : 1	Student Name : Gaurav\n"
						+ "Roll No. : 2	Student Name : Mahesh\n"
						+ "Roll No. : 3	Student Name : Neel\n"
						+ "Roll No. : 4	Student Name : Rajat\n";

		assertEquals(result, expected);
	}

	// Negative Test Case.
	@Test
	public void treeSortTestCase3() {
		student = new Student(5, "Udit");
		tree.insert(student);
		student = new Student(3, "Neel");
		tree.insert(student);
		student = new Student(2, "Mahesh");
		tree.insert(student);
		student = new Student(4, "Rajat");
		tree.insert(student);
		student = new Student(1, "Gaurav");
		tree.insert(student);

		String result = tree.inorder(tree.root);
		String expected = "Roll No. : 5	Student Name : Udit\n"
						+ "Roll No. : 3	Student Name : Neel\n"
						+ "Roll No. : 2	Student Name : Mahesh\n"
						+ "Roll No. : 4	Student Name : Rajat\n"
						+ "Roll No. : 1	Student Name : Gaurav\n";

		assertNotEquals(result, expected);
	}
	
	// Negative Test Case.
	@Test
	public void treeSortTestCase4() {
		student = new Student(3, "Neel");
		tree.insert(student);
		student = new Student(2, "Mahesh");
		tree.insert(student);
		student = new Student(4, "Rajat");
		tree.insert(student);
		student = new Student(1, "Gaurav");
		tree.insert(student);
		student = new Student(3, "Udit");
		tree.insert(student);
		student = new Student(4, "Rajat");
		tree.insert(student);
		
		String result = tree.inorder(tree.root);
		String expected = "Roll No. : 1	Student Name : Gaurav\n"
						+ "Roll No. : 2	Student Name : Mahesh\n"
						+ "Roll No. : 3	Student Name : Neel\n"
						+ "Roll No. : 4	Student Name : Rajat\n"
						+ "Roll No. : 3	Student Name : Udit\n"
						+ "Roll No. : 4	Student Name : Rajat\n";

		assertNotEquals(result, expected);
	}
}
