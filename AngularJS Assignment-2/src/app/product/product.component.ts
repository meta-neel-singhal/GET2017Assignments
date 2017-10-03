import { Component, OnInit } from '@angular/core';
import { Router } from "@angular/router";

import { Product } from '../model/product';
//import { PRODUCTS } from './product-mock';
import { ProductService } from '../services/product.service';
import { CartService } from '../services/cart.service';

@Component({
    selector: 'app-product',
    templateUrl: './product.component.html',
    styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {
    products: Product[];
    selectedProduct: Product;

    constructor(
        private productService: ProductService,
        private router: Router,
        private cartService: CartService
    ) { }

    ngOnInit(): void {
        this.getProducts();
    }

    getProducts(): void {
        this.productService
            .getProducts()
            .then(products => this.products = products);
    }

    delete(product: Product): void {
        this.productService
            .delete(product.id)
            .then(() => {
                this.products = this.products.filter(prod => prod !== product);
                if (this.selectedProduct === product) { this.selectedProduct = null; }
            });
    }

    onSelect(product: Product): void {
        this.selectedProduct = product;
    }

    gotoDetail(): void {
        this.router.navigate(['/detail', this.selectedProduct.id]);
    }

    addToCart(product: Product): void {
        this.cartService.addToCart(product);
    }
}