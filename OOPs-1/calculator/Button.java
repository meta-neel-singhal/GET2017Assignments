/**
 * Determine which button is pressed and set size of each button.
 * 
 * @author Neel Singhal
 */
public class Button {
	String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void setButtonPosition(){
		// To set position for a particular button and calls for setButtonLayout..
		this.setButtonLayout(2,2,2,2);
	}

	/**
	 * @param row_index       row position of the button.
	 * @param column_index    column position of the button.
	 * @param height		  height of the button.
	 * @param width           width of the button.
	 */
	public void setButtonLayout(int row_index, int column_index, int height, int width) {
		/* This will set the layout for the button such as the 
		 * height and width of a button.
		 */
	}

	public void buttonEvents(){
		// This will help to perform operations on buttons such as onClick event.
		Calculator calculator = new Calculator();
		calculator.getInput(this.getValue());
	}

}
