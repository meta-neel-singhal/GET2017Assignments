import { Injectable } from '@angular/core';
import { Product } from '../product/product';

// Cart service for functions related to cart.
@Injectable()
export class CartService {

    static products: Product[] = [];

    // Get the cart products.
    getCartProducts(): Promise<Product[]> {
        return Promise.resolve(CartService.products);
    }

    // Add a product to the cart.
    addToCart(product: Product) {
        CartService.products.push(product);
    }
}