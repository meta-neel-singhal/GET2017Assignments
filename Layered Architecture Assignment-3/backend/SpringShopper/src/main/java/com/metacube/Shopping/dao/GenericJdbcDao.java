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

/**
 * The class GenericJdbcDao to store and execute all the database queries.
 * 
 * @author Neel Singhal
 *
 * @param <T> generic data type.
 * @param <ID> generic data type.
 */
public abstract class GenericJdbcDao<T, ID extends Serializable> implements
		AbstractDao<T, ID> {
	JdbcConnectionFactory connectionFactory = new JdbcConnectionFactory();

	protected abstract String getTableName();

	protected abstract T extractResultSetRow(ResultSet resultSet);

	protected abstract String getPrimaryKeyColoumnName();

	/**
	 * Add a product.
	 * 
	 * @return the Success or Error status.
	 */
	public Boolean add(final T entity) {
		Product product = (Product) entity;
		try {
			Connection connection = connectionFactory.getConnection();
			PreparedStatement query = connection
					.prepareStatement("Insert into " + getTableName()
							+ " (name, price, img)values(?,?,?);");
			query.setString(1, product.getName());
			query.setDouble(2, product.getPrice());
			query.setString(3, product.getImg());
			int rowAffected = query.executeUpdate();
			System.out.println("rows affected" + rowAffected);
			if (rowAffected == 1) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			System.out.println("Exception caught");
			return null;
		}
	}

	/**
	 * To get a product by its ID.
	 */
	public T findOne(final ID primaryKey) {
		try {
			Connection connection = connectionFactory.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet resultSet = stmt.executeQuery("SELECT * FROM "
					+ getTableName() + " where " + getPrimaryKeyColoumnName()
					+ "='" + primaryKey + "'");
			System.out.println("resultset" + resultSet);
			while (resultSet.next()) {
				System.out.println(extractResultSetRow(resultSet));
				return extractResultSetRow(resultSet);
			}
			return null;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Edit a product.
	 * 
	 * @param product    the product.
	 * @param id    the id of product.
	 * @return true, if edited successfully .
	 */
	public Boolean edit(Product product, int primaryKey) {
		Boolean flag = true;
		try {
			Connection connection = connectionFactory.getConnection();
			Statement stmt = connection.createStatement();
			String query = "UPDATE " + getTableName() + " SET name = '"
					+ product.getName() + "' , price = " + product.getPrice()
					+ " where " + getPrimaryKeyColoumnName() + " = "
					+ primaryKey + " ;";
			stmt.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
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
			List<T> userList = new ArrayList<T>();
			while (resultSet.next()) {
				userList.add(extractResultSetRow(resultSet));
			}
			return userList;

		} catch (Exception e) {
			return Collections.emptyList();
		}

	}

	/**
	 * Delete a product.
	 * 
	 * @return true, if deleted successfully.
	 */
	public Boolean delete(int id) {
		try {
			Connection connection = connectionFactory.getConnection();
			PreparedStatement query = connection
					.prepareStatement("DELETE FROM " + getTableName()
							+ " where " + getPrimaryKeyColoumnName() + "=?");
			query.setInt(1, id);
			int rowAffected = query.executeUpdate();
			System.out.println("rows affected" + rowAffected);
			if (rowAffected == 1) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			System.out.println("Exception caught");
			return false;
		}
	}
}