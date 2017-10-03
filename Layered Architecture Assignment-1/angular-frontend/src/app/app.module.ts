import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { HttpModule } from '@angular/http';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { ProductComponent } from './product/product.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ProductSearchComponent } from './product/product-search.component';
import { ContactUsComponent } from "./contact/contact.component";
import { ProductDetailsComponent } from './product/product-details.component';
import { AppRoutingModule } from './app-routing.module';
import { ProductAddComponent } from './product/product-add.component';
import { ProductUpdateComponent } from './product/product-update.component';
import { ProductDeleteComponent } from './product/product-delete.component';
import { CartComponent } from './cart/cart.component';
import { CheckoutComponent } from "./cart/checkout.component";

import { DashboardService } from "./dashboard/dashboard.service";
import { ProductService } from './product/product.service';
import { ProductSearchService } from './product/product-search.service'
import { CartService } from './cart/cart.service';

@NgModule({
  declarations: [
    AppComponent,
    ProductComponent,
    DashboardComponent,
    ContactUsComponent,
    ProductDetailsComponent,
    ProductSearchComponent,
    ProductAddComponent,
    ProductUpdateComponent,
    ProductDeleteComponent,
    CartComponent,
    CheckoutComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpModule
  ],
  providers: [
    ProductService,
    DashboardService,
    ProductSearchService,
    CartService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
