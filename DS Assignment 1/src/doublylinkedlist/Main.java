package doublylinkedlist;

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
	 * @param <T>    the generic type
	 * @param args the arguments
	 */
	public static <T> void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		DoublyLinkedList<T> linkedList = new DoublyLinkedList<T>();
		int option = 0;
		int size;
		int index;
		T element;
		int location;
		do {
			System.out.println("\n1. Add item to Doubly Linked List\n2. Add item to Doubly Linked List at a location\n"
					+ "3. Remove item from Doubly Linked List\n4. Remove item from Doubly Linked List by location\n"
					+ "5. Retreive item from Doubly Linked List by location\n6. Reverse the Doubly Linked List\n"
					+ "7. Print Doubly Linked List\n8. Sort Doubly Linked List\n9. Exit\nEnter your choice");

			try {
				option = scan.nextInt();
			}
			catch (InputMismatchException exception) {
				System.out.println("Please enter correct value.");
				scan.next();
			}

			switch (option) {
			// Add item to Doubly Linked List.
			case 1:
				System.out.println("Enter element you want to add");
				element = (T) scan.next();
				linkedList.addNode(element);
				break;
				// Add item to Doubly Linked List at a location.
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
				// Remove item from Doubly Linked List.
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
				// Remove item from Doubly Linked List by location.	
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
				// Retreive item from Doubly Linked List by location.			
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
				// Reverse the linked list.				
			case 6:
				linkedList.reverseLinkedList();
				break;
				// Prints the linked list.		
			case 7:
				size = linkedList.getSize();
				if (size == 0) {
					System.out.println("LinkedList is empty");
				}
				else {
					for (index = 0; index < size - 1; index++) {
						System.out.print(linkedList.getElementFromPosition(index) + " <--> ");
					}
					System.out.print(linkedList.getElementFromPosition(index));
				}
				break;
				// Sort the linked list.		
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
