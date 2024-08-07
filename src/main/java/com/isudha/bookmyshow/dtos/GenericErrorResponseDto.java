package com.isudha.bookmyshow.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GenericErrorResponseDto {
    public boolean success;
    @JsonProperty("error_message")
    public String errorMessage;
}
