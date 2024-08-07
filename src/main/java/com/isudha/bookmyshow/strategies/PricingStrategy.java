package com.isudha.bookmyshow.strategies;

import com.isudha.bookmyshow.models.Booking;

public interface PricingStrategy {
    public Double calculatePrice(Booking booking);
}
