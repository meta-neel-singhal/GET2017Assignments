package queue.dao;

import queue.model.Candidate;
import queue.utility.Queue;

/**
 * Interface for candidates dao.
 * 
 * @author Neel Singhal
 */
public interface CandidatesDao {
	// Returns list of all the candidates.
	public Queue<Candidate> getAllCandidates();
}
