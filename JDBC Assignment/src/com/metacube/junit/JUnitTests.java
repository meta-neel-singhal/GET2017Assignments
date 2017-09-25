package com.metacube.junit;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.metacube.connection.ConnectToDB;
import com.metacube.helpers.DBQueries;
import com.metacube.model.Title;

/**
 * Test cases for the DBMS queries.
 * 
 * @author Neel Singhal
 */
public class JUnitTests {
	private DBQueries database;

	// Initialize database.
	@Before
	public void initializeDatabase() {
		database = DBQueries.getInstance();
	}

	// Positive Test Case.
	@Test
	public void createConnectionTestCase1() {
		assertNotNull(ConnectToDB.createConnection());
	}

	// Positive Test Case.
	@Test
	public void getBookPublishedByAuthorNameTestCase1() throws SQLException {
		List<Title> titles = database.getBookPublishedByAuthorName("j. k. rowling");
		String actualResult = "";
		for (Title title : titles) {
			actualResult += title.getTitle() + "\n";
		}
		assertEquals("Earth Facts\nHarry Potter - Goblet of Fire\n", actualResult);
	}

	// Positive Test Case.
	@Test
	public void isBookIssuedTestCase1() throws SQLException {
		assertEquals(0, database.isBookIssued("Earth Facts"));
	}
	
	// Positive Test Case.
	@Test
	public void isBookIssuedTestCase2() throws SQLException {
		assertEquals(1, database.isBookIssued("Let Us C"));
	}

	// Positive Test Case.
	@Test
	public void deleteSelectedBooksTestCase1() throws SQLException {
		assertEquals(0, database.deleteSelectedBooks());
	}
	
	// Negative Test Case.
	@Test
	public void createConnectionTestCase2() {
		assertFalse(ConnectToDB.createConnection() == null);
	}

	// Negative Test Case.
	@Test
	public void getBookPublishedByAuthorNameTestCase2() throws SQLException {
		List<Title> titles = database.getBookPublishedByAuthorName("chetan bhagat");
		String actualResult = "";
		for (Title title : titles) {
			actualResult += title.getTitle();
		}
		assertNotEquals("Earth Facts", actualResult);
	}

	// Negative Test Case.
	@Test
	public void isBookIssuedTestCase3() throws SQLException {
		assertNotEquals(1, database.isBookIssued("Earth Facts"));
	}

	// Negative Test Case.
	@Test
	public void isBookIssuedTestCase4() throws SQLException {
		assertNotEquals(0, database.isBookIssued("Let Us C"));
	}

	// Negative Test Case.
	@Test
	public void deleteSelectedBooksTestCase2() throws SQLException {
		assertNotEquals(2, database.deleteSelectedBooks());
	}
}
