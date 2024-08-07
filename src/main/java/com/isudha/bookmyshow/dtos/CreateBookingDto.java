package com.isudha.bookmyshow.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateBookingDto {
    @JsonProperty("customer_id")
    private Long customerId;
    @JsonProperty("show_id")
    private Long showId;
    @JsonProperty("show_seat_ids")
    private List<Long> showSeatIds;
}
