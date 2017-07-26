import java.util.ArrayList;
import java.util.List;

/**
 * Contains all the products selected in the cart.
 * 
 * @author Neel Singhal
 */
public class Cart {
	private List<CartProducts> cartItems = new ArrayList<CartProducts>();
	private double orderLevelDiscount;
	private double totalAmount;
	private double totalProductLevelDiscount;

	public List<CartProducts> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartProducts> cartItems) {
		this.cartItems = cartItems;
	}
	
	public double getOrderLevelDiscount() {
		return orderLevelDiscount;
	}

	public void setOrderLevelDiscount(double orderLevelDiscount) {
		this.orderLevelDiscount = orderLevelDiscount;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public double getTotalProductLevelDiscount() {
		return totalProductLevelDiscount;
	}

	public void setTotalProductLevelDiscount(double totalProductLevelDiscount) {
		this.totalProductLevelDiscount = totalProductLevelDiscount;
	}

	/**
	 * Adds selected product to Cart.
	 * 
	 * @param store       Contains list of all the products available in store.
	 * @param id          Product ID.
	 * @param quantity    Quantity of item bought.
	 */
	public void addProductToCartByProductId(Store store, int id, int quantity) {
		CartProducts product = getProductByProductId(store,id);
		if (cartItems.contains(product)) {
			product.setQuantity(product.getQuantity() + quantity);
		}
		else {
			product.setQuantity(quantity);
			cartItems.add(product);
		}
	}

	/**
	 * Gets the product with the particular product id in the store.
	 * 
	 * @param store    Contains list of all the products available in store.
	 * @param id       Product ID.
	 * @return product with the particular product id.
	 */
	public CartProducts getProductByProductId(Store store, int id) {
		CartProducts product = null;
		List<CartProducts> products = store.getProducts();
		for (CartProducts item : products) {
			if (item.getProductId() == id) {
				product = item;
				break;
			}
		}

		return product;
	}

	/**
	 * Overridden toString method to display contents in a following pattern.
	 * 
	 * @return result string of desired pattern.
	 */
	@Override
	public String toString() {
		String result = "";
		for (CartProducts product : cartItems) {
			result += product.getProductId() + "  -->  "
					+ product.getProductName() + "  -->  "
					+ product.getProductPrice() + "*" + product.getQuantity()
					+ " = " + product.getProductPrice() * product.getQuantity()
					+ "  --> " + product.getDiscount() + "*"
					+ product.getQuantity() + " = " + product.getQuantity()
					* product.getDiscount() + "  -->  "
					+ (product.getProductPrice() - product.getDiscount())
					* product.getQuantity() + "\n";
		}

		return result;
	}
}
