package com.metacube.Shopping.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.metacube.Shopping.dto.ProductDto;
import com.metacube.Shopping.facade.ProductFacade;

/**
 * The Class ProductController used to direct the service.
 * 
 * @author Neel Singhal
 */
@CrossOrigin
@Controller
@RequestMapping("product")
public class ProductController {
	@Autowired
	ProductFacade productFacade;

	/**
	 * Gets the product facade object.
	 *
	 * @return the product facade
	 */
	public ProductFacade getProductFacade() {
		return productFacade;
	}

	/**
	 * Sets the product facade object.
	 *
	 * @param productFacade the new product facade
	 */
	public void setProductFacade(ProductFacade productFacade) {
		this.productFacade = productFacade;
	}

	/**
	 * Gets all the products.
	 *
	 * @return the products
	 */
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody Iterable<ProductDto> getProducts() {
		return productFacade.getAllProducts();
	}

	/**
	 * Gets the product by its id.
	 *
	 * @param id the id
	 * @return the product
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody ProductDto getProduct(@PathVariable("id") int id) {
		return productFacade.getProductById(id);
	}

	/**
	 * Delete a product.
	 *
	 * @param id the id
	 * @return the boolean
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public @ResponseBody Boolean deleteProduct(@PathVariable("id") int id) {
		return productFacade.deleteProduct(id);
	}

	/**
	 * Adds the product.
	 *
	 * @param product the product
	 * @return the boolean
	 */
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody Boolean addProduct(@RequestBody ProductDto product) {
		return productFacade.addProduct(product);
	}

	/**
	 * Edits the product.
	 *
	 * @param product the product
	 * @param id the id
	 * @return the object
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public @ResponseBody Object editProduct(@RequestBody ProductDto product,
			@PathVariable("id") int id) {
		return productFacade.editProduct(product, id);
	}
}