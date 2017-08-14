package facade;

import model.Cart;
import model.Product;
import dao.BaseDao;
import dao.InMemoryProductDao;

public class ProductFacade {
	BaseDao daoObject = ProductFactory.getInstance("InMemoryProductDao");
	
	public boolean isValid(Product input) {
		// TODO Auto-generated method stub
		if(InMemoryProductDao.productMap.containsKey(input.getId())) {
			return true;
		} 
		else {
			return false;
		}
	}
	
	public double getPrice(Product input) {
		double totalPrice;
		Product prod = (Product) daoObject.getProduct(input.getId());
		double price = prod.getProductPrice(); 
		totalPrice = input.getProductQuantity() * price;
		return totalPrice;
	}
	
	public void addToCart(Product input){
		Cart cart = new Cart();
		cart.setProductId(input.getId());
		cart.setProductQuantity(input.getProductQuantity());
		cart.setTotalPrice(getPrice(input));

		((InMemoryProductDao)daoObject).addToCartItems(cart);
		System.out.println("Product added successfully to the cart.");
	}

}
