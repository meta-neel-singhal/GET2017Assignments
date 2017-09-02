package model;

/**
 * Contains the details of the products such as its id,
 * name, price and quantity.
 * 
 * @author Neel Singhal
 */
public class Product extends BaseEntity {
	
	private String productCode;
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

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}	
}
