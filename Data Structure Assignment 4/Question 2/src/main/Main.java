package main;

import helpers.Constants;

import java.util.Scanner;

import roomallotment.*;

/**
 * Main class to initialize the room allotment in guest house.
 * 
 * @author Neel Singhal
 */
public class Main {
	
	/**
	 * The main function to initialize room allotment.
	 * 
	 * @param args    the arguments.
	 */
	public static void main(String[] args) {
		String guestName;
		int guestAge;
		int noOfGuests;
		Guest guest;

		RoomAllotment allotment = new RoomAllotment();
		Scanner scan = new Scanner(System.in);

		System.out.println("Enter no. of guests : ");
		noOfGuests = getIntegerInput(scan);
		// Checks if the number of guests is greater than the number of rooms available.
		if (noOfGuests > Constants.TOTAL_ROOMS) {
			System.out.println("Room is available for only " + Constants.TOTAL_ROOMS + " people !\nPress Y to continue : ");
			// If user wants to continue with the room allotment.
			if (!scan.next().equalsIgnoreCase("y")) {
				System.out.println("Thank You.");
				System.exit(0);
			} 
			else {
				noOfGuests = Constants.TOTAL_ROOMS;
			}
		}
		// Gets the name and age of each guest.
		for (int count = 0; count < noOfGuests; count++) {
			System.out.println("Enter the Guest's name : ");
			guestName = scan.next();
			System.out.println("Enter the Guest's age : ");
			guestAge = getIntegerInput(scan);
			guest = new Guest(guestName, guestAge);
			allotment.Hashing(guest);
		}	
		// Displays the room alloted to the guests.
		for (int key : RoomAllotment.hashtable.keySet()) {
			System.out.println("Room No. - " + (key + 1)  + " is alloted to : " + RoomAllotment.hashtable.get(key).getName());
		}
	}
	
	/**
	 * Helps to take only integer value from the user.
	 * 
	 * @param scan    Scanner object.
	 * @return the integer input.
	 */
	public static int getIntegerInput(Scanner scan) {
		int input = 0;
		boolean flag = true;
		do {
			try {
				input = Integer.parseInt(scan.next());
				// Check if the input is not integer or less than 0.
				if(String.class.isInstance(input) || input < 1) {
					throw new NumberFormatException();
				}
				flag = false;
			} 
			catch (NumberFormatException exception) {
				System.out.println("Please enter proper value !");
			}
		} while (flag);
		
		return input;
	}
}
