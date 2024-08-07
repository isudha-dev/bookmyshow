package com.isudha.bookmyshow.exceptions;

public class ScreenAlreadyExists extends RuntimeException{
    public ScreenAlreadyExists(){
        super("Screen already exists");
    }
}
