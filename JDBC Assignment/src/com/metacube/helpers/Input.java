package com.metacube.helpers;

import java.util.Scanner;

/**
 * The Input class to take specific input from the user.
 * 
 * @author Neel Singhal
 */
public class Input {
	private static Scanner scan = new Scanner(System.in);

	/**
	 * Take only integer as input.
	 *
	 * @return the input.
	 */
	public static int takeIntegerAsInput() {
		boolean flag = true;
		int input = 0;
		String temp = "";
		while (flag) {
			try {
				temp = scan.nextLine().trim();
				input = Integer.parseInt(temp);
				flag = false;
			} 
			catch (Exception e) {
				System.out.println("Please Enter a valid input !");
			}
		}

		return input;
	}

	/**
	 * Take only String as input.
	 *
	 * @return the input string.
	 */
	public static String takeStringAsInput() {
		String input;
		input = scan.nextLine().trim();
		if (input.length() == 0) {
			System.out.println("Please enter some value !");
			input = takeStringAsInput();
		}
		return input;
	}
	
	/**
	 * Prints the menu.
	 */
	public static void printMenu() {
		System.out.println("1. Give the name of the author to fetch all the books published by that author. Get the books data (List of Titles).");
		System.out.println("2. Give the name of the book, to be issued by an existing member. Get flag to indicate whether the book has been issued or not.");
		System.out.println("3. Delete all those books which were not issued in last 1 year. Get the number of books deleted.");
		System.out.println("4. Exit");
	}
}