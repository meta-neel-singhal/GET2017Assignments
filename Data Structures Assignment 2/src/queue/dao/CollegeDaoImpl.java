package queue.dao;

import queue.model.College;
import queue.utility.ArrayList;

public class CollegeDaoImpl implements CollegeDao {

	/**
	 * Creates the list of colleges.
	 *
	 * @return array list of colleges.
	 */
	@Override
	public ArrayList<College> getAllColleges() {
		ArrayList<College> collegeLists = new ArrayList<College>();

		try {
			College college1 = new College("Amity University", 1, 1);
			College college2 = new College("LNMIIT", 2, 1);
			College college3 = new College("JECRC", 3, 2);
			College college4 = new College("SKIT", 4, 3);
			College college5 = new College("Poornima University", 5, 3);
			College college6 = new College("Jaipur University", 6, 2);

			collegeLists.add(college1);
			collegeLists.add(college2);
			collegeLists.add(college3);
			collegeLists.add(college4);
			collegeLists.add(college5);
			collegeLists.add(college6);
		}
		catch (Exception exception) {
			System.out.println("Something went wrong: " + exception.getMessage());
			getAllColleges();
		}

		return collegeLists;
	}		
}
