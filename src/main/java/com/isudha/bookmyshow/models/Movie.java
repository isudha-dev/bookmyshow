package com.isudha.bookmyshow.models;

import com.isudha.bookmyshow.enums.Language;
import com.isudha.bookmyshow.enums.MovieFeature;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "movies")
public class Movie extends BaseModel{
    private String name;
    private int duration;
    @ElementCollection
    @Enumerated
    private List<MovieFeature> movieFeatures = new ArrayList<>();
    @ElementCollection
    @Enumerated
    private List<Language> languages = new ArrayList<>();
    @OneToMany(mappedBy = "movie")
    private List<Show> shows = new ArrayList<>();

}
