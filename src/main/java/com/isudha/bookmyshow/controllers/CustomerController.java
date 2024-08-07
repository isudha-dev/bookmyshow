package com.isudha.bookmyshow.controllers;

import com.isudha.bookmyshow.dtos.CreateCustomerDto;
import com.isudha.bookmyshow.dtos.GenericSuccessResponseDto;
import com.isudha.bookmyshow.models.Customer;
import com.isudha.bookmyshow.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@AllArgsConstructor
public class CustomerController {

    private CustomerService customerService;

    @GetMapping("/{id}")
    public ResponseEntity<GenericSuccessResponseDto> get(@PathVariable Long id){
        Customer customer = customerService.getCustomerById(id);
        return new ResponseEntity<>(new GenericSuccessResponseDto(true, customer), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<GenericSuccessResponseDto> post(@RequestBody CreateCustomerDto reqDto){
        Customer customer = customerService.createCustomer(reqDto);
        return new ResponseEntity<>(new GenericSuccessResponseDto(true, customer), HttpStatus.OK);
    }

}
