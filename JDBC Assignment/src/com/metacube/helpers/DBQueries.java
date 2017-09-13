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

public class DBQueries {
	private Connection connection = null;
	private static DBQueries database = null;
	
	private DBQueries() {
		connection = ConnectToDB.createConnection();
	}
	
	public static DBQueries getInstance() {
		if(database == null) {
			synchronized (DBQueries.class) {
				if(database == null) {
					database = new DBQueries();
				}
			}
		}
		
		return database;
	}
	
	public List<Title> getBookPublishedByAuthorName(String name) throws SQLException {
		List<Title> titles = new ArrayList<Title>();
		PreparedStatement statement = null;
		ResultSet resultSet;
		Title title;
		String query = "SELECT t.`title`"
				  	 + "FROM `publisher` p"
					 + "JOIN `title` t ON p.`id` = t.`publisher_id`"
					 + "JOIN `title_author` ta ON t.`id` = ta.`title_id`"
					 + "JOIN `author` a ON a.`id` = ta.`author_id`"
					 + "WHERE a.`name` = ?;";
		
		try {
			statement  = connection.prepareStatement(query);
			statement.setString(1, name);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				title = new Title();
				title.setTitle(resultSet.getString(1));
				titles.add(title);
			}
		} 
		catch (SQLException exception) {
			System.out.print("Please enter a valid author name.");
		} 
		finally {
			if (statement != null) {
				statement.close();
			}
		}
		
		return titles;
	}
	// 1: Available
	public int isBookIssued(String name) throws SQLException {
		int flag = 0;
		PreparedStatement statement = null;
		ResultSet resultSet;
		String query = "SELECT `status`"
					 + "FROM `books` b"
					 + "JOIN `title` t"
					 + "ON t.`id` = b.`title_id`"
					 + "WHERE t.`title` = ?;";
		try {
			statement = connection.prepareStatement(query);
			statement.setString(1, name);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				if ((flag = resultSet.getInt(1)) == 1) {
					break;
				}	
			}
		} 
		catch (SQLException exception) {
			System.out.print("Some error occured in executing the query.");
		} 
		finally {
			if (statement != null) {
				statement.close();
			}
		}
		
		return flag;
	}
	
	public int deleteSelectedBooks() throws SQLException {
		int recordsDeleted = 0;
		Statement statement = null;
		ResultSet resultSet;
		String query = "SELECT DISTINCT b.`accession_no`"
					 + "FROM `books` b"
					 + "JOIN `book_issue` bi"
					 + "ON bi.`accession_no` = b.`accession_no` AND DATEDIFF(bi.`issue_date`, NOW()) > 365 OR"
					 + "(b.`accession_no` NOT IN (SELECT bi.`accession_no` FROM `book_issue` bi WHERE b.`accession_no` = bi.`accession_no`)"
					 + "AND DATEDIFF(NOW(), b.`purchase_date`) > 365);";
		
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			resultSet.last();
			recordsDeleted = resultSet.getRow();
			resultSet.beforeFirst();
		} 
		catch (SQLException exception) {
			System.out.println("Cannot delete the records due to some error.");
		} 
		finally {
			if (statement != null) {
				statement.close();
			}
		}
		
		return recordsDeleted;
	}
}
