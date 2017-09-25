package com.metacube.helpers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.metacube.connection.ConnectToDB;
import com.metacube.model.Title;

/**
 * Contains all the queries to execute.
 * 
 * @author Neel Singhal
 */
public class DBQueries {
	private Connection connection = null;
	private static DBQueries database = null;
	
	/**
	 * Making the class singleton.
	 */
	private DBQueries() {
		connection = ConnectToDB.createConnection();
	}
	
	/**
	 * Returns only a single object of the class.
	 * 
	 * @return the instance of the class.
	 */
	public static DBQueries getInstance() {
		// Double locking mechanism.
		if(database == null) {
			synchronized (DBQueries.class) {
				if(database == null) {
					database = new DBQueries();
				}
			}
		}
		
		return database;
	}
	
	/**
	 * Get the list of titles published by an author.
	 * 
	 * @param name    Author name for which published titles are to be get.
	 * @return the list of titles published by that author.
	 * @throws SQLException
	 */
	public List<Title> getBookPublishedByAuthorName(String name) throws SQLException {
		List<Title> titles = new ArrayList<Title>();
		PreparedStatement statement = null;
		ResultSet resultSet;
		Title title;
		String query = "SELECT t.`title` "
				  	 + "FROM `publisher` p "
					 + "JOIN `title` t ON p.`id` = t.`publisher_id` "
					 + "JOIN `title_author` ta ON t.`id` = ta.`title_id` "
					 + "JOIN `author` a ON a.`id` = ta.`author_id` "
					 + "WHERE a.`name` = ?;";
		
		try {
			statement  = connection.prepareStatement(query);
			statement.setString(1, name);
			resultSet = statement.executeQuery();
			// Runs while result set contains value.
			while (resultSet.next()) {
				title = new Title();
				title.setTitle(resultSet.getString(1));
				titles.add(title);
			}
		} 
		catch (SQLException exception) {
			System.out.print("Please enter a valid author name.");
		} 
		// Close the statement if it is not null.
		finally {
			if (statement != null) {
				statement.close();
			}
		}
		
		return titles;
	}
	
	/**
	 * Check if the book is available for issue to a member or not. 
	 * 
	 * @param name    Name of to be checked for availability.
	 * @return 1 if available else 0.
	 * @throws SQLException
	 */
	public int isBookIssued(String name) throws SQLException {
		int flag = 0;
		PreparedStatement statement = null;
		ResultSet resultSet;
		String query = "SELECT `status` "
					 + "FROM `books` b "
					 + "JOIN `title` t "
					 + "ON t.`id` = b.`title_id` "
					 + "WHERE t.`title` = ?;";
		
		try {
			statement = connection.prepareStatement(query);
			statement.setString(1, name);
			resultSet = statement.executeQuery();
			// Runs while result set contains value.
			while (resultSet.next()) {
				// Check if any book with 'name' is available in the library.
				if ((flag = resultSet.getInt(1)) == 1) {
					break;
				}	
			}
		} 
		catch (SQLException exception) {
			System.out.print("Please choose another book.");
		} 
		// Close the statement if it is not null.
		finally {
			if (statement != null) {
				statement.close();
			}
		}
		
		return flag;
	}
	
	/**
	 * Deletes the books which are not issued since 1 year.
	 * 
	 * @return the number of books deleted.
	 * @throws SQLException
	 */
	public int deleteSelectedBooks() throws SQLException {
		int recordsDeleted = 0;
		Statement statement = null;
		String queryToCreateView = "CREATE OR REPLACE VIEW `books_to_delete` "
								 + "AS "
								 + "SELECT DISTINCT b.`accession_no` "
								 + "FROM `books` b "
								 + "JOIN `book_issue` bi "
								 + "ON bi.`accession_no` = b.`accession_no` AND DATEDIFF(bi.`issue_date`, NOW()) > 365 OR "
								 + "(b.`accession_no` NOT IN (SELECT bi.`accession_no` FROM `book_issue` bi WHERE b.`accession_no` = bi.`accession_no`) "
								 + "AND DATEDIFF(NOW(), b.`purchase_date`) > 365);";
		
		String queryToDelete =  "DELETE "
							  + "FROM `books` "
							  + "WHERE `accession_no` IN (SELECT `accession_no` FROM `books_to_delete`);";
		
		try {
			statement = connection.createStatement();
			statement.executeUpdate(queryToCreateView);
			recordsDeleted = statement.executeUpdate(queryToDelete);
		} 
		catch (SQLException exception) {
			System.out.println("Cannot delete the records due to some error.");
		} 
		// Close the statement if it is not null.
		finally {
			if (statement != null) {
				statement.close();
			}
		}
		
		return recordsDeleted;
	}
}