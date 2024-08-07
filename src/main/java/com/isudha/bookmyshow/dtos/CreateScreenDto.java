package com.isudha.bookmyshow.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.isudha.bookmyshow.models.Screen;
import com.isudha.bookmyshow.models.Theater;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateScreenDto {
    private int number;
    @JsonProperty("theater_id")
    private Long theaterId;
    @JsonProperty("platinum_count")
    private int platinumCount;
    @JsonProperty("gold_count")
    private int goldCount;
    @JsonProperty("economy_count")
    private int economyCount;
    private int cols;

    public Screen toScreen(Theater theater){
        return Screen
                .builder()
                .number(number)
                .theater(theater)
                .build();
    }
}
