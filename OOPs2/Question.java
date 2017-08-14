import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.hamcrest.core.IsNull;

/**
 * Reads the question from the file, process it and writes on the output file.
 * 
 * @author Neel Singhal
 */
public class Question implements Comparable<Question> {
	String question;

	// Parameterized constructor.
	public Question(String question) {
		this.question = question;
	}

	// Default constructor.
	public Question() {

	}

	static Scanner scanItem = new Scanner(System.in);

	/**
	 * Reads the file to get the questions and their information.
	 * 
	 * @param filePath
	 * @return
	 */
	public String[][] readFile(String filePath) {
		int index = 0;
		String question[][] = new String[5][];
		try {
			FileInputStream stream = new FileInputStream(filePath);
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					stream));
			String data = "";
			data = reader.readLine();
			while (data != null) {
				question[index++] = data.split(",");
				data = reader.readLine();
			}
			reader.close();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return question;
	}

	/**
	 * Writes on the output file.
	 *
	 * @param data
	 * @param filePath
	 */
	public void writeFile(String data, String filePath) {
		try {
			FileWriter fileWrite = new FileWriter(new File(filePath), true);
			BufferedWriter writer = new BufferedWriter(fileWrite);

			if (data.equals("-1")) {
				writer.newLine();
			} else {
				writer.write(data);
			}
			writer.close();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	/**
	 * Helps to take inputs from the users.
	 *
	 * @param participant
	 * @param questions
	 */
	public void takeInputFromUser(int participant, String questions[][]) {
		int answer1;
		String answer2;
		String answer3 = "";
		long answer4 = 0;

		for (int rowIndex = 0; rowIndex < questions.length; rowIndex++) {
			for (int columnIndex = 0; columnIndex < questions[rowIndex].length; columnIndex++) {
				System.out.println(questions[rowIndex][columnIndex]);
			}

			// Checks for single type question and its validation.
			if ("(Type) Single Select".equals(questions[rowIndex][1])) {
				answer1 = checkSingleType();
				writeFile("Participant" + " " + participant + "," + answer1,
						Constants.REPORT_B_PATH);
			}
			// Checks for multiple type question and its validation.
			else if ("(Type) Multi Select".equals(questions[rowIndex][1])) {
				answer2 = checkMultiType();
				writeFile("," + answer2, Constants.REPORT_B_PATH);
			}

			// Checks for text type question and its validation.
			else if ("(Type)Text".equals(questions[rowIndex][1])) {
				answer3 = checkTextType();
				writeFile("," + answer3, Constants.REPORT_B_PATH);
			}

			// Checks for number type question and its validation.
			else if ("(Type) Number".equals(questions[rowIndex][1])) {
				answer4 = checkNumberType();
				writeFile("," + answer4, Constants.REPORT_B_PATH);
			}
		}
		writeFile("-1", Constants.REPORT_B_PATH);
	}

	/**
	 * @return answers for single type questions.
	 */
	public static int checkSingleType() {
		int answer1 = 0;
		do {
			try {
				System.out.print("Enter correct option from 1 to 5");
				answer1 = scanItem.nextInt();

			} catch (InputMismatchException e) {

			}
			scanItem.nextLine();
		} while ((answer1 < 0) || (answer1 > 5));
		return answer1;
	}

	/**
	 * @return answers for multi type questions.
	 */
	public static String checkMultiType() {

		int optionIndex;
		String answer2;

		List<String> checkList = new ArrayList<String>();
		checkList.add("Service Quality");
		checkList.add("Communication");
		checkList.add("Delivery Process");
		String[] chosenArray;

		System.out.print("Please enter comma separated values");
		answer2 = scanItem.nextLine();
		optionIndex = 0;
		boolean flag = false;
		chosenArray = answer2.split(",");
		while (!flag) {
			if (!checkList.contains(chosenArray[optionIndex])) {
				answer2 = scanItem.nextLine();
				chosenArray = answer2.split(",");

				optionIndex = 0;
			} else {
				if (optionIndex < chosenArray.length - 1) {
					optionIndex++;
				} else {
					flag = true;
				}
			}
		}
		return answer2;

	}

	/**
	 * @return answers for text type questions.
	 */
	public static String checkTextType() {
		String answer3;
		answer3 = scanItem.nextLine();
		while (answer3.length() == 0) {
			System.out.println("Please give your answer");
			answer3 = scanItem.nextLine();
		}
		return answer3;
	}

	/**
	 * @return answers for number type questions.
	 */
	public static long checkNumberType() {
		long answer4 = 0;
		do {
			try {
				System.out.print("Enter 10 digit number");
				answer4 = scanItem.nextLong();
			} catch (InputMismatchException e) {
			}
			scanItem.nextLine();
		} while (String.valueOf(answer4).length() != 10);

		return answer4;
	}

	@Override
	public int compareTo(Question comparedQuestion) {
		String nextQuestion = comparedQuestion.question;

		return question.compareTo(nextQuestion);
	}
}