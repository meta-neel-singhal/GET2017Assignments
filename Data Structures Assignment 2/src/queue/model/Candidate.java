package queue.model;

/**
 * The Candidate class containing candidate details.
 *
 * @author Neel Singhal
 */
public class Candidate {
	private String candidateName;
	private int candidateRank;

	/**
	 * Constructor.
	 */
	public Candidate() {

	}

	/**
	 * Parameterized constructor to set up the fields of candidate.
	 *
	 * @param candidateName    the candidate name
	 * @param candidateRank    the candidate rank
	 */
	public Candidate(String candidateName , int candidateRank) {
		this.candidateName = candidateName;
		this.candidateRank = candidateRank;
	}

	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}

	public String getCandidateName() {
		return this.candidateName;
	}

	public void setCandidateRank(int candidateRank) {
		this.candidateRank = candidateRank;
	}

	public int getCandidateRank() {
		return this.candidateRank;
	}
}