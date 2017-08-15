package dao;
import java.util.List;

import model.Product;

/**
 * Interface which contains the list of all the products.
 * 
 * @author Neel Singhal
 */
public interface ProductDao extends BaseDao{
	public List<Product> getAllProducts();
}
