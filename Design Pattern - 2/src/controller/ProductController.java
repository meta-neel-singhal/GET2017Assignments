package controller;

import model.Product;
import utility.StatusEnumerations;
import view.DisplayOutput;
import facade.ProductFacade;

public class ProductController {
	ProductFacade product = new ProductFacade();

	public void getView(Product input) {
		if(product.isValid(input)) {
			product.addToCart(input);
		}
		else {
			DisplayOutput.checkStatus(StatusEnumerations.NOTAVAILABLE);
		}
	}

	/*private void addToCart(DisplayInput input) {
		// TODO Auto-generated method stub
		Cart cart = new Cart();
		cart.setProductId(input.productId);
		cart.setProductQuantity(input.productQuantity);
		cart.setTotalPrice(product.getPrice(input));
		cart.addCartProducts();
	}
*/}
