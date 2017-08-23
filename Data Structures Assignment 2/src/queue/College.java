package queue;

/**
 * The Class College.
 * 
 * @author Neel Singhal
 */
// college class 
public class College {
	private String collegeName;
	private int collegeRank , collegeSeats;

	/**
	 * Empty constructor.
	 */
	public College() {

	}

	/**
	 * Parameterized constructor for setting up the name , rank and seats of college.
	 *
	 * @param collegeName the college name
	 * @param collegeRank the college rank
	 * @param collegeSeats the college seats
	 */
	public College(String collegeName, int collegeRank, int collegeSeats) {
		this.collegeName = collegeName;
		this.collegeRank = collegeRank;
		this.collegeSeats = collegeSeats;
	}

	/**
	 * Sets the college name.
	 *
	 * @param collegeName the new college name
	 */
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	/**
	 * Gets the college name.
	 *
	 * @return collegeName
	 */
	public String getCollegeName() {
		return this.collegeName;
	}

	/**
	 * Sets the college rank.
	 *
	 * @param collegeRank the new college rank
	 */
	public void setCollegeRank(int collegeRank) {
		this.collegeRank = collegeRank;
	}

	/**
	 * Gets the college rank.
	 *
	 * @return collegeRank
	 */
	public int getCollegeRank() {
		return this.collegeRank;
	}

	/**
	 * Sets the college seats.
	 *
	 * @param collegeSeats the new college seats
	 */
	public void setCollegeSeats(int collegeSeats) {
		this.collegeSeats = collegeSeats;
	}

	/**
	 * Gets the college seats.
	 *
	 * @return collegeSeats
	 */
	public int getCollegeSeats() {
		return this.collegeSeats;
	}
}