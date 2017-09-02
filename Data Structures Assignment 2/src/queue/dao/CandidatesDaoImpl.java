package queue.dao;

import queue.model.Candidate;
import queue.utility.Queue;

public class CandidatesDaoImpl implements CandidatesDao {

	/**
	 * Creates the queue of candidates.
	 *
	 * @return queue of candidate.
	 */
	@Override
	public Queue<Candidate> getAllCandidates() {
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
			getAllCandidates();
		}

		return candidates;
	}
}