package queue.dao;

import queue.model.College;
import queue.utility.ArrayList;

/**
 * Interface for college dao.
 * 
 * @author Neel Singhal
 */
public interface CollegeDao {
	// Returns list of all the colleges.
	public ArrayList<College> getAllColleges();
}
