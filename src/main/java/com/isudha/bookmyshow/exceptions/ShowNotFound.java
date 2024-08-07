package com.isudha.bookmyshow.exceptions;

import com.isudha.bookmyshow.repositories.ShowRepo;

public class ShowNotFound extends RuntimeException {
    public ShowNotFound() {
        super("Show not found");
    }
}
