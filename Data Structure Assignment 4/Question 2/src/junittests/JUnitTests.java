package junittests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Hashtable;

import org.junit.Before;
import org.junit.Test;

import roomallotment.*;

public class JUnitTests {
	static Hashtable<Integer, Guest> hashtable;
	static Guest guest;
	static RoomAllotment allotment;

	@Before
	public void initHash() {
		hashtable = new Hashtable<Integer, Guest>();
		allotment = new RoomAllotment();
		guest = new Guest();
	}

	// Positive Test Case.
	@Test
	public void roomAllotmentTestCase1() {
		guest.setAge(12);
		guest.setName("Neel");
		allotment.Hashing(guest);
		guest.setAge(12);
		guest.setName("Gaurav");
		allotment.Hashing(guest);
		guest.setAge(32);
		guest.setName("Shivam");
		allotment.Hashing(guest);
		guest.setAge(53);
		guest.setName("Udit");
		String expected = allotment.Hashing(guest);
		String actual = "Room : 10 To : Neel\nRoom : 8 To : Gaurav\nRoom : 7 To : Shivam\nRoom : 6 To : Udit\n";
		assertEquals(expected, actual);
	}

	// Negative Test case.
	@Test
	public void roomAllotmentTestCase2() {
		guest.setAge(12);
		guest.setName("Neel");
		allotment.Hashing(guest);
		guest.setAge(12);
		guest.setName("Gaurav");
		allotment.Hashing(guest);
		guest.setAge(32);
		guest.setName("Shivam");
		allotment.Hashing(guest);
		guest.setAge(53);
		guest.setName("Udit");
		String expected = allotment.Hashing(guest);
		String actual = "Room : 10 To : Neel\nRoom : 10 To : Gaurav\nRoom : 7 To : Shivam\nRoom : 6 To : Udit";
		assertNotEquals(expected, actual);
	}
}
