package com.metacube.Shopping.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.metacube.Shopping.Product.Model.Product;

public abstract class GenericJdbcDao<T, ID extends Serializable> implements AbstractDao<T,ID>
{
    JdbcConnectionFactory connectionFactory = new JdbcConnectionFactory();

    protected abstract String getTableName();
    protected abstract T extractResultSetRow(ResultSet resultSet);
    protected abstract String getPrimaryKeyColoumnName();

    public Boolean save(final T entity)
    {
        
        Product product = (Product) entity;
        try {
            Connection connection = connectionFactory.getConnection();
            PreparedStatement query = connection.prepareStatement("Insert into "+getTableName()+" (name,price,imageUrl)values(?,?,?);"); 
            query.setString(1, product.getName());
            query.setDouble(2,product.getPrice());
            query.setString(3, product.getImageUrl());
            int rowAffected=query.executeUpdate();
            System.out.println("rows affected"+rowAffected);
            if(rowAffected == 1) {
                return true;
            }
            else {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Exception caught");
            return null;
        }
    }

    public T findOne(final ID primaryKey)
    {
        try {
            Connection connection = connectionFactory.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM " + getTableName() + " where " + getPrimaryKeyColoumnName() +"='" + primaryKey + "'");
            System.out.println("resultset"+resultSet);
            while(resultSet.next()) {
                System.out.println(extractResultSetRow(resultSet));
                return extractResultSetRow(resultSet);
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }
    
    public Boolean edit(Product product,int primaryKey) {
        System.out.println("A call here in edit dao");
        Boolean flag= true;
        try {
            Connection connection = connectionFactory.getConnection();
            Statement stmt = connection.createStatement();
            String query = "UPDATE " + getTableName() + " SET name = '"+ product.getName() + "' , price = " + product.getPrice()+" where " + getPrimaryKeyColoumnName() +" = " + primaryKey + " ;";
            stmt.executeUpdate(query);
        } catch(Exception e) {
            e.printStackTrace();
            flag=false;
        }
        return flag;
    }
    
    public Iterable<T> findAll ()
    {
        try {
            Connection connection = connectionFactory.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM " + getTableName());
            List<T> userList = new ArrayList<T>();
            while(resultSet.next()) {
                userList.add(extractResultSetRow(resultSet));
            }
            return userList;

        } catch (Exception e) {
            return Collections.emptyList();
        }

    }

    public Long count()
    {
        return null;
    }

    public boolean delete(int id)
    {
        System.out.println("i m calleed in dao");
        try {
            Connection connection = connectionFactory.getConnection();
            PreparedStatement query = connection.prepareStatement("DELETE FROM "+getTableName()+" where "+getPrimaryKeyColoumnName()+"=?"); 
            query.setInt(1, id);
            int rowAffected=query.executeUpdate();
            System.out.println("rows affected"+rowAffected);
            if(rowAffected == 1) {
                return true;
            }
            else {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Exception caught");
            return false;
        }
    }

    public boolean exists(final ID primaryKey)
    {
        return false;
    }
}