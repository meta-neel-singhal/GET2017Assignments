package com.metacube.get.layarch.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.metacube.get.layarch.enums.Status;
import com.metacube.get.layarch.model.Product;

/**
 * The class GenericJdbcDao to store and execute all the database queries.
 * 
 * @author Neel Singhal
 *
 * @param <T> generic data type.
 * @param <ID> generic data type.
 */
public abstract class GenericJdbcDao<T, ID extends Serializable> implements	AbstractDao<T, ID> {
	
	JdbcConnectionFactory connectionFactory = new JdbcConnectionFactory();

	protected abstract String getTableName();

	protected abstract T extractResultSetRow(ResultSet resultSet);

	protected abstract String getPrimaryKeyColoumnName();

	/**
	 * Save the changes in the product.
	 */
	public <S extends T> S save(S entity) {
		return null;
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
			ResultSet resultSet = stmt.executeQuery("SELECT * FROM "
					+ getTableName());
			List<T> productList = new ArrayList<>();
			while (resultSet.next()) {
				productList.add(extractResultSetRow(resultSet));
			}
			return productList;

		} catch (Exception e) {
			// TODO - Logging
			return Collections.emptyList();
		}

	}

	/**
	 * Count the number of products available.
	 */
	public Long count() {
		return null;
	}

	/**
	 * Delete a product.
	 */
	public Status delete(ID id) {
		Status result = Status.Success;
		try {
			Connection connection = connectionFactory.getConnection();
			Statement stmt = connection.createStatement();
			stmt.executeUpdate("DELETE FROM " + getTableName() + " WHERE "
					+ getPrimaryKeyColoumnName() + "='" + id + "';");
		} catch (Exception e) {
			result = Status.Error_Occured;
		}
		return result;
	}

	/**
	 * Update a product.
	 *
	 * @param product the product
	 * @param id the id of product
	 * @return the status
	 */
	public Status update(Product product, ID id) {
		Status result = Status.Success;
		try {
			Connection connection = connectionFactory.getConnection();
			Statement stmt = connection.createStatement();
			String query = "UPDATE " + getTableName() + " SET name = '"
					+ product.getName() + "' , price = " + product.getPrice()
					+ " where " + getPrimaryKeyColoumnName() + " = " + id
					+ " ;";
			stmt.executeUpdate(query);
		} catch (Exception e) {
			result = Status.Error_Occured;
		}
		return result;
	}

	/**
	 * Add a product.
	 */
	public <S extends T> Status add(S prod) {
		Status result = Status.Success;
		Product product = (Product) prod;
		try {
			Connection connection = connectionFactory.getConnection();
			Statement stmt = connection.createStatement();
			String query = "INSERT INTO " + getTableName()
					+ " (name, price, img)" + " VALUES ('" + product.getName()
					+ "','" + product.getPrice() + "','" + product.getImg()
					+ "');";
			stmt.executeUpdate(query);
		} catch (Exception e) {
			result = Status.Error_Occured;
		}
		return result;
	}

	/**
	 * Check if a product exists.
	 */
	public boolean exists(ID primaryKey) {
		return false;
	}
}
