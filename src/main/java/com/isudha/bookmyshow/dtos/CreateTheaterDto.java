package com.isudha.bookmyshow.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.isudha.bookmyshow.models.City;
import com.isudha.bookmyshow.models.Theater;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateTheaterDto {
    private String name;
    private String address;
    @JsonProperty("city_id")
    private Long cityId;

    public Theater toTheater(City city){
        return Theater.builder()
                .city(city)
                .name(this.name)
                .address(this.address)
                .build();
    }
}
