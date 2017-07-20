/**
 * Class for calculator applications.
 * @author Neel Singhal
 */
public class Calculator {
	double operand1;
	double operand2;
	char operator;
	char newOperator;
	Operator operation;

	public void getInput(String input) {
		/*
		 * Checks if the operator or operands fetched is not empty.
		 * And until the operator and operands are provided gets their
		 * value and insert in their respective variable or instance 
		 * variable.
		 * Initially takes the first operand in operand1 then the 
		 * operator in operator variable and then the second operand in
		 * operand2.
		 * If equals to ('=') or any other operator is pressed then it is
		 * stored in the newOperator and then calculation is done..
		 */
				
		this.calculate();
		// Handles all the exceptions if expression is invalid.
	}

	public void calculate(){
		/* Check for operator and call appropriate method from operator 
		 * class and store the result in operator variable.
		 */
		this.setOutput();
		operator = newOperator;

	}

	public void setOutput() {
		// Sets the output to be displayed.
		new Display(this.operand1);
		new Display(this.operand2);
		new Display(this.operator);
		new Display(this.newOperator);
	}
}
