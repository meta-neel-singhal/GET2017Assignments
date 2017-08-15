package dao;
import model.BaseEntity;
import model.Product;

/**
 * Interface to Add, Delete, Update and Get products.
 * 
 * @author Neel Singhal
 */
public interface BaseDao {
	public Product getProduct(int productId);
	public void addProduct(BaseEntity product);
	public void updateProduct(BaseEntity product);
	public void deleteProduct(BaseEntity product);
}
