package arraylist;

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
		MyArrayList<T> arrayList = new MyArrayList<T>();
		int option = 0;
		Scanner scan;
		int location;
		int position;
		int index;
		int num;

		do {
			System.out.println("\n1. Add item to Array List\n2. Add item to Array List by location\n3. Get item from Array List"
					+ "\n4. Remove item from Array List\n5. Remove item from Array List by location\n6. Clear Array List"
					+ "\n7. Reverse Array List\n8. Sort Array List\n9. Print Array List\n10. Join two Array List\n11. Exit\n"
					+ "Enter your choice\n");
			scan = new Scanner(System.in);

			try {
				option = scan.nextInt();
			}
			catch (InputMismatchException exception) {
				System.out.println("Please enter correct value.");
			}

			switch (option) {
			// Add item to Array List.
			case 1:
				System.out.println("Enter element to add in Array List: ");
				T element = (T) scan.next();
				arrayList.addElement(element);
				break;
				// Add item to Array List by location.	
			case 2:
				System.out.println("Enter location: ");
				location = scan.nextInt();
				System.out.println("Enter element to add in Array List: ");
				element = (T) scan.next();
				if (arrayList.addElementByIndex(location - 1, element)) {
					System.out.println(element + " is added in the Array List");
				}
				else {
					System.out.println(element + " can not be added at " + location + " location.");
				}
				break;
				// Get item from Array List.	
			case 3:
				System.out.println("Enter element to find in Array List: ");
				element = (T) scan.next(); 
				position = arrayList.getElement(element);
				if (position == -1) {
					System.out.println(element + " is not present in the Array List");
				}
				else {
					System.out.println(element + " is at: " + position + " position.");
				}
				break;
				// Remove item from Array List.	
			case 4:
				System.out.println("Enter element to remove: ");
				element = (T) scan.next();
				if (arrayList.removeElement(element)) {
					System.out.println(element + " is removed from the Array List");
				}
				else {
					System.out.println(element + " is not present in the Array List");
				}
				break;
				// Remove item from Array List by location.	
			case 5:	
				System.out.println("Enter location of the element you want to remove: ");
				location = scan.nextInt();
				if (arrayList.removeElementFromPosition(location - 1)) {
					System.out.println("Element at " + location + " is removed from the Array List");
				}
				else {
					System.out.println("Element at " + location + " is not present in the Array List");
				}
				break;
				// Clear Array List.	
			case 6:
				arrayList.deleteAllElements();
				break;
				// Reverse Array List.	
			case 7:
				arrayList.reverseArrayList();
				break;
				// Sort Array List.	
			case 8:
				arrayList.sortArrayList();
				break;
				// Print Array List.	
			case 9:
				Object result[] = arrayList.printArrayList();
				if (result[0] == null) {
					System.out.println("ArrayList is empty");
				}
				for (index = 0; index < result.length; index++) {
					if (result[index] != null) {
						System.out.print(result[index] + " ");
					}
				}
				break;
				// Join two Array List.	
			case 10:
				JoinArrayList<T> joinedList = new JoinArrayList<T>();
				MyArrayList<T> newArrayList = new MyArrayList<T>();
				System.out.println("Enter number of elements you want to add into new list: ");
				num = scan.nextInt();
				for (index = 0; index < num; index++) {
					System.out.println("Enter element you want to add: ");
					element = (T) scan.next();
					newArrayList.addElement(element);
				}
				joinedList.joinTwoArrayLists(arrayList, newArrayList);
				break;
				// Exit.	
			case 11:
				scan.close();
				System.exit(0);
				break;
			}
		} while (true);
	}
}
