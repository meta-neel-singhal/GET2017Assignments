package controller;

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
}
