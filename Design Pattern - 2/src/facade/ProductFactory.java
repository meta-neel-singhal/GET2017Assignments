package facade;

import dao.BaseDao;
import dao.FileDao;
import dao.InMemoryProductDao;
import dao.MySQLDao;

public class ProductFactory {
	public static BaseDao getInstance(String instance){
		switch(instance){
		case "InMemoryProductDao":
			return new InMemoryProductDao();
		case "MySQLDao":
			return new MySQLDao();
		case "FileDao":
			return new FileDao();
		default:
			return null;
		}
	}
}
