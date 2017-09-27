package com.metacube.get.layarch.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcConnectionFactory
{
	Connection getConnection() throws Exception
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping_cart", "get_user", "get_pwd");
			return con;
		}
		catch (Exception e)
		{
			System.out.println(e);
			throw e;
		}
	}
}
