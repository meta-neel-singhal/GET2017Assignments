package surveymaterial;

import  helper.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * Main class which drive all the function to get the feedback of
 * a user in the survey.
 * 
 * @author Neel Singhal
 **/
public class Survey {
	/**
	 * Main function.
	 * 
	 * @param args    arguments of type string
	 */
	public static void main(String args[]) {
		Questions questions = new Questions();
		Answers answers = new Answers();
		Report print = new Report();
		FileManager reader = new FileManager();
		Scanner scan = new Scanner(System.in);

		String question[][] = {};
		String questionFilePath = Constants.QUESTION_PATH;
		String reportAPath = Constants.REPORT_A_PATH;
		String reportBPath = Constants.REPORT_B_PATH;
		String enteredValue;
		String[] choices;
		int noOfUsers;
		int noOfQuestions;

		System.out.println("Enter number of users to participate in survey :- ");
		noOfUsers = scan.nextInt();
		noOfQuestions = reader.countLines(questionFilePath);
		// Read all the question from Text file
		question = questions.getQuestionDetails(questionFilePath);
		scan.nextLine();

		// Will take inputs from all user
		for (int participant = 1; participant <= noOfUsers; participant++) {
			answers.setAnswer("Participant " + participant + ",");
			for (int index = 0; index < noOfQuestions; index++) {
				System.out.println(questions.getQuestion(question, index));
				System.out.println("Hint: Type -" + questions.getType(question, index));

				// Print options if question is of single select or multi select.
				if (question[index].length > 2) {
					System.out.println("\n" + "Options:" + questions.getOption(question, index));
				}

				// Condition for single select type questions.
				if ("Single Select".equals(questions.getType(question, index))) {
					enteredValue = scan.nextLine();

					// Checking if entered option is valid or not.
					while (questions.isValidOption(questions.getOption(question, index),
							enteredValue) == false) {
						System.out.println("Please enter the correct option");
						enteredValue = scan.nextLine();
					}
					answers.setAnswer(enteredValue + ",");
				}
				// Condition for multi select type questions.
				else if ("Multi Select".equals(questions.getType(question, index))) {
					System.out.println("Enter option in following pattern: Option1,Option2,so on...");
					enteredValue = scan.nextLine();

					// Checking entered value is valid or not
					while (questions.isValidOption(questions.getOption(question, index),
							enteredValue) == false) {
						System.out.println("Please enter the correct option");
						enteredValue = scan.nextLine();
					}

					choices = enteredValue.split(",");
					for (int count = 0; count < choices.length; count++) {
						answers.setAnswer(choices[count]);
						if (count != choices.length - 1) {
							answers.setAnswer("/");
						} 
						else {
							answers.setAnswer(",");
						}
					}
				}
				
				// Condition for (10 digit Number) type question.
				else if ("Number".equals(questions.getType(question, index))) {
					long number = 0;
					do {
						System.out.println("Enter 10 digit number");
						try {
							number = scan.nextLong();
						} catch (InputMismatchException e) {
						}
						scan.nextLine();
					} while (String.valueOf(number).length() != 10);
					answers.setAnswer(number + ",");
				}
				// Validate Text type questions
				else {
					enteredValue = scan.nextLine();
					while (enteredValue.length() == 0) {
						System.out
						.println("Enter data This field is mandantory");
						enteredValue = scan.nextLine();
					}
					answers.setAnswer(enteredValue);
					if (index != 4) {
						answers.setAnswer(",");
					}
				}
			}
			
			// Print report B
			print.printReportB(answers.getAnswer(), reportBPath);
			String[][] reportB = reader.read(reportBPath);
			// Print report A
			print.printReportA(reportB, reportB.length, reportAPath,
					reportBPath);
			// Reseting the answer data to get data of next user.
			answers.reset();
			// "-1" for next line.
			print.printReportB("-1", reportBPath);

		}
		
		/**
		 * For part B problem in which we have to sort the given question.
		 */
		question = reader.read(questionFilePath);
		List<Questions> list = new ArrayList<Questions>();
		for (int index = 0; index < question.length; index++) {
			list.add(new Questions(question[index][0]));
		}
		Collections.sort(list);
		Iterator<Questions> itr = list.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next().queString);
		}
		scan.close();
	}
}