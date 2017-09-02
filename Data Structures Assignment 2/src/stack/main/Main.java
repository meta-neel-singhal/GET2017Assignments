package stack.main;

import java.util.Scanner;

import stack.stack.Stack;

/**
 * Main class that invokes the required operation.
 * 
 * @author Neel Singhal
 */
public class Main {

	/**
	 * The main method to take input from user and call the convertInfixToPostfix function.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String infix;
		String[] postfix;
		Stack<String> operatorStack;
		String option;
		int index;
		boolean flag = false;
		
		do {
			System.out.println("\nEnter the infix expression you want to convert : ");
			infix = scan.next();
			operatorStack = new Stack<String>();
			postfix = operatorStack.convertInfixToPostfix(infix);
			// Prints the postfix expression of the input infix expression.
			System.out.print("Postfix Expression is : ");    
			for (index = 0; index < infix.length() && postfix[index] != null; index++) {
				System.out.print(postfix[index]);    
			}
			System.out.println("\nPress Y to continue : ");
			option = scan.next();
			// Check if user wants to continue or not.
			switch (option) {
				case "y":
				case "Y":
					flag = true;
					break;
				default:
					flag = false;
					System.out.println("Thank You !");
					break;
			}
		} while (flag);	
	}
}
