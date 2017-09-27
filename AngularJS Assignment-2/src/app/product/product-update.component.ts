import { Component } from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { Location } from '@angular/common';

import { Observable } from 'rxjs/Observable';
import { Product } from './product';
import { ProductService } from './product.service';

import 'rxjs/add/operator/switchMap';

@Component({
    selector: 'app-product-update',
    templateUrl: './product-update.component.html',
    styleUrls: ['./product-update.component.css']
})
export class ProductUpdateComponent {
    product: Product;

    constructor(
        private productService: ProductService,
        private route: ActivatedRoute,
        private location: Location
    ) { }

    ngOnInit(): void {
        this.route.paramMap
            .switchMap((params: ParamMap) => this.productService.getProduct(+ params.get('id')))
            .subscribe(product => this.product = product);
    }

    save(): void {
        this.productService.update(this.product)
            .then(() => this.goBack());
    }

    goBack(): void {
        this.location.back();
    }
}