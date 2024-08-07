package com.isudha.bookmyshow.services;

import com.isudha.bookmyshow.exceptions.TheaterAlreadyExists;
import com.isudha.bookmyshow.exceptions.TheaterNotFound;
import com.isudha.bookmyshow.models.Theater;
import com.isudha.bookmyshow.repositories.TheaterRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class TheaterService {

    private TheaterRepo theaterRepo;
    public Theater getTheaterById(Long id) {
        return theaterRepo.findById(id).orElseThrow(() -> new TheaterNotFound(id));
    }

    public Theater createTheater(Theater theater) {
        String theaterName = theater.getName();
        Long cityId = theater.getCity().getId();
        Optional<Theater> existingTheater = theaterRepo.findByNameAndCity_Id(theaterName, cityId);
        if(existingTheater.isPresent()){
            throw new TheaterAlreadyExists(theaterName, cityId);
        }
        return theaterRepo.save(theater);
    }
}
