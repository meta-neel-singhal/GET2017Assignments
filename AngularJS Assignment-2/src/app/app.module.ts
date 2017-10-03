import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { HttpModule } from '@angular/http';
import { FormsModule } from '@angular/forms';

import { InMemoryWebApiModule } from 'angular-in-memory-web-api';
import { InMemoryDataService }  from './in-memory-data.service';

import { AppComponent } from './app.component';
import { ProductComponent } from './product/product.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ProductSearchComponent } from './product/product-search/product-search.component';
import { ContactUsComponent } from "./contact/contact.component";
import { ProductDetailsComponent } from './product/product-details/product-details.component';
import { AppRoutingModule } from './app-routing.module';
import { ProductAddComponent } from './product/product-add/product-add.component';
import { ProductUpdateComponent } from './product/product-update/product-update.component';
import { ProductDeleteComponent } from './product/product-delete/product-delete.component';
import { CartComponent } from './cart/cart.component';
import { CheckoutComponent } from "./checkout/checkout.component";

import { DashboardService } from "./services/dashboard.service";
import { ProductService } from './services/product.service';
import { ProductSearchService } from './services/product-search.service'
import { CartService } from './services/cart.service';

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
    HttpModule,
    InMemoryWebApiModule.forRoot(InMemoryDataService)
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
