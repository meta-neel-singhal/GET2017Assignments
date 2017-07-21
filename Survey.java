import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class Survey {
	public static void main(String args[]) {

		Question questionObject = new Question();
		Scanner scanItem = new Scanner(System.in);

		String question[][] = {};
		System.out.println("Enter number of the users participating in the survey : ");
		
		int totalNumberOfUsers = scanItem.nextInt();
		question = questionObject.readFile("C:/Users/Neel Singhal/Desktop/Questions.txt");
		
		for (int index = 0; index < totalNumberOfUsers; index++) {
			questionObject.takeInputFromUser(index + 1, question);
		}
		question = questionObject.readFile("C:/Users/Neel Singhal/Desktop/Report-B.txt");
		
		int percentageOfResponses[] = new int[6];
		int questionNumber;
		
		for (int index = 0; index < totalNumberOfUsers; index++) {
			questionNumber = Integer.parseInt(question[index][1]);
			percentageOfResponses[questionNumber] += 1;
		}
		
		//will find the percentage of the result
		for (int index = 1; index <= 5; index++) {
			if (percentageOfResponses[index] != 0) {
				percentageOfResponses[index] = (int)((percentageOfResponses[index] / (float) totalNumberOfUsers) * 100);
				questionObject.writeFile(index + " - " + percentageOfResponses[index] + "%","C:/Users/Neel Singhal/Desktop/Report-A.txt");
				questionObject.writeFile("-1", "C:/Users/Neel Singhal/Desktop/Report-A.txt");
			} 
			else {
				questionObject.writeFile(index + " - " + percentageOfResponses[index] + "%","C:/Users/Neel Singhal/Desktop/Report-A.txt");
				questionObject.writeFile("-1", "C:/Users/Neel Singhal/Desktop/Report-A.txt");
			}
		}
		
		/**
		 * for part B problem in which we have to sort
		 * the given question
		 * 
		 */
		question = questionObject.readFile("C:/Users/Neel Singhal/Desktop/Questions.txt");
		List<Question> listOfQuestions = new ArrayList<Question>();
		for (int index = 0; index < question.length; index++) {
			listOfQuestions.add(new Question(question[index][0]));
		}
		
		Iterator<Question> iterate = listOfQuestions.iterator();
		Collections.sort(listOfQuestions);
		
		while (iterate.hasNext()) {
			System.out.println(iterate.next().question);
		}
	}
}
