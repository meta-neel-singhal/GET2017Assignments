
import { Component, OnInit } from '@angular/core';

import { Product } from '../model/product';
import { CartService } from "../services/cart.service";
import { Router } from '@angular/router';

// Class for checkout component.
@Component({
    selector: 'app-checkout',
    templateUrl: './checkout.component.html',
    styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent implements OnInit {

    products: Product[];
    totalPrice: number;
    constructor(private cartService: CartService, private router: Router) { }

    // Run on component initialization.
    ngOnInit() {
        this.getCartProducts();
        this.getTotal();
    }

    // Get all Card products.
    getCartProducts(): void {
        this.cartService.getCartProducts().then(products => this.products = products);
    }

    // Get total price of the cart products.
    getTotal(): void {
        
        for (let i = 0; i < this.products.length; i++) {
            if (this.products[i].price) {
                this.totalPrice += this.products[i].price;
                //this.totalPrice = total;
            }
        }
    }

    // Empty the cart.
    emptyCart(): void {
        this.products = [];
        this.router.navigate(['./products']);
    }
}