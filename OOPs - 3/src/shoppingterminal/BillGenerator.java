package shoppingterminal;
import cart.*;
import promotions.*;
import helper.*;

/**
 * Helps to generate the bill of the customer.
 * 
 * @author Neel Singhal
 */
public class BillGenerator {
	private User userName;
	private Cart cart;
	private ProductPromotion productPromo;
	private double subTotal;
	private double totalProductLevelDiscount;
	private double orderLevelDiscount;

	/**
	 * Initializes all the below mentioned entities.
	 * 
	 * @param name                         Name of the customer.
	 * @param cart                         Contains the cart details of the customer.
	 * @param orderPromo                   Order Promotions applicable on the customers purchase.
	 * @param productPromo                 Product Promotions applicable on the customers purchase.
	 * @param subTotal                     Total purchased amount before any promotions were applied.
	 * @param totalProductLevelDiscount    Total product level discount applicable.
	 * @param orderLevelDiscount           Total order level discount applicable.
	 */
	public BillGenerator(String name, User userName, Cart cart, ProductPromotion productPromo, double subTotal,
			double totalProductLevelDiscount, double orderLevelDiscount) {
		this.userName = userName;
		this.cart = cart;
		this.productPromo = productPromo;
		this.subTotal = subTotal;
		this.totalProductLevelDiscount = totalProductLevelDiscount;
		this.orderLevelDiscount = orderLevelDiscount;
	}

	/**
	 * Provides the details of every product purchased.
	 * 
	 * @return output string containing details of products purchased.
	 */
	public String purchaseProductDetails() {
		String output = "";
		for (CartProducts product : cart.getCartItems()) {
			// To display details in the required format.
			output += "\nProduct : " + product.getProductId() + " - " + product.getProductName() + "\nCost : "
					+ (product.getProductPrice() * product.getQuantity()) + "("	+ product.getQuantity()
					+ " X " + product.getProductPrice() + ")\n";
		}
		
		return output;
	}

	/**
	 * Provides details of all the promotions applicable.
	 * 
	 * @return output string containing details of promotions applicable.
	 */
	public String appliedPromotionsOrDiscount() {
		String output = "";
		for (CartProducts product : cart.getCartItems()) {
			if(productPromo.getDiscountType().containsKey(product.getProductId())){
				if ("ProductFixedAmountPromotion".equals(productPromo.getDiscountType().get(product.getProductId()))) {
					// To display details in the required format.
					output += "Promotion : " + product.getDiscount() + " off on " + product.getProductName()
							+ " [Code:"	+ product.getProductId() + "]\nDiscount : "	
							+ (product.getDiscount() * product.getQuantity()) + "\n\n";
				}
				else {
					// To display details in the required format.
					output += "Promotion : " + productPromo.getDiscountAmount().get(product.getProductId())
							+ "% off on " + product.getProductName() + " [Code:" + product.getProductId()
							+ "]\nDiscount : " + (product.getDiscount() * product.getQuantity()) + "\n\n";
				}

			}}
		output += "Promotion : " + cart.getOrderLevelDiscount() + " off on order \nDiscount : "
				+ cart.getOrderLevelDiscount() + "\n\n\n";

		return output;
	}

	/**
	 * Provides final billing details.
	 * 
	 * @return output string containing final billing details.
	 */
	public String finalBill() {
		String output = "Subtotal : " + subTotal + "\nProduct Level Discounts : " + totalProductLevelDiscount
				+ "\nOrder Level Discounts : " + orderLevelDiscount + "\nTotal : "
				+ (subTotal - totalProductLevelDiscount - orderLevelDiscount + "\n");
		
		return output;
	}
 
	/**
	 * Overridden toString method to display contents in a following pattern.
	 * 
	 * @return string of desired pattern.
	 */
	@Override
	public String toString() {
		String display = "";
		String hashLine = "##########################################################################################\n";
		display += hashLine + " Your Order : " + userName.getUserName() + " \n" + hashLine;
		display += "\nPURCHASE PRODUCTS :\n";
		display += purchaseProductDetails();
		display += "\n\nAPPLIED PROMOTION/DISCOUNTS : \n\n";
		display += appliedPromotionsOrDiscount();
		display += finalBill();
		FileManager file = new FileManager();
		file.write(display, userName.getUserName());

		return display;
	}
}
