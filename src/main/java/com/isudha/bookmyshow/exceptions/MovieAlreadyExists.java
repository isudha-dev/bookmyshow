package com.isudha.bookmyshow.exceptions;

public class MovieAlreadyExists extends RuntimeException {
    public MovieAlreadyExists(){
        super("Movie already exists");
    }
}
