package queue.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import queue.facade.CounselingFacade;
import queue.model.Candidate;
import queue.model.College;
import queue.utility.ArrayList;
import queue.utility.Queue;

/**
 * The CollegeCounseling class to perform the counseling operation.
 * 
 * @author Neel Singhal
 */
public class CollegeCounseling {
	BufferedReader bufferedReader;

	/**
	 * Default Constructor.
	 */
	public CollegeCounseling() {
		bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		int totalSeats;
		ArrayList<College> collegesList;
		Queue<Candidate> candidatesQueue;
		Map<String, String> assignedColleges;
		CollegeCounseling collegeCounselling = new CollegeCounseling();

		CounselingFacade counseling = new CounselingFacade();

		try {
			System.out.println("Welcome to college counselling process.");
			collegesList = counseling.getAllColleges();
			candidatesQueue = counseling.getAllCandidates();
			totalSeats = counseling.getTotalSeats(collegesList);
			assignedColleges = new HashMap<String, String>();
			assignedColleges = counseling.collegeCounsellingProcess(collegesList, candidatesQueue, totalSeats);
			System.out.println("Assigned Colleges: ");
			// Displays the candidate name and the college assigned to him.
			for (Map.Entry<String, String> entry : assignedColleges.entrySet()) {
				System.out.println("candidate Name: " + entry.getKey() + " , " + " assigned college: " + entry.getValue());
			}
		} 
		finally {
			try {
				// Closing the input stream
				collegeCounselling.bufferedReader.close();
			}
			catch (Exception exception) {
				System.out.println("Something went wrong: " + exception.getMessage());
			}
		}
	}

	/**
	 * Gets the user input.
	 *
	 * @param message     the message
	 * @return user input
	 */
	public int getUserInput(String message) {
		int userInput = 0;
		try {
			System.out.println(message);
			userInput = Integer.parseInt(bufferedReader.readLine());
			while (userInput <= 0) {
				getUserInput(message);
			}
		}
		catch (Exception exception) {
			System.out.println("Something went wrong: " + exception.getMessage());
			getUserInput(message);
		}

		return userInput;
	}
}