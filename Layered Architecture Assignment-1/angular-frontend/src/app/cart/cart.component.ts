import { Component, OnInit } from '@angular/core';

import { Product } from '../product/product';
import { CartService } from './cart.service';

// Class for Cart Component.
@Component({
    selector: 'app-cart',
    templateUrl: './cart.component.html',
    styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

    products: Product[];

    constructor(private cartService: CartService) { }

    // Run on component initialization.
    ngOnInit() {
        this.getCartProducts();
    }

    // Get all cart products.
    getCartProducts(): void {
        this.cartService.getCartProducts().then(products => this.products = products);
    }

    // Delete a product from the cart.
    deleteFromCart(prod: Product) {
        for (let i = 0; i < this.products.length; i++) {
            if (this.products[i] == prod) {
                this.products.splice(i, 1);
            }
        }
    }
}