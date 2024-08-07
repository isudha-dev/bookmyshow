package com.isudha.bookmyshow.exceptions;

public class TheaterAlreadyExists extends RuntimeException {
    public TheaterAlreadyExists(String theaterName, Long cityId) {
        super("Theater already exists for city");
    }
}
