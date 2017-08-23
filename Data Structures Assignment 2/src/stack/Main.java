package stack;

import java.util.Scanner;

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
		boolean flag = false;
		
		do{
			System.out.println("\nEnter the infix expression you want to convert : ");
			infix = scan.next();
			operatorStack = new Stack<String>();
			postfix = operatorStack.convertInfixToPostfix(infix);

			System.out.print("Postfix Expression is : ");    
			for(int index = 0; index < infix.length() && postfix[index] != null; index++) {
				System.out.print(postfix[index]);    
			}
			System.out.println("\nPress Y to continue : ");
			option = scan.next();

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
