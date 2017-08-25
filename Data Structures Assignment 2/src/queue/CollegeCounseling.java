package queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

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

		try {
			System.out.println("Welcome to college counselling process.");
			collegesList = collegeCounselling.createListOfColleges();
			candidatesQueue = collegeCounselling.createQueueOfCandidates();
			totalSeats = collegeCounselling.getTotalSeats(collegesList);
			assignedColleges = new HashMap<String, String>();
			assignedColleges = collegeCounselling.collegeCounsellingProcess(collegesList, candidatesQueue, totalSeats);
			System.out.println("Assigned Colleges: ");

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
	 * Allots the colleges to student until all the students are alloted college or all the seats are full.
	 *
	 * @param collegesList       the colleges list
	 * @param candidatesQueue    the candidates queue
	 * @param totalSeats         the total seats
	 * @return Map consisting candidates and the colleges alloted to them.
	 */
	public Map<String, String> collegeCounsellingProcess(ArrayList<College> collegesList, Queue<Candidate> candidatesQueue, int totalSeats) {
		Map<String, String> assignedColleges  = new HashMap<String, String>();

		try {
			int userInput = 0;
			int numberOfSeats;
			String candidateName = "";

			// Until all the candidates get the seats or all the seats are full.
			while (candidatesQueue.getSize() != 0 && totalSeats != 0) {
				numberOfSeats = 0;
				candidateName = candidatesQueue.getFront().getCandidateName();
				System.out.println("College List is: ");
				
				for (int i = 0 ;i < collegesList.getSize() ; ++i) {
					College college = collegesList.getElement(i);
					System.out.println((i+1)+"."+" Name: "+college.getCollegeName() + 
							" Rank: "+college.getCollegeRank()
							+" Seats Available: "+college.getCollegeSeats());
				}
				
				userInput = getUserInput("Candidate: "+candidateName + " Please enter the college number you want to select");
				// Check if user input is greater than the total colleges.
				if (userInput > collegesList.getSize()) {
					System.out.println("Invalid Input. Try Again");
				}
				// Else get the total seats in that college.
				else {
					numberOfSeats = collegesList.getElement(userInput - 1).getCollegeSeats();
				}
				
				/**
				 *  Check if the college chosen has seats available decrease total seats and no. of seats in that
				 *  college and dequeue the candidate from the queue and allot him the chosen college.
				 */
				if (numberOfSeats > 0) {
					totalSeats = totalSeats - 1;
					candidateName = candidatesQueue.dequeue().getCandidateName();
					assignedColleges.put(candidateName, collegesList.getElement(userInput - 1).getCollegeName());
					numberOfSeats--;
					College college = collegesList.getElement(userInput -1 );
					college.setCollegeSeats(numberOfSeats);
					collegesList.overwriteElement(userInput - 1, college);
				}
				// If no seats are available in the chosen college.
				else {
					System.out.println("The college you entered is already full. Please select another college");
				}
			}

		}
		catch (Exception exception) {
			System.out.println("Something went wrong: " + exception.getMessage());
		}

		return assignedColleges;
	}


	/**
	 * Creates the list of colleges.
	 *
	 * @return array list of colleges
	 */
	public ArrayList<College> createListOfColleges() {
		ArrayList<College> collegeLists = new ArrayList<College>();

		try {
			College college1 = new College("Amity University", 1,1);
			College college2 = new College("LNMIIT", 2,1);
			College college3 = new College("JECRC",3,2);
			College college4 = new College("SKIT",4,3);
			College college5 = new College("Poornima University", 5,3);
			College college6 = new College("Jaipur University", 6,2);

			collegeLists.add(college1);
			collegeLists.add(college2);
			collegeLists.add(college3);
			collegeLists.add(college4);
			collegeLists.add(college5);
			collegeLists.add(college6);
		}
		catch (Exception exception) {
			System.out.println("Something went wrong: " + exception.getMessage());
			createListOfColleges();
		}

		return collegeLists;
	}

	/**
	 * Creates the queue of candidates.
	 *
	 * @return queue of candidate
	 */
	public Queue<Candidate> createQueueOfCandidates() {
		Queue<Candidate> candidates = new Queue<Candidate>();

		try {
			Candidate candidate1 = new Candidate("Candidate 1", 1);
			Candidate candidate2 = new Candidate("Candidate 2", 2);
			Candidate candidate3 = new Candidate("Candidate 3", 3);
			Candidate candidate4 = new Candidate("Candidate 4", 4);
			Candidate candidate5 = new Candidate("Candidate 5", 5);
			Candidate candidate6 = new Candidate("Candidate 6", 6);
			Candidate candidate7 = new Candidate("Candidate 7", 7);
			Candidate candidate8 = new Candidate("Candidate 8", 8);
			Candidate candidate9 = new Candidate("Candidate 9", 9);
			Candidate candidate10 = new Candidate("Candidate 10", 10);
			Candidate candidate11 = new Candidate("Candidate 11", 11);
			Candidate candidate12 = new Candidate("Candidate 12", 12);
			Candidate candidate13 = new Candidate("Candidate 13", 13);

			candidates.enqueue(candidate1);
			candidates.enqueue(candidate2);
			candidates.enqueue(candidate3);
			candidates.enqueue(candidate4);
			candidates.enqueue(candidate5);
			candidates.enqueue(candidate6);
			candidates.enqueue(candidate7);
			candidates.enqueue(candidate8);
			candidates.enqueue(candidate9);
			candidates.enqueue(candidate10);
			candidates.enqueue(candidate11);
			candidates.enqueue(candidate12);
			candidates.enqueue(candidate13);
		}
		catch (Exception exception) {
			System.out.println("Something went wrong: " + exception.getMessage());
			createQueueOfCandidates();
		}

		return candidates;

	}

	/**
	 * Gets the total seats.
	 *
	 * @param collegesList the colleges list
	 * @return total seats available
	 */
	public int getTotalSeats(ArrayList<College> collegesList) {
		int totalSeats = 0;
		try {
			for (int i = 0; i < collegesList.getSize(); i++) {
				totalSeats += collegesList.getElement(i).getCollegeSeats();
			}
		}
		catch (Exception exception) {
			System.out.println("Something went wrong: " + exception.getMessage());
			getTotalSeats(collegesList);
		}

		return totalSeats;
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