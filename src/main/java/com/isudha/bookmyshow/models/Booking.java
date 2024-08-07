package com.isudha.bookmyshow.models;

import com.isudha.bookmyshow.enums.BookingStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder(toBuilder = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bookings")
public class Booking extends BaseModel{
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Show show;
    @OneToMany
    private List<ShowSeat> showSeats = new ArrayList<>();

    private BookingStatus status;

    private Double amount;

    @OneToMany
    private List<Payment> payments = new ArrayList<>();

}
