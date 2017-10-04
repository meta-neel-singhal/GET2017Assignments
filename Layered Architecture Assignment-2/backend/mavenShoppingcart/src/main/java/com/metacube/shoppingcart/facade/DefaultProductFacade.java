package com.metacube.shoppingcart.facade;

import java.util.ArrayList;
import java.util.List;

import com.metacube.shoppingcart.dto.ProductDto;
import com.metacube.shoppingcart.enums.Status;
import com.metacube.shoppingcart.modal.Product;
import com.metacube.shoppingcart.service.ProductService;

/**
 * The Class DefaultProductFacade.
 * 
 * @author Neel Singhal
 */
public class DefaultProductFacade implements ProductFacade {
	ProductService productService;

	public DefaultProductFacade() {

	}
	
	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	/**
	 * Instantiates a new default product facade.
	 *
	 * @param productService    the product service object.
	 */
	public DefaultProductFacade(ProductService productService) {
		this.productService = productService;
	}

	/**
	 * Get the list of all products.
	 */
	@Override
	public Iterable<ProductDto> getAllProducts() {
		List<ProductDto> productDtoList = new ArrayList<>();

		for (Product product : productService.getAllProducts()) {
			productDtoList.add(modelToDto(product));
		}

		return productDtoList;
	}

	/**
	 * Get a product by its ID.
	 */
	@Override
	public ProductDto getProductById(int id) {
		// TODO Auto-generated method stub
		return modelToDto(productService.getProductById(id));
	}

	/**
	 * Convert Dto to model object.
	 *
	 * @param productDto the product dto
	 * @return the product
	 */
	protected Product dtoToModel(ProductDto productDto) {
		if (productDto == null) {
			return null;
		}
		Product user = new Product();
		user.setId(productDto.getId());
		user.setName(productDto.getName());
		user.setPrice(productDto.getPrice());
		return user;
	}

	/**
	 * Convert Model to dto object.
	 *
	 * @param product the product
	 * @return the product dto
	 */
	protected ProductDto modelToDto(Product product) {
		if (product == null) {
			return null;
		}
		ProductDto productDto = new ProductDto();
		productDto.setId(product.getId());
		productDto.setName(product.getName());
		productDto.setPrice(product.getPrice());
		return productDto;
	}

	/**
	 * Add a product.
	 */
	@Override
	public Status addProduct(Product entity) {
		return productService.addProduct(entity);
	}

	/**
	 * Delete a product.
	 */
	public Status deleteProduct(int id) {
		return productService.deleteProduct(id);
	}

	/**
	 * Edit a product.
	 */
	@Override
	public Status editProduct(Product entity, int id) {
		return productService.editProduct(entity, id);
	}
}
