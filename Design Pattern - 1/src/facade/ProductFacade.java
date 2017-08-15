package facade;

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
		if(InMemoryProductDao.productMap.containsKey(input.getProductId())) {
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
		Product prod = (Product) daoObject.getProduct(input.getProductId());
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
		cart.setProductId(input.getProductId());
		cart.setProductQuantity(input.getProductQuantity());
		cart.setTotalPrice(getPrice(input));

		((InMemoryProductDao)daoObject).addToCartItems(cart);
		System.out.println("Product added successfully to the cart.");
	}

}
