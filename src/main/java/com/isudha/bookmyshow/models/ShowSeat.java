package com.isudha.bookmyshow.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.isudha.bookmyshow.enums.SeatStatus;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "showseats")
public class ShowSeat extends BaseModel{
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "show_id")
    private Show show;
    @JsonIgnore
    @ManyToOne
    private Seat seat;
    @Enumerated
    private SeatStatus seatStatus;
}
