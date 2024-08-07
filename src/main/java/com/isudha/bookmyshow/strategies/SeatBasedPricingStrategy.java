package com.isudha.bookmyshow.strategies;

import com.isudha.bookmyshow.enums.SeatType;
import com.isudha.bookmyshow.models.Booking;
import com.isudha.bookmyshow.models.ShowSeat;
import org.springframework.stereotype.Component;

@Component
public class SeatBasedPricingStrategy implements PricingStrategy{
    private static Double calculatePrice(ShowSeat seat) {
        return getPrice(seat.getSeat().getSeatType());
    }

    private static Double getPrice(SeatType seatType) {
        switch (seatType) {
            case PLATINUM -> {
                return 1000.0;
            }
            case GOLD -> {
                return 500.0;
            }
            case ECONOMY -> {
                return 250.0;
            }
        }

        throw new IllegalArgumentException("Seat type not valid: " + seatType);
    }

    @Override
    public Double calculatePrice(Booking booking) {
        return booking.getShowSeats().stream().mapToDouble(
                SeatBasedPricingStrategy::calculatePrice
        ).sum();
    }
}
