package com.isudha.bookmyshow.controllers;

import com.isudha.bookmyshow.dtos.CreateScreenDto;
import com.isudha.bookmyshow.dtos.GenericSuccessResponseDto;
import com.isudha.bookmyshow.models.Screen;
import com.isudha.bookmyshow.services.ScreenService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/screen")
public class ScreenController {

    private ScreenService screenService;

    @GetMapping("/{id}")
    public ResponseEntity<GenericSuccessResponseDto> get(@PathVariable Long id){
        Screen screen = screenService.getScreenById(id);

        return new ResponseEntity<>(new GenericSuccessResponseDto<>(true, screen), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<GenericSuccessResponseDto> post(@RequestBody CreateScreenDto requestDto){
        Screen screen = screenService.createScreen(requestDto);

        return new ResponseEntity<>(new GenericSuccessResponseDto<>(true, screen), HttpStatus.OK);
    }
}
