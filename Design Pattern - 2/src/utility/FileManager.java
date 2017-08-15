package utility;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import model.Product;
import dao.InMemoryProductDao;

/**
 * Handles the file and performs the read operations.
 * 
 * @author Neel Singhal
 */
public class FileManager {
	
	/**
	 * Read the product and sets the id, name and price in the product map.
	 * 
	 * @param filepath    path of the products file.
	 */
	public static void readProducts(String filepath){
		try {
			String str = "";
			FileInputStream  fstream = new FileInputStream(filepath);
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			Product prod = null;
			while ((str = br.readLine()) != null) {
				String s[] = str.split(",");
				prod = new Product();
				prod.setProductId(Integer.parseInt(s[0]));
				prod.setProductName(s[1]);
				prod.setProductPrice(Double.parseDouble(s[2]));
				InMemoryProductDao.productMap.put(Integer.parseInt(s[0]), prod);
			}
			br.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Print details of all the products on the console when user enters the store.
	 * 
	 * @param filepath    path of the products file.
	 */
	public static void allProducts(String filepath){
		try {
			FileInputStream  fstream = new FileInputStream(filepath);
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			String check = "";
			String str = "";
			while ((check = br.readLine()) != null) {
				str += check + "\n";
			}
			System.out.println(str);
			br.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
