package utility;

import view.DisplayInput;
import view.DisplayOutput;

/**
 * Main class and initializes the shopping store terminal.
 * 
 * @author Neel Singhal
 */
public class ShoppingStore {
	
	/**
	 * Main method to initialize shopping store terminal.
	 * 
	 * @param args
	 */
	public static void main(String args[]){
		FileManager.readProducts(Constants.PRODUCT_LOCATION);
		DisplayInput.showAllProducts();
		DisplayInput.getInput();
		DisplayOutput.getOutput();
	}
}
