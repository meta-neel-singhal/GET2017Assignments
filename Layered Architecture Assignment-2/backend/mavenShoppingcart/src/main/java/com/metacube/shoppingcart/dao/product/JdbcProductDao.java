package com.metacube.shoppingcart.dao.product;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.metacube.shoppingcart.dao.GenericJdbcDao;
import com.metacube.shoppingcart.modal.Product;

/**
 * The Class JdbcProductDao.
 * 
 * @author Neel Singhal
 */
public class JdbcProductDao extends GenericJdbcDao<Product, Integer> implements
		ProductDao {

	private String tableName;

	/**
	 * Sets the table name.
	 * 
	 * @param tableName    the table name to set.
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	/**
	 * @return the table name.
	 */
	@Override
	protected String getTableName() {
		return tableName;
	}

	/**
	 * @return the product.
	 */
	@Override
	protected Product extractResultSetRow(ResultSet resultSet) {
		Product product = new Product();
		try {
			product.setName(resultSet.getString("name"));
			product.setId(resultSet.getInt("id"));
			product.setPrice(resultSet.getDouble("price"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return product;
	}

	/**
	 * @return the column name of Primary Key.
	 */
	@Override
	protected String getPrimaryKeyColoumnName() {
		return "id";
	}

}
