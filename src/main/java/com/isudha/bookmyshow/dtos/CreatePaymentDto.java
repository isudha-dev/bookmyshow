package com.isudha.bookmyshow.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.isudha.bookmyshow.enums.PaymentMethodType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatePaymentDto {
    @JsonProperty("booking_id")
    private Long bookingId;

    private Double amount;

    private PaymentMethodType paymentMethodType;

}
