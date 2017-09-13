package com.metacube.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.metacube.helpers.Constants;

public class ConnectToDB {
	public static Connection createConnection() {
		Connection connection = null;
		String mysqlURL = Constants.host + Constants.dbName;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(mysqlURL, Constants.userId, Constants.password);
		} 
		catch (ClassNotFoundException exception) {
			System.out.println("Error loading Driver: " + exception);
		} 
		catch (SQLException exception) {
			System.out.println("Connection is not created ! Try again !");
		}

		return connection;
	}
}