package com.isudha.bookmyshow.controllers;

import com.isudha.bookmyshow.dtos.CreateBookingDto;
import com.isudha.bookmyshow.dtos.GenericSuccessResponseDto;
import com.isudha.bookmyshow.models.Booking;
import com.isudha.bookmyshow.services.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/booking")
public class BookingController {
    private BookingService bookingService;

    @GetMapping
    public ResponseEntity<GenericSuccessResponseDto> get(@PathVariable Long id){
        Booking booking = bookingService.getBookingById(id);
        return new ResponseEntity<>(new GenericSuccessResponseDto(true, booking), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<GenericSuccessResponseDto> post(@RequestBody CreateBookingDto reqDto){
        Booking booking = bookingService.createBooking(reqDto);
        return new ResponseEntity<>(new GenericSuccessResponseDto(true, booking), HttpStatus.OK);
    }
}
