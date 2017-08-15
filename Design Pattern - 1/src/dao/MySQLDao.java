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
	public Product getProduct(int productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addProduct(BaseEntity product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateProduct(BaseEntity product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProduct(BaseEntity product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}
}
