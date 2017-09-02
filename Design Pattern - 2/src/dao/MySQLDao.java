package dao;

import java.util.List;

import model.BaseEntity;
import model.Product;

/**
 * For future use if the database is in MySQL.
 * 
 * @author Neel Singhal
 */
public class MySQLDao implements BaseDao, ProductDao {

	@Override
	public Product get(String productCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(BaseEntity product) {
		// TODO Auto-generated method stub
	}

	@Override
	public void update(BaseEntity product) {
		// TODO Auto-generated method stub
	}

	@Override
	public void delete(BaseEntity product) {
		// TODO Auto-generated method stub
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}
}
