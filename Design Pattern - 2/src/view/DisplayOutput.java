package view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import controller.ProductController;
import model.Cart;
import utility.StatusEnumerations;
import dao.InMemoryProductDao;

/**
 * Displays the output according to the options chosen by the user.
 * 
 * @author Neel Singhal
 */
public class DisplayOutput {

	static ProductController prodController = new ProductController();
	static List<Cart> cartItems;
	static Scanner scan;
	static double totalPrice = 0.0;
	
	/**
	 * Provide the user with the options to chose from.
	 */
	public static void getOutput() {
		scan = new Scanner(System.in);
		int num;
		do {
			System.out.println("\n1. View Cart");
			System.out.println("2. Edit Cart");
			System.out.println("3. Generate Bill");
			try {
				num = scan.nextInt();
				switch (num) {
				case 1:
					viewCart();
					break;
				case 2:
					editCart();
					break;
				case 3:
					generateBill();
					break;
				}
			}
			catch (InputMismatchException e) {
				System.out.println(e.getMessage());
			}
		} while (true);		

	}

	/**
	 * Displays the cart of the user.
	 */
	public static void viewCart() {
		cartItems = prodController.getCartItems();
		System.out.println("\n########################");
		System.out.println("YOUR ORDER");
		System.out.println("########################");
		System.out.println("\nPURCHASED PRODUCTS : ");
		for (Cart item : cartItems) {
			System.out.println("Product : "	+ prodController.getProductCode(item) 
					+ " - " + prodController.getProductName(item));
			System.out.println("Cost : Rs."	+ item.getTotalPrice() + "( "
					+ prodController.getProductPrice(item) + " * "
					+ item.getProductQuantity() + " )\n");
		}
	}

	/**
	 * Helps the user to edit the cart according to the requirement.
	 */
	public static void editCart() {
		boolean flag = true;
		String productCode;
		do {
			System.out.println("\n1. Remove items from cart");
			System.out.println("2. Add items to cart");
			System.out.println("3. Back");
			int val = scan.nextInt();
			switch (val) {
			case 1:
				System.out.println("Enter product code you want to remove");
				productCode = scan.next();
				prodController.removeFromCart(productCode);
				break;
			case 2:
				DisplayInput.getInput();
				break;
			case 3:
				flag = false;
				break;
			}
		} while (flag);
	}

	/**
	 * Generates the bill of the user and exit from the application.
	 */
	public static void generateBill() {
		cartItems = prodController.getCartItems();
		totalPrice = 0;
		for (Cart item : cartItems) {
			totalPrice += item.getTotalPrice();
		}
		System.out.println("\n########################");
		System.out.println("YOUR BILL");
		System.out.println("########################");
		System.out.println("\nTotal : " + totalPrice);
		System.exit(0);
	}

	/**
	 * Print status of the product if the chosen product is not in the store
	 * or is not in the cart.
	 * 
	 * @param status    Enumeration stating the status about the chosen product.
	 */
	public static void checkStatus(StatusEnumerations status) {
		switch (status) {
		case NOT_AVAILABLE:
			System.out.println("Product is not available in the shop.");
			break;
		case NOT_SELECTED:
			System.out.println("Product is not available in your cart.");
			break;
		}
	}
}

