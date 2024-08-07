package com.isudha.bookmyshow.services;

import com.isudha.bookmyshow.exceptions.CityAlreadyExists;
import com.isudha.bookmyshow.exceptions.CityNotFound;
import com.isudha.bookmyshow.models.City;
import com.isudha.bookmyshow.repositories.CityRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CityService {
    private CityRepo cityRepo;

    public City getCityById(Long id) {
        return cityRepo.findById(id).orElseThrow(() -> new CityNotFound(id));
    }

    public City createCity(String cityName){
        Optional<City> existingCity = cityRepo.findByName(cityName);
        if(existingCity.isPresent()){
            throw new CityAlreadyExists(cityName);
        }
        City city = new City(cityName);
        return cityRepo.save(city);
    }
}
