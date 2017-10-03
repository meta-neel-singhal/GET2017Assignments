
import { Component, OnInit } from '@angular/core';

import { Product } from '../product/product';
import { CartService } from "./cart.service";
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
    }

    // Get all Card products.
    getCartProducts(): void {
        this.cartService.getCartProducts().then(products => this.products = products);
    }

    // Get total price of the cart products.
    getTotal(): number {
        let total = 0;
        for (var i = 0; i < this.products.length; i++) {
            if (this.products[i].price) {
                total += this.products[i].price;
                this.totalPrice = total;
            }
        }

        return total;
    }

    // Empty the cart.
    emptyCart(): void {
        this.products.splice(0, this.products.length);
        this.router.navigate(['./products']);
    }
}