package com.metacube.Shopping.Product.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import com.metacube.Shopping.Product.Model.Product;
import com.metacube.Shopping.dao.GenericJdbcDao;

/**
 * The Class JdbcProductDao.
 * 
 * @author Neel Singhal
 */
@Component("productDao")
public class JdbcProductDao extends GenericJdbcDao<Product, Integer> implements
		ProductDao {

	private String tableName = "Products";

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
	protected Product extractResultSetRow(final ResultSet resultSet) {
		Product product = new Product();

		try {
			product.setImg(resultSet.getString("img"));
			product.setPrice(resultSet.getDouble("price"));
			product.setName(resultSet.getString("name"));
			product.setId(resultSet.getInt("id"));
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
