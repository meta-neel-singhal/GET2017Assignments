package view;

import java.util.Scanner;

import model.Product;
import controller.ProductController;

public class DisplayInput {

/*	public int productId, productQuantity;
	public DisplayInput(int productId, int productQuantity) {
		this.productId = productId;
		this.productQuantity = productQuantity;
	}*/

	public static void getInput() {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int noOfProducts, productId, productQuantity;
		System.out.println("Enter the no. of products you want to buy: ");
		noOfProducts = scan.nextInt();
		ProductController controller = new ProductController();
		Product input = new Product();
		
		for(int count = 0; count < noOfProducts; count++){
			System.out.println("Enter the product id: ");
			productId = scan.nextInt();
			System.out.println("Enter quantity of this product: ");
			productQuantity = scan.nextInt();
			while (productQuantity < 1) {
				System.out.println("Enter valid quantity for the product :");
				productQuantity = scan.nextInt();
			}
			input.setId(productId);
			input.setProductQuantity(productQuantity);
			controller.getView(input);
		}
	}
}