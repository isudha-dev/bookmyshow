package com.isudha.bookmyshow.exceptions;

public class CityNotFound extends RuntimeException {
    public CityNotFound(Long id){
        super("City not found");
    }
}
