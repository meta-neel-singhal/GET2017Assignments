package junittests;

import model.Product;

import org.junit.Assert;
import org.junit.Test;

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
	
		product.setProductId(126);
		Assert.assertTrue(productFacade.isValid(product) == false);
	}
	
	// Positive test case.
	@Test
	public void getInstanceTestCase1() {
		BaseDao daoObject = ProductFactory.getInstance("InMemoryProductDao");
		Assert.assertTrue(daoObject instanceof InMemoryProductDao);
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
	
		product.setProductId(126);
		Assert.assertFalse(productFacade.isValid(product) == true);
	}
}
