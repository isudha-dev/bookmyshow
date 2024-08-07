package com.isudha.bookmyshow.exceptions;

public class TheaterNotFound extends RuntimeException {
    public TheaterNotFound(Long id) {
        super("Theater not found");
    }
}
