package controller;

import java.util.List;

import model.Cart;
import model.Product;
import utility.StatusEnumerations;
import view.DisplayOutput;
import facade.ProductFacade;

/**
 * Contact from facade and adds the product to the cart.
 * 
 * @author Neel Singhal
 */
public class ProductController {
	ProductFacade product = new ProductFacade();

	/**
	 * Gets the view content according to the product to be added in the cart.
	 * 
	 * @param input    Product to add in the cart.
	 */
	public void getView(Product input) {
		// If the product to add is a valid product in the store.
		if(product.isValid(input)) {
			product.addToCart(input);
		}
		else {
			DisplayOutput.checkStatus(StatusEnumerations.NOT_AVAILABLE);
		}
	}
	
	/**
	 * Get the product of the cart.
	 * 
	 * @return the list of cart items.
	 */
	public List<Cart> getCartItems() {
		List<Cart> cartItems = product.getCartItems();
		return cartItems;
	}

	/**
	 * Removes the product from the cart.
	 * 
	 * @param productCode    the code of product to be removed.
	 */
	public void removeFromCart(String productCode) {
		product.removeFromCart(productCode);
	}

	/**
	 * Get the product code of the cart item. 
	 * 
	 * @param item    Cart item.
	 * @return the code of the required item.
	 */
	public String getProductCode(Cart item) {
		return product.getProductCode(item);
	}
	
	/**
	 * Get the product name of the cart item. 
	 * 
	 * @param item    Cart item.
	 * @return the name of the required item.
	 */
	public String getProductName(Cart item) {
		return product.getProductName(item);
	}
	
	/**
	 * Get the product price of the cart item. 
	 * 
	 * @param item    Cart item.
	 * @return the price of the required item.
	 */
	public Double getProductPrice(Cart item) {
		return product.getProductPrice(item);
	}
}
