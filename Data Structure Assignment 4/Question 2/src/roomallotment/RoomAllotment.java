package roomallotment;

import helpers.Constants;

import java.util.Hashtable;

/**
 * Class to generate a unique room for each guest and allot it to the guest.
 * 
 * @author Neel Singhal
 */
public class RoomAllotment {
	// Number used to generate hash function.
	private int num = 1;
	// Hash table consisting details of guests and room alloted to them.
	public static Hashtable<Integer, Guest> hashtable = new Hashtable<Integer, Guest>();;
	// The room number.
	private int roomNo;
	// Result containing the final allotment of rooms to guests.
	String result = "";
	
	/**
	 * Generates the unique room number for each guest.
	 * 
	 * @param guest    Guest class object.
	 * @return the final room allotment string.
	 */
	public String Hashing(Guest guest) {
		int age = guest.getAge();
		// Generate unique room numbers using hash function.
		roomNo = (Constants.TOTAL_ROOMS + (age * + num++) * Constants.PRIME) % Constants.TOTAL_ROOMS;
		// Check if the room number is already filled allot another room to the guest.
		while (hashtable.containsKey(roomNo)) {
			roomNo = (++roomNo) % Constants.TOTAL_ROOMS;
		}
		hashtable.put(roomNo, guest);
		result += "Room : " + (roomNo + 1) + " To : " + guest.getName() + "\n";

		return result;
	}

	/**
	 * Overriden hashCode function to set the index of a key-value pair of the hash table.
	 */
	@Override
	public int hashCode() {
		int result = 1;
		result = Constants.PRIME * result + roomNo;

		return result;
	}

	/**
	 * Overriden equals function to compare two objects of RoomAllotment class.
	 */
	@Override
	public boolean equals(Object object) {
		boolean flag = true;
		if (this == object) {
			flag = true;
		}
		if (object == null) {
			flag = false;
		}
		if (getClass() != object.getClass()) {
			flag = false;
		}
		RoomAllotment other = (RoomAllotment) object;
		if (roomNo != other.roomNo) {
			flag = false;
		}

		return flag;
	}	
}
