import { Component } from '@angular/core';

// Class for AppComponent.
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title: string = 'Shopping Cart';
  caption: string = 'because shopping is an art !!!';
  footerContent: string = 'Metacube Shopping Cart';
}
