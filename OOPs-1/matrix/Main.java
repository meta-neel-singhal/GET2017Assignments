import java.util.Scanner;


public class Main {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the no. of rows of matrix1 : ");
		int noOfRows1 = input.nextInt();
		System.out.println("Enter the no. of columns of matrix1 : ");
		int noOfCols1 = input.nextInt();

		Matrix newMatrix1 = new Matrix(noOfRows1, noOfCols1);

		System.out.println("Enter the values of matrix1 : ");

		for (int i = 0; i < noOfRows1; i++) {
			for (int j = 0; j < noOfCols1; j++) {
				int value = input.nextInt();
				newMatrix1.addElements(i, j, value);
			}
		}
		System.out.println("First Matrix : ");
		System.out.println(newMatrix1.show());
	
		Matrix transposeMatrix = newMatrix1.transpose();
		System.out.println("Transpose of first matrix : ");
		System.out.println(transposeMatrix.show());
		
		System.out.println("Enter the no. of rows of matrix2 : ");
		int noOfRows2 = input.nextInt();
		System.out.println("Enter the no. of columns of matrix2 : ");
		int noOfCols2 = input.nextInt();
		System.out.println("Enter the values of matrix2 : ");
		Matrix newMatrix2 = new Matrix(noOfRows2, noOfCols2);
		
		for (int i = 0; i < noOfRows2; i++) {
			for (int j = 0; j < noOfCols2; j++) {
				int value = input.nextInt();
				newMatrix2.addElements(i, j, value);
			}
		}
		System.out.println("Second Matrix : ");
		System.out.println(newMatrix2.show());
		
		Matrix multipliedMatrix = new Matrix(noOfRows1, noOfCols1);
		multipliedMatrix = newMatrix1.multiplication(newMatrix2);
		System.out.println("Multiplicatoin of matrices : ");
		System.out.println(multipliedMatrix.show());
	}
}
