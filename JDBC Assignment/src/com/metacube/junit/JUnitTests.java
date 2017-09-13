package com.metacube.junit;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.metacube.connection.ConnectToDB;
import com.metacube.helpers.DBQueries;
import com.metacube.model.Title;

public class JUnitTests {
	private DBQueries database;
	/**
	 * Method is used to set up the class object before start testing
	 */
	@Before
	public void setUp() {
		database = DBQueries.getInstance();
	}

	/**
	 * Test method to check connection established or not
	 */
	@Test
	public void testConnectionEstablish() {
		assertNotNull(ConnectToDB.createConnection());
	}
	/**
	 * Test method to check books fetch method for valid author name
	 * 
	 * @throws SQLException 
	 */
	@Test
	public void testFetchMethodWhenValid() throws SQLException {
		List<Title> titlesList = database.getBookPublishedByAuthorName("henry");
		String actualResult = "";
		// loop continue till end of list
		for (Title title : titlesList) {
			actualResult += title.getTitle();
		}
		assertEquals("Physics", actualResult);
	}

	/**
	 * Test method to check books fetch method for wrong author name
	 * 
	 * @throws SQLException 
	 */
	@Test
	public void testFetchBooksMethodWhenInvalid() throws SQLException {
		List<Title> titlesList = database.getBookPublishedByAuthorName("example");
		String actualResult = "";
		// loop continue till end of list
		for (Title title : titlesList) {
			actualResult += title.getTitle();
		}
		assertNotEquals("Physics", actualResult);
	}

	/**
	 * Test method to check book issued when book name is valid
	 *
	 * @throws SQLException 
	 */
	@Test
	public void testIsBookIssuedWhenValid() throws SQLException {
		assertEquals(0, database.isBookIssued("Cooking With Computers"));
	}

	/**
	 * Test method to check book issued when book name is Invalid
	 *
	 * @throws SQLException 
	 */
	@Test
	public void testIsBookIssuedWhenInvalid() throws SQLException {
		assertEquals(-1, database.isBookIssued("example"));
	}
	/**
	 * Test method to check book deleted or not which are not issued since last year
	 * 
	 * @throws SQLException 
	 */
	@Test
	public void testDeleteBooksNotIssuedSinceLastYear() throws SQLException {
		assertEquals(0, database.deleteSelectedBooks());
	}
}
