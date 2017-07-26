import java.util.Scanner;

/**
 * 
 * @author Neel Singhal
 */
public class ShoppingStore {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		ProductPromotion productPromo = new ProductPromotion();
		Cart cart = new Cart();
		Store store = new Store();
		OrderPromotion orderPromo = new OrderPromotion();

		int numberOfProduct = 0;
		int quantity = 0;
		int productId = 0;

		String name = initializeShopping(scan, store, productPromo, orderPromo);

		while (!(scan.hasNextInt()) || ((numberOfProduct = scan.nextInt()) < 1) ||
				(numberOfProduct > store.getProducts().size())) {
			System.out.println("Please enter a valid number!!!");
			scan.nextLine();
		}

		for (int count = 0; count < numberOfProduct; count++) {
			System.out.println("Enter " + ordinal(count + 1) + " Product Id");

			while (!scan.hasNextInt() || !store.isIdValid(productId = scan.nextInt())) {
				System.out.println("Enter Correct Product Id:");
				scan.nextLine();

			}
			System.out.println("Enter Quantity of Product:");

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
		BillGenerator bill = new BillGenerator(name, cart, productPromo,
				subTotal, totalProductLevelDiscount, orderLevelDiscount);
		System.out.println(bill);

		scan.close();
	}

	/**
	 * 
	 * @param scan
	 * @param store
	 * @param productPromo
	 * @param orderPromo
	 * @return
	 */
	public static String initializeShopping(Scanner scan, Store store,
			ProductPromotion productPromo, OrderPromotion orderPromo) {
		System.out.println("Enter your Name:");
		String name = scan.next();
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
	 * 
	 * @param number
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
