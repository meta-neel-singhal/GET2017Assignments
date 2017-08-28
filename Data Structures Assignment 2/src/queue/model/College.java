package queue.model;

/**
 * The College class containing college details.
 * 
 * @author Neel Singhal
 */
public class College {
	private String collegeName;
	private int collegeRank , collegeSeats;

	/**
	 * Empty constructor.
	 */
	public College() {

	}

	/**
	 * Parameterized constructor.
	 *
	 * @param collegeName     the college name.
	 * @param collegeRank     the college rank.
	 * @param collegeSeats    the college seats.
	 */
	public College(String collegeName, int collegeRank, int collegeSeats) {
		this.collegeName = collegeName;
		this.collegeRank = collegeRank;
		this.collegeSeats = collegeSeats;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getCollegeName() {
		return this.collegeName;
	}

	public void setCollegeRank(int collegeRank) {
		this.collegeRank = collegeRank;
	}

	public int getCollegeRank() {
		return this.collegeRank;
	}

	public void setCollegeSeats(int collegeSeats) {
		this.collegeSeats = collegeSeats;
	}

	public int getCollegeSeats() {
		return this.collegeSeats;
	}
}