package binarysearch;

import java.util.Scanner;

/**
 * Main class to initialize the array and search an element using binary search.
 *  
 * @author Neel Singhal
 */
public class Main {

	/**
	 * Method to initialize array and search a element in it.
	 * 
	 * @param args    the arguments.
	 */
	public static void main(String[] args) {
		int[] array;
		int elementToSearch, 
			locationOfElement, 
			size;
		Scanner scan = new Scanner(System.in);
		BinarySearch searchObject = new BinarySearch();

		System.out.println("Enter the no. of elements to insert in the array : ");
		size = Input.takeIntegerAsInput();
		array = new int[size];
		System.out.println("Enter " + size + " elements.");
		// Initialize the array.
		for (int count = 0; count < size; count++) {
			array[count] = Input.takeIntegerAsInput();
			if (!(count == 0 || array[count] >= array[count - 1])) {
				System.out.println("Please enter a sorted array.");
				count--;
			}
		}
		// Run till user wants to search elements.
		do {
			System.out.println("Enter the element you want to search : ");
			elementToSearch = Input.takeIntegerAsInput();

			// Call the method to find an element in the array using binary search.
			locationOfElement = searchObject.findElement(array, 0, size - 1, elementToSearch);
			// Check if the element was found or not.
			if (locationOfElement == -1) {
				System.out.println("Element not found !");
			}
			else {
				System.out.println("Element is found at position : " + (locationOfElement + 1));
			}
			System.out.println("Press Y to continue searching : ");
		} while (scan.next().equalsIgnoreCase("y"));
		
		System.out.println("Thank You.");
	}
}