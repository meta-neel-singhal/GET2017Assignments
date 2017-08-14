package controller;

import com.metacube.shoppingCart.Enums.Status;
import com.metacube.shoppingCart.View.DisplayOutput;

import model.Cart;
import model.Product;
import view.DisplayInput;
import facade.ProductFacade;

public class ProductController {
	ProductFacade product = new ProductFacade();

	public void getView(Product input) {
		if(product.isValid(input)) {
			product.addToCart(input);
		}
		else {
			DisplayOutput.checkStatus(Status.NOTAVAILABLE);
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
