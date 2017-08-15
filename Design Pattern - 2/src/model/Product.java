package model;

/**
 * Contains the details of the products such as its id,
 * name, price and quantity.
 * 
 * @author Neel Singhal
 */
public class Product extends BaseEntity {
	
	private int productId;
	private String productName;
	private double productPrice;
	private int productQuantity;

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}	
}
