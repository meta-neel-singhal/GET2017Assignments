package shoppingterminal;
import helper.*;
import cart.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Contains the list of all the products available in the store.
 * 
 * @author Neel Singhal
 */
public class Store {
	private List<CartProducts> products = new ArrayList<CartProducts>();

	public List<CartProducts> getProducts() {
		return products;
	}

	public void setProducts(List<CartProducts> products) {
		this.products = products;
	}

	/**
	 * Default constructor that calls initStoreItems to initialize the product details.
	 */
	public Store() {
		this.initStoreItems();
	}

	/**
	 * Initializes the product details in a list.
	 */
	public void initStoreItems() {
		List<String> productsDetails = new FileManager().read(Constants.PRODUCT_PATH);
		String[] details;
		for (String item : productsDetails) {
			details = item.split(",");
			this.products.add(new CartProducts(details[0], details[1], details[2]));
		}
	}

	/**
	 * Checks if the product id entered by the customer is valid.
	 * 
	 * @param id    Product id entered by the customer.
	 * @return true if the product id entered by the customer is a valid entry, otherwise false.
	 */
	public boolean isIdValid(int id){
		for(CartProducts product : products){
			if(product.getProductId() == id){

				return true;
			}
		}

		return false;
	}

	/**
	 * Overridden toString method to display contents in a following pattern.
	 * 
	 * @return result string of desired pattern.
	 */
	@Override
	public String toString() {
		String result ="";
		for (CartProducts product : products) {
			result += "Product Id : " + product.getProductId() + "  -->  " + product.getProductName()
					+ "  -->  Rs " + product.getProductPrice() + "\n";
		}

		return result;
	}
}
