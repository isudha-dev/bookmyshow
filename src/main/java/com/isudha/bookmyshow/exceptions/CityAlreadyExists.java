package com.isudha.bookmyshow.exceptions;

public class CityAlreadyExists extends RuntimeException {
    public CityAlreadyExists(String name) {
        super("City with name "+ name + " already exists.");
    }
}
