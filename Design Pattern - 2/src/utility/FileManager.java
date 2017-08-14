package utility;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import model.Product;


public class FileManager {
/*	public static String read(String filepath) {
		StringBuffer buffer = null;
		try {
			String str = "";
			buffer = new StringBuffer();
			FileInputStream  fstream = new FileInputStream(filepath);
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			while ((str = br.readLine()) != null) {
				
				buffer.append(str);
		}
			br.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return buffer.toString();
	}*/

	public static void readProducts(String filepath){
		try {
			String str = "";
			FileInputStream  fstream = new FileInputStream(filepath);
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			Product prod = new Product();
			while ((str = br.readLine()) != null) {
				String s[] = str.split(",");
				/*Product prod = new Product(0, str, 0);*/
				prod.setId(Integer.parseInt(s[0]));
				prod.setProductName(s[1]);
				prod.setProductPrice(Double.parseDouble(s[2]));
			}
			br.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
