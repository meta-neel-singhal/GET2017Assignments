package com.metacube.Shopping.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.metacube.Shopping.Product.Model.Product;
import com.metacube.Shopping.Product.dao.ProductDao;

/**
 * The Class DefaultProductService.
 * 
 * @author Neel Singhal
 */
@Component("productService")
public class DefaultProductService implements ProductService {
	@Autowired
	ProductDao productDao;

	public DefaultProductService() {

	}
	
	public DefaultProductService(ProductDao productDao) {
		this.productDao = productDao;
	}

	/**
	 * Gets the product dao object.
	 *
	 * @return the product dao object
	 */
	public ProductDao getProductDao() {
		return productDao;
	}

	/**
	 * Sets the product dao object.
	 *
	 * @param productDao the new product dao object
	 */
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	public Iterable<Product> getAllProducts() {
		return productDao.findAll();
	}

	@Override
	public Product getProductById(final int id) {
		return productDao.findOne(id);
	}

	@Override
	public Boolean deleteProduct(int id) {
		return productDao.delete(id);
	}

	@Override
	public Boolean editProduct(Product entity, int id) {
		return productDao.edit(entity, id);
	}

	@Override
	public Boolean addProduct(Product newProduct) {
		return productDao.add(newProduct);
	}
}
