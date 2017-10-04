package com.metacube.shoppingcart.service;

import com.metacube.shoppingcart.dao.product.ProductDao;
import com.metacube.shoppingcart.enums.Status;
import com.metacube.shoppingcart.modal.Product;

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
	public Iterable<Product> getAllProducts() {
		return productDao.findAll();
	}

	@Override
	public Product getProductById(int id) {
		return productDao.findOne(id);
	}

	@Override
	public Status addProduct(Product entity) {
		return productDao.add(entity);
	}

	@Override
	public Status deleteProduct(int id) {
		return productDao.delete(id);
	}

	@Override
	public Status editProduct(Product entity,int id) {
		return productDao.edit(entity,id);
	}
}
