package com.isudha.bookmyshow.models;

import com.isudha.bookmyshow.enums.SeatType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = "seats")
public class Seat extends BaseModel{
    private int rowNum;
    private int colNum;
    @ManyToOne
    @JoinColumn(name = "screen_id")
    private Screen screen;
    private SeatType seatType;

    public Seat(Screen screen, SeatType seatType){
        this.screen = screen;
        this.seatType = seatType;
    }

}
