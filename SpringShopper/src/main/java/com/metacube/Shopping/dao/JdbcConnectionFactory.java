package com.metacube.Shopping.dao;

import java.sql.Connection;
import java.sql.DriverManager;


public class JdbcConnectionFactory
{
    Connection getConnection() throws Exception
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/ShoppingDB", "root", "root");
            return con;
        }
        catch (Exception e)
        {
            System.out.println(e);
            throw e;
        }
    }
}
