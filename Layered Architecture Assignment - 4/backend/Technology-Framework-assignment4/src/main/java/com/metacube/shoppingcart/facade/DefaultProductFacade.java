package com.metacube.shoppingcart.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.metacube.shoppingcart.dto.ProductDto;
import com.metacube.shoppingcart.enums.Status;
import com.metacube.shoppingcart.model.Product;
import com.metacube.shoppingcart.service.ProductService;

/**
 * The Class DefaultProductFacade.
 * 
 * @author Neel Singhal
 */
@Component("productFacade")
public class DefaultProductFacade implements ProductFacade {

	@Autowired
	private ProductService productService;

	public DefaultProductFacade() {
	}

	public DefaultProductFacade(ProductService productService) {
		this.productService = productService;
	}

	/**
	 * Gets the product service.
	 *
	 * @return the product service
	 */
	public ProductService getProductService() {
		return productService;
	}

	/**
	 * Sets the product service.
	 *
	 * @param productService
	 *            the new product service
	 */
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	/**
	 * Gets the all products.
	 *
	 * @return the all products
	 */
	@Override
	public Iterable<ProductDto> getAllProducts() {
		List<ProductDto> productDtoList = new ArrayList<>();
		for (Product product : productService.getAllProducts()) {
			productDtoList.add(modelToProductDto(product));
		}

		return productDtoList;
	}

	/**
	 * Gets the product details by id.
	 *
	 * @param id
	 *            the id
	 * @return the product by id
	 */
	@Override
	public ProductDto getProductById(final int id) {
		return modelToProductDto(productService.getProductById(id));
	}

	/**
	 * Delete product by id.
	 *
	 * @param id
	 *            the id
	 * @return the status
	 */
	@Override
	public Status deleteProductById(final int id) {
		return productService.deleteProductById(id);
	}

	/**
	 * Adds the product.
	 *
	 * @param entity
	 *            the entity
	 * @return the status
	 */
	@Override
	public Status addProduct(Product entity) {
		return productService.addProduct(entity);
	}

	/**
	 * Update product.
	 *
	 * @param entity
	 *            the entity
	 * @param id
	 *            the id
	 * @return the status
	 */
	@Override
	public Status updateProduct(Product entity, int id) {
		return productService.updateProduct(entity, id);
	}

	/**
	 * product Dto to model.
	 *
	 * @param productDto
	 *            the product dto
	 * @return the product
	 */
	private Product productDtoToModel(ProductDto productDto) {
		if (productDto == null) {
			return null;
		}
		Product product = new Product();
		product.setId(productDto.getId());
		product.setName(productDto.getName());
		product.setPrice(productDto.getPrice());
		product.setImg(productDto.getImg());

		return product;
	}

	/**
	 * Model to dto.
	 *
	 * @param product
	 *            the product
	 * @return the product dto
	 */
	private ProductDto modelToProductDto(Product product) {
		if (product == null) {
			return null;
		}
		ProductDto productDto = new ProductDto();
		productDto.setId(product.getId());
		productDto.setName(product.getName());
		productDto.setPrice(product.getPrice());
		productDto.setImg(product.getImg());

		return productDto;
	}
}
