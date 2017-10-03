import { Component, OnInit } from '@angular/core';

import { DashboardService } from './dashboard.service';

// Class for Dashboard Component.
@Component({
    selector: 'app-dashboard',
    templateUrl: './dashboard.component.html'
})
export class DashboardComponent implements OnInit {
    offers: any[];

    constructor(private dashboardService: DashboardService) { }

    // Run on component initialization.
    ngOnInit(): void {
        this.getOffers();
    }

    // Get all tha offers.
    getOffers(): void {
        this.offers = this.dashboardService.getOffers();
    }
}