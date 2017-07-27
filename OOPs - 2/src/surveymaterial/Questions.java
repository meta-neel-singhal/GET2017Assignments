package surveymaterial;

import helper.FileManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Contains all the questions and also helps to sort the questions.
 * 
 * @author Neel Singhal
 */
public class Questions implements Comparable<Questions> {
	String queString;

	// Default constructor
	public Questions() {

	}

	/**
	 * Initializing questions string 
	 * 
	 * @param queString    String containing questions
	 */
	public Questions(String queString) {
		this.queString = queString;
	}

	// Implements Comparable.compareTo
	// Compares the questions from question object.
	public int compareTo(Questions newQue) {

		return queString.compareTo(newQue.queString);
	}

	/**
	 * Read the questions file and return its details.
	 * 
	 * @param filePath    Location of Questions text file.
	 * @return questions details
	 */
	public String[][] getQuestionDetails(String filePath) {

		return new FileManager().read(filePath);
	}

	/**
	 * Returns Question
	 * 
	 * @param question    question details
	 * @param index       index of question
	 * @return String     contains question
	 */
	public String getQuestion(String[][] question, int index) {

		return question[index][0];
	}

	/**
	 * Returns the type of question
	 * 
	 * @param question    question details
	 * @param index       index of question
	 * @return String of question's type
	 */
	public String getType(String[][] question, int index) {

		return question[index][1];
	}

	/**
	 * Return options of that Question
	 * 
	 * @param question    question details
	 * @param index       index of question
	 * @return String of Options of that question
	 */
	public String getOption(String[][] question, int index) {

		return question[index][2];
	}

	/**
	 * Checking whether the option entered by user is valid or not.
	 * 
	 * @param givenOptions     Option available for user.
	 * @param enteredOption    Option or Options entered by user.
	 * @return true if valid else false.
	 */
	public boolean isValidOption(String givenOptions, String enteredOption) {
		String[] enteredValue = enteredOption.split("\\,");
		List<String> checkList = new ArrayList<String>();
		String[] option = givenOptions.split("/");
		List<String> opt = Arrays.asList(option);
		checkList.addAll(opt);
		if (checkList.size() < enteredValue.length) {
			
			return false;
		}
		for (int count = 0; count < enteredValue.length; count++) {
			if (!checkList.contains(enteredValue[count])) {
				
				return false;
			}
		}

		return true;
	}
}
