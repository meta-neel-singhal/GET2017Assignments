package stack.stack;

/**
 * The Stack class.
 *
 * @param <T>    Generic type
 */
public class Stack<T> {

	public Node<T> top = null;
	Node<T> node = new Node<T>();
	int size = 0;

	/**
	 * Push operation of the stack.
	 *
	 * @param data    data of the node.
	 * @return the node.
	 */
	public Node<T> push(T data) {
		Node<T> newNode = node.getNode(data);
		newNode.previous = this.top;
		this.top = newNode;
		this.size++;
		printData();
		
		return newNode;
	}

	/**
	 * Pop operation of the stack.
	 *
	 * @return the data of the popped node.
	 */
	public T pop() {
		Node<T> tempNode = null;
		// Check if stack is empty.
		if (1 > this.size) {
			System.out.println("Underflow condition ! Cannot perform pop operation !");
		} 
		else {
			tempNode = this.top;
			this.top = this.top.previous;
			this.size--;
			System.out.println("Node deleted");
			printData();
		}

		return tempNode.data;
	}

	/**
	 * Prints the data on the console.
	 */
	private void printData() {
		Node<T> pointer = this.top;
		Node<T> tempNode = null;
		// Check if the stack is empty.
		if (pointer == null) {
			System.out.print("Stack is empty !\n");
		} 
		else {
			while (pointer.previous != null) {
				tempNode = pointer;
				pointer = pointer.previous;
				System.out.print(tempNode.data + " <-- ");
			}
			System.out.println(pointer.data);
		}
	}

	/**
	 * Checks if the character is an operator.
	 *
	 * @param data    data to check.
	 * @return true, if is operator.
	 */
	private boolean isOperator(String data) {
		boolean flag = false;
		if (data.charAt(0) == '+' || data.charAt(0) == '-' || data.charAt(0) == '*' || data.charAt(0) == '/') {
			flag = true;
		}

		return flag;
	}

	/**
	 * Checks if is the character is an alphabet or numeric value.
	 *
	 * @param dataa    data to check.
	 * @return true, if is alpha-numeric.
	 */
	private boolean isAlphaNumeric(String data) { 
		boolean flag = false;    
		if (data.charAt(0) >= 'a' && data.charAt(0) <= 'z' || data.charAt(0) >= 'A' && data.charAt(0) <= 'Z' 
				|| data.charAt(0) >= '0' && data.charAt(0) <= '9') {
			flag = true; 
		}

		return flag; 
	} 

	/**
	 * Get priority of the operators.
	 *
	 * @param data    operator to check.
	 * @return the priority.
	 */
	private int priority(String data) { 
		int priority = 0;
		switch (data.charAt(0)) { 
			case '-':
			case '+':
				priority = 1;
				break;
			case '*':
			case '/':
				priority = 2;
				break;
		} 

		return priority;
	} 

	/**
	 * Convert infix to postfix expression.
	 *
	 * @param infix    input infix expression.
	 */
	public String[] convertInfixToPostfix(String infix) { 
		if (infix != null) {
			String output[] = new String[infix.length()];
			String data;
			int index = 0;
			int count; 
			for (count = 0; count < infix.length(); count++) { 
				data = infix.charAt(count) + ""; 
				// Push '(' in the stack.
				if (data.charAt(0) == '(') { 
					push((T) data);
				}
				// Add character to output array if it is an alphabet or numeric value.
				else if (isAlphaNumeric(data)) { 
					output[index++] = data; 
				}
				// Add character to output array if it is an operator.
				else if (isOperator(data)) {
					// If the incoming operator has higher precedence than the top of the stack, push it on the stack. 
					if (this.top == null || (priority(data) > priority((String) this.top.data)) 
							|| this.top.data.toString().charAt(0) == '(') { 
						push((T) data); 
					}
					/* 	
					 * If the incoming operator has lower precedence than the operator on the top of the stack,
					 * pop the stack and print the top operator. Then test the incoming operator against the new top of stack.
					 */
					else if (priority(data) <= priority((String) this.top.data)) { 
						while (this.top != null && (priority(data) <= priority((String) this.top.data))) {
							output[index++] = (String) pop();
							System.out.println(output[index]);
						}
						push((T) data);
					}
				}  
				//	If ')' occurs, pop the stack and print the operators until we get '('.
				else if (data.charAt(0) == ')') { 
					while ((data = (String) pop()).charAt(0) != '(') { 
						output[index++] = data;
					} 
				}    
			} 
			// At the end of the expression, pop and print all operators in the stack.
			while (top != null) { 
				output[index++] = (String) pop();
			} 
			// Prints the resultant postfix expression.
			return output;
		}
		
		return null;	
	}
}
