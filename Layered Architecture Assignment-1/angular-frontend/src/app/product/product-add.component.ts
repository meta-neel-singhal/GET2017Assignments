import { Component } from '@angular/core';
import { ProductService } from './product.service';
import { Location } from '@angular/common';

import { Product } from './product'

@Component({
    selector: 'app-product-add',
    templateUrl: './product-add.component.html',
    styleUrls: ['./product-add.component.css']
})
export class ProductAddComponent {
    products: Product[];
    selectedProduct: Product;

    constructor(
        private productService: ProductService,
        private location: Location
    ) { }

    ngOnInit(): void {
        this.getProducts();
    }

    getProducts(): void {
        //this.products = this.productService.getProducts();
        this.productService
            .getProducts()
            .then(products => this.products = products);
    }

    add(name: string, price: number, img: string): void {
        name = name.trim();
        if (!name || !price || !img) {
            alert("All values should be compulsorily filled !!!")
            return;
        }
        this.productService.create(name, price, img)
            .then(product => {
                this.products.push(product);
                this.selectedProduct = null;
            });
        this.location.back();
    }
}