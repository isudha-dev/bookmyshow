package com.isudha.bookmyshow.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.isudha.bookmyshow.enums.Language;
import com.isudha.bookmyshow.enums.MovieFeature;
import com.isudha.bookmyshow.models.Movie;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CreateMovieDto {
    private String name;
    private int duration;
    @JsonProperty("movie_features")
    private List<MovieFeature> movieFeatures = new ArrayList<>();

    @JsonProperty("languages")
    private List<Language> languages = new ArrayList<>();

    public Movie toMovie(){
        return Movie
                .builder()
                .name(name)
                .duration(duration)
                .movieFeatures(movieFeatures)
                .languages(languages)
                .build();
    }
}
