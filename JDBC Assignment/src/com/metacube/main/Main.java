package com.metacube.main;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.metacube.helpers.DBQueries;
import com.metacube.helpers.Input;
import com.metacube.model.Title;

public class Main {
	private static String name;
	private static Scanner scan = new Scanner(System.in);
	
	/**
	 * main method to run the application
	 *  
	 * @param args
	 * 		arguments taken through console
	 */
	public static void main(String[] args) {
		try {
			DBQueries database = DBQueries.getInstance();
			int choice;
			while(true) {
				Input.printMenu();
				System.out.println("Enter your choice :");
				choice = Input.takeIntegerAsInput();
				switch (choice) {
				case 1:
					scan.nextLine();
					System.out.println("Enter the name of author :");
					name = scan.nextLine();
					name = name.trim();
					List<Title> titles = database.getBookPublishedByAuthorName(name);
					/*
					 * if list size is greater than zero then display the titles 
					 * else display no book written message
					 */
					if(titles.size() > 0){
						System.out.println("Books Written by " + name + " are:");
						// loop continue till end of list is reached
						for (Title title : titles) {
							System.out.println(title.getTitle());
						}
					} 
					else {
						System.out.println("There is no book available which is written by " + name);
					}
					break;

				case 2:
					scan.nextLine();
					System.out.println("Enter the name of book :");
					name = scan.nextLine();
					name = name.trim();
					int flag = database.isBookIssued(name);
					/*
					 * if flag is -1 then display book is not in library
					 * else if flag is 1 then display book can't be issued 
					 * else display book can be issued
					 */
					if (flag == -1) {
						System.out.println("Book is not available in library");
					}
					else if (flag == 1) {
						System.out.println("Book can't be issued");
					} 
					else {
						System.out.println("Book can be issued");
					}
					break;
					
				case 3:
					System.out.println("Number of Books removed is : " + database.deleteSelectedBooks());
					break;
					
				case 4:
					System.out.println("Thank You.");
					System.exit(0);
					break;
					
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