package com.metacube.shoppingcart.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.metacube.shoppingcart.enums.Status;
import com.metacube.shoppingcart.modal.Product;

/**
 * The class GenericJdbcDao to store and execute all the database queries.
 * 
 * @author Neel Singhal
 *
 * @param <T> generic data type.
 * @param <ID> generic data type.
 */
public abstract class GenericJdbcDao<T, ID extends Serializable> implements AbstractDao<T,ID> {

	JdbcConnectionFactory connectionFactory = new JdbcConnectionFactory();

	protected abstract String getTableName();

	protected abstract T extractResultSetRow(ResultSet resultSet);

	protected abstract String getPrimaryKeyColoumnName();

	/**
	 * Add a product.
	 * 
	 * @return the Success or Error status.
	 */
	public <S extends T> Status add(S entity) {
		Status result = Status.Success;
		Product product = (Product) entity;
		try {
			Connection connection = connectionFactory.getConnection();
			Statement stmt = connection.createStatement();
			String query = "INSERT INTO " + getTableName() + " (name, price)"
					+ " VALUES ('" + product.getName() + "','"
					+ product.getPrice() + "');";
			stmt.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
			result = Status.Error_Occured;
		}
		
		return result;
	}

	/**
	 * To get a product by its ID.
	 */
	public T findOne(ID primaryKey) {
		try {
			Connection connection = connectionFactory.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet resultSet = stmt.executeQuery("SELECT * FROM "
					+ getTableName() + " where " + getPrimaryKeyColoumnName()
					+ " = '" + primaryKey + "'");
			while (resultSet.next()) {
				return extractResultSetRow(resultSet);
			}
			return null;
		} catch (Exception e) {
			// TODO - Logging
			return null;
		}
	}

	/**
	 * To get all the products in the store.
	 */
	public Iterable<T> findAll() {
		try {
			Connection connection = connectionFactory.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet resultSet = stmt.executeQuery("SELECT * FROM " + getTableName());
			List<T> productList = new ArrayList<>();
			while (resultSet.next()) {
				productList.add(extractResultSetRow(resultSet));
			}
			return productList;

		} catch (Exception e) {
			//TODO - Logging
			return Collections.emptyList();
		}
	}

	/**
	 * Delete a product.
	 * 
	 * @return the Success or Error status.
	 */
	public Status delete(ID primaryKey) {
		Status result = Status.Success;
		try {
			Connection connection = connectionFactory.getConnection();
			Statement stmt = connection.createStatement();
			String query = "DELETE FROM " + getTableName() + " where " + getPrimaryKeyColoumnName() +" = '" + primaryKey + "'";
			stmt.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
			result = Status.Error_Occured;
		}
		
		return result;
	}

	/**
	 * Edit a product.
	 * 
	 * @param product    the product.
	 * @param id    the id of product.
	 * @return the Success or Error status.
	 */
	public Status edit(Product product,ID id) {
		Status result = Status.Success;
		try {
			Connection connection = connectionFactory.getConnection();
			Statement stmt = connection.createStatement();
			String query = "UPDATE " + getTableName() + " SET name = '"+ product.getName() + "' , price = " + product.getPrice()+" where " + getPrimaryKeyColoumnName() +" = " + id + " ;";
			stmt.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
			result = Status.Error_Occured;
		}
		
		return result;
	}
}
