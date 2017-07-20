/**
 * Performs various operations of calculator on the operands.
 * @author Neel Singhal
 */
public class Operator {

	/**
	 * Addition of two numbers i.e. firstNumber and secondNumber.
	 * 
	 * @param firstNumber     First operand.
	 * @param secondNumber    Second operand.
	 * @return the result of operation.
	 */
	public double addition(double firstNumber, double secondNumber) {
		double result = 0.0;
		result = firstNumber + secondNumber;
		return result;
	}

	/**
	 * Subtraction of two numbers i.e. firstNumber and secondNumber.
	 * 
	 * @param firstNumber     First operand.
	 * @param secondNumber    Second operand.
	 * @return the result of operation.
	 */
	public double subtraction(double firstNumber, double secondNumber) {
		double result = 0.0;
		result = firstNumber - secondNumber;
		return result;
	}

	/**
	 * Division of two numbers i.e. firstNumber and secondNumber.
	 * 
	 * @param firstNumber     First operand.
	 * @param secondNumber    Second operand.
	 * @return the result of operation.
	 */
	public double division(double firstNumber, double secondNumber) {
		// Handles divide by zero exception
		double result = 0.0;
		result = firstNumber / secondNumber;
		return result;
	}

	/**
	 * Multiplication of two numbers i.e. firstNumber and secondNumber.
	 * 
	 * @param firstNumber     First operand.
	 * @param secondNumber    Second operand.
	 * @return the result of operation.
	 */
	public double multiply(double firstNumber, double secondNumber) {
		double result = 0.0;
		result = firstNumber * secondNumber;
		return result;
	}

	/**
	 * Modulus of two numbers i.e. firstNumber and secondNumber.
	 * 
	 * @param firstNumber     First operand.
	 * @param secondNumber    Second operand.
	 * @return the result of operation.
	 */
	public double modulus(double firstNumber, double secondNumber) {
		double result = 0.0;
		result = firstNumber % secondNumber;
		return result;
	}

	/*
	 * Similarly more functions can be added according to the user's 
	 * requirement.
	 */
}
