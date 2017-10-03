package com.metacube.get.layarch.service;

import com.metacube.get.layarch.dao.user.ProductDao;
import com.metacube.get.layarch.enums.Status;
import com.metacube.get.layarch.model.Product;

/**
 * The Class DefaultProductService.
 * 
 * @author Neel Singhal
 */
public class DefaultProductService implements ProductService {
	
	ProductDao productDao;

	/**
	 * Instantiates a new default product service.
	 *
	 * @param productDao the product dao
	 */
	public DefaultProductService(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	public Product getProductById(int id) {
		return productDao.findOne(id);
	}

	@Override
	public Iterable<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productDao.findAll();
	}

	@Override
	public Status deleteProduct(int id) {
		return productDao.delete(id);
	}

	@Override
	public Status updateProduct(Product product, int id) {
		return productDao.update(product, id);
	}

	@Override
	public Status addProduct(Product product) {
		return productDao.add(product);
	}
}
