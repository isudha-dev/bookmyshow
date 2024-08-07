package com.isudha.bookmyshow.controllers;

import com.isudha.bookmyshow.dtos.CreateShowDto;
import com.isudha.bookmyshow.dtos.GenericSuccessResponseDto;
import com.isudha.bookmyshow.models.Show;
import com.isudha.bookmyshow.services.ShowService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/show")
@AllArgsConstructor
public class ShowController {

    private ShowService showService;

    @GetMapping("/{id}")
    public ResponseEntity<GenericSuccessResponseDto> get(@PathVariable Long id){
        Show show = showService.getShowById(id);
        return new ResponseEntity<>(new GenericSuccessResponseDto<>(true, show), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<GenericSuccessResponseDto> post(@RequestBody CreateShowDto reqDto){
        Show show = showService.createShow(reqDto);
        return new ResponseEntity<>(new GenericSuccessResponseDto(true, show), HttpStatus.OK);
    }
}
