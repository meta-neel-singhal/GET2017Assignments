package facade;

import dao.BaseDao;
import dao.FileDao;
import dao.InMemoryProductDao;
import dao.MySQLDao;

/**
 * Generates the object of the required class.
 * 
 * @author Neel Singhal
 */
public class ProductFactory {
	
	/**
	 * Returns the object of required class to the facade layer. 
	 * 
	 * @param instance    Type of object to obtain from the factory.
	 * @return the object of the required class.
	 */
	public static BaseDao getInstance(String instance){
		BaseDao instBaseDao;
		switch(instance){
		case "InMemoryProductDao":
			instBaseDao = new InMemoryProductDao();
			break;
		case "MySQLDao":
			instBaseDao = new MySQLDao();
			break;
		case "FileDao":
			instBaseDao = new FileDao();
			break;
		default:
			instBaseDao = null;
			break;
		}
		
		return instBaseDao;
	}
}
