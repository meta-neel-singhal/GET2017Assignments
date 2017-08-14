package dao;
import java.util.List;

import model.Product;


public interface ProductDao extends BaseDao{

	public List<Product> getAllProducts();
	
	/*List<Product> products;

	@Override
	public Product getProduct(int productId) {
		// TODO Auto-generated method stub
		return products.get(productId);
	}

	@Override
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		products.get(product.getId()).setProductName(product.getProductName());
		products.get(product.getId()).setProductPrice(product.getProductPrice());
		System.out.println("Product Id: " + product.getId() + " is deleted.");
	}

	@Override
	public void deleteProduct(Product product) {
		// TODO Auto-generated method stub
		products.remove(product.getId());
	    System.out.println("Product Id: " + product.getId() + " is deleted.");
	}

	@Override
	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		
	}*/
}
