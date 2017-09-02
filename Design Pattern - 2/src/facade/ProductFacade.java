package facade;

import java.util.List;

import model.Cart;
import model.Product;
import dao.BaseDao;
import dao.InMemoryProductDao;

/**
 * Layer which have the database information.
 * 
 * @author Neel Singhal
 */
public class ProductFacade {
	BaseDao daoObject = ProductFactory.getInstance("InMemoryProductDao");
		
	/**
	 * Check if the input product is in the store or not.
	 * 
	 * @param input    Product type input.
	 * @return true if input is in the product map otherwise false.
	 */
	public boolean isValid(Product input) {
		boolean result = false;
		if(InMemoryProductDao.productMap.containsKey(input.getProductCode())) {
			result = true;
		}
		return result;
	}
	
	/**
	 * Calculates the total price of the input product.
	 * 
	 * @param input    Product type input.
	 * @return total price of the input product bought.
	 */
	public double getPrice(Product input) {
		double totalPrice;
		Product prod = (Product) daoObject.get(input.getProductCode());
		double price = prod.getProductPrice(); 
		totalPrice = input.getProductQuantity() * price;
		return totalPrice;
	}
	
	/**
	 * Adds the product to the cart including its id, quantity and total price.
	 * 
	 * @param input    Product type input.
	 */
	public void addToCart(Product input){
		Cart cart = new Cart();
		cart.setProductCode(input.getProductCode());
		cart.setProductQuantity(input.getProductQuantity());
		cart.setTotalPrice(getPrice(input));

		((InMemoryProductDao)daoObject).addToCartItems(cart);
		System.out.println("Product added successfully to the cart.");
	}
	
	/**
	 * Get the product of the cart.
	 * 
	 * @return the list of cart items.
	 */
	public List<Cart> getCartItems() {
		List<Cart> cartItems = InMemoryProductDao.getCartItems();
		return cartItems;
	}
	
	/**
	 * Removes the product from the cart.
	 * 
	 * @param productCode    the code of product to be removed.
	 */
	public void removeFromCart(String productCode) {
		InMemoryProductDao.removeFromCart(productCode);
	}
	
	/**
	 * Get the product code of the cart item.
	 * 
	 * @param item    Cart item.
	 * @return the code of the required item.
	 */
	public String getProductCode(Cart item) {
		return InMemoryProductDao.productMap.get(item.getProductCode()).getProductCode();
	}
	
	/**
	 * Get the product name of the cart item. 
	 * 
	 * @param item    Cart item.
	 * @return the name of the required item.
	 */
	public String getProductName(Cart item) {
		return InMemoryProductDao.productMap.get(item.getProductCode()).getProductName();
	}
	
	/**
	 * Get the product price of the cart item. 
	 * 
	 * @param item    Cart item.
	 * @return the price of the required item.
	 */
	public Double getProductPrice(Cart item) {
		return InMemoryProductDao.productMap.get(item.getProductCode()).getProductPrice();
	}
}
