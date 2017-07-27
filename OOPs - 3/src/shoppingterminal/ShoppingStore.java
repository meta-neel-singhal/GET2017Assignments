package shoppingterminal;
import promotions.*;
import cart.*;
import helper.*;
import java.util.Scanner;

/**
 * (Main Class) Initializes the shopping terminal for the customer to do the 
 * shopping and takes use of other classes to help the customer to buy the 
 * products and generate the corresponding bill of the shopping done by the
 * customer.
 * 
 * @author Neel Singhal
 */
public class ShoppingStore {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		ProductPromotion productPromo = new ProductPromotion();
		Cart cart = new Cart();
		Store store = new Store();
		User userName = new User();
		OrderPromotion orderPromo = new OrderPromotion();

		int numberOfProduct = 0;
		int quantity = 0;
		int productId = 0;

		String name = initializeShopping(scan, userName, store, productPromo, orderPromo);

		// Validates the entry of the number of products to be bought. 
		// It should be between 1 to the total number of products available in the store.
		while (!(scan.hasNextInt()) || ((numberOfProduct = scan.nextInt()) < 1) ||
				(numberOfProduct > store.getProducts().size())) {
			System.out.println("Please enter a valid number!!!");
			scan.nextLine();
		}

		for (int count = 0; count < numberOfProduct; count++) {
			System.out.println("Enter " + ordinal(count + 1) + " Product Id");
			
			// Validates the entry of the id of products to be bought. 
			// It should be among the id of products available in the store.
			while (!scan.hasNextInt() || !store.isIdValid(productId = scan.nextInt())) {
				System.out.println("Enter Correct Product Id:");
				scan.nextLine();

			}
			System.out.println("Enter Quantity of Product:");
			
			// Validates the entry of the quantity of a product which is to be bought. 
			// It should be a positive integer value.
			while (!scan.hasNextInt() || (quantity = scan.nextInt()) < 1) {
				System.out.println("Enter positive integer value:");
				scan.nextLine();

			}

			cart.addProductToCartByProductId(store, productId, quantity);
			productPromo.getDiscount(cart);
		}

		double subTotal = 0;
		double totalProductLevelDiscount = 0;
		double orderLevelDiscount;
		for (CartProducts products : cart.getCartItems()) {
			subTotal += products.getProductPrice() * products.getQuantity();
			totalProductLevelDiscount += products.getDiscount()	* products.getQuantity();
		}

		cart.setTotalAmount(subTotal);
		cart.setTotalProductLevelDiscount(totalProductLevelDiscount);
		orderPromo.getDiscount(cart);
		orderLevelDiscount = cart.getOrderLevelDiscount();
		BillGenerator bill = new BillGenerator(name, userName, cart, productPromo,
				subTotal, totalProductLevelDiscount, orderLevelDiscount);
		System.out.println(bill);

		scan.close();
	}

	/**
	 * Initializes the shopping terminal for the customer to use.
	 * 
	 * @param scan    		  Scanner class object to take input of customer from the console.
	 * @param store    		  Contains details of all the available products in the store.
	 * @param productPromo    Contains all the details of available product promotions.
	 * @param orderPromo      Contains all the details of available order promotions.
	 * @return the name of the user
	 */
	public static String initializeShopping(Scanner scan, User userName, Store store,
			ProductPromotion productPromo, OrderPromotion orderPromo) {
		System.out.println("Enter your Name:");
		String name = scan.nextLine();
		userName.setUserName(name);
		System.out.println("Welcome " + name + " to Shopping Store Terminal\n\n");
		System.out.println("List of Products Available: " + "\n");
		System.out.println(store);
		System.out.println("Offers Available on folowing Products: " + "\n");
		System.out.println(productPromo);
		System.out.println("Offers Available on Shopping : " + "\n");
		System.out.println(orderPromo);
		System.out.println("\nEnter Number of Products you want to buy: ");

		return name;
	}

	/**
	 * Provides ordinal value of the required number.
	 * 
	 * @param number    Number whose ordinal value is to be found.
	 * @return ordinal value
	 */
	public static String ordinal(int number) {
		String[] sufixes = new String[] { "th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th" };
		switch (number % 100) {
		case 11:
		case 12:
		case 13:
			return number + "th";
		default:
			return number + sufixes[number % 10];

		}
	}
}
