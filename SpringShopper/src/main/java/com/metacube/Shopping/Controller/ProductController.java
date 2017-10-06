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

@CrossOrigin
@Controller

@RequestMapping("product")
public class ProductController
{
    @Autowired
    ProductFacade productFacade;

    public ProductFacade getProductFacade() {
        return productFacade;
    }

    public void setProductFacade(ProductFacade productFacade) {
        this.productFacade = productFacade;
    }

    

    @RequestMapping(method=RequestMethod.GET)
    public @ResponseBody Iterable<ProductDto> getProducts() {
        return productFacade.getAllProducts();
    }
    
    @RequestMapping(value="/{id}",method=RequestMethod.GET)
    public @ResponseBody ProductDto getProduct(@PathVariable("id") int id) {
        return productFacade.getProductById(id);
    }
    
    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    public @ResponseBody Boolean deleteProduct(@PathVariable("id") int id) {
        return productFacade.deleteProduct(id);
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public @ResponseBody Boolean addProduct(@RequestBody ProductDto product) {
        return productFacade.saveProduct(product);
    }
    
    @RequestMapping(value="/{id}",method=RequestMethod.PUT)
    public @ResponseBody Object editProduct(@RequestBody ProductDto product,@PathVariable("id") int id) {
        System.out.println("A call here in edit controller");
        return productFacade.editProduct(product,id);
    }
    
}