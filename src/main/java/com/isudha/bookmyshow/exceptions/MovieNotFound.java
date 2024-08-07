package com.isudha.bookmyshow.exceptions;

public class MovieNotFound extends RuntimeException{
    public MovieNotFound() {
        super("Movie not found");
    }
}
