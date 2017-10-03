package com.metacube.get.layarch.facade;

import java.util.ArrayList;
import java.util.List;

import com.metacube.get.layarch.dto.ProductDto;
import com.metacube.get.layarch.enums.Status;
import com.metacube.get.layarch.model.Product;
import com.metacube.get.layarch.service.ProductService;

/**
 * The Class DefaultProductFacade.
 * 
 * @author Neel Singhal
 */
public class DefaultProductFacade implements ProductFacade {
	ProductService productService;

	public DefaultProductFacade(ProductService productService) {
		this.productService = productService;
	}

	/**
	 * Get the list of all products.
	 */
	@Override
	public Iterable<ProductDto> getAllProducts() {
		List<ProductDto> userDtoList = new ArrayList<>();

		for (Product product : productService.getAllProducts()) {
			userDtoList.add(modelToDto(product));
		}

		return userDtoList;
	}

	/**
	 * Get a product by its ID.
	 */
	@Override
	public ProductDto getProductById(final int id) {
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
		Product product = new Product();
		product.setId(productDto.getId());
		product.setName(productDto.getName());
		product.setPrice(productDto.getPrice());
		product.setImg(productDto.getImg());
		return product;
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
		productDto.setImg(product.getImg());
		return productDto;
	}

	/**
	 * Delete a product.
	 */
	@Override
	public Status deleteProduct(int id) {
		return productService.deleteProduct(id);
	}

	/**
	 * Update a product.
	 */
	@Override
	public Status updateProduct(Product product, int id) {
		return productService.updateProduct(product, id);
	}

	/**
	 * Add a product.
	 */
	@Override
	public Status addProduct(Product product) {
		return productService.addProduct(product);
	}

}
