package linkedlist;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Ask the action that user wants to perform and executes the program accordingly.
 * 
 * @author Neel Singhal
 */
public class Main {
	
	/**
	 * The main method containing all the actions.
	 *
	 * @param <T>    Generic data type.
	 * @param arguments.
	 */
	public static <T> void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		SinglyLinkedList<T> linkedList = new SinglyLinkedList<T>();
		int option = 0;
		int location;
		T element;
		int size;
		int index;

		do {
			System.out.println("\n1. Add item to Linked List\n2. Add item to Linked List at a location\n"
					+ "3. Remove item from Linked List\n4. Remove item from Linked List by location\n"
					+ "5. Retreive item from Linked List by location\n6. Reverse the Linked List\n"
					+ "7. Print Linked List\n8. Sort Linked List\n9. Exit\nEnter your choice");

			try{
				option = scan.nextInt();
			}
			catch (InputMismatchException exception) {
				System.out.println("Please enter correct value.");
				scan.next();
			}
			
			switch (option) {
				// Add item to Linked List.
				case 1:
					System.out.println("Enter element you want to add");
					element = (T) scan.next();
					linkedList.addNode(element);
					break;
				// Add item to Linked List at a location.	
				case 2:
					System.out.println("Enter location at which you want to add element");
					location = scan.nextInt();
					System.out.println("Enter element you want to add");
					element = (T) scan.next();
					if (linkedList.addNodeAtLocation(location, element)) {
						System.out.println("Element is added to list");
					}
					else {
						System.out.println("Invalid location");
					}
					break;
				// Remove item from Linked List.	
				case 3:
					System.out.println("Enter element you want to remove");
					element = (T) scan.next();
					if (linkedList.removeItem(element)) {
						System.out.println("Element is removed from the LinkedList");
					} 
					else {
						System.out.println("Element is not present in the LinkedList");
					}
					break;
				// Remove item from Linked List by location.	
				case 4:
					System.out.println("Enter location of the element you want to remove");
					location = scan.nextInt();
					if (linkedList.removeItemFromPosition(location - 1)) {
						System.out.println("Element is removed from the LinkedList");
					} 
					else {
						System.out.println("Invalid Location");
					}
					break;
				// Retreive item from Linked List by location.	
				case 5:
					System.out.println("Enter location of the element you want to retreive");
					location = scan.nextInt();
					element = linkedList.getElementFromPosition(location - 1);
					if (element.equals("-1")) {
						System.out.println("Location Invalid");
					} 
					else {
						System.out.println("Element present at this location is " + element.toString());
					}
					break;
			    // Reverse the Linked List.		
				case 6:
					linkedList.reverseLinkedList();
					break;
				// Print Linked List.		
				case 7:
					size = linkedList.getSize();
					if (size == 0) {
						System.out.println("Linked List is empty");
					}
					else {
						for (index = 0; index < size - 1; index++) {
							System.out.print(linkedList.getElementFromPosition(index) + " --> ");
						}
						System.out.print(linkedList.getElementFromPosition(index));
					}
					break;
				// Sort Linked List.		
				case 8:
					linkedList.sort();
					break;
				// Exit.		
				case 9:
					System.exit(0);
					break;
			}
		} while (true);
	}
}
