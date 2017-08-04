package shoppingterminal;
/**
 * Initializes all the products available in the shop.
 * 
 * @author Neel Singhal
 */
public class Product {
	private int productId;
	private String productName;
	private double productPrice;

	/**
	 * Parameterized constructor to initialize product details.
	 * 
	 * @param id       ID of the product.
	 * @param name     Name of the product.
	 * @param price    Price of the product.
	 */
	public Product(String id, String name, String price) {
		productId = Integer.parseInt(id);
		productName = name;
		productPrice = Double.parseDouble(price);
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
}
