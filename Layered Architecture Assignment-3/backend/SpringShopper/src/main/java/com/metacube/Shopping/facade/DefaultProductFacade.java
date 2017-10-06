package com.metacube.Shopping.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.metacube.Shopping.Product.Model.Product;
import com.metacube.Shopping.Service.ProductService;
import com.metacube.Shopping.dto.ProductDto;

/**
 * The Class DefaultProductFacade.
 * 
 * @author Neel Singhal
 */
@Component("productFacade")
public class DefaultProductFacade implements ProductFacade {
	@Autowired
	ProductService productService;

	public DefaultProductFacade(ProductService productService) {
		this.productService = productService;
	}

	public DefaultProductFacade() {

	}

	/**
	 * Gets the product service object.
	 *
	 * @return the product service object.
	 */
	public ProductService getProductService() {
		return productService;
	}

	/**
	 * Sets the product service object.
	 *
	 * @param productService the new product service object.
	 */
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	/**
	 * Get the list of all products.
	 */
	public Iterable<ProductDto> getAllProducts() {
		List<ProductDto> productDtoList = new ArrayList<ProductDto>();

		for (Product product : productService.getAllProducts()) {
			productDtoList.add(modelToDto(product));
		}

		return productDtoList;
	}

	/**
	 * Get a product by its ID.
	 */
	public ProductDto getProductById(final int id) {
		return modelToDto(productService.getProductById(id));
	}

	/**
	 * Convert Dto to model object.
	 *
	 * @param productDto the product dto
	 * @return the product
	 */
	public Product dtoToModel(ProductDto productDto) {
		if (productDto == null) {
			return null;
		}
		Product product = new Product();
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
	public ProductDto modelToDto(Product product) {
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
	public Boolean deleteProduct(int id) {
		return productService.deleteProduct(id);
	}

	/**
	 * Add a product.
	 */
	public Boolean addProduct(ProductDto newProduct) {
		return (productService.addProduct(dtoToModel(newProduct)));
	}

	/**
	 * Edit a product's details.
	 */
	public Boolean editProduct(ProductDto entity, int id) {
		return productService.editProduct(dtoToModel(entity), id);
	}
}