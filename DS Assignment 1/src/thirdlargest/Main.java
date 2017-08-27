package thirdlargest;

/**
 * Main class to initialize the array and find the third largest element in it.
 * 
 * @author Neel Singhal
 */
public class Main {

	/**
	 * Method to initialize and find the third largest element in the array.
	 * 
	 * @param args    the arguments.
	 */
	public static void main(String[] args) {
		double[] array;
		double thirdLargest;
		int size;
		ThirdLargest object = new ThirdLargest();

		System.out.println("Enter the no. of elements to insert in the array : ");
		size = (int) Input.takeDoubleAsInput();
		array = new double[size];
		System.out.println("Enter " + size + " elements.");
		// Initialize the array.
		for (int count = 0; count < size; count++) {
			array[count] = Input.takeDoubleAsInput();
		}
		// Call the function to find the third largest element in the array.
		thirdLargest = object.thirdLargest(array, size);
		// Check if the array is of at least 3 elements.
		if (thirdLargest != Double.NEGATIVE_INFINITY) {
			System.out.println("The third Largest element is : " + thirdLargest);
		}
		else {
			System.out.println("Third largest cannot be found because the array contains only "
					+ size + " elements");
		}
	}
}
