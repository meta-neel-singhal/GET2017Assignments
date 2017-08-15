package view;

import java.util.Scanner;

import model.Product;
import utility.Constants;
import utility.FileManager;
import controller.ProductController;

/**
 * Helps to take inputs from the users and displays the list of products available 
 * in the store.
 * 
 * @author Neel Singhal
 */
public class DisplayInput {

	/**
	 * Gets the input from the user about the products that user wants to buy.
	 */
	public static void getInput() {
		Scanner scan = new Scanner(System.in);
		int noOfProducts, productId, productQuantity;
		System.out.println("Enter the no. of products you want to buy: ");
		noOfProducts = scan.nextInt();
		ProductController controller = new ProductController();
		Product input = new Product();
		// Get input about product details for every product.
		for(int count = 0; count < noOfProducts; count++){
			System.out.println("Enter the product id: ");
			productId = scan.nextInt();
			System.out.println("Enter quantity of this product: ");
			productQuantity = scan.nextInt();
			// Validate that quantity of product should not be less than 1.
			while (productQuantity < 1) {
				System.out.println("Enter valid quantity for the product :");
				productQuantity = scan.nextInt();
			}
			input.setProductId(productId);
			input.setProductQuantity(productQuantity);
			controller.getView(input);
		}
	}

	/**
	 * Display the list of all the products available in the store.
	 */
	public static void showAllProducts() {
		FileManager.allProducts(Constants.PRODUCT_LOCATION);
	}
}