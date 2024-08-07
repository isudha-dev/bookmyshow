package com.isudha.bookmyshow.exceptions;

public class ScreenNotFound extends RuntimeException {
    public ScreenNotFound(){
        super("Screen not found");
    }
}
