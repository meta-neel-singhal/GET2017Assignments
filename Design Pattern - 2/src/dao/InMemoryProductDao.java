package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.metacube.shoppingCart.Enums.Status;
import com.metacube.shoppingCart.Model.ShoppingCart;
import com.metacube.shoppingCart.View.DisplayOutput;

import model.Cart;
import model.Product;

public class InMemoryProductDao implements BaseDao, ProductDao {
	public static HashMap<Integer, Product> productMap = new HashMap<Integer, Product>();
	static List<Cart> cartItems = new ArrayList<Cart>();

	@Override
	public Product getProduct(int productId) {
		// TODO Auto-generated method stub
		return InMemoryProductDao.productMap.get(productId);
	}

	@Override
	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProduct(Product product) {
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
	
	public void removeFromCart(int productId) {
		boolean flag = true;
		for (Cart item : cartItems) {
			if (item.getProductId() == productId) {
				cartItems.remove(item);
				flag = false;
				System.out.println("Product is successfully removed from the cart.");
				break;
			}
		}
		if (flag) {
			DisplayOutput.checkStatus(Status.NOTSELECTED);
		}
	}
}
