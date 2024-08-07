package com.isudha.bookmyshow.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class CityResponseDto {
    private String name;
    private List<TheaterResponseDto> theaters;

}
