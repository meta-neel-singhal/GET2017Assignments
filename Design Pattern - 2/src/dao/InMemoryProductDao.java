package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.BaseEntity;
import model.Cart;
import model.Product;
import utility.StatusEnumerations;
import view.DisplayOutput;

/**
 * Used when the database is in the memory.
 * 
 * @author Neel Singhal
 */
public class InMemoryProductDao implements BaseDao, ProductDao {
	public static HashMap<Integer, Product> productMap = new HashMap<Integer, Product>();
	static List<Cart> cartItems = new ArrayList<Cart>();

	@Override
	public Product getProduct(int productId) {
		// TODO Auto-generated method stub
		return InMemoryProductDao.productMap.get(productId);
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
	
	public void addToCartItems(Cart cart) {
		cartItems.add(cart);
	}

	public static List<Cart> getCartItems() {
		return cartItems;
	}
	
	/**
	 * Removes the product from the cart.
	 * 
	 * @param productId    ID of the product to be removed.
	 */
	public static void removeFromCart(int productId) {
		boolean flag = true;
		// Iterates over the list of products in cart.
		for (Cart item : cartItems) {
			// Deletes the product from cart if available.
			if (item.getProductId() == productId) {
				cartItems.remove(item);
				flag = false;
				System.out.println("Product is successfully removed from the cart.");
				break;
			}
		}
		if (flag) {
			DisplayOutput.checkStatus(StatusEnumerations.NOT_SELECTED);
		}
	}
}
