import java.util.ArrayList;
import java.util.List;

/**
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
	 * 
	 */
	public Store() {
		this.initStoreItems();
	}

	/**
	 * 
	 */
	public void initStoreItems() {
		List<String> productsDetails = new FileHandling().read(Constants.PRODUCT_PATH);
		String[] details;
		for (String item : productsDetails) {
			details = item.split(",");
			this.products.add(new CartProducts(details[0], details[1], details[2]));
		}
	}

	/**
	 * 
	 * @param id
	 * @return
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
	 * 
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
