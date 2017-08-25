package queue;

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

	/**
	 * Sets the candidate name.
	 *
	 * @param candidateName    the new candidate name
	 */
	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}

	/**
	 * Gets the candidate name.
	 *
	 * @return candidateName
	 */
	public String getCandidateName() {
		return this.candidateName;
	}

	/**
	 * Sets the candidate rank.
	 *
	 * @param candidateRank    the new candidate rank
	 */
	public void setCandidateRank(int candidateRank) {
		this.candidateRank = candidateRank;
	}

	/**
	 * Gets the candidate rank.
	 *
	 * @return candidateRank
	 */
	public int getCandidateRank() {
		return this.candidateRank;
	}
}