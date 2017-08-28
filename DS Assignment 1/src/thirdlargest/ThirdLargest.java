package thirdlargest;


public class ThirdLargest {
	public double thirdLargest(double array[], int size) {
		double first;
		double second = Double.NEGATIVE_INFINITY;
		double third = Double.NEGATIVE_INFINITY;

		// There should be at least three elements.
		if (size >= 3) {	 
			// Initialize first, second and third largest element.
			first = array[0];

			// Traverse array elements to find the third largest element.
			for (int count = 1; count < size; count++) {
				/*
				 * If current element is greater than first, then update
				 * first, second and third.
				 */
				if (array[count] > first) {
					third  = second;
					second = first;
					first  = array[count];
				}
				// If current element is in between first and second.
				else if (array[count] > second) {
					third = second;
					second = array[count];
				}
				// If current element is in between second and third.
				else if (array[count] > third) {
					third = array[count];
				}
			}
		}
		
		return third;
	}
}

