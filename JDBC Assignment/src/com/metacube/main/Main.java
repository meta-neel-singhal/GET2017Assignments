package com.metacube.main;

import java.sql.SQLException;
import java.util.List;

import com.metacube.helpers.DBQueries;
import com.metacube.helpers.Input;
import com.metacube.model.Title;

/**
 * Main class to initialize the application.
 * 
 * @author Neel Singhal
 */
public class Main {
	private static String name;
	
	/**
	 * Main method to run the application
	 *  
	 * @param args    the arguments.
	 */
	public static void main(String[] args) {
		try {
			DBQueries database = DBQueries.getInstance();
			int choice;
			
			// Runs till the user exits the application.
			while (true) {
				Input.printMenu();
				System.out.println("Enter your choice :");
				choice = Input.takeIntegerAsInput();
				
				switch (choice) {
					// To get the list of titles published by an author.
					case 1:
						System.out.println("Enter the name of author :");
						name = Input.takeStringAsInput();
						name = name.trim();
						List<Title> titles = database.getBookPublishedByAuthorName(name);
						// Displays the list of titles obtained.
						if(titles.size() > 0){
							System.out.println("Books Written by " + name + " are:");
							for (Title title : titles) {
								System.out.println(title.getTitle());
							}
						} 
						else {
							System.out.println("\nThere is no book available which is written by " + name);
						}
						break;
					// Get the flag to indicate whether the book can be issued or not.
					case 2:
						System.out.println("Enter the name of book :");
						name = Input.takeStringAsInput();
						name = name.trim();
						int flag = database.isBookIssued(name);
						// Check if book is available or not.
						if (flag == 1) {
							System.out.println("\nBook can be issued !");
						} 
						else {
							System.out.println("\nBook cannot be issued !");
						}
						break;
					// Removes the book not issued since 1 year and get the number of books removed.	
					case 3:
						System.out.println("Number of Books removed is : " + database.deleteSelectedBooks());
						break;
					// Exit.	
					case 4:
						System.out.println("Thank You.");
						System.exit(0);
						break;
					// Helps to take correct choice from the user.	
					default:
						System.out.println("Invalid choice. Try again");
				}
			}
		} 
		catch (SQLException exception) {
			System.out.println(exception.getMessage());
		}
	}
}