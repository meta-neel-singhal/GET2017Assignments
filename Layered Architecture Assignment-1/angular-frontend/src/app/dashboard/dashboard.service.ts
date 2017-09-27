import { Injectable } from '@angular/core';

import { OFFERS } from './dashboard-mock';

// Dashboard service for functions related to dashboard.
@Injectable()
export class DashboardService {
    // Get all the offers on dashboard.
    getOffers() {
        return OFFERS;
    }
}