package com.isudha.bookmyshow.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "screens")
public class Screen extends BaseModel{
    private int number;
    @ManyToOne
    private Theater theater;
    @JsonIgnore
    @OneToMany(mappedBy = "screen")
    private List<Seat> seats = new ArrayList<>();

    public void addSeats(List<Seat> seats){
        this.setSeats(seats);
    }

}
