package com.isudha.bookmyshow.models;

import com.isudha.bookmyshow.enums.PaymentMethodType;
import com.isudha.bookmyshow.enums.PaymentStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "payments")
public class Payment extends BaseModel{
    @ManyToOne
    private Booking booking;
    private Double amount;
    private PaymentStatus paymentStatus;
    private PaymentMethodType paymentMethodType;

}
