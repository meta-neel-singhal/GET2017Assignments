package model;


public class Cart {
	// static List<Cart> cartProducts = new ArrayList<Cart>();
	int productId;
	int productQuantity;
	double totalPrice;
	
	/*public static List<Cart> getCartProducts() {
		return cartProducts;
	}
	
	public void addCartProducts() {
		cartProducts.add(this);
	}*/
	
	public int getProductId() {
		return productId;
	}
	
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	public int getProductQuantity() {
		return productQuantity;
	}
	
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	
	public double getTotalPrice() {
		return totalPrice;
	}
	
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
}
