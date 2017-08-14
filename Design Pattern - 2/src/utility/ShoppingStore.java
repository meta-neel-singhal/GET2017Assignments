package utility;

import view.DisplayInput;
import view.DisplayOutput;

public class ShoppingStore {
	public static void main(String args[]){
		FileManager.readProducts(Constants.PRODUCT_LOCATION);
		DisplayInput.getInput();
		DisplayOutput.getOutput();
	}
}
