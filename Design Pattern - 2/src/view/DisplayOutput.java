package view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import model.Cart;
import utility.StatusEnumerations;
import dao.InMemoryProductDao;

public class DisplayOutput {

	public static void getOutput() {
		double totalPrice = 0.0;
		Scanner scan = new Scanner(System.in);
		List<Cart> cartItems = InMemoryProductDao.getCartItems();

		do {
			System.out.println("\n1. View Cart");
			System.out.println("2. Edit Cart");
			System.out.println("3. Generate Bill");
			try{
			int num = scan.nextInt();
			switch (num) {
			case 1:
				cartItems = InMemoryProductDao.getCartItems();
				System.out.println("\n########################");
				System.out.println("YOUR ORDER");
				System.out.println("########################");
				System.out.println("\nPURCHASED PRODUCTS : ");
				for (Cart item : cartItems) {
					System.out.println("Product : "
							+ InMemoryProductDao.productMap.get(item.getProductId()).getId()
							+ " - " + InMemoryProductDao.productMap.get(item.getProductId()).getProductName());
					System.out.println("Cost : Rs."	+ item.getTotalPrice() + "( "
							+ InMemoryProductDao.productMap.get(item.getProductId()).getProductPrice()
							+ " * " + item.getProductQuantity() + " )\n");
				}
				break;
			case 2:
				boolean flag = true;
				do {
					System.out.println("\n1. Remove items from cart");
					System.out.println("2. Add items to cart");
					System.out.println("3. Back");
					int val = scan.nextInt();
					switch (val) {
					case 1:
						System.out.println("Enter product code you want to remove");
						int productId = scan.nextInt();
						InMemoryProductDao.removeFromCart(productId);
						break;
					case 2:
						DisplayInput.getInput();
						break;
					case 3:
						flag = false;
						break;
					}
				} while (flag);
				break;
			case 3:
				cartItems = InMemoryProductDao.getCartItems();
				totalPrice = 0;
				for (Cart item : cartItems) {
					totalPrice += item.getTotalPrice();
				}
				System.out.println("\n########################");
				System.out.println("YOUR BILL");
				System.out.println("########################");
				System.out.println("\nTotal : " + totalPrice);
				System.exit(0);
				break;
			}
			}catch(InputMismatchException ie){
				System.out.println(ie.getMessage());
			}
		} while (true);		
	
	}
	
	public static void checkStatus(StatusEnumerations status) {
		switch (status) {
		case NOTAVAILABLE:
			System.out.println("Product is not available in the shop.");
			break;
		case NOTSELECTED:
			System.out.println("Product is not available in your cart.");
			break;
		}
	}
}

