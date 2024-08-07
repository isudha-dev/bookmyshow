package com.isudha.bookmyshow.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "theaters")
public class Theater extends BaseModel {
    private String name;
    private String address;
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
    @OneToMany
    private List<Show> shows = new ArrayList<>();
}
