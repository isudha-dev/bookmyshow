package com.isudha.bookmyshow.controllers;

import com.isudha.bookmyshow.dtos.CreateMovieDto;
import com.isudha.bookmyshow.dtos.GenericSuccessResponseDto;
import com.isudha.bookmyshow.models.Movie;
import com.isudha.bookmyshow.services.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/movie")
public class MovieController {

    private MovieService movieService;

    @GetMapping("/{id}")
    public ResponseEntity<GenericSuccessResponseDto> get(@PathVariable Long id){
        Movie movie = movieService.getMovieById(id);
        return new ResponseEntity<>(new GenericSuccessResponseDto<>(true, movie), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<GenericSuccessResponseDto> post(@RequestBody CreateMovieDto reqDto){
        Movie movie = movieService.createMovie(reqDto);
        return new ResponseEntity<>(new GenericSuccessResponseDto<>(true, movie), HttpStatus.OK);
    }

    
}
