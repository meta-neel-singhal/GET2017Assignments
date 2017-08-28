package queue.facade;

import java.util.HashMap;
import java.util.Map;

import queue.main.CollegeCounseling;
import queue.dao.CandidatesDaoImpl;
import queue.dao.CollegeDaoImpl;
import queue.model.Candidate;
import queue.model.College;
import queue.utility.ArrayList;
import queue.utility.Queue;

/**
 * Interacts with dao and performs all the operations related to the seat allotment.
 * 
 * @author Neel Singhal
 */
public class CounselingFacade {

	/**
	 * Allots the colleges to student until all the students are alloted college or
	 * all the seats are full.
	 *
	 * @param collegesList       the colleges list.
	 * @param candidatesQueue    the candidates queue.
	 * @param totalSeats         the total seats.
	 * @return Map consisting candidates and the colleges alloted to them.
	 */
	public Map<String, String> collegeCounsellingProcess(ArrayList<College> collegesList,
			Queue<Candidate> candidatesQueue, int totalSeats) {
		Map<String, String> assignedColleges  = new HashMap<String, String>();
		CollegeCounseling input = new CollegeCounseling();
		boolean flag = true;
		int userInput, numberOfSeats, index;
		String candidateName;

		while (flag) {
			try {
				userInput = 0;
				candidateName = "";

				// Until all the candidates get the seats or all the seats are full.
				while (candidatesQueue.getSize() != 0 && totalSeats != 0) {
					numberOfSeats = 0;
					candidateName = candidatesQueue.getFront().getCandidateName();
					System.out.println("College List is: ");

					for (index = 0; index < collegesList.getSize(); ++index) {
						College college = collegesList.getElement(index);
						System.out.println((index + 1) + "." + " Name: " + college.getCollegeName()
								+ " Rank: " + college.getCollegeRank() 
								+ " Seats Available: " + college.getCollegeSeats());
					}

					userInput = input.getUserInput("Candidate: " + candidateName 
							+ " Please enter the college number you want to select");
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
						College college = collegesList.getElement(userInput - 1);
						college.setCollegeSeats(numberOfSeats);
						collegesList.overwriteElement(userInput - 1, college);
					}
					// If no seats are available in the chosen college.
					else {
						System.out.println("The college you entered is already full. Please select another college");
					}
				}
				flag = false;
			}
			catch (Exception exception) {
				flag = true;
				System.out.println("Something went wrong: " + exception.getMessage());
			}
		}

		return assignedColleges;
	}

	/**
	 * Gets the total seats.
	 *
	 * @param collegesList the colleges list.
	 * @return total seats available.
	 */
	public int getTotalSeats(ArrayList<College> collegesList) {
		int totalSeats = 0;
		try {
			for (int index = 0; index < collegesList.getSize(); index++) {
				totalSeats += collegesList.getElement(index).getCollegeSeats();
			}
		}
		catch (Exception exception) {
			System.out.println("Something went wrong: " + exception.getMessage());
			getTotalSeats(collegesList);
		}

		return totalSeats;
	}

	/**
	 * Gets the college list from the college dao.
	 * 
	 * @return the college list.
	 */
	public ArrayList<College> getAllColleges() {
		CollegeDaoImpl colleges = new CollegeDaoImpl();

		return colleges.getAllColleges();
	}

	/**
	 * Gets the candidate list from the candidate dao.
	 * 
	 * @return the candidate list.
	 */
	public Queue<Candidate> getAllCandidates() {
		CandidatesDaoImpl candidates = new CandidatesDaoImpl();

		return candidates.getAllCandidates();
	}
}
