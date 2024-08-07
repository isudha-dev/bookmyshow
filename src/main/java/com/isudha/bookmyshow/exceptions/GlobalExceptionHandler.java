package com.isudha.bookmyshow.exceptions;

import com.isudha.bookmyshow.dtos.GenericErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CityNotFound.class)
    public ResponseEntity<GenericErrorResponseDto> handleCityNotFoundEx(CityNotFound ex){
        GenericErrorResponseDto response = new GenericErrorResponseDto(false, ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CityAlreadyExists.class)
    public ResponseEntity<GenericErrorResponseDto> handleCityAlreadyExistsEx(CityAlreadyExists ex){
        GenericErrorResponseDto response = new GenericErrorResponseDto(false, ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TheaterNotFound.class)
    public ResponseEntity<GenericErrorResponseDto> handleTheaterNotFoundEx(TheaterNotFound ex){
        GenericErrorResponseDto response = new GenericErrorResponseDto(false, ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TheaterAlreadyExists.class)
    public ResponseEntity<GenericErrorResponseDto> handleTheaterAlreadyExistsEx(TheaterAlreadyExists ex){
        GenericErrorResponseDto response = new GenericErrorResponseDto(false, ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ScreenNotFound.class)
    public ResponseEntity<GenericErrorResponseDto> handleScreenNotFoundEx(ScreenNotFound ex){
        GenericErrorResponseDto response = new GenericErrorResponseDto(false, ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ScreenAlreadyExists.class)
    public ResponseEntity<GenericErrorResponseDto> handleScreenAlreadyExistsEx(ScreenAlreadyExists ex){
        GenericErrorResponseDto response = new GenericErrorResponseDto(false, ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MovieNotFound.class)
    public ResponseEntity<GenericErrorResponseDto> handleMovieNotFoundEx(MovieNotFound ex){
        GenericErrorResponseDto response = new GenericErrorResponseDto(false, ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MovieAlreadyExists.class)
    public ResponseEntity<GenericErrorResponseDto> handleMovieAlreadyExistsEx(MovieAlreadyExists ex){
        GenericErrorResponseDto response = new GenericErrorResponseDto(false, ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ShowNotFound.class)
    public ResponseEntity<GenericErrorResponseDto> handleShowNotFoundEx(ShowNotFound ex){
        GenericErrorResponseDto response = new GenericErrorResponseDto(false, ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<GenericErrorResponseDto> handleRuntimeException(RuntimeException ex){
        GenericErrorResponseDto response = new GenericErrorResponseDto(false, ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
