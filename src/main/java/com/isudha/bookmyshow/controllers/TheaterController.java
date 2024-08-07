package com.isudha.bookmyshow.controllers;

import com.isudha.bookmyshow.dtos.CreateTheaterDto;
import com.isudha.bookmyshow.dtos.GenericSuccessResponseDto;
import com.isudha.bookmyshow.models.City;
import com.isudha.bookmyshow.models.Theater;
import com.isudha.bookmyshow.services.CityService;
import com.isudha.bookmyshow.services.TheaterService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/theater")
public class TheaterController {

    private TheaterService theaterService;
    private CityService cityService;

    @GetMapping("/{id}")
    public ResponseEntity<GenericSuccessResponseDto> get(@PathVariable Long id){
        Theater theater = theaterService.getTheaterById(id);
        GenericSuccessResponseDto<Theater> response = new GenericSuccessResponseDto<>(true, theater);
        ResponseEntity<GenericSuccessResponseDto> responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
        return responseEntity;
    }

    @PostMapping
    public ResponseEntity<GenericSuccessResponseDto> post(@RequestBody CreateTheaterDto requestDto){
        City city = cityService.getCityById(requestDto.getCityId());
        Theater theater = theaterService.createTheater(requestDto.toTheater(city));
        GenericSuccessResponseDto<Theater> response = new GenericSuccessResponseDto<>(true, theater);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
