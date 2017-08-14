package surveymaterial;
/**
 * Handles data given by the user.
 * 
 * @author Neel Singhal
 */
public class Answers {
	private String answer = "";

	/**
	 * Save the data entered by user in the answer string.
	 * 
	 * @param enteredData    Data entered by user
	 */
	public void setAnswer(String enteredData) {
		answer += enteredData;
	}

	/**
	 * Returns the data entered by user.
	 * 
	 * @return answer string that contains data entered by user.
	 */
	public String getAnswer() {

		return answer;
	}

	/**
	 * Reset the answer field to empty.
	 */
	public void reset() {
		answer = "";
	}

}
