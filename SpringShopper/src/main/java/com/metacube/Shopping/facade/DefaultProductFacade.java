package com.metacube.Shopping.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.metacube.Shopping.Product.Model.Product;
import com.metacube.Shopping.Service.ProductService;
import com.metacube.Shopping.dto.ProductDto;


@Component("productFacade")
public class DefaultProductFacade implements ProductFacade
{
    @Autowired
    ProductService productService;

    public DefaultProductFacade(ProductService productService) {
        this.productService = productService;
    }

    public DefaultProductFacade() {
        
    }
    

    public ProductService getProductService() {
        return productService;
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    public Iterable<ProductDto> getAllProducts()
    {
        List<ProductDto> productDtoList = new ArrayList<ProductDto>();

        for (Product product : productService.getAllProducts()) {
            productDtoList.add(modelToDto(product));
        }

        return productDtoList;
    }

    public ProductDto getProductById(final int id)
    {
        return modelToDto(productService.getProductById(id));
    }

    protected Product dtoToModel(ProductDto productDto) {
        if (productDto == null) {
            return null;
        }
        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setImageUrl(productDto.getImageUrl());
        return product;
    }

    public ProductDto modelToDto(Product product) {
        if (product == null) {
            return null;
        }
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());
        productDto.setImageUrl(product.getImageUrl());
        return productDto;
    }

    public Boolean deleteProduct(int id) {
        return productService.deleteProduct(id);
    }

    public Boolean saveProduct(ProductDto newProduct) {
        System.out.println("i m calleed in facade");
        return (productService.saveProduct(dtoToModel(newProduct)));
    }
    
    public Boolean editProduct(ProductDto entity,int id) {
        System.out.println("A call here in edit fcasde");
        return productService.editProduct(dtoToModel(entity),id);
    }
}