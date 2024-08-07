package com.isudha.bookmyshow.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CreateShowDto {
    @JsonProperty("movie_id")
    private Long movieId;
    @JsonProperty("screen_id")
    private Long screenId;
    @JsonProperty("date_time")
    private LocalDateTime dateTime;
}
