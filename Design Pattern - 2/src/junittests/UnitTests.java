package junittests;

import model.Product;

import org.junit.Assert;
import org.junit.Test;

import utility.Constants;
import utility.FileManager;
import dao.BaseDao;
import dao.InMemoryProductDao;
import dao.MySQLDao;
import facade.ProductFacade;
import facade.ProductFactory;

public class UnitTests {

	// Positive test case.
	@Test
	public void isValidTestCase1() {
		Product product = new Product();
		ProductFacade productFacade = new ProductFacade();
		FileManager.readProducts(Constants.PRODUCT_LOCATION);
		product.setProductId(123);
		Assert.assertTrue(productFacade.isValid(product));
	}

	// Positive test case.
	@Test
	public void getInstanceTestCase1() {
		BaseDao daoObject = ProductFactory.getInstance("InMemoryProductDao");
		Assert.assertTrue(daoObject instanceof InMemoryProductDao);
	}	

	// Positive test case.
	@Test
	public void getPriceTestCase1() {
		Product product = new Product();
		ProductFacade facade = new ProductFacade();
		FileManager.readProducts(Constants.PRODUCT_LOCATION);
		product.setProductId(123);
		product.setProductQuantity(3);
		double expectedPrice = facade.getPrice(product);
		Assert.assertFalse(expectedPrice == 0.0);
	}

	// Negative test case.
	@Test
	public void getPriceTestCase2() {
		Product product = new Product();
		ProductFacade facade = new ProductFacade();
		FileManager.readProducts(Constants.PRODUCT_LOCATION);
		product.setProductId(123);
		product.setProductQuantity(3);
		double expectedPrice = facade.getPrice(product);
		Assert.assertTrue(expectedPrice == 4500.0);
	}

	// Negative test case.
	@Test
	public void getInstanceTestCase2() {
		BaseDao daoObject = ProductFactory.getInstance("InMemoryProductDao");
		Assert.assertFalse(daoObject instanceof MySQLDao);
	}

	// Negative test case.
	@Test
	public void isValidTestCase2() {
		Product product = new Product();
		ProductFacade productFacade = new ProductFacade();
		FileManager.readProducts(Constants.PRODUCT_LOCATION);
		product.setProductId(123);
		Assert.assertFalse(!productFacade.isValid(product));
	}
}
