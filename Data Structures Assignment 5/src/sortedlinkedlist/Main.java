package sortedlinkedlist;

/**
 * Main class to initialize sorted linked list.
 * 
 * @author Neel Singhal
 */
public class Main {
	/**
	 * The main method to initialize and display the sorted linked list.
	 *
	 * @param args    the arguments
	 */
	public static void main(String[] args) {
		int choice = 0, data = 0;

		while (true) {
			Input.printMenu();
			choice = Input.takeIntegerAsInput();
			switch (choice) {
			// For adding an element.
			case 1:
				data = Input.takeIntegerAsInput();
				SortedList.add(data);
				break;
			// To print the sorted list.
			case 2:
				if (SortedList.sortedList.isEmpty()) {
					Input.print("List is Empty");
				} 
				else {
					Input.print(SortedList.sortedList.toString());
				}
				break;
			// Exit.
			case 3:
				Input.close();
				System.exit(0);
			// Default case.
			default :
				Input.print("Please Enter a Valid Option");
			}
		}
	}
}

