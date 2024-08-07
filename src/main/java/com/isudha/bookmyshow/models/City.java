package com.isudha.bookmyshow.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.isudha.bookmyshow.dtos.CityResponseDto;
import com.isudha.bookmyshow.dtos.TheaterResponseDto;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "cities")

public class City extends BaseModel{
    private String name;
    @JsonIgnore
    @OneToMany(mappedBy = "city")
    private List<Theater> theaters = new ArrayList<>();

    public City(String name){
        this.name = name;
    }

    public CityResponseDto toCityResponseDto(){
        List<TheaterResponseDto> theaterResponseList = theaters.stream().map(theater -> new TheaterResponseDto(theater.getName(), theater.getAddress())).collect(Collectors.toList());
        return CityResponseDto
                .builder()
                .name(this.name)
                .theaters(theaterResponseList)
                .build();
    }
}
