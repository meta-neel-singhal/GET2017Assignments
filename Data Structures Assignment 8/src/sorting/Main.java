package sorting;


/**
 * Main class to initialize the sorting system which takes input from user and provide a sorted
 * list. Here User can choose if he want to go with Comparison Sorting Or Linear Sorting.
 * 
 * @author Neel Singhal
 */
public class Main {

	/**
	 * Main method which takes the user choice and makes the program flow accordingly.
	 * 
	 * @param args    the arguments.
	 */
	public static void main(String[] args) {
		int choice, 
			size = 0,
			max;
		int[] array = null;
		do {
			Input.printMenu();
			choice = Input.takeIntegerAsInput();
			
			switch (choice) {
			// When user wants to input an array.
			case 1:
				System.out.println("Enter the no. of elements to insert in the array : ");
				size = Input.takeIntegerAsInput();
				array = new int[size];
				System.out.println("Enter " + size + " elements.");
				// Insert the value in the array.
				for (int count = 0; count < size; count++) {
					array[count] = Input.takeIntegerAsInput();
					// To take positive input from the user.
					if (array[count] < 0) {
						System.out.println("Please Enter positive value");
						count--;
					}
				}
				break;
			// When user wants to use Comparison Sort. 
			case 2:
				try {
					// When input elements <= 10 use Bubble Sort.
					if (array.length <= 10) {
						array = ComparisonSort.bubbleSort(array);
						System.out.println("Using Bubble Sort...");
					}
					// Else use Quick Sort.
					else {
						array = ComparisonSort.quickSort(array, 0, size - 1);
						System.out.println("Using Quick Sort...");
					}
					//Prints the sorted array.
					printArray(array, size);
				}
				catch (NullPointerException exception) {
					System.out.println("Array is empty !");
				}
				break;
			// When user wants to use Linear Sort. 
			case 3:
				try{
					// Maximum element of the array.
					max = findMax(array);
					// When input array ha element having more than 2 digit use Radix Sort.
					if ((max / 100) > 0) {
						array = LinearSort.radixSort(array, max);
						System.out.println("Using Radix Sort...");
					}
					// Else use Counting Sort.
					else {
						array = LinearSort.countingSort(array, size, max, 0, max + 1);
						System.out.println("Using Counting Sort...");
					}
				}
				catch (NullPointerException exception) {
					System.out.println("Array is empty !");
				}
				//Prints the sorted array.
				printArray(array, size);
				break;
			// Exit.
			default:
				System.out.println("Thank You.");
				System.exit(0);
				break;
			}
		} while (true);
	}

	/**
	 * Finds the maximum element in the array.
	 * 
	 * @param array    the input array.
	 * @return the maximum element.
	 */
	public static int findMax(int[] array) {
		int max = array[0];
		/* 
		 * Comparing every element of array with max and if any element greater than
		 * max is found update the value of max.
		 */
		for (int count = 1; count < array.length; count++) {
			if (max < array[count]) {
				max = array[count];
			}
		}

		return max;
	}	

	/**
	 * Prints the array.
	 * 
	 * @param array    array to be displayed.
	 * @param size     size of the array.
	 */
	private static void printArray(int[] array, int size) {
		for (int index = 0; index < size; index++) {
			System.out.print(array[index] + " ");
		}
		System.out.println();
	}
}
