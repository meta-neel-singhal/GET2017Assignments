package com.metacube.get.layarch.dao.user;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.metacube.get.layarch.dao.GenericJdbcDao;
import com.metacube.get.layarch.model.Product;

/**
 * The Class JdbcProductDao.
 * 
 *  @author Neel Singhal
 */
public class JdbcProductDao extends GenericJdbcDao<Product, Integer> implements
		ProductDao {
	
	/**
	 * @return the table name.
	 */
	@Override
	protected String getTableName() {
		return "Products";
	}

	/**
	 * @return the product.
	 */
	@Override
	protected Product extractResultSetRow(final ResultSet resultSet) {
		Product product = new Product();

		try {
			product.setName(resultSet.getString("name"));
			product.setImg(resultSet.getString("img"));
			product.setId(resultSet.getInt("id"));
			product.setPrice(resultSet.getInt("price"));
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
