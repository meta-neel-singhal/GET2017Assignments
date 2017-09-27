import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { DashboardComponent } from './dashboard/dashboard.component';
import { ProductComponent } from './product/product.component';
import { ContactUsComponent } from './contact/contact.component';
import { ProductDetailsComponent } from './product/product-details.component';
import { ProductUpdateComponent } from './product/product-update.component';
import { ProductAddComponent } from './product/product-add.component';
import { CartComponent } from './cart/cart.component';
import { CheckoutComponent } from "./cart/checkout.component";

const routes: Routes = [
  { path: '', redirectTo: '/dashboard', pathMatch: 'full' },
  { path: 'dashboard', component: DashboardComponent },
  { path: 'detail/:id', component: ProductDetailsComponent },
  { path: 'update/:id', component: ProductUpdateComponent },
  { path: 'products', component: ProductComponent },
  { path: 'contact-us', component: ContactUsComponent},
  { path: 'create-product', component: ProductAddComponent },
  { path: 'cart', component: CartComponent},
  { path: 'checkout', component: CheckoutComponent}
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule { }