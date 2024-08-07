package com.isudha.bookmyshow.controllers;

import com.isudha.bookmyshow.dtos.CreatePaymentDto;
import com.isudha.bookmyshow.dtos.GenericSuccessResponseDto;
import com.isudha.bookmyshow.models.Payment;
import com.isudha.bookmyshow.services.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    private PaymentService paymentService;

    @PostMapping
    public ResponseEntity<GenericSuccessResponseDto> post(@RequestBody CreatePaymentDto reqDto){
        Payment payment = paymentService.makePayment(reqDto);
        return new ResponseEntity<>(new GenericSuccessResponseDto<>(true, payment), HttpStatus.OK);
    }

}
