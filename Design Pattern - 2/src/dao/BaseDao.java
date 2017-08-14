package dao;
import model.Product;

public interface BaseDao {
	// HashMap<Integer, Product> productMap = new HashMap<Integer, Product>();
	public Product getProduct(int productId);
	public void addProduct(Product product);
	public void updateProduct(Product product);
	public void deleteProduct(Product product);
}
