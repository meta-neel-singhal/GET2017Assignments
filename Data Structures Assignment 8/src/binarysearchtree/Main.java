package binarysearchtree;

/**
 * Main class to initialize the sorting. 
 * 
 * @author Neel Singhal
 */
public class Main {

	/**
	 * Takes user input and invokes the sorting method using Binary Search Tree.
	 * 
	 * @param args    the arguments.
	 */
	public static void main(String[] args) {
		int totalStudents, rollNo, num;
		Student student;
		String name, result;
		BinarySearchTree tree = new BinarySearchTree();
	
		System.out.println("Enter number of students in the class :");
		totalStudents = Input.takeIntegerAsInput();
		// Take input for every student.
		for (int count = 0; count < totalStudents; count++) {
			num = count + 1;
			System.out.println("Enter Roll No. of student " + num);
			rollNo = Input.takeIntegerAsInput();
			System.out.println("Enter Name of student " + num);
			name = Input.takeStringAsInput();		
			student = new Student(rollNo, name);
			// Insert the student into the Binary Search Tree.
			tree.insert(student);
		}
		// Makes inorder of the tree.
		result = tree.inorder(tree.root);
		System.out.println(result);
	}
}
