package com.isudha.bookmyshow.services;

import com.isudha.bookmyshow.dtos.CreateMovieDto;
import com.isudha.bookmyshow.exceptions.MovieAlreadyExists;
import com.isudha.bookmyshow.exceptions.MovieNotFound;
import com.isudha.bookmyshow.exceptions.ShowNotFound;
import com.isudha.bookmyshow.models.Movie;
import com.isudha.bookmyshow.models.Show;
import com.isudha.bookmyshow.repositories.MovieRepo;
import com.isudha.bookmyshow.repositories.ShowRepo;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Data
@Service
public class MovieService {
    private MovieRepo movieRepo;
    private ShowRepo showRepo;

    public Movie getMovieById(Long id){
        return movieRepo.findById(id).orElseThrow(() -> new MovieNotFound());
    }

    public Optional<Movie> getMovieInternal(Long id){
        return movieRepo.findById(id);
    }

    public Movie createMovie(CreateMovieDto requestDto){
        Optional<Movie> existingMovie = movieRepo.findByName(requestDto.getName());
        if(existingMovie.isPresent()){
            throw new MovieAlreadyExists();
        }
        Movie movie = requestDto.toMovie();
        return movieRepo.save(movie);
    }



    public Movie addShow(Long movieId, Long showId){
        Optional<Movie> movie = movieRepo.findById(movieId);
        if(!movie.isPresent()){
            throw new MovieNotFound();
        }
        Optional<Show> show = showRepo.findById(showId);
        if(!show.isPresent()){
            throw new ShowNotFound();
        }

        movie.get().getShows().add(show.get());
        return movieRepo.save(movie.get());
    }

}
