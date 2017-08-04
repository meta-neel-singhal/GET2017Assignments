/**
 * Extends product class to get and set applicable discounts and
 * quantity of products.
 * 
 * @author Neel Singhal
 */
public class CartProducts extends Product {
	private double discount;
	private int quantity;

	public CartProducts(String id, String name, String price) {
		super(id, name, price);

	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
