package com.isudha.bookmyshow.controllers;

import com.isudha.bookmyshow.dtos.CityResponseDto;
import com.isudha.bookmyshow.dtos.GenericSuccessResponseDto;
import com.isudha.bookmyshow.models.City;
import com.isudha.bookmyshow.services.CityService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/city")
public class CityController {

    private CityService cityService;

    @GetMapping("/{id}")
    public ResponseEntity<GenericSuccessResponseDto> get(@PathVariable Long id){
        City city = cityService.getCityById(id);
        CityResponseDto cityResponseDto = city.toCityResponseDto();

        GenericSuccessResponseDto<CityResponseDto> response = new GenericSuccessResponseDto<>(true, cityResponseDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<GenericSuccessResponseDto> post(@RequestBody String name){
        City city = cityService.createCity(name);
        CityResponseDto cityResponseDto = city.toCityResponseDto();

        GenericSuccessResponseDto<CityResponseDto> response = new GenericSuccessResponseDto<>(true, cityResponseDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
